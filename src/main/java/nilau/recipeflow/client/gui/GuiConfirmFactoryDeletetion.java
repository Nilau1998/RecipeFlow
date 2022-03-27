package nilau.recipeflow.client.gui;

import java.io.IOException;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.ResourceLocation;
import nilau.recipeflow.lib.Reference;
import nilau.recipeflow.util.FactoryIO;

public class GuiConfirmFactoryDeletetion extends GuiScreen {
	private int guiWidth = 175;
	private int guiHeight = 100;
	
	int buttonIDOffset = buttonList.size();
	FactoryIO factoryIO = new FactoryIO();
	
	private GuiButtonCenterAligned buttonDelete;
	private GuiButtonCenterAligned buttonCancel;
	
	private GuiChartMaker chartMaker;
	
	@Override
	public void drawScreen(int x, int y, float ticks) {
		int guiX = (width - guiWidth) / 2;
		int guiY = (height - guiHeight) / 2;
		GuiExtended guiExtension = new GuiExtended();
		GL11.glColor4f(1, 1, 1, 1);
		drawDefaultBackground();
		mc.renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/gui/gui_confirm_deletion.png"));
		guiExtension.drawTexturedModalRectCustomSize(guiX, guiY, 0, 0, guiWidth, guiHeight, 512, 512);
		fontRendererObj.drawString("Factory Plan Naming", guiX + 7, guiY + 5, 0x000000);
		super.drawScreen(x, y, ticks);
	}
	
	@Override
	public void initGui() {
		int guiX = (width - guiWidth) / 2;
		int guiY = (height - guiHeight) / 2;		

		// hard coded buttons
		buttonList.clear();
		buttonList.add(buttonDelete = new GuiButtonCenterAligned(0, guiX + 10, guiY + 40, 110, 20, "Delete", 1F));
		buttonList.add(buttonCancel = new GuiButtonCenterAligned(1, guiX + 123, guiY + 40, 43, 20, "Cancel", 1F));
		super.initGui();
	}
	
	@Override
	protected void actionPerformed(GuiButton button) {
		int guiX = (width - guiWidth) / 2;
		int guiY = (height - guiHeight) / 2;
		
		if (button == buttonDelete) {
			
		}
		
		if (button == buttonCancel) {
			chartMaker = new GuiChartMaker();
			mc.displayGuiScreen(chartMaker);
		}
		super.actionPerformed(button);
	}
	
	public void updateScreen() {
		super.updateScreen();
	}
	
	private int invround(int x, float y) {
		return Math.round(x * (1 / y));
	}
}
