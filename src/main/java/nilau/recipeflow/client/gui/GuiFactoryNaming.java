package nilau.recipeflow.client.gui;

import java.io.IOException;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import nilau.recipeflow.lib.Reference;
import nilau.recipeflow.util.FactoryIO;

public class GuiFactoryNaming extends GuiScreen {
	private int guiWidth = 175;
	private int guiHeight = 100;
	private GuiTextField textBox;
	
	int buttonIDOffset = buttonList.size();
	FactoryIO factoryIO = new FactoryIO();
	
	private GuiButtonCenterAligned buttonCreateFactory;
	private GuiButtonCenterAligned buttonCancel;
	private GuiButtonCenterAligned itemPickerBackground;
	private GuiButtonCenterAlignedItem itemPicker;
	
	private GuiChartMaker chartMaker;
	
	@Override
	public void drawScreen(int x, int y, float ticks) {
		int guiX = (width - guiWidth) / 2;
		int guiY = (height - guiHeight) / 2;
		GuiExtended guiExtension = new GuiExtended();
		GL11.glColor4f(1, 1, 1, 1);
		drawDefaultBackground();
		mc.renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/gui/gui_flowchartToolFactoryNaming.png"));
		guiExtension.drawTexturedModalRectCustomSize(guiX, guiY, 0, 0, guiWidth, guiHeight, 512, 512);
		this.textBox.drawTextBox();
		this.textBox.xPosition = guiX + 10;
		this.textBox.yPosition = guiY + 17;
		this.textBox.width = 132;
		fontRendererObj.drawString("Naming and Item selection", guiX + 7, guiY + 5, 0x000000);
		super.drawScreen(x, y, ticks);
	}
	
	@Override
	public void initGui() {
		int guiX = (width - guiWidth) / 2;
		int guiY = (height - guiHeight) / 2;
		
		this.textBox = new GuiTextField(this.fontRendererObj, this.width / 2 - 68, this.height/2-46, 137, 20);
		textBox.setMaxStringLength(20);
		textBox.setText("Enter Plan Name...");
		this.textBox.setFocused(true);
		

		// hard coded buttons
		buttonList.clear();
		buttonList.add(buttonCreateFactory = new GuiButtonCenterAligned(0, guiX + 10, guiY + 40, 110, 20, "Create New Factory", 1F));
		buttonList.add(buttonCancel = new GuiButtonCenterAligned(1, guiX + 123, guiY + 40, 43, 20, "Cancel", 1F));
		buttonList.add(itemPickerBackground = new GuiButtonCenterAligned(2, guiX + 145, guiY + 17, 20, 20, "", 1F));
		buttonList.add(itemPicker = new GuiButtonCenterAlignedItem(3, guiX + 147, guiY + 19, 20, 20, "", 1F));
		super.initGui();
	}
	
	@Override
	protected void actionPerformed(GuiButton button) {
		int guiX = (width - guiWidth) / 2;
		int guiY = (height - guiHeight) / 2;
		
		if (button == buttonCreateFactory) {
			try {
				factoryIO.createFactoryFile(this.textBox.getText());
				factoryIO.updateFactoryList();
				chartMaker = new GuiChartMaker();
				mc.displayGuiScreen(chartMaker);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if (button == buttonCancel) {
			chartMaker = new GuiChartMaker();
			mc.displayGuiScreen(chartMaker);
		}
		
		if (button == itemPicker) {
			System.out.println("itemPicker!");
		}
		super.actionPerformed(button);
	}
	
	@Override
	protected void keyTyped(char c, int key) {
		super.keyTyped(c, key);
		this.textBox.textboxKeyTyped(c, key);
	}
	
	private void drawItemStack() {
		
	}
	
	public void updateScreen() {
		super.updateScreen();
		this.textBox.updateCursorCounter();
	}
	
	private int invround(int x, float y) {
		return Math.round(x * (1 / y));
	}
}
