package nilau.recipeflow.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiLabel;
import net.minecraft.client.gui.GuiScreen;

public class GuiScreenExtended extends GuiScreen{
	/**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        int k;

        for (k = 0; k < this.buttonList.size(); ++k)
        {
            ((GuiButton)this.buttonList.get(k)).drawButton(this.mc, p_73863_1_, p_73863_2_);
        }

        for (k = 0; k < this.labelList.size(); ++k)
        {
            ((GuiLabel)this.labelList.get(k)).func_146159_a(this.mc, p_73863_1_, p_73863_2_);
        }
    }
}
