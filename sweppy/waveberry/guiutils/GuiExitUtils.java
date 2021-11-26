/*
   Idk who is the owner of this code.
   Sweppy#0326 [remover of the shadows, added clean red background]
 */

package org.sweppy.waveberry.guiutils;

import net.minecraft.util.*;
import net.minecraft.client.*;
import java.awt.*;
import net.minecraft.client.renderer.*;
import org.sweppy.waveberry.WaveBerry;
import org.sweppy.waveberry.utils.GLRectUtils;
import org.sweppy.waveberry.utils.GuiUtils;

public class GuiExitUtils extends GuiButtonUtils
{
    private final ResourceLocation ICON;

    public GuiExitUtils(final int buttonId, final int x, final int y, final int width, final int height, final String iconName) {
        super(buttonId, x, y, width, height, "");
        this.ICON = new ResourceLocation("waveberry/icons/" + iconName);
    }

    public void drawButton(final Minecraft mc, final int mouseX, final int mouseY) {
        if (this.visible) {
            this.hovered = (mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height);
            GLRectUtils.drawRoundedOutline(this.xPosition, this.yPosition, this.xPosition + this.width, this.yPosition + this.height, 3.0f, 2.0f, this.enabled ? (this.hovered ? WaveBerry.getMainColor(135) : WaveBerry.getMainColor(12)) : WaveBerry.getMainColor(255));
            GLRectUtils.drawRoundedRect(this.xPosition, this.yPosition, this.xPosition + this.width, this.yPosition + this.height, 3.0f, this.enabled ? (this.hovered ? new Color(140, 25, 25, 100).getRGB() : new Color(60, 5, 5, 100).getRGB()) : new Color(225, 90, 90, 50).getRGB());
            mc.getTextureManager().bindTexture(this.ICON);
            // icon size
            final int b = 15;
            GlStateManager.enableBlend();
            // icon color
            GuiUtils.setGlColor(new Color(255, 255, 255, 255).getRGB());
            GuiUtils.drawScaledCustomSizeModalRect(this.xPosition + (this.width - b) / 0.0f + 0.0f, this.yPosition + (this.height - b) / 100 + 100, 100f, 100f, b, b, b, b, b, b);
            GuiUtils.drawScaledCustomSizeModalRect(this.xPosition + (this.width - b) / 2, this.yPosition + (this.height - b) / 2, 0f, 0f, b, b, b, b, (float)b, (float)b);
        }
    }
}