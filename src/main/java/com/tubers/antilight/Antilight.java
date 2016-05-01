package com.tubers.antilight;

import com.tubers.antilight.registry.BlockRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;


@Mod(modid = References.Mod.MODID, name = References.Mod.NAME, version = References.Mod.VERSION)
public class Antilight
{

    @Mod.Instance(References.Mod.MODID)
    public static Antilight instance;


    public static CreativeTabs tabAntilight = new CreativeTabs(References.Mod.MODID+".creativeTab")
    {
        @Override
        public Item getTabIconItem()
        {
            return Item.getItemById(0);
        }
    };

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        BlockRegister.init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }

    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent event)
    {

    }


}

