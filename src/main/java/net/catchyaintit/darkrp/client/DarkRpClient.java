package net.catchyaintit.darkrp.client;

import net.catchyaintit.darkrp.net.packet.s2c.JobPacket;
import net.fabricmc.api.ClientModInitializer;
import net.catchyaintit.darkrp.net.packet.s2c.PayPacket;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;

public class DarkRpClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        ClientPlayNetworking.registerGlobalReceiver(PayPacket.packetId, (client, networkHandler, packet, sender) -> {
            ClientProfileHandler.setMoney(packet.readInt());
        });
        ClientPlayNetworking.registerGlobalReceiver(JobPacket.packetId, (client, networkHandler, packet, sender) -> {
            ClientProfileHandler.setJobIdTranslated(packet.readString());
        });
        ClientLifecycleEvents.CLIENT_STARTED.register(c -> {
                HudRenderCallback.EVENT.register(
                        new DefualtDarkRpHud(c)
                );
            }
        );




    }
}
