package com.github.xjcyan1de.cellulose.data.holder

import com.github.xjcyan1de.cellulose.data.DataManagerImpl
import org.spongepowered.api.data.DataHolder
import org.spongepowered.api.data.DataProvider
import org.spongepowered.api.data.Key
import org.spongepowered.api.data.value.Value

interface DataHolderImpl : DataHolder {
    fun <V: Value<E>, E> getProviderFor(key: Key<V>): DataProvider<V,E> =
        DataManagerImpl.dataProviderRegistry.getProvider(key, this.javaClass)

}