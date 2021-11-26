package org.sweppy.waveberry.hudposition;

import org.sweppy.waveberry.hudposition.impl.IRenderer;
import org.sweppy.waveberry.hudposition.impl.ScreenPosition;

public abstract class ModDraggable extends Mod implements IRenderer {

    public ModDraggable(String name) {
        super(name);
    }

    public final int getLineOffset(ScreenPosition pos, int lineNum) {
        return pos.getAbsoluteX() + getLineOffset(lineNum);
    }

    private int getLineOffset(int lineNum) {
        return (font.FONT_HEIGHT + 3) * lineNum;
    }

}
