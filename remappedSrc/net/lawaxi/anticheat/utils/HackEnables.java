package net.lawaxi.anticheat.utils;

import net.minecraft.client.MinecraftClient;

public class HackEnables {

    public static boolean jetpack = false;
    public static boolean boatfly = true;
    public static boolean waterwalk = false;

    public static void reload(){

        String t = "";
        if(jetpack)
            t+=" 喷气背包;";
        if(boatfly)
            t+=" 飞船;";
        if(waterwalk)
            t+=" 水上行走;";

        MinecraftClient.getInstance().getWindow().setTitle(
                !t.equals("") ? "LawaxiHC 当前特异功能:"+t : "LawaxiHC 当前没有开启任何特异功能"
        );
    }
}
