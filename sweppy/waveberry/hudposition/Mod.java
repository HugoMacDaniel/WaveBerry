package org.sweppy.waveberry.hudposition;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import org.sweppy.waveberry.WaveBerry;
import org.sweppy.waveberry.events.EventManager;

public class Mod {
    private boolean isEnabled;

    protected final Minecraft mc;

    protected static FontRenderer font;

    protected final WaveBerry waveBerry;

    public String name;

    public Mod(String name) {
        this.name = name;
        this.mc = Minecraft.getMinecraft();
        font = this.mc.fontRendererObj;
        this.waveBerry = WaveBerry.instance;
        setEnabled(this.isEnabled);
    }

    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
        if (isEnabled) {
            EventManager.register(this);
        } else {
            EventManager.unregister(this);
        }
    }

    public boolean isEnabled() {
        return this.isEnabled;
    }

    public void toggle() {
        this.setEnabled(!isEnabled);
    }
}
