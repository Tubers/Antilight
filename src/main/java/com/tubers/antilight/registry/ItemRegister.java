package com.tubers.antilight.registry;


import com.tubers.antilight.References;
import com.tubers.antilight.item.TestItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemRegister {

    public static Item Test_Item;

    public static void init ()
    {
        Test_Item = registerItem(new TestItem());
    }

    public static void initRenders()
    {
        registerRender(Test_Item);
    }

    public static void registerRender(Item item)
    {
        System.out.println(item.getClass().getSimpleName());

        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(References.Mod.MODID + ":" + item.getUnlocalizedName().split("\\.")[2], "inventory"));
    }

    private static Item registerItem(Item item)
    {
        //String itemName = item.getRegistryName().split(":")[1];
        // check if blacklisted configuration item. It blacklisted, don't register.
        GameRegistry.registerItem(item);
        //register item model?? (item, itemName)
        return item;
    }
}
