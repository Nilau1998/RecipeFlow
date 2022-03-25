package nilau.recipeflow.util;

import java.io.File;

import cpw.mods.fml.relauncher.FMLInjectionData;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;

public class CommonUtils {
	public static File getSaveLocation(World world) {
        File base = DimensionManager.getCurrentSaveRootDirectory();
        return world.provider.dimensionId == 0 ? base : new File(base, world.provider.getSaveFolder());
    }
	
	public static File getMinecraftDir() {
		return (File) FMLInjectionData.data()[6];
	}
	
	public static String getCurrentWorldName() {
        return Minecraft.getMinecraft().thePlayer.getEntityWorld().getWorldInfo().getWorldName();
    }
}
