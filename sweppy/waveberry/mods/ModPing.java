package org.sweppy.waveberry.mods;

import net.minecraft.server.MinecraftServer;
import org.sweppy.waveberry.hudposition.ModDraggable;
import org.sweppy.waveberry.hudposition.impl.ScreenPosition;

public class ModPing extends ModDraggable {

    private ScreenPosition pos;

    public ModPing() {
        super("PING");
    }

    @Override
    public int getWidth() {
        return font.getStringWidth("[00 ms]");
    }
    @Override
    public int getHeight() {
        return font.FONT_HEIGHT;
    }
    @Override
    public void render(ScreenPosition pos) {
        if(!MinecraftServer.getServer().isSinglePlayer()) {
            font.drawStringWithShadow("[" + mc.getCurrentServerData().pingToServer + " ms]", pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
        } else {
            font.drawStringWithShadow("[0 ms]", pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
        }
    }

    @Override
    public void save(ScreenPosition pos) {
        this.pos = pos;
    }

    @Override
    public ScreenPosition load() {
        return pos;
    }
}