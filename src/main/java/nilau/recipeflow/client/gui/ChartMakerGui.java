package nilau.recipeflow.client.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import nilau.recipeflow.lib.Reference;
import nilau.recipeflow.client.gui.*;

public class ChartMakerGui extends GuiScreenExtended {
	int guiWidth = 512;
	int guiHeight = 256;
	
	GuiButtonExtended addFlow;
	GuiButtonExtended removeFlow;
	GuiButtonExtended showFlowchart;
	// GuiButton editFlowName;
	
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
		guiExtension.drawStringScalable(fontRendererObj, "Test", guiX + 40, guiY + 40, 0.6F, 0xFFFFFF);
		guiExtension.drawStringScalable(fontRendererObj, "lmao", guiX + 40, guiY + 70, 1F, 0xFFFFFF);
		
		super.drawScreen(x, y, ticks);
	}
	
	@Override
	public void initGui() {
		int guiX = (width - guiWidth) / 2;
		int guiY = (height - guiHeight) / 2;
		
		buttonList.clear();
		buttonList.add(addFlow = new GuiButtonExtended(0, guiX + 9, guiY + 16, 10, 9, "+", 0.5F));
		buttonList.add(removeFlow = new GuiButtonExtended(1, guiX + 21, guiY + 16, 10, 9, "-", 0.5F));
		buttonList.add(showFlowchart = new GuiButtonExtended(2, guiX + 468, guiY + 9, 50, 20, "Flowchart", 0.7F));
		// buttonList.add(editFlowName = new GuiButton(3, guiX + 70, guiY + 51, 50, 20, ""));
		
		super.initGui();
	}
}
