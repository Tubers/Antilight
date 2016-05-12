package com.tubers.antilight.client;


import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

import java.util.Map;

public class ALFMLCorePlugin implements IFMLLoadingPlugin {

    @Override
    public String[] getASMTransformerClass()
    {
        return new String[] {"com.tubers.antilight.client.ALTransformer"};
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {

    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}
