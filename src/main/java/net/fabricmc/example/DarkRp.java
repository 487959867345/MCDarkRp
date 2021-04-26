package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
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
import net.minecraft.util.Identifier;

public class DarkRp implements ModInitializer {
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		System.out.println("Hello Fabric world!");

	}
}
