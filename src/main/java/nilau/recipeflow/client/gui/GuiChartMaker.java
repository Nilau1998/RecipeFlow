package nilau.recipeflow.client.gui;

import java.io.IOException;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import nilau.recipeflow.lib.Reference;
import nilau.recipeflow.util.FactoryIO;

public class GuiChartMaker extends GuiScreen {
	private int guiWidth = 512;
	private int guiHeight = 256;
	private int lastButtonPressedID;
	
	FactoryIO factoryIO = new FactoryIO();
	FlowChartGui flowChartGui = new FlowChartGui();
	GuiFactoryNaming factoryNamingBox = new GuiFactoryNaming();
	GuiChartMakerButtonController guiChartMakerButtonController;
	
	private GuiButtonCenterAligned buttonCreateFactory;
	private GuiButtonCenterAligned buttonRemoveFactory;
	private GuiButtonCenterAligned buttonShowFlowchart;
	private GuiButton debug;
	
	int buttonIDOffset = 4;
	
	@Override
	public void initGui() {
		int guiX = (width - guiWidth) / 2;
		int guiY = (height - guiHeight) / 2;
		guiChartMakerButtonController = new GuiChartMakerButtonController(buttonList, buttonIDOffset, guiX, guiY);

		// hard coded buttons
		guiChartMakerButtonController.addButton(buttonCreateFactory = new GuiButtonCenterAligned(0, guiX + 9, guiY + 16, 10, 9, "+", 1F));
		guiChartMakerButtonController.addButton(buttonRemoveFactory = new GuiButtonCenterAligned(1, guiX + 21, guiY + 16, 10, 9, "-", 1F));
		guiChartMakerButtonController.addButton(buttonShowFlowchart = new GuiButtonCenterAligned(2, guiX + 468, guiY + 9, 50, 20, "Flowchart", 0.7F));
		guiChartMakerButtonController.addButton(debug = new GuiButton(3, guiX + 34, guiY + 9, 50, 20, "Debug"));
		
		// create existing factory buttons from FactoryIO#factoryList
		int j = factoryIO.getFactoryListLength();
		for (int k = 0; k < j; ++k) {
			guiChartMakerButtonController.addButton(new GuiButtonLeftAligned(k + buttonIDOffset, guiX + 9, 29 + guiY + 14 * k, invround(90, 0.7F), 20, factoryIO.getFactoryName(k), 0.7F));
		}
		
		// Get initial buttons from controller to draw them via buttonList
		buttonList.clear();
		buttonList.addAll(guiChartMakerButtonController.getButtonList());
		
		debug.visible = false; // hide debug button
		((GuiButtonCenterAligned)buttonList.get(1)).enabled = false; // initialize buttonRemoveFactory disabled
		((GuiButton)buttonList.get(1)).enabled = false; // initialize buttonRemoveFactory disabled
		((GuiButtonCenterAligned)buttonList.get(2)).enabled = false; // initialize buttonShowFlowChart disabled
		((GuiButton)buttonList.get(2)).enabled = false; // initialize buttonShowFlowChart disabled
		
		super.initGui();
	}
	
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
	protected void actionPerformed(GuiButton button) {
		System.out.println("Button ID, Name: " + button.id + " " + button.displayString);
		int guiX = (width - guiWidth) / 2;
		int guiY = (height - guiHeight) / 2;
		
		if (button == buttonCreateFactory) {
			mc.displayGuiScreen(factoryNamingBox);
		}
		if (button == buttonRemoveFactory) {
			try {
				factoryIO.deleteFactoryFile(((GuiButtonLeftAligned)buttonList.get(lastButtonPressedID)).displayString);
				((GuiButtonLeftAligned)buttonList.get(lastButtonPressedID)).visible = false;
				guiChartMakerButtonController.popButton(((GuiButtonLeftAligned)buttonList.get(lastButtonPressedID)));
				guiChartMakerButtonController.refreshFactoryButtons();
				((GuiButtonCenterAligned)buttonList.get(1)).enabled = false;
				((GuiButton)buttonList.get(1)).enabled = false;
				((GuiButtonCenterAligned)buttonList.get(2)).enabled = false;
				((GuiButton)buttonList.get(2)).enabled = false;
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (button == buttonShowFlowchart) {
			mc.displayGuiScreen(flowChartGui);
		}
		if (button.id > 3) {
			// Enable buttonRemoveFactory, showFlowchart
			((GuiButtonCenterAligned)buttonList.get(1)).enabled = true;
			((GuiButton)buttonList.get(1)).enabled = true;
			((GuiButtonCenterAligned)buttonList.get(2)).enabled = true;
			((GuiButton)buttonList.get(2)).enabled = true;
			
			// Enable / Disable FactoryListButtons
			((GuiButton)buttonList.get(lastButtonPressedID)).enabled = true;
			((GuiButton)button).enabled = false;
			writeLastButtonID(button.id);
		}
		if (button == debug) {
			guiChartMakerButtonController.refreshFactoryButtons();
		}
		super.actionPerformed(button);
	}
	
	@Override
	protected void keyTyped(char c, int key) {
		switch(key) {
		case Keyboard.KEY_E:
			mc.displayGuiScreen(null);
		case Keyboard.KEY_ESCAPE:
			mc.displayGuiScreen(null);
		}
	}
	
	public void updateScreen() {
		//factoryListControler.refreshButtons();
		super.updateScreen();
	}

	private int invround(int x, float y) {
		return Math.round(x * (1 / y));
	}
	
	private void writeLastButtonID(int id) {
		if (id >= buttonIDOffset) {
			lastButtonPressedID = id;
		}
	}
}
