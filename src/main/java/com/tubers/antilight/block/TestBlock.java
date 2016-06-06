package com.tubers.antilight.block;


import com.tubers.antilight.Antilight;
import com.tubers.antilight.References;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;

public class TestBlock extends Block {

    public TestBlock()
    {
        super(Material.cactus);

        setCreativeTab(Antilight.tabAntilight);
        setUnlocalizedName(References.Mod.MODID + "." + References.AntilightBlock.TEST_BLOCK.getRegName());
        setRegistryName(References.AntilightBlock.TEST_BLOCK.getRegName());
    }

    //Attempt some anti light mechanic shenanigans



}
