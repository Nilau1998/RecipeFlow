package nilau.recipeflow.client.gui;

import java.util.concurrent.locks.ReentrantLock;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class GuiButtonCenterAlignedItem extends GuiButton {
	protected static final ResourceLocation buttonTextures = new ResourceLocation("textures/gui/container/inventory.png");
    /** Button width in pixels */
    public int width;
    /** Button height in pixels */
    public int height;
    /** The x position of this control. */
    public int xPosition;
    /** The y position of this control. */
    public int yPosition;
    /** The string displayed on this control. */
    public String displayString;
    public int id;
    /** True if this control is enabled, false to disable. */
    public boolean enabled;
    /** Hides the button completely if false. */
    public boolean visible;
    protected boolean field_146123_n;
    private static final String __OBFID = "CL_00000668";
    public int packedFGColour;
    private float scale;
    private RenderItem itemRender = new RenderItem();
	private FontRenderer fontRendererObj;
    
    public GuiButtonCenterAlignedItem(int p_i1021_1_, int p_i1021_2_, int p_i1021_3_, int p_i1021_4_, int p_i1021_5_, String p_i1021_6_, float p_scale) {
    	super(p_i1021_1_, p_i1021_2_, p_i1021_3_, p_i1021_4_, p_i1021_5_, p_i1021_6_);
    	this.width = 200;
        this.height = 20;
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
     * Draws this button to the screen with center alignment for the string.
     */
    public void drawButton(Minecraft mc, int p_146112_2_, int p_146112_3_) {
    	if (this.visible) {
        	FontRenderer fontrenderer = mc.fontRenderer;
        	mc.getTextureManager().bindTexture(buttonTextures);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.field_146123_n = p_146112_2_ >= this.xPosition && p_146112_3_ >= this.yPosition && p_146112_2_ < this.xPosition + Math.round(this.width * scale) && p_146112_3_ < this.yPosition + Math.round(this.height * scale);
            int k = this.getHoverState(this.field_146123_n);
            GL11.glEnable(GL11.GL_BLEND);
            OpenGlHelper.glBlendFunc(770, 771, 1, 0);
            GL11.glScalef(scale, scale, scale);
            float mScale = (float)Math.pow(scale, -1);
            itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, mc.getTextureManager(), new ItemStack(Blocks.bedrock), Math.round(this.xPosition / scale), Math.round(this.yPosition / scale));
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            // Right side
            //this.drawTexturedModalRect(Math.round(this.xPosition / scale), Math.round(this.yPosition / scale), 200 - this.width, 46 + k * 20, this.width, this.height);
            // Left side
            //this.drawTexturedModalRect(Math.round(this.xPosition / scale), Math.round(this.yPosition / scale), 0, 46 + k * 20, this.width / 2, this.height);
            GL11.glScalef(mScale, mScale, mScale);
            this.mouseDragged(mc, p_146112_2_, p_146112_3_);
        }
    }
    
    public boolean mousePressed(Minecraft p_146116_1_, int p_146116_2_, int p_146116_3_) {
        return this.enabled && this.visible && p_146116_2_ >= this.xPosition && p_146116_3_ >= this.yPosition && p_146116_2_ < this.xPosition + Math.round(this.width * scale) && p_146116_3_ < this.yPosition + Math.round(this.height * scale);
    }
    
    public void setEnabled(boolean setVariable) {
    	this.enabled = setVariable;
    }
    
    @Override
    public void func_146113_a(SoundHandler p_146113_1_)
    {
        p_146113_1_.playSound(PositionedSoundRecord.func_147674_a(new ResourceLocation("gui.button.press"), 1F));
    }
}