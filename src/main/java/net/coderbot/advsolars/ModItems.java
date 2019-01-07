package net.coderbot.advsolars;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = AdvancedSolarMaterials.MODID)
public class ModItems {

	public static Item SUNNARIUM;

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		System.out.println("REGISTER ITEMS");
	   SUNNARIUM = register(event, "sunnarium");
	}

	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {
		register(event, SUNNARIUM);
	}

	private static Item register(RegistryEvent.Register<Item> event, String name) {
		Item item = new Item();

		item.setRegistryName(new ResourceLocation(AdvancedSolarMaterials.MODID, name));
		item.setUnlocalizedName(AdvancedSolarMaterials.MODID + '.' + name);
		event.getRegistry().register(item);

		return item;
	}

	private static void register(ModelRegistryEvent event, Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
