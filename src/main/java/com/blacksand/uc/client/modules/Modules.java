package com.blacksand.uc.client.modules;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

import java.util.ArrayList;
import java.util.List;

public class Modules {
    public static boolean xrayEnabled = false;
    public static boolean fullbrightEnabled = false;
    public static List<Block> xrayAllowedBlocks = new ArrayList<>();

    static {
        //Nether ores
        xrayAllowedBlocks.add(Blocks.ANCIENT_DEBRIS);
        xrayAllowedBlocks.add(Blocks.NETHER_GOLD_ORE);
        xrayAllowedBlocks.add(Blocks.NETHER_QUARTZ_ORE);

        //Overworld ores
        xrayAllowedBlocks.add(Blocks.COAL_ORE);
        xrayAllowedBlocks.add(Blocks.DEEPSLATE_COAL_ORE);
        xrayAllowedBlocks.add(Blocks.COPPER_ORE);
        xrayAllowedBlocks.add(Blocks.DEEPSLATE_COPPER_ORE);
        xrayAllowedBlocks.add(Blocks.IRON_ORE);
        xrayAllowedBlocks.add(Blocks.DEEPSLATE_IRON_ORE);
        xrayAllowedBlocks.add(Blocks.GOLD_ORE);
        xrayAllowedBlocks.add(Blocks.DEEPSLATE_GOLD_ORE);
        xrayAllowedBlocks.add(Blocks.REDSTONE_ORE);
        xrayAllowedBlocks.add(Blocks.DEEPSLATE_REDSTONE_ORE);
        xrayAllowedBlocks.add(Blocks.EMERALD_ORE);
        xrayAllowedBlocks.add(Blocks.DEEPSLATE_EMERALD_ORE);
        xrayAllowedBlocks.add(Blocks.DIAMOND_ORE);
        xrayAllowedBlocks.add(Blocks.DEEPSLATE_DIAMOND_ORE);
    }
}
