package net.lawaxi.anticheat.mixin;

import net.lawaxi.anticheat.utils.HackEnables;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.network.listener.PacketListener;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class EntityMixin {

	@Shadow public abstract boolean equals(Object o);

	@Inject(at = @At("HEAD"), method = "updatePosition")
	private void waterwalk(CallbackInfo info) {

		ClientPlayerEntity player = MinecraftClient.getInstance().player;
		if(HackEnables.waterwalk){
			if(player.isTouchingWater() && !player.isSneaking()){
				player.setVelocity(player.getVelocity().x, 0.11, player.getVelocity().z);
			}
		}
	}

}
