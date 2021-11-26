package org.sweppy.waveberry.mods;

import org.sweppy.waveberry.hudposition.ModDraggable;
import org.sweppy.waveberry.hudposition.impl.ScreenPosition;


public class ModFPS extends ModDraggable {

    private ScreenPosition pos;

    public ModFPS() {
        super("FPS");
    }

    @Override
    public void save(ScreenPosition pos) {
        this.pos = pos;
    }
    @Override
    public ScreenPosition load() {
        return pos;
    }

    @Override
    public int getWidth() {
        return font.getStringWidth("[FPS: " + mc.getDebugFPS() + "]");
    }

    @Override
    public int getHeight() {
        return font.FONT_HEIGHT;
    }

    @Override
    public void render(ScreenPosition pos) {
        font.drawStringWithShadow("[FPS: " + mc.getDebugFPS() + "]", pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
    }
}
