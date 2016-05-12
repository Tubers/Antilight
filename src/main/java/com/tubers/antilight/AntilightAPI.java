package com.tubers.antilight;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class AntilightAPI {

    public static Item getItem(String name)
    {
        return GameRegistry.findItem(References.Mod.MODID, name);
    }

    public static Block getBlock(String name) {return GameRegistry.findBlock(References.Mod.MODID, name); }

}
