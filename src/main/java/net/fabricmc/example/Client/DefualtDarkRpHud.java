package net.fabricmc.example.Client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.example.Economey.Handlers.MoneyHandler;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;
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
        text.draw(matrixStack, Text.of("Money: " + ClientMoneyHandler.getMoney()), 10, 10, Color.red.getRGB());
        //
        matrixStack.pop();
    }

}
