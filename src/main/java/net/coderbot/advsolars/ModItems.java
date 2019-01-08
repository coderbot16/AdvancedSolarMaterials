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
	public static Item SUNNARIUM_ENRICHED;
	public static Item SUNNARIUM_PLATE;
	public static Item SUNNARIUM_ENRICHED_PLATE;

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		SUNNARIUM = register(event, "sunnarium");
		SUNNARIUM_ENRICHED = register(event, "sunnarium_enriched");
		SUNNARIUM_PLATE = register(event, "sunnarium_plate");
		SUNNARIUM_ENRICHED_PLATE = register(event, "sunnarium_enriched_plate");
	}

	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {
		register(event, SUNNARIUM);
		register(event, SUNNARIUM_ENRICHED);
		register(event, SUNNARIUM_PLATE);
		register(event, SUNNARIUM_ENRICHED_PLATE);
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
