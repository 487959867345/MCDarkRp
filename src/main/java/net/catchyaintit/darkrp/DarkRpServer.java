package net.catchyaintit.darkrp;

import net.catchyaintit.darkrp.job.Handlers.PlayerJobHandler;
import net.catchyaintit.darkrp.job.JobBase;
import net.catchyaintit.darkrp.job.JobType;
import net.catchyaintit.darkrp.net.packet.s2c.JobPacket;
import net.catchyaintit.darkrp.registries.JobRegistry;
import net.fabricmc.api.DedicatedServerModInitializer;
import net.catchyaintit.darkrp.command.ListJobsCommand;
import net.catchyaintit.darkrp.economy.handlers.MoneyHandler;
import net.catchyaintit.darkrp.economy.handlers.PayCycleHandler;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.PacketByteBuf;

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
                    new ListJobsCommand()
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
                        ServerPlayNetworking.send(player.player, JobPacket.packetId, PacketByteBufs.create().writeString(temp.Id));
                }
            );
    }
}
