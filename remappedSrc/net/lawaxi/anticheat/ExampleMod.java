package net.lawaxi.anticheat;

import net.fabricmc.api.ModInitializer;
import net.lawaxi.anticheat.utils.HackEnables;
import net.lawaxi.anticheat.utils.KeyBindings;

public class ExampleMod implements ModInitializer {


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		System.out.println("Hello Fabric world!");
		KeyBindings.build();
	}
}
