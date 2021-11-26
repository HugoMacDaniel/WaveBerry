package org.sweppy.waveberry.mods;

import org.sweppy.waveberry.hudposition.ModDraggable;
import org.sweppy.waveberry.hudposition.impl.ScreenPosition;

public class ModSprintToggle extends ModDraggable {

    private ScreenPosition pos;

    public ModSprintToggle() {
        super("SPRINT");
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
        return font.getStringWidth("Sprint Toggle");
    }

    @Override
    public int getHeight() {
        return font.FONT_HEIGHT;
    }

    @Override
    public void render(ScreenPosition pos) {
        if (mc.thePlayer.isSprinting()) {
            font.drawStringWithShadow("[Sprint (Toggle)]", pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
        }
        if (mc.thePlayer.isSneaking()) {
            font.drawStringWithShadow("[Sneaking (true)]", pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
        }
    }
}
