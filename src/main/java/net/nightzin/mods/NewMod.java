package net.nightzin.mods;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.nightzin.mods.block.ModBlocks;
import net.nightzin.mods.component.ModDataComponentTypes;
import net.nightzin.mods.item.ModItems;
import net.nightzin.mods.item.ModItemsGroup;
import net.nightzin.mods.util.HammerUsageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewMod implements ModInitializer {
	public static final String MOD_ID = "newmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItemsGroup.registerItemGroups();

        ModItems.registerModItems();
        ModBlocks.registerModBlocks();

        ModDataComponentTypes.registerDataComponentTypes();

        FuelRegistry.INSTANCE.add(ModItems.STARLIGHT_ASHES, 600);

        PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
	}
}