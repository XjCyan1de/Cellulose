package com.github.xjcyan1de.cellulose.data.provider

import org.spongepowered.api.data.DataHolder
import org.spongepowered.api.data.DataProvider
import org.spongepowered.api.data.DataTransactionResult
import org.spongepowered.api.data.Key
import org.spongepowered.api.data.value.Value
import java.lang.reflect.Type
import java.util.*

class DelegateDataProvider<V : Value<E>, E>(
    private val key: Key<V>,
    private val providers: Collection<DataProvider<V, E>>
) : DataProvider<V, E> {
    override fun getKey(): Key<V> = key

    override fun allowsAsynchronousAccess(dataHolder: DataHolder): Boolean =
        providers.all { it.allowsAsynchronousAccess(dataHolder) }

    override fun get(dataHolder: DataHolder): Optional<E> =
        providers.asSequence().mapNotNull { it[dataHolder] }.first { it.isPresent }

    override fun isSupported(dataHolder: DataHolder): Boolean =
        providers.any { it.isSupported(dataHolder) }

    override fun isSupported(dataHolder: Type): Boolean =
        providers.any { it.isSupported(dataHolder) }

    override fun offer(dataHolder: DataHolder.Mutable, element: E): DataTransactionResult = providers.asSequence()
        .map { it.offer(dataHolder, element) }
        .firstOrNull { it.type != DataTransactionResult.Type.FAILURE }
        ?: DataTransactionResult.errorResult(Value.immutableOf(key, element))

    override fun remove(dataHolder: DataHolder.Mutable?): DataTransactionResult = providers.asSequence()
        .map { it.remove(dataHolder) }
        .firstOrNull { it.type != DataTransactionResult.Type.FAILURE }
        ?: DataTransactionResult.failNoData()

    override fun <I : DataHolder.Immutable<I>> with(immutable: I, element: E): Optional<I> = providers.asSequence()
        .map { it.with(immutable, element) }
        .firstOrNull { it.isPresent } ?: Optional.empty()

    override fun <I : DataHolder.Immutable<I>> without(immutable: I): Optional<I> = providers.asSequence()
        .map { it.without(immutable) }
        .firstOrNull { it.isPresent } ?: Optional.of(immutable)
}