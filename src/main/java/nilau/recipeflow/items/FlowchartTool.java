package nilau.recipeflow.items;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import nilau.recipeflow.client.gui.ChartMakerGui;

public class FlowchartTool extends Item {
	public FlowchartTool() {
		super();
		this.setUnlocalizedName("FlowchartTool");
		this.setTextureName("rflow:flowchartTool");
		this.setCreativeTab(CreativeTabs.tabTools);
		this.setMaxStackSize(1);
	}
	@Override
	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
		if(!world.isRemote) {
			Minecraft.getMinecraft().displayGuiScreen(new ChartMakerGui());
		}
		return super.onItemRightClick(item, world, player);
	}
}