package org.sweppy.waveberry.gui.hudmod.comp;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.MinecraftError;
import net.minecraft.util.ResourceLocation;

import java.awt.*;

public class ModButton extends GuiButton {
    String modName;
    ResourceLocation resourceLocationFile;
    public ModButton(String mod,int id, int x, int y,int width, int height, ResourceLocation resourceLocation) {
        super(id, x, y, width, height, "");
        modName = mod;
        resourceLocationFile = resourceLocation;
    }

    public void drawButton(Minecraft mc, int x, int y) {
        if (this.visible) {

            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            boolean flag = x >= this.xPosition && y >= this.yPosition && x < this.xPosition + this.width && y < this.yPosition + this.height;

            if(resourceLocationFile != null){
                mc.getTextureManager().bindTexture(resourceLocationFile);
            }
            if(flag){
                Gui.drawScaledCustomSizeModalRect(this.xPosition + 13, this.yPosition + 13, this.width - 29, this.height- 29, this.width- 29, this.height- 29,this.width- 29,this.height- 29,this.width- 29,this.height- 29);

            }else{
                Gui.drawScaledCustomSizeModalRect(this.xPosition + 15, this.yPosition + 15, this.width - 30, this.height- 30, this.width- 30, this.height- 30,this.width- 30,this.height- 30,this.width- 30,this.height- 30);

            }

            if(flag){
                ModDrawer.drawBigOutline(this.xPosition,this.yPosition,this.xPosition + this.width,this.yPosition + this.height,-20);

            }else{
                ModDrawer.drawOutline(this.xPosition,this.yPosition,this.xPosition + this.width,this.yPosition + this.height,-1);

            }
            Gui.drawCenteredString(Minecraft.getMinecraft().fontRendererObj,modName,xPosition + (width/ 2),this.yPosition + height - 13,-1);

        }
    }
}