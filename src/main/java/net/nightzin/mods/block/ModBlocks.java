package net.nightzin.mods.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.nightzin.mods.NewMod;
import net.nightzin.mods.block.custom.MagicBlock;

public class ModBlocks {
    // blocos
    public static final Block PINK_GARNET_BLOCK = registerBlock("pink_garnet_block",
            new Block(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block RAW_PINK_GARNET_BLOCK = registerBlock("raw_pink_garnet_block",
            new Block(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.DRIPSTONE_BLOCK)));

    public static final Block PINK_GARNET_DEEPSLATE_ORE = registerBlock("pink_garnet_deepslate_ore",
            new Block(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));

    public static final Block PINK_GARNET_ORE = registerBlock("pink_garnet_ore",
            new Block(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.STONE)));


    public static final Block PINK_GARNET_STAIRS = registerBlock("pink_garnet_stairs",
            new StairsBlock(ModBlocks.PINK_GARNET_BLOCK.getDefaultState(),
                    AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static final Block PINK_GARNET_SLAB = registerBlock("pink_garnet_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block PINK_GARNET_BUTTON = registerBlock("pink_garnet_button",
            new ButtonBlock(BlockSetType.IRON, 2, AbstractBlock.Settings.create().strength(2f).requiresTool().noCollision()));
    public static final Block PINK_GARNET_PRESSURE_PLATE = registerBlock("pink_garnet_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block PINK_GARNET_FENCE = registerBlock("pink_garnet_fence",
            new FenceBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static final Block PINK_GARNET_FENCE_GATE = registerBlock("pink_garnet_fence_gate",
            new FenceGateBlock(WoodType.ACACIA, AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static final Block PINK_GARNET_WALL = registerBlock("pink_garnet_wall",
            new WallBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block PINK_GARNET_DOOR = registerBlock("pink_garnet_door",
            new DoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque()));
    public static final Block PINK_GARNET_TRAPDOOR = registerBlock("pink_garnet_trapdoor",
            new TrapdoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque()));

    public static final Block MAGIC_BLOCK = registerBlock("magic_block",
            new MagicBlock(AbstractBlock.Settings.create().strength(1f).requiresTool()));
    // metodos para auxiliar
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(NewMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(NewMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        NewMod.LOGGER.info("Registering mod blocks");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.PINK_GARNET_BLOCK);
            fabricItemGroupEntries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);

            fabricItemGroupEntries.add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);
            fabricItemGroupEntries.add(ModBlocks.PINK_GARNET_ORE);

            fabricItemGroupEntries.add(ModBlocks.MAGIC_BLOCK);
        });
    }
}
