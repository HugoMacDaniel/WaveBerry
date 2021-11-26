/*
   Sweppy#0326 [For The Main Classe and Functions]
   Internet For Much of the Function Fixs
   and this dude (https://www.youtube.com/channel/UCDO0hEkGSvujLnb3cZb0XCA) uwu
 */

package org.sweppy.waveberry;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.Display;
import org.sweppy.waveberry.discord.DiscordRP;
import org.sweppy.waveberry.events.EventManager;
import org.sweppy.waveberry.events.EventTarget;
import org.sweppy.waveberry.events.impl.EventClientTick;
import org.sweppy.waveberry.gui.hudmod.ModHud;
import org.sweppy.waveberry.hudposition.Mod;
import org.sweppy.waveberry.hudposition.ModInstances;
import org.sweppy.waveberry.hudposition.impl.HUDManager;
import org.sweppy.waveberry.utils.CustomFontRenderer;
import org.sweppy.waveberry.utils.GuiUtils;

public class WaveBerry {

    public static WaveBerry instance = new WaveBerry();
    public static String name = "WaveBerry", version = "1.8.9", build = "1v01b189m";
    public static CustomFontRenderer textRenderer2;
    public boolean dev = true;
    public static DiscordRP discordRP = new DiscordRP();
    public static DiscordRP getDiscordRP() {
        return discordRP;
    }
    public final Minecraft mc;
    public static Logger LOGGER;
    public static CustomFontRenderer titleRenderer;
    public static CustomFontRenderer textRenderer;
    public static CustomFontRenderer titleRenderer2;
    public static EventManager eventManager;
    private static HUDManager hudManager;
    private static Mod mod;

    public WaveBerry() {
        this.mc = Minecraft.getMinecraft();
    }

    public void StartUp() {
        eventManager = new EventManager();
        hudManager = new HUDManager();
        mod = new Mod("");
        discordRP.start();
        if(!dev) {
            Display.setTitle(name + " (" + version + ") " + "[" + build +"]");
        }
        else {
            Display.setTitle(name + " (" + version + ") " + "[" + build +"]" + " DevMode");
        }
        eventManager.register(this);
    }

    public static void ModsAndHud(){
        hudManager = HUDManager.getInstance();
        ModInstances.register(hudManager);
    }

    public static int getMainColor(final int alpha) {
        return GuiUtils.getRGB(0, alpha);
    }

    public void onPostInit() {
        WaveBerry.titleRenderer = new CustomFontRenderer("Lato Bold", 16.0f);
        WaveBerry.titleRenderer2 = new CustomFontRenderer("Lato Black", 16.0f);
        WaveBerry.textRenderer = new CustomFontRenderer("Lato Light", 16.0f);
        WaveBerry.textRenderer2 = new CustomFontRenderer("Main Menu", 15.0f);
    }

    public static void error(final Object msg, final Object... objs) {
        WaveBerry.LOGGER.error("$[WaveBerry Client] " + msg, objs);
    }

    public void ShutDown() {
        discordRP.shutdown();
        eventManager.unregister(this);
    }

    @EventTarget
    public void onTick(EventClientTick event) {
        if (Minecraft.getMinecraft().gameSettings.keyBindHud.isPressed()) {
            hudManager.openConfigScreen();
        }
        if (Minecraft.getMinecraft().gameSettings.keyBindMod.isPressed()) {
            mc.displayGuiScreen(new ModHud());
        }
        KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindSprint.getKeyCode(), true);
    }
}
