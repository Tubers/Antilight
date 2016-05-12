package com.tubers.antilight.proxy;


import com.tubers.antilight.utils.EventHandler;
import net.minecraftforge.common.MinecraftForge;



public class CommonProxy
{

    public static void preInit()
    {
        MinecraftForge.EVENT_BUS.register(new EventHandler());
    }
    public static void init()
    {

    }
    public static void postInit()
    {

    }



    public void registerRenders()
    {

    }

}
