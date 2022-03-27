package nilau.recipeflow.client.gui;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.GuiButton;
import nilau.recipeflow.util.FactoryIO;

public class GuiChartMakerButtonController {
    private List buttonList = new ArrayList();
    private int buttonIDOffset;
    private int guiX;
    private int guiY;
    
    GuiChartMakerButtonController(List buttonList, int buttonIDOffset, int guiX, int guiY) {
    	this.buttonIDOffset = buttonIDOffset;
    	this.guiX = guiX;
    	this.guiY = guiY;
    }
    
    public void refreshFactoryButtons() {
    	System.out.println("Factory List Length: " + buttonList.size());
    	for (int k = 0; k < buttonList.size(); ++k) {
    		if (((GuiButton)buttonList.get(k)) instanceof GuiButtonLeftAligned) {
    			((GuiButtonLeftAligned)buttonList.get(k)).xPosition = this.guiX + 9;
        		((GuiButtonLeftAligned)buttonList.get(k)).yPosition = 29 + this.guiY + 14 * (k - buttonIDOffset);
    		}
    	}
    }
    
    public void addButton(GuiButton newButton) {
    	buttonList.add(newButton);
    }
    
    public void popButton(GuiButton factory) {
    	buttonList.remove(factory);
    }
    
    public List getButtonList() {
    	return this.buttonList;
    }
    
    private int invround(int x, float y) {
		return Math.round(x * (1 / y));
	}
}
