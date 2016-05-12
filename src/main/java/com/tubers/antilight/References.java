package com.tubers.antilight;




import net.minecraft.block.Block;
import net.minecraft.item.Item;

import java.util.Locale;

public class References {

    public static class Mod
    {
        public static final String MODID = "antilight";
        public static final String DOMAIN = MODID.toLowerCase(Locale.ENGLISH) + ":";
        public static final String NAME = "Antilight: Darkness Evolved";
        public static final String VERSION = "1.0";
        public static final String CLIENT_PROXY = "com.tubers.antilight.proxy.ClientProxy";
        public static final String COMMON_PROXY = "com.tubers.antilight.proxy.CommonProxy";
    }

    public static final class Gui
    {

    }

    public enum AntilightItem
    {
        TEST_ITEM("TestItem"); // registry name

        private final String regName;

        public String getRegName()
        {
            return regName;
        }

        AntilightItem(String regName)
        {
            this.regName = regName;
        }

        public Item getItem()
        {
            return AntilightAPI.getItem(getRegName());
        }


    }

    public enum AntilightBlock
    {
        TEST_BLOCK("TestBlock"); // registry name

        private final String regName;

        public String getRegName()
        {
            return regName;
        }

        AntilightBlock(String regName)
        {
            this.regName = regName;
        }

        public Block getBlock()
        {
            return AntilightAPI.getBlock(getRegName());
        }
    }


}
