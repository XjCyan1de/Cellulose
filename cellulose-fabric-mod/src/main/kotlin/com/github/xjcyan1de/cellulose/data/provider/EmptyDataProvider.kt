package com.github.xjcyan1de.cellulose.data.provider

import org.spongepowered.api.data.DataHolder
import org.spongepowered.api.data.DataProvider
import org.spongepowered.api.data.DataTransactionResult
import org.spongepowered.api.data.Key
import org.spongepowered.api.data.value.Value
import java.lang.reflect.Type
import java.util.*

class EmptyDataProvider<V : Value<E>, E>(
    private val key: Key<V>
) : DataProvider<V, E> {
    override fun getKey(): Key<V> = key

    override fun allowsAsynchronousAccess(dataHolder: DataHolder?): Boolean = false

    override fun get(dataHolder: DataHolder?): Optional<E> = Optional.empty()

    override fun isSupported(dataHolder: DataHolder?): Boolean = false

    override fun isSupported(dataHolder: Type?): Boolean = false

    override fun offer(dataHolder: DataHolder.Mutable?, element: E): DataTransactionResult =
        DataTransactionResult.failResult(Value.immutableOf(key, element))

    override fun remove(dataHolder: DataHolder.Mutable?): DataTransactionResult = DataTransactionResult.failNoData()

    override fun <I : DataHolder.Immutable<I>> with(immutable: I, element: E): Optional<I> = Optional.empty()

    override fun <I : DataHolder.Immutable<I>> without(immutable: I): Optional<I> = Optional.of(immutable)
}