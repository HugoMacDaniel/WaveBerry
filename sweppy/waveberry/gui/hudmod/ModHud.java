package org.sweppy.waveberry.gui.hudmod;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import org.sweppy.waveberry.gui.hudmod.comp.ModButton;

import java.io.IOException;

public class ModHud extends GuiScreen {

    @Override
    public void initGui() {
        super.initGui();
        this.buttonList.add( new ModButton("FPS",500,500, 80,80, 80, new ResourceLocation("waveberry/exit.png")));
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if (button.id == 500) {
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
        Gui.drawRect(100, 100, 100, 100, -1);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}
