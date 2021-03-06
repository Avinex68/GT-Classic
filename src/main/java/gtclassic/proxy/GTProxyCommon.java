package gtclassic.proxy;

import java.io.File;

import gtclassic.GTConfig;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class GTProxyCommon {

	// config instance
	public static Configuration config;

	// create config on pre load
	public void preInit(FMLPreInitializationEvent e) {
		File directory = e.getModConfigurationDirectory();
		config = new Configuration(new File(directory.getPath(), "ic2/gtclassic.cfg"));
		GTConfig.readConfig();
		config.save();
	}

	public void init(FMLInitializationEvent e) {
		// temporarily empty init method
	}

	public void postInit(FMLPostInitializationEvent e) {
		// temporarily empty post init method
	}
}
