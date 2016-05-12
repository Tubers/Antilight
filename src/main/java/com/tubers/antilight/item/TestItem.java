package com.tubers.antilight.item;


import com.tubers.antilight.Antilight;
import com.tubers.antilight.References;
import net.minecraft.item.Item;


public class TestItem extends Item
{
    public TestItem()
    {
        super();

        setCreativeTab(Antilight.tabAntilight);
        setUnlocalizedName(References.Mod.MODID + "." + References.AntilightItem.TEST_ITEM.getRegName());
        setRegistryName(References.AntilightItem.TEST_ITEM.getRegName());
    }


}
