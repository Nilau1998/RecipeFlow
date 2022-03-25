package nilau.recipeflow.client.gui;

import java.util.concurrent.locks.ReentrantLock;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class GuiButtonFactoryList extends GuiButton{
	protected static final ResourceLocation buttonTextures = new ResourceLocation("textures/gui/widgets.png");
    /** Button width in pixels */
    private int width;
    /** Button height in pixels */
    private int height;
    /** The indent in front of the button text. */
    private int textIndent;
    /** The x position of this control. */
    private int xPosition;
    /** The y position of this control. */
    private int yPosition;
    /** The string displayed on this control. */
    private String displayString;
    private int id;
    /** True if this control is enabled, false to disable. */
    private boolean enabled;
    /** Hides the button completely if false. */
    private boolean visible;
    protected boolean field_146123_n;
    private static final String __OBFID = "CL_00000668";
    private int packedFGColour;
    private float scale;
    
    public GuiButtonFactoryList(int p_i1021_1_, int p_i1021_2_, int p_i1021_3_, int p_i1021_4_, int p_i1021_5_, String p_i1021_6_, float p_scale) {
    	super(p_i1021_1_, p_i1021_2_, p_i1021_3_, p_i1021_4_, p_i1021_5_, p_i1021_6_);
    	this.width = 200;
        this.height = 20;
        this.textIndent = 4;
        this.enabled = true;
        this.visible = true;
        this.id = p_i1021_1_;
        this.xPosition = p_i1021_2_;
        this.yPosition = p_i1021_3_;
        this.width = p_i1021_4_;
        this.height = p_i1021_5_;
        this.displayString = p_i1021_6_;
        this.scale = p_scale;
    }
    
    /**
     * Draws this button to the screen.
     */
    public void drawButton(Minecraft p_146112_1_, int p_146112_2_, int p_146112_3_)
    {
    	if (this.visible)
        {
        	FontRenderer fontrenderer = p_146112_1_.fontRenderer;
            p_146112_1_.getTextureManager().bindTexture(buttonTextures);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.field_146123_n = p_146112_2_ >= this.xPosition && p_146112_3_ >= this.yPosition && p_146112_2_ < this.xPosition + Math.round(this.width * scale) && p_146112_3_ < this.yPosition + Math.round(this.height * scale);
            int k = this.getHoverState(this.field_146123_n);
            GL11.glEnable(GL11.GL_BLEND);
            OpenGlHelper.glBlendFunc(770, 771, 1, 0);
            GL11.glScalef(scale, scale, scale);
            float mScale = (float)Math.pow(scale, -1);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            // Right side
            this.drawTexturedModalRect(Math.round(this.xPosition / scale), Math.round(this.yPosition / scale), 200 - this.width, 46 + k * 20, this.width, this.height);
            // Left side
            this.drawTexturedModalRect(Math.round(this.xPosition / scale), Math.round(this.yPosition / scale), 0, 46 + k * 20, this.width / 2, this.height);
            GL11.glScalef(mScale, mScale, mScale);
            this.mouseDragged(p_146112_1_, p_146112_2_, p_146112_3_);
            int l = 14737632;
            if (packedFGColour != 0)
            {
                l = packedFGColour;
            }
            else if (!this.enabled)
            {
                l = 10526880;
            }
            else if (this.field_146123_n)
            {
                l = 16777120;
            }
            GuiExtended guiExtended = new GuiExtended();
			guiExtended.drawString(fontrenderer, this.displayString, Math.round(this.xPosition / scale) + this.textIndent, Math.round(this.yPosition / scale) + (this.height - 8) / 2, scale, l);
        }
    }
    
    public boolean mousePressed(Minecraft p_146116_1_, int p_146116_2_, int p_146116_3_)
    {
        return this.enabled && this.visible && p_146116_2_ >= this.xPosition && p_146116_3_ >= this.yPosition && p_146116_2_ < this.xPosition + Math.round(this.width * scale) && p_146116_3_ < this.yPosition + Math.round(this.height * scale);
    }
}