package com.tubers.antilight.registry;

import com.tubers.antilight.References;
import com.tubers.antilight.block.TestBlock;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockRegister {

    public static Block Test_Block;

    public static void init ()
    {
        Test_Block = registerBlock(new TestBlock());
    }

    public static void initRenders()
    {
        registerRender(Test_Block);
    }

    public static void registerRender(Block block)
    {
        Item item = Item.getItemFromBlock(block);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(References.Mod.MODID + ":" + item.getUnlocalizedName().split("\\.")[2], "inventory"));
    }

    private static Block registerBlock(Block block)
    {
        //String itemName = item.getRegistryName().split(":")[1];
        // check if blacklisted configuration item. It blacklisted, don't register.
        GameRegistry.registerBlock(block);
        //register item model?? (item, itemName)
        return block;
    }

}
