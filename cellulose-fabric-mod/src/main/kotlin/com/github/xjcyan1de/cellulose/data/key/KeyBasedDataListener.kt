package com.github.xjcyan1de.cellulose.data.key

import org.spongepowered.api.data.DataHolder
import org.spongepowered.api.data.Key
import org.spongepowered.api.event.EventListener
import org.spongepowered.api.event.data.ChangeDataHolderEvent.ValueChange
import org.spongepowered.plugin.PluginContainer

class KeyBasedDataListener<E : DataHolder>(
    val owner: PluginContainer,
    val holderType: Class<E>,
    val key: Key<*>,
    val listener: EventListener<ValueChange>
) : EventListener<ValueChange> {
    override fun handle(event: ValueChange) {
        if (holderType.isInstance(event.targetHolder) && event.endResult.successfulData.any { it.key == this.key }) {
            listener.handle(event)
        }
    }
}
