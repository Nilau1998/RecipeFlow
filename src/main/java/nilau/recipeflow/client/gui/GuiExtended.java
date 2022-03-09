package nilau.recipeflow.client.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.Tessellator;

public class GuiExtended extends Gui{
	/**
     * Draws a custom sized textured rectangle at the stored z-value. Args: x, y, u, v, width, height
     * 
     * Based on the original method drawTexturedModalRect()
     */
	public void drawTexturedModalRectCustomSize(int x, int y, int u, int v, int width, int height, float texture_size_x, float texture_size_y)
    {
        float f = 1/texture_size_x;
        float f1 = 1/texture_size_y;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV((double)(x + 0), (double)(y + height), (double)this.zLevel, (double)((float)(u + 0) * f), (double)((float)(v + height) * f1));
        tessellator.addVertexWithUV((double)(x + width), (double)(y + height), (double)this.zLevel, (double)((float)(u + width) * f), (double)((float)(v + height) * f1));
        tessellator.addVertexWithUV((double)(x + width), (double)(y + 0), (double)this.zLevel, (double)((float)(u + width) * f), (double)((float)(v + 0) * f1));
        tessellator.addVertexWithUV((double)(x + 0), (double)(y + 0), (double)this.zLevel, (double)((float)(u + 0) * f), (double)((float)(v + 0) * f1));
        tessellator.draw();
    }
	
	public void drawStringScalable(FontRenderer fontRendererIn, String text, int x, int y, float scale, int color) {
        GL11.glScalef(scale, scale,scale);
        float mScale = (float)Math.pow(scale, -1);
        this.drawString(fontRendererIn, text, Math.round(x / scale), Math.round(y / scale), color);
        GL11.glScalef(mScale, mScale, mScale);
    }
	
	/**
     * Renders the specified text to the screen, center-aligned.
     */
    public void drawCenteredString(FontRenderer fontRendererIn, String text, int x, int y, float scale, int color)
    {
    	GL11.glScalef(scale, scale, scale);
        float mScale = (float)Math.pow(scale, -1);
    	fontRendererIn.drawStringWithShadow(text, (x - fontRendererIn.getStringWidth(text) / 2), y, color);
    	GL11.glScalef(mScale, mScale, mScale);
    }
    
    /**
     * Renders the specified text to the screen, left-aligned.
     */
    public void drawString(FontRenderer fontRendererIn, String text, int x, int y, float scale, int color)
    {
    	GL11.glScalef(scale, scale, scale);
    	float mScale = (float)Math.pow(scale, -1);
    	fontRendererIn.drawStringWithShadow(text, x, y, color);
    	GL11.glScalef(mScale, mScale, mScale);
    }
}