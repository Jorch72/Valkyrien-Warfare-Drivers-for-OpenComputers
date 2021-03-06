package io.github.djeezuss.VWDrivers;

import io.github.djeezuss.VWDrivers.client.ModCreativeTab;
import io.github.djeezuss.VWDrivers.proxy.CommonProxy;
import io.github.djeezuss.VWDrivers.recipe.ModRecipes;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = "[1.11.2]",
	dependencies="required-after:valkyrienwarfare;required-after:opencomputers")
public class VWDrivers {
	
	@SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.SERVER)
	public static CommonProxy proxy;
	
	@Instance(Reference.MOD_ID)
	public static VWDrivers instance;
	
	public static final ModCreativeTab creativeTab = new ModCreativeTab();
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		proxy.preInit(e);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e) {
		ModRecipes.init();
		proxy.init(e);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		proxy.postInit(e);
	}
	
}
