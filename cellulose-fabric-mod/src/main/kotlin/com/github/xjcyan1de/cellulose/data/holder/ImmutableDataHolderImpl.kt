package com.github.xjcyan1de.cellulose.data.holder

import org.spongepowered.api.data.DataHolder

interface ImmutableDataHolderImpl<I : DataHolder.Immutable<I>> : DataHolderImpl, DataHolder.Immutable<I> {
}