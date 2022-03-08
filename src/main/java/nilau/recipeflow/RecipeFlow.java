package nilau.recipeflow;

import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import nilau.recipeflow.proxies.*;
import nilau.recipeflow.lib.*;

@Mod(modid = Reference.MOD_NAME, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
public class RecipeFlow {
	
	@SidedProxy(clientSide="nilau.recipeflow.proxies.ClientProxy", serverSide="nilau.recipeflow.proxies.CommonProxy")
	public static CommonProxy proxy;
	public static ClientProxy cproxy;
	
	public static Logger log = FMLLog.getLogger();
		
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		log.info("Mod preInit");
		AddedItems.initItems();
	}
	
	@Mod.EventHandler
	public void Init(FMLInitializationEvent event) {
		log.info("Mod Init");
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		log.info("Mod postInit");
	}
}
