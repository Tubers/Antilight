package com.tubers.antilight;

import com.tubers.antilight.block.TestBlock;
import com.tubers.antilight.network.PacketHandler;
import com.tubers.antilight.proxy.CommonProxy;
import com.tubers.antilight.registry.BlockRegister;
import com.tubers.antilight.registry.ItemRegister;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTorch;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.WorldServer;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.core.config.plugins.ResolverUtil;


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
            return ItemRegister.Test_Item;
        }
    };

    private Configuration config;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {

        ItemRegister.init();
        BlockRegister.init();

        CommonProxy.preInit();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        PacketHandler.init();
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

    // injected method through asm transformer
    public static int getLightValue(Block block, IBlockAccess world, BlockPos pos)
    {
        int vanillaValue = block.getLightValue(world, pos);

        if (instance == null || world instanceof WorldServer)
        {
            return vanillaValue;
        }


        int dampenLightValue = 0;


        return vanillaValue - dampenLightValue;
    }

}

