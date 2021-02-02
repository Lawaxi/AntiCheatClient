package net.lawaxi.anticheat.utils;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.glfw.GLFW;

public class KeyBindings {

    public static KeyBinding jetpack;
    public static KeyBinding boatfly;

    public static void build(){

        jetpack = KeyBindingHelper.registerKeyBinding(
                new KeyBinding(
                        "key.enablehack.jetpack",
                        InputUtil.Type.KEYSYM,
                        GLFW.GLFW_KEY_H,
                        "LawaxiHC"));

        boatfly = KeyBindingHelper.registerKeyBinding(
                new KeyBinding(
                        "key.enablehack.boatfly",
                        InputUtil.Type.KEYSYM,
                        GLFW.GLFW_KEY_B,
                        "LawaxiHC"));


        ClientTickEvents.END_CLIENT_TICK.register(e ->
        {

            ClientPlayerEntity player = MinecraftClient.getInstance().player;
            if (MinecraftClient.getInstance().options.keyJump.isPressed()) {
                Entity boat = player.getRootVehicle();
                if(boat==null){
                    if(HackEnables.jetpack){
                        player.jump();
                    }
                }else{
                    if(HackEnables.boatfly){
                        boat.setVelocity(new Vec3d(boat.getVelocity().x, 0.3, boat.getVelocity().z));
                    }
                }
            }

        });
    }
}
