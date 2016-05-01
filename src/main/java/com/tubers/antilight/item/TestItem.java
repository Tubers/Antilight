package com.tubers.antilight.item;


import com.tubers.antilight.References;
import net.minecraft.item.Item;

public class TestItem extends Item
{
    public TestItem()
    {
        super();

        setUnlocalizedName(References.Mod.MODID + "." + References.AntilightItem.TEST_ITEM.getRegName());
        setRegistryName(References.AntilightItem.TEST_ITEM.getRegName());
    }


}
