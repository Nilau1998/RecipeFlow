package nilau.recipeflow.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import net.minecraft.world.World;

public class FactoryIO {
	private ArrayList<String> factoryList = new ArrayList<String>();
	
	public FactoryIO() {
		File folder = new File("RecipeFlowFactories/");
		if (!folder.exists()) {
			folder.mkdirs();
		}
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				factoryList.add(listOfFiles[i].getName().substring(0, listOfFiles[i].getName().length() - 5));
			}
		}
	}
	
	public void createFactoryFile(String factoryName) throws IOException {
		final File dir = new File("RecipeFlowFactories/");
		
		if (!dir.exists()) {
			dir.mkdirs();
		}
		
		FileWriter factoryFile = new FileWriter("RecipeFlowFactories/" + factoryName + ".json");
		factoryFile.close();
	}
	
	public void deleteFactoryFile(String factoryName) throws IOException {
		final File fileToDelete = new File("RecipeFlowFactories/" + factoryName + ".json");
		fileToDelete.delete();
	}
	
	public ArrayList<String> getFactoryList() {
		return factoryList;
	}
	
	public int getFactoryListLength() {
		return factoryList.size();
	}
	
	public String getFactoryName(int index) {
		return factoryList.get(index);
	}
	
	public void updateFactoryList() {
		factoryList.clear();
		File folder = new File("RecipeFlowFactories/");
		if (!folder.exists()) {
			folder.mkdirs();
		}
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				factoryList.add(listOfFiles[i].getName().substring(0, listOfFiles[i].getName().length() - 5));
			}
		}
	}
}