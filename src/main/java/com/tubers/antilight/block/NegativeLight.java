package com.tubers.antilight.block;

import java.util.List;
import java.util.Random;

import com.tubers.antilight.Antilight;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class NegativeLight extends Block {

    protected static final AxisAlignedBB AABB = new AxisAlignedBB(0.4, 0.4, 0.4, 0.6, 0.6, 0.6);

    public NegativeLight()
    {
        super(Material.cloth);

        setUnlocalizedName("antilight.negativelight");
        setCreativeTab(Antilight.tabAntilight);

    }

    @Override
    @SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.CUTOUT;
    }

    @Override
    public boolean isNormalCube()
    {
        return false;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public boolean isFullCube()
    {
        return false;
    }


    @Override
    public int getLightValue(IBlockAccess world, BlockPos pos)
    {
        return 15;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean addDestroyEffects(World world, BlockPos pos, net.minecraft.client.particle.EffectRenderer effectRenderer)
    {
        if (world.getBlockState(pos).getBlock() == this)
        {
            Random random = new Random();
            effectRenderer.spawnEffectParticle(EnumParticleTypes.REDSTONE.getParticleID(), pos.getX() + 0.5D + random.nextGaussian() / 8, pos.getY() + 0.5D, pos.getZ() + 0.5D + random.nextGaussian() / 8, 0, 0, 0);
        }
        return true;
    }


    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        EntityPlayerSP playerSP = Minecraft.getMinecraft().thePlayer;

        if (rand.nextInt(3) != 0)
        {
            worldIn.spawnParticle(EnumParticleTypes.REDSTONE, pos.getX() + 0.5D + rand.nextGaussian() / 8, pos.getY() + 0.5D, pos.getZ() + 0.5D + rand.nextGaussian() / 8, 0, 0, 0, 0);
            worldIn.spawnParticle(EnumParticleTypes.REDSTONE, pos.getX() + 0.5D + rand.nextGaussian() / 8, pos.getY() + 0.5D, pos.getZ() + 0.5D + rand.nextGaussian() / 8, 0, 0, 0, 0);
            worldIn.spawnParticle(EnumParticleTypes.REDSTONE, pos.getX() + 0.5D + rand.nextGaussian() / 8, pos.getY() + 0.5D, pos.getZ() + 0.5D + rand.nextGaussian() / 8, 0, 0, 0, 0);
            worldIn.spawnParticle(EnumParticleTypes.REDSTONE, pos.getX() + 0.5D + rand.nextGaussian() / 8, pos.getY() + 0.5D, pos.getZ() + 0.5D + rand.nextGaussian() / 8, 0, 0, 0, 0);

        }
    }

    //

    @Override
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBox(World worldIn, BlockPos pos)
    {
        return AABB;
    }

    @Override
    public int quantityDropped(Random par1Random)
    {
        return 0;
    }


}
