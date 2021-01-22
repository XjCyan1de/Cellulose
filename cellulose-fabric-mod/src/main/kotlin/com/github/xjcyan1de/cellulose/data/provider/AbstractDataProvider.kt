package com.github.xjcyan1de.cellulose.data.provider

import org.spongepowered.api.data.DataHolder
import org.spongepowered.api.data.DataProvider
import org.spongepowered.api.data.Key
import org.spongepowered.api.data.value.Value

abstract class AbstractDataProvider<V : Value<E>, E>(
    private val key: Key<V>
) : DataProvider<V, E> {
    override fun getKey(): Key<V>  = key

    override fun allowsAsynchronousAccess(dataHolder: DataHolder): Boolean = false

    interface KnownHolderType {
        val holderType: Class<*>
    }
}