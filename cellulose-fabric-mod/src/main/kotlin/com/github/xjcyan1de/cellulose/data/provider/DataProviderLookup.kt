package com.github.xjcyan1de.cellulose.data.provider

import com.github.xjcyan1de.cellulose.data.key.KeyImpl
import com.google.common.collect.ImmutableMap
import org.spongepowered.api.data.DataProvider
import org.spongepowered.api.data.Key
import org.spongepowered.api.data.value.Value

class DataProviderLookup(
    providerMap: Map<Key<*>, DataProvider<*, *>>
) {
    val providerMap = ImmutableMap.copyOf(providerMap)

    /**
     * Gets all the non-empty delegate [DataProvider]s.
     *
     * @return The delegate data providers
     */
    fun getAllProviders(): Collection<DataProvider<*, *>> = providerMap.values

    /**
     * Gets the delegate [DataProvider] for the given [Key].
     *
     * @param key The key
     * @param <V> The value type
     * @param <E> The element type
     * @return The delegate provider
     */
    @Suppress("UNCHECKED_CAST")
    fun <V : Value<E>, E> getProvider(key: Key<V>): DataProvider<V, E> {
        return providerMap.getOrDefault(key, (key as KeyImpl<V, E>).emptyDataProvider) as DataProvider<V, E>
    }
}