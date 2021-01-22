package com.github.xjcyan1de.cellulose.data.provider

import com.github.xjcyan1de.cellulose.data.key.KeyImpl
import com.github.xjcyan1de.cellulose.util.invoke
import com.google.common.collect.HashMultimap
import org.spongepowered.api.data.DataProvider
import org.spongepowered.api.data.Key
import org.spongepowered.api.data.value.Value
import java.util.concurrent.ConcurrentHashMap
import java.util.function.Predicate

class DataProviderRegistry {
    val dataProviders = HashMultimap.create<Key<*>, DataProvider<*, *>>()
    val dataProviderCache = ConcurrentHashMap<LookupKey, DataProvider<*, *>>()
    val dataProviderLookupCache = ConcurrentHashMap<Class<*>, DataProviderLookup>()

    @Suppress("UNCHECKED_CAST")
    fun <V : Value<E>, E> getProvider(key: Key<V>, dataHolderType: Class<*>): DataProvider<V,E> {
        val lookupKey = LookupKey(dataHolderType, key)
        return dataProviderCache.getOrPut(lookupKey) {
            loadProvider(lookupKey)
        } as DataProvider<V, E>
    }

    /**
     * Builds a delegate [DataProvider] from the [DataProvider] that
     * are accepted by the given [Predicate].
     *
     * @param key The key
     * @param predicate The predicate
     * @param <V> The value type
     * @param <E> The element type
     * @return The delegate data provider
     */
    @Suppress("UNCHECKED_CAST")
    private fun <V : Value<E>, E> buildDelegate(
        key: Key<V>,
        predicate: Predicate<DataProvider<V, E>>
    ): DataProvider<V, E> {
        val providers = dataProviders[key] as Collection<DataProvider<V, E>>
        return buildDelegateProvider(key, providers.filter { predicate(it) })
    }

    @Suppress("UNCHECKED_CAST")
    private fun  loadProvider(key: LookupKey): DataProvider<*,*>  = buildDelegate(key.key as Key<Value<Any>>) { provider ->
        filterHolderType(provider, key.holderType)
    }

    @Suppress("UNCHECKED_CAST")
    private fun <V : Value<E>, E> buildDelegateProvider(
        key: Key<V>,
        providers: Collection<DataProvider<V, E>>
    ): DataProvider<V, E> = when {
        providers.isEmpty() -> (key as KeyImpl<V, E>).emptyDataProvider
        providers.size == 1 -> providers.first()
        else -> DelegateDataProvider(key, providers)
    }

    private fun filterHolderType(provider: DataProvider<*, *>, holderType: Class<*>): Boolean {
        // Filter out data providers of which we know that they will never be relevant.
        if (provider is AbstractDataProvider.KnownHolderType) {
            val foundHolderType: Class<*> = (provider as AbstractDataProvider.KnownHolderType).holderType
            return foundHolderType.isAssignableFrom(holderType)
        }
        return true
    }

    data class LookupKey(
        val holderType: Class<*>,
        val key: Key<*>
    )
}