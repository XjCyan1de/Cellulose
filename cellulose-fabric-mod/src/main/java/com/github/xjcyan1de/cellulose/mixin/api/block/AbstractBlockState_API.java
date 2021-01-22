package com.github.xjcyan1de.cellulose.mixin.api.block;

import net.minecraft.block.AbstractBlock;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(AbstractBlock.AbstractBlockState.class)
public abstract class AbstractBlockState_API implements BlockState {
}
