package com.tubers.antilight.registry;


import net.minecraft.item.Item;

public class ItemRegister {

    public static Item test_Item;

    public static void init ()
    {
        test_Item = new Item().setUnlocalizedName();
    }


}
