package com.smashingmods.alchemistry.common.block.liquifier;

import com.smashingmods.alchemistry.api.container.AbstractAlchemistryScreenHandler;
import com.smashingmods.alchemistry.common.block.dissolver.DissolverBlockEntity;
import com.smashingmods.alchemistry.registry.ScreenRegistry;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;

import java.util.Objects;

public class LiquifierScreenHandler extends AbstractAlchemistryScreenHandler {

    public LiquifierScreenHandler(int syncId, PlayerInventory playerInventory, PacketByteBuf buffer) {
        this(syncId, playerInventory, Objects.requireNonNull(playerInventory.player.getWorld().getBlockEntity(buffer.readBlockPos())), new SimpleInventory(LiquifierBlockEntity.INVENTORY_SIZE), new ArrayPropertyDelegate(6));
    }

    protected LiquifierScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity blockEntity, Inventory inventory, PropertyDelegate delegate) {
        super(ScreenRegistry.LIQUIFIER_SCREEN_HANDLER, syncId, playerInventory, blockEntity, inventory, delegate, 1);
        addSlots(Slot::new, inventory, 1, 1, 0, inventory.size(), 62, 35);
    }
}
