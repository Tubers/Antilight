package com.tubers.antilight.proxy;

import com.tubers.antilight.registry.BlockRegister;
import com.tubers.antilight.registry.ItemRegister;

public class ClientProxy extends CommonProxy
{

    @Override
    public void registerRenders()
    {
        ItemRegister.initRenders();
        BlockRegister.initRenders();
    }

}
