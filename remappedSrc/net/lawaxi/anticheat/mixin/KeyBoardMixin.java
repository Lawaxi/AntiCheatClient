package net.lawaxi.anticheat.mixin;

import net.lawaxi.anticheat.utils.HackEnables;
import net.lawaxi.anticheat.utils.KeyBindings;
import net.minecraft.client.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Keyboard.class)
public abstract class KeyBoardMixin {

	@Inject(at = @At("RETURN"), method = "onKey")
	private void onKey(CallbackInfo info) {


		if(KeyBindings.jetpack.isPressed()){
			HackEnables.jetpack=!HackEnables.jetpack;
			HackEnables.reload();
			return;
		}

		if(KeyBindings.boatfly.isPressed()){
			HackEnables.boatfly=!HackEnables.boatfly;
			HackEnables.reload();
			return;
		}

		if(KeyBindings.waterwalk.isPressed()){
			HackEnables.waterwalk=!HackEnables.waterwalk;
			HackEnables.reload();
			return;
		}
	}

}
