package com.tubers.antilight;

import com.tubers.antilight.block.BlockRegister;
import com.tubers.antilight.block.NegativeLight;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

import java.io.FileOutputStream;


@Mod(modid = "antilight", name = "Antilight: Darkness Evolved", version = "1.0")
public class Antilight
{

    @Mod.Instance("antilight")
    public static Antilight instance;


    public static CreativeTabs tabAntilight = new CreativeTabs("antilight.creativeTab")
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

