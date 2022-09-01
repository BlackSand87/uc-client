package com.blacksand.uc.client;

import com.blacksand.uc.client.modules.Flight;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

@Environment(EnvType.CLIENT)
public class UCClient implements ClientModInitializer {

    public static double defaultGamma;

    @Override
    public void onInitializeClient() {
        ClientTickEvents.START_CLIENT_TICK.register(client -> Flight.Tick(client));
    }
}
