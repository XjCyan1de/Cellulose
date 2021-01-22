package com.github.xjcyan1de.cellulose.data

import com.github.xjcyan1de.cellulose.data.key.KeyBasedDataListener
import com.github.xjcyan1de.cellulose.data.provider.DataProviderRegistry
import org.spongepowered.api.data.DataHolder
import org.spongepowered.api.data.DataHolderBuilder
import org.spongepowered.api.data.DataManager
import org.spongepowered.api.data.DataRegistration
import org.spongepowered.api.data.persistence.*
import java.util.*
import kotlin.collections.ArrayList

object DataManagerImpl : DataManager {
    val dataProviderRegistry = DataProviderRegistry()
    val keyListeners = ArrayList<KeyBasedDataListener<*>>()

    override fun <T : DataSerializable?> registerBuilder(clazz: Class<T>?, builder: DataBuilder<T>?) {
        TODO("Not yet implemented")
    }

    override fun <T : DataSerializable?> registerContentUpdater(clazz: Class<T>?, updater: DataContentUpdater?) {
        TODO("Not yet implemented")
    }

    override fun <T : DataSerializable?> getWrappedContentUpdater(
        clazz: Class<T>?,
        fromVersion: Int,
        toVersion: Int
    ): Optional<DataContentUpdater> {
        TODO("Not yet implemented")
    }

    override fun <T : DataSerializable?> getBuilder(clazz: Class<T>?): Optional<DataBuilder<T>> {
        TODO("Not yet implemented")
    }

    override fun <T : DataSerializable?> deserialize(clazz: Class<T>?, dataView: DataView?): Optional<T> {
        TODO("Not yet implemented")
    }

    override fun <T : DataHolder.Immutable<T>?, B : DataHolderBuilder.Immutable<T, B>?> register(
        holderClass: Class<T>?,
        builder: B
    ) {
        TODO("Not yet implemented")
    }

    override fun registerLegacyManipulatorIds(legacyId: String?, registration: DataRegistration?) {
        TODO("Not yet implemented")
    }

    override fun <T : DataHolder.Immutable<T>?, B : DataHolderBuilder.Immutable<T, B>?> getImmutableBuilder(holderClass: Class<T>?): Optional<B> {
        TODO("Not yet implemented")
    }

    override fun <T : Any?> getTranslator(objectClass: Class<T>?): Optional<DataTranslator<T>> {
        TODO("Not yet implemented")
    }

    override fun createContainer(): DataContainer {
        TODO("Not yet implemented")
    }

    override fun createContainer(safety: DataView.SafetyMode?): DataContainer {
        TODO("Not yet implemented")
    }

    fun <E:DataHolder> registerKeyListener(keyListener: KeyBasedDataListener<E>) {
        keyListeners.add(keyListener)
    }
}