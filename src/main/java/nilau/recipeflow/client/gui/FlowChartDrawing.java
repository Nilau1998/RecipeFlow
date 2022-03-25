package nilau.recipeflow.client.gui;

import java.util.LinkedList;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraft.stats.StatFileWriter;
import net.minecraft.util.ResourceLocation;

public class FlowChartDrawing extends GuiScreen {
	private static final int field_146572_y = AchievementList.minDisplayColumn * 24 - 112;
    private static final int field_146571_z = AchievementList.minDisplayRow * 24 - 112;
    private static final int field_146559_A = AchievementList.maxDisplayColumn * 24 - 77;
    private static final int field_146560_B = AchievementList.maxDisplayRow * 24 - 77;
    private static final ResourceLocation field_146561_C = new ResourceLocation("textures/gui/achievement/achievement_background.png");
    protected GuiScreen field_146562_a;
    protected int field_146555_f = 256;
    protected int field_146557_g = 202;
    protected int field_146563_h;
    protected int field_146564_i;
    protected float field_146570_r = 1.0F;
    protected double field_146569_s;
    protected double field_146568_t;
    protected double field_146567_u;
    protected double field_146566_v;
    protected double field_146565_w;
    protected double field_146573_x;
    private int field_146554_D;
    private StatFileWriter field_146556_E;
    private boolean field_146558_F = true;
    private static final String __OBFID = "CL_00000722";

    private int currentPage = -1;
    private GuiButton button;
    private LinkedList<Achievement> minecraftAchievements = new LinkedList<Achievement>();
}
