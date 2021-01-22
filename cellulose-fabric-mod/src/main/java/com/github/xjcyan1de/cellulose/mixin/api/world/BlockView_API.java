package com.github.xjcyan1de.cellulose.mixin.api.world;

import com.github.xjcyan1de.cellulose.hook.world.BlockViewHook;
import net.minecraft.world.BlockView;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.entity.BlockEntity;
import org.spongepowered.api.fluid.FluidState;
import org.spongepowered.api.world.volume.game.PrimitiveGameVolume;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.math.vector.Vector3i;

import java.util.Collection;
import java.util.Optional;

@Mixin(BlockView.class)
public abstract class BlockView_API implements PrimitiveGameVolume {
    @Override
    public int getMaximumLight() {
        return BlockViewHook.INSTANCE.getMaximumLight((BlockView) this);
    }

    @Override
    public int getEmittedLight(Vector3i position) {
        return BlockViewHook.INSTANCE.getEmittedLight((BlockView) this, position);
    }

    @Override
    public int getEmittedLight(int x, int y, int z) {
        return BlockViewHook.INSTANCE.getEmittedLight((BlockView) this, x, y, z);
    }

    @Override
    public int getHeight() {
        return  BlockViewHook.INSTANCE.getHeight((BlockView) this);
    }

    @Override
    public Collection<? extends BlockEntity> getBlockEntities() {
        return BlockViewHook.INSTANCE.getBlockEntities((BlockView) this);
    }

    @Override
    public Optional<? extends BlockEntity> getBlockEntity(Vector3i position) {
        return BlockViewHook.INSTANCE.getBlockEntity((BlockView) this, position);
    }

    @Override
    public BlockState getBlock(int x, int y, int z) {
        return BlockViewHook.INSTANCE.getBlock((BlockView) this,x, y, z);
    }

    @Override
    public FluidState getFluid(int x, int y, int z) {
        return BlockViewHook.INSTANCE.getFluid((BlockView) this,x, y, z);
    }
}
