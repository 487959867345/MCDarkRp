package net.catchyaintit.darkrp.client;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

import java.awt.*;

public class DefualtDarkRpHud implements HudRenderCallback {
    private MinecraftClient client;
    private TextRenderer text;
    public DefualtDarkRpHud(MinecraftClient instance) {
        this.client = instance;
    }

    @Override
    public void onHudRender(MatrixStack matrixStack, float tickDelta) {
        text = client.textRenderer;
        matrixStack.push();
        // draw
        text.draw(matrixStack, Text.of(ClientProfileHandler.getJob().getId()), 20, 20, Color.WHITE.getRGB());
        text.draw(matrixStack, Text.of("Money: " + ClientProfileHandler.getMoney()), 10, 10, Color.red.getRGB());
        text.draw(matrixStack, Text.of("health: " + client.player.getHealth()), 30, 30, Color.RED.getRGB());
        //
        matrixStack.pop();
    }

}
