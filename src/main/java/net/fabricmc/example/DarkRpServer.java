package net.fabricmc.example;

import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.example.Command.ListJobs;
import net.fabricmc.example.Economey.Handlers.MoneyHandler;
import net.fabricmc.example.Economey.Handlers.PayCycleHandler;
import net.fabricmc.example.Job.Handlers.PlayerJobHandler;
import net.fabricmc.example.Job.JobBase;
import net.fabricmc.example.Job.JobType;
import net.fabricmc.example.Registries.JobRegistry;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.util.registry.Registry;

public class DarkRpServer implements DedicatedServerModInitializer {
    static JobBase DEFAULT_JOB = new JobBase(JobType.CIVILIAN, 10, (20 * 60) * 1);
    @Override
    public void onInitializeServer() {
            try {
                JobRegistry.register("DEFAULT", DEFAULT_JOB);
            } catch (Exception e) {
                e.printStackTrace();
            }

            CommandRegistrationCallback.EVENT.register(
                    new ListJobs()
            );

            ServerTickEvents.START_SERVER_TICK.register(server -> {
                        PayCycleHandler.tick(server);
                    }
            );
            ServerPlayConnectionEvents.JOIN.register((player, packetSender, server)-> {
                        JobBase temp = DEFAULT_JOB;
                        temp.lastPayed = server.getTicks();
                        MoneyHandler.createDefault(player.player.getUuid());
                        PlayerJobHandler.addPlayerWithJob(player.player.getUuid(), temp);
                    }
            );
    }
}
