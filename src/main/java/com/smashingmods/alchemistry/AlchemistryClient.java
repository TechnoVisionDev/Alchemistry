package com.smashingmods.alchemistry;

import com.smashingmods.alchemistry.common.block.liquifier.LiquifierScreen;
import com.smashingmods.alchemistry.network.AlchemistryNetwork;
import com.smashingmods.alchemistry.common.block.dissolver.DissolverScreen;
import com.smashingmods.alchemistry.registry.ScreenRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class AlchemistryClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        // Register screens
        HandledScreens.register(ScreenRegistry.DISSOLVER_SCREEN_HANDLER, DissolverScreen::new);
        HandledScreens.register(ScreenRegistry.LIQUIFIER_SCREEN_HANDLER, LiquifierScreen::new);

        // Register client-side packet handlers
        AlchemistryNetwork.registerClientHandlers();
    }
}