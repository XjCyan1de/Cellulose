package com.github.xjcyan1de.cellulose.data.key

import com.github.xjcyan1de.cellulose.common.AbstractResourceKeyed
import com.github.xjcyan1de.cellulose.data.DataManagerImpl
import com.github.xjcyan1de.cellulose.data.provider.EmptyDataProvider
import org.spongepowered.api.ResourceKey
import org.spongepowered.api.data.DataHolder
import org.spongepowered.api.data.Key
import org.spongepowered.api.data.value.Value
import org.spongepowered.api.event.EventListener
import org.spongepowered.api.event.data.ChangeDataHolderEvent
import org.spongepowered.plugin.PluginContainer
import java.lang.reflect.Type
import java.util.Comparator
import java.util.function.BiPredicate

class KeyImpl<V : Value<E>, E>(
    key: ResourceKey,
    private val valueType: Type,
    private val elementType: Type,
    private val elementComparator: Comparator<in E>,
    private val elementIncludesTester: BiPredicate<in E, in E>
) : AbstractResourceKeyed(key), Key<V>  {
    val emptyDataProvider = EmptyDataProvider(this)

    override fun getValueType(): Type = valueType

    override fun getElementType(): Type = elementType

    override fun getElementComparator(): Comparator<in E> =elementComparator

    override fun getElementIncludesTester(): BiPredicate<in E, in E> = elementIncludesTester

    override fun <E : DataHolder> registerEvent(
        plugin: PluginContainer,
        holderFilter: Class<E>,
        listener: EventListener<ChangeDataHolderEvent.ValueChange>
    ): Unit = DataManagerImpl.registerKeyListener(KeyBasedDataListener(plugin, holderFilter, this, listener))
}