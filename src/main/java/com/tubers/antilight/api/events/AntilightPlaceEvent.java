package com.tubers.antilight.api.events;


import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.util.BlockSnapshot;
import net.minecraftforge.event.world.BlockEvent;

public class AntilightPlaceEvent extends BlockEvent.PlaceEvent
{
    public AntilightPlaceEvent(BlockSnapshot blockSnapshot, IBlockState placedAgainst, EntityPlayer player)
    {
        super(blockSnapshot, placedAgainst, player);
    }
}
