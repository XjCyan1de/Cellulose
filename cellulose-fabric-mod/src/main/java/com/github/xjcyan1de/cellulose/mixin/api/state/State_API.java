package com.github.xjcyan1de.cellulose.mixin.api.state;

import com.github.xjcyan1de.cellulose.data.holder.ImmutableDataHolderImpl;
import org.spongepowered.api.state.State;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(net.minecraft.state.State.class)
public abstract class State_API<S extends State<S>, C> implements State<S>, ImmutableDataHolderImpl<S> {
}
