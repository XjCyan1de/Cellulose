package com.github.xjcyan1de.cellulose.hook.world

import net.minecraft.world.BlockView
import org.spongepowered.api.block.BlockState
import org.spongepowered.api.block.entity.BlockEntity
import org.spongepowered.api.data.Key
import org.spongepowered.api.data.value.Value
import org.spongepowered.api.fluid.FluidState
import org.spongepowered.api.world.volume.game.PrimitiveGameVolume
import org.spongepowered.math.vector.Vector3i
import java.util.*

class BlockViewHook(
    val handle: BlockView
) : PrimitiveGameVolume {
    override fun getBlockMin(): Vector3i {
        TODO("Not yet implemented")
    }

    override fun getBlockMax(): Vector3i {
        TODO("Not yet implemented")
    }

    override fun getBlockSize(): Vector3i {
        TODO("Not yet implemented")
    }

    override fun containsBlock(x: Int, y: Int, z: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun isAreaAvailable(x: Int, y: Int, z: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun getBlock(x: Int, y: Int, z: Int): BlockState {
        TODO("Not yet implemented")
    }

    override fun getFluid(x: Int, y: Int, z: Int): FluidState {
        TODO("Not yet implemented")
    }

    override fun getHighestYAt(x: Int, z: Int): Int {
        TODO("Not yet implemented")
    }

    override fun getBlockEntities(): MutableCollection<out BlockEntity> {
        TODO("Not yet implemented")
    }

    override fun getBlockEntity(x: Int, y: Int, z: Int): Optional<out BlockEntity> {
        TODO("Not yet implemented")
    }

    override fun <E : Any?> get(x: Int, y: Int, z: Int, key: Key<out Value<E>>?): Optional<E> {
        TODO("Not yet implemented")
    }

    override fun <E : Any?, V : Value<E>?> getValue(x: Int, y: Int, z: Int, key: Key<V>?): Optional<V> {
        TODO("Not yet implemented")
    }

    override fun supports(x: Int, y: Int, z: Int, key: Key<*>?): Boolean {
        TODO("Not yet implemented")
    }

    override fun getKeys(x: Int, y: Int, z: Int): MutableSet<Key<*>> {
        TODO("Not yet implemented")
    }

    override fun getValues(x: Int, y: Int, z: Int): MutableSet<Value.Immutable<*>> {
        TODO("Not yet implemented")
    }

}