package net.fabricmc.example.Client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.example.net.packet.S2C.PayPacket;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;

public class DarkRpClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        ClientPlayNetworking.registerGlobalReceiver(PayPacket.packetId, (client, networkHandler, packet, sender) -> {
            ClientMoneyHandler.setMoney(packet.readInt());
        });
        ClientLifecycleEvents.CLIENT_STARTED.register(c -> {
                HudRenderCallback.EVENT.register(
                        new DefualtDarkRpHud(c)
                );
            }
        );



    }
}
