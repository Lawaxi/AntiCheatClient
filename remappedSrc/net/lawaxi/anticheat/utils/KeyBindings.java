package net.lawaxi.anticheat.utils;

import net.fabricmc.fabric.api.client.keybinding.FabricKeyBinding;
import net.fabricmc.fabric.api.client.keybinding.KeyBindingRegistry;
import net.fabricmc.fabric.api.event.client.ClientTickCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.glfw.GLFW;

public class KeyBindings {

    public static FabricKeyBinding jetpack;
    public static FabricKeyBinding boatfly;
    public static FabricKeyBinding waterwalk;

    public static void build(){

        KeyBindingRegistry.INSTANCE.addCategory("LawaxiHC");

        jetpack = FabricKeyBinding.Builder.create(
                new Identifier("enablehack","jetpack"),
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_H,
                "LawaxiHC"
        ).build();

        boatfly = FabricKeyBinding.Builder.create(
                new Identifier("enablehack","boatfly"),
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_B,
                "LawaxiHC"
        ).build();


        waterwalk = FabricKeyBinding.Builder.create(
                new Identifier("enablehack","waterwalk"),
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_J,
                "LawaxiHC"
        ).build();

        KeyBindingRegistry.INSTANCE.register(jetpack);
        KeyBindingRegistry.INSTANCE.register(boatfly);
        KeyBindingRegistry.INSTANCE.register(waterwalk);

        ClientTickCallback.EVENT.register(e ->
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
