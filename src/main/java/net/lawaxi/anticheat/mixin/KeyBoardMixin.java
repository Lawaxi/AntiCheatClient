package net.lawaxi.anticheat.mixin;

import net.lawaxi.anticheat.utils.HackEnables;
import net.lawaxi.anticheat.utils.KeyBindings;
import net.minecraft.client.Keyboard;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Keyboard.class)
public abstract class KeyBoardMixin {

	@Inject(at = @At("RETURN"), method = "onKey")
	private void onKey(CallbackInfo info) {

/*
		if(KeyBindings.jetpack.isPressed()){
			HackEnables.jetpack=!HackEnables.jetpack;
			HackEnables.reload();
			return;
		}

		if(KeyBindings.boatfly.isPressed()){
			HackEnables.boatfly=!HackEnables.boatfly;
			HackEnables.reload();
			return;
		}*/

		ClientPlayerEntity player = MinecraftClient.getInstance().player;
		if (MinecraftClient.getInstance().options.keyJump.isPressed()) {
			Entity boat = player.getRootVehicle();
			if(boat==null){
				player.jump();
			}else{
				boat.setVelocity(new Vec3d(boat.getVelocity().x, 0.3, boat.getVelocity().z));
			}
		}
	}

}
