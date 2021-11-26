/*
   Its just a remap by Sweppy#0326 and the class made by Tuxy#1321 (Cheatbreaker Animated Logo)
   now its static xd
 */

package org.sweppy.waveberry.guiutils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.SimpleTexture;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiLogoUtils {

    public static void drawScaledLogo(float x, float y, int size) {
        GL11.glPushMatrix();
        GL11.glTranslatef(x, y, 0.0F);
        GL11.glPopMatrix();
        drawTexture(new ResourceLocation("waveberry/logo.png"), x - (float) size / 2, y - (float) size / 2, size, size);
    }

    public static void bindTexture(final ResourceLocation resourceLocation) {
        ITextureObject texture = Minecraft.getMinecraft().getTextureManager().getTexture(resourceLocation);
        if (texture == null) {
            texture = new SimpleTexture(resourceLocation);
            Minecraft.getMinecraft().getTextureManager().loadTexture(resourceLocation, texture);
        }
        GL11.glBindTexture(3553, texture.getGlTextureId());
    }

    public static void drawTexture(final ResourceLocation resourceLocation, final float x, final float y, final float width, final float height) {
        GL11.glPushMatrix();
        final float size = width / 2.0f;
        GL11.glEnable(3042);
        GL11.glEnable(3553);
        GL11.glEnable(2848);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        bindTexture(resourceLocation);
        GL11.glBegin(7);
        GL11.glTexCoord2d(0.0f / size, 0.0f / size);
        GL11.glVertex2d(x, y);
        GL11.glTexCoord2d(0.0f / size, (0.0f + size) / size);
        GL11.glVertex2d(x, y + height);
        GL11.glTexCoord2d((0.0f + size) / size, (0.0f + size) / size);
        GL11.glVertex2d(x + width, y + height);
        GL11.glTexCoord2d((0.0f + size) / size, 0.0f / size);
        GL11.glVertex2d((x + width), y);
        GL11.glEnd();
        GL11.glEnable(3553);
        GL11.glDisable(2848);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
    }

}