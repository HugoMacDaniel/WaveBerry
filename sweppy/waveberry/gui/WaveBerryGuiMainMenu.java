/*
    Sweppy#0326 [For the mainmenu, pos, actionperformed ect...]
    Internet For Open Link
    Intenet For assets img
    Fireentr#9717 [For move background]
 */

package org.sweppy.waveberry.gui;

import net.minecraft.client.gui.*;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.sweppy.waveberry.WaveBerry;
import org.sweppy.waveberry.guiutils.*;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WaveBerryGuiMainMenu extends GuiScreen {

    @Override
    public void initGui() {
        WaveBerry.discordRP.update("Idle", "MainMenu");
        this.buttonList.add(new GuiButtonUtils(1, width / 2 - 100, height / 2 - 16, 220, 20, "S I N G L E P L A Y E R"));
        this.buttonList.add(new GuiButtonUtils(2, width / 2 - 100, height / 2 + 7, 220, 20, "M U L T I P L A Y E R"));
        this.buttonList.add(new GuiButtonIconUtils(3, width / 2 - 5, height / 2 + 32, 22, 22, "options.png"));
        this.buttonList.add(new GuiExitUtils(4, width - 28, 5, 22, 22, "exit.png"));
        this.buttonList.add(new GuiButtonIconUtils(5,width / 2 + 26, height / 2 + 32, 22, 22, "discord.png"));
        this.buttonList.add(new GuiButtonIconUtils(6,width / 2 - 37, height / 2 + 32, 22, 22, "twitter.png"));
        super.initGui();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        GL11.glColor4f(1, 1, 1, 1);
        //Background
        mc.getTextureManager().bindTexture(new ResourceLocation("waveberry/bg2.png"));
        Gui.drawModalRectWithCustomSizedTexture(-21 + (Mouse.getX() / 90), ((Mouse.getY() * -1 / 90)), 0, 0, width + 20, height + 20, width + 21, height + 20);

        // Logo
        GuiLogoUtils.drawScaledLogo(width / 2 + 5, height / 2 - 60, 110);

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if(button.id == 1) {
            mc.displayGuiScreen(new GuiSelectWorld(this));
        }
        if(button.id == 2) {
            mc.displayGuiScreen(new GuiMultiplayer(this));
        }
        if(button.id == 3) {
            mc.displayGuiScreen(new GuiOptions(this, mc.gameSettings));
        }
        if(button.id == 4) {
            mc.shutdown();
        }
        // Discord Button Open Invite
        if(button.id == 5) {
            String url_open ="HTTPS://discord.gg/DXm35hS8wX";
            try {
                java.awt.Desktop.getDesktop().browse(java.net.URI.create(url_open));
            } catch (IOException ex) {
                Logger.getLogger(WaveBerry.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // Twitter Button Open App Account
        if(button.id == 6) {
            String url_open ="HTTPS://discord.gg/DXm35hS8wX";
            try {
                java.awt.Desktop.getDesktop().browse(java.net.URI.create(url_open));
            } catch (IOException ex) {
                Logger.getLogger(WaveBerry.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}
