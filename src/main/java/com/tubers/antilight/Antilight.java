package com.tubers.antilight;

import com.tubers.antilight.proxy.CommonProxy;
import com.tubers.antilight.registry.BlockRegister;
import com.tubers.antilight.registry.ItemRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;


@Mod(modid = References.Mod.MODID, name = References.Mod.NAME, version = References.Mod.VERSION)
public class Antilight
{

    @SidedProxy(serverSide = References.Mod.COMMON_PROXY, clientSide = References.Mod.CLIENT_PROXY)
    public static CommonProxy proxy;

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
        ItemRegister.init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.registerRenders();
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

