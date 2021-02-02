package net.lawaxi.anticheat.mixin;

import net.lawaxi.anticheat.utils.HackEnables;
import net.minecraft.SharedConstants;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.Window;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {

    @Shadow @Final private Window window;

    @Inject(at = @At("RETURN"), method = "updateWindowTitle")
	private void updateWindowTitle(CallbackInfo info) {
        HackEnables.reload();
	}

}
