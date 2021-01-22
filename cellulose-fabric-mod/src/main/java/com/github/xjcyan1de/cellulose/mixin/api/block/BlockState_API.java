package com.github.xjcyan1de.cellulose.mixin.api.block;

import net.minecraft.block.BlockState;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BlockState.class)
public abstract class BlockState_API extends AbstractBlockState_API {
}
