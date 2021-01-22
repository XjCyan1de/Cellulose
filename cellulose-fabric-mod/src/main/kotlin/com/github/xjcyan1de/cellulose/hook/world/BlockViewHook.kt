@file:Suppress("CAST_NEVER_SUCCEEDS")

package com.github.xjcyan1de.cellulose.hook.world

import com.github.xjcyan1de.cellulose.util.asOptional
import net.minecraft.util.math.BlockPos
import net.minecraft.world.BlockView
import org.spongepowered.api.block.BlockState
import org.spongepowered.api.block.entity.BlockEntity
import org.spongepowered.api.fluid.FluidState
import org.spongepowered.math.vector.Vector3i
import java.util.*

object BlockViewHook {
    fun getMaximumLight(blockView: BlockView): Int = blockView.maxLightLevel

    fun getEmittedLight(blockView: BlockView, position: Vector3i): Int =
        getEmittedLight(blockView, position.x, position.y, position.z)

    fun getEmittedLight(blockView: BlockView, x: Int, y: Int, z: Int): Int = blockView.getLuminance(BlockPos(x, y, z))

    fun getHeight(blockView: BlockView): Int = blockView.height

    fun getBlockEntities(blockView: BlockView): Collection<BlockEntity> = emptyList()

    fun getBlockEntity(blockView: BlockView, position: Vector3i): Optional<BlockEntity> =
        blockView.getBlockEntity(BlockPos(position.x, position.y, position.z)).asOptional()

    fun getBlock(blockView: BlockView, x: Int, y: Int, z: Int): BlockState =
        blockView.getBlockState(BlockPos(x, y, z)) as BlockState

    fun getFluid(blockView: BlockView, x: Int, y: Int, z: Int): FluidState =
        blockView.getFluidState(BlockPos(x, y, z)) as FluidState
}