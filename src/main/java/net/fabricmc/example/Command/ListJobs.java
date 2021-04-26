package net.fabricmc.example.Command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.fabricmc.example.Job.JobBase;
import net.fabricmc.example.Registries.JobRegistry;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;

import java.util.Map;

import static net.minecraft.server.command.CommandManager.literal;

public class ListJobs implements CommandRegistrationCallback {
    @Override
    public void register(CommandDispatcher<ServerCommandSource> dispatcher, boolean dedicated) {
        dispatcher.register(
                literal("display")
                .then(literal("criminals").executes(ListJobs::DisplayCriminalJobs))
        );
    }

    private static int DisplayCriminalJobs(CommandContext<ServerCommandSource> ctx) throws CommandSyntaxException {
        ServerPlayerEntity player = ctx.getSource().getPlayer();
        JobRegistry.getCriminalJobs().forEach((key, val) -> player.sendMessage(new LiteralText(key), false));
        return Command.SINGLE_SUCCESS;
    }


}
