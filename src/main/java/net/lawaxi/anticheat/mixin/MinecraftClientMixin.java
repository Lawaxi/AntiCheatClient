package net.lawaxi.anticheat.mixin;

import net.lawaxi.anticheat.utils.HackEnables;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {

    @Inject(at = @At("RETURN"), method = "updateWindowTitle")
	private void updateWindowTitle(CallbackInfo info) {
        HackEnables.reload();
	}

}
