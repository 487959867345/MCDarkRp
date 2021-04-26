package net.catchyaintit.darkrp.economy.handlers;

import net.catchyaintit.darkrp.job.Handlers.PlayerJobHandler;
import net.catchyaintit.darkrp.net.packet.s2c.PayPacket;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Formatting;

public class PayCycleHandler {

    public static void tick(MinecraftServer server) {
        PlayerJobHandler.getPlayerJobList().forEach((player, job) -> {
            if (job.lastPayed + job.payCycle == server.getTicks()) {
                job.lastPayed = server.getTicks();
                MoneyHandler.pay(player, job.pay);
                ServerPlayerEntity targetPlayer = server.getPlayerManager().getPlayer(player);

                targetPlayer.sendMessage(
                        new LiteralText("You received a paycheck of " + job.pay + " For working as " + job.toString())
                        .formatted(Formatting.GREEN), false);
                PacketByteBuf buf = PacketByteBufs.create();

                buf.writeInt(job.pay);
                ServerPlayNetworking.send(targetPlayer, PayPacket.packetId, buf);
            }
        });
    }
}
