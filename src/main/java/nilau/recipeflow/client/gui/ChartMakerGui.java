package nilau.recipeflow.client.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiOptionButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import nilau.recipeflow.lib.Reference;
import nilau.recipeflow.client.gui.*;

public class ChartMakerGui extends GuiScreen {
	private int guiWidth = 512;
	private int guiHeight = 256;
	
	private GuiButtonCentered addFlow;
	private GuiButtonCentered removeFlow;
	private GuiButtonCentered showFlowchart;
	
	@Override
	public void drawScreen(int x, int y, float ticks) {
		int guiX = (width - guiWidth) / 2;
		int guiY = (height - guiHeight) / 2;
		GuiExtended guiExtension = new GuiExtended();
		GL11.glColor4f(1, 1, 1, 1);
		drawDefaultBackground();
		mc.renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/gui/gui_flowchartTool.png"));
		guiExtension.drawTexturedModalRectCustomSize(guiX, guiY, 0, 0, guiWidth, guiHeight, 512, 512);
		fontRendererObj.drawString("Recipe Flow", guiX + 7, guiY + 5, 0x000000);
		super.drawScreen(x, y, ticks);
	}
	
	@Override
	public void initGui() {
		int guiX = (width - guiWidth) / 2;
		int guiY = (height - guiHeight) / 2;
		String[] testingStringArray = {"Hey", "wie", "gehtssssssssssssss"};
		
		// hard coded buttons
		buttonList.clear();
		buttonList.add(addFlow = new GuiButtonCentered(0, guiX + 9, guiY + 16, 10, 9, "+", 1F));
		buttonList.add(removeFlow = new GuiButtonCentered(1, guiX + 21, guiY + 16, 10, 9, "-", 1F));
		buttonList.add(showFlowchart = new GuiButtonCentered(2, guiX + 468, guiY + 9, 50, 20, "Flowchart", 0.7F));
		int buttonIndexOffset = buttonList.size();
		int j = testingStringArray.length;
		for (int k = 0; k < j; ++k) {
			this.buttonList.add(new GuiButtonFactoryList(k + buttonIndexOffset, guiX + 9, 29 + guiY + 14 * k, invround(90, 0.7F), 20, testingStringArray[k], 0.7F));
		}
		
		super.initGui();
	}
	
	private int invround(int x, float y) {
		return Math.round(x * (1 / y));
	}
}
