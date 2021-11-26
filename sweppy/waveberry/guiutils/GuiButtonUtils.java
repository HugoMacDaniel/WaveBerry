/*
   Credits:
   haha yes#8128 [for fade button]
   ???? [For function like GLRect and ECT]
   Sweppy#0326 [For remap not 100% completed]
 */

package org.sweppy.waveberry.guiutils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import org.sweppy.waveberry.WaveBerry;
import org.sweppy.waveberry.utils.GLRectUtils;

import java.awt.*;

public class GuiButtonUtils extends GuiButton {

    int fade;

    public GuiButtonUtils(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText) {
        super(buttonId, x, y, widthIn, heightIn, buttonText);
    }

    public void drawButton(Minecraft mc, int mouseX, int mouseY) {
        if(this.visible) {
            this.hovered = (mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height);
            if(!hovered) {
                this.fade = 90;
            }
            else {
                if(this.fade <= 30) {
                    return;
                }
                if(this.fade != 230) {
                    this.fade += 5;
                }
            }
            float b = this.hovered ? new Color(153, 9, 193).getRGB() : new Color(255,255,255,255).getRGB();
            Color a = new Color(0,0,0, this.fade);
            GLRectUtils.drawRoundedOutline(this.xPosition, this.yPosition, this.xPosition + this.width, this.yPosition + this.height, 3.0f, 2.0f, this.enabled ? (this.hovered ? WaveBerry.getMainColor(255) : WaveBerry.getMainColor(150)) : WaveBerry.getMainColor(100));
            GLRectUtils.drawRoundedRect(this.xPosition, this.yPosition, this.xPosition + this.width, this.yPosition + this.height, 3.0f, this.enabled ? (this.hovered ? new Color(0, 0, 0, 100).getRGB() : new Color(30, 30, 30, 100).getRGB()) : new Color(70, 70, 70, 50).getRGB());
            GLRectUtils.drawRoundedRect(this.xPosition, this.yPosition,this.xPosition + this.width, this.yPosition + this.height, 2.0F , a.getRGB());
            WaveBerry.textRenderer2.drawCenteredString(this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, (int) b);
            this.mouseDragged(mc, mouseX, mouseY);
        }
    }
}
