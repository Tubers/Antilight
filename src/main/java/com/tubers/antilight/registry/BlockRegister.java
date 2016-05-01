package com.tubers.antilight.registry;

import com.tubers.antilight.block.NegativeLight;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockRegister {

    public static final NegativeLight block1 = new NegativeLight();

    public static void init()
    {
        GameRegistry.registerBlock(block1, "BlockNegativeLight");
    }

}
