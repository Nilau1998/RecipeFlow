package nilau.recipeflow.client.gui;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiOptionButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.achievement.GuiAchievements;
import net.minecraft.network.play.client.C16PacketClientStatus;
import net.minecraft.util.ResourceLocation;
import nilau.recipeflow.lib.Reference;
import nilau.recipeflow.util.FactoryIO;
import nilau.recipeflow.client.gui.*;

public class ChartMakerGui extends GuiScreen {
	private int guiWidth = 512;
	private int guiHeight = 256;
	
	private int lastButtonPressedID;
	
	int buttonIDOffset = 3;
	FactoryIO factoryIO = new FactoryIO();
	
	private GuiButtonCentered createFactory;
	private GuiButtonCentered removeFactory;
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
		this.mc.getNetHandler().addToSendQueue(new C16PacketClientStatus(C16PacketClientStatus.EnumState.REQUEST_STATS));
		int guiX = (width - guiWidth) / 2;
		int guiY = (height - guiHeight) / 2;

		// hard coded buttons
		buttonList.clear();
		buttonList.add(createFactory = new GuiButtonCentered(0, guiX + 9, guiY + 16, 10, 9, "+", 1F));
		buttonList.add(removeFactory = new GuiButtonCentered(1, guiX + 21, guiY + 16, 10, 9, "-", 1F));
		buttonList.add(showFlowchart = new GuiButtonCentered(2, guiX + 468, guiY + 9, 50, 20, "Flowchart", 0.7F));
		
		// draws buttons from FactoryIO#factoryList
		System.out.println(buttonIDOffset);
		int j = factoryIO.getFactoryListLength();
		for (int k = 0; k < j; ++k) {
			this.buttonList.add(new GuiButtonFactoryList(k + buttonIDOffset, guiX + 9, 29 + guiY + 14 * k, invround(90, 0.7F), 20, factoryIO.getFactoryName(k), 0.7F));
		}
		super.initGui();
	}
	
	@Override
	protected void actionPerformed(GuiButton button) {
		System.out.println(button.id);
		int guiX = (width - guiWidth) / 2;
		int guiY = (height - guiHeight) / 2;
		
		if (button == createFactory) {
			FactoryNamingBox factoryNamingBox = new FactoryNamingBox();
			mc.displayGuiScreen(factoryNamingBox);
			System.out.println("New Factory created!");
		}
		if (button == removeFactory) {
			System.out.println("Factory deleted!");
		}
		if (button == showFlowchart) {
			System.out.println(factoryIO.getFactoryList());
		}
		if (button.id > 2 && button.id != lastButtonPressedID) {
			GuiButton last_button = (GuiButton) buttonList.get(lastButtonPressedID);
			last_button.enabled = true;
			button.enabled = false;
			writeLastButtonID(button.id);
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
		super.updateScreen();
	}

	private int invround(int x, float y) {
		return Math.round(x * (1 / y));
	}
	
	private void writeLastButtonID(int id) {
		lastButtonPressedID = id;
	}
}
