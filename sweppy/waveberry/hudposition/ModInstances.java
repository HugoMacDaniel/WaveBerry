package org.sweppy.waveberry.hudposition;

import org.sweppy.waveberry.hudposition.impl.HUDManager;
import org.sweppy.waveberry.mods.ModFPS;
import org.sweppy.waveberry.mods.ModPing;
import org.sweppy.waveberry.mods.ModSprintToggle;

public class ModInstances {

    public static ModFPS modFPS = new ModFPS();
    public static ModSprintToggle modSprintToggle = new ModSprintToggle();
    public static ModPing modPing = new ModPing();

    public static void register(HUDManager api) {
        modFPS = new ModFPS();
        modSprintToggle = new ModSprintToggle();
        modPing = new ModPing();
        api.register(modPing);
        api.register(modFPS);
        api.register(modSprintToggle);
    }

}

