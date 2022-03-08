package nilau.recipeflow;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import nilau.recipeflow.items.FlowchartTool;

public class AddedItems {

	public static Item flowchartTool;
	
	public static void initItems() {
		flowchartTool = new FlowchartTool();
		GameRegistry.registerItem(flowchartTool, "FlowchartMaker");
	}
}
