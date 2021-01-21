package com.github.xjcyan1de.cellulose.effect.particle

import net.minecraft.block.BlockState
import net.minecraft.item.ItemStack
import net.minecraft.network.Packet
import net.minecraft.network.packet.s2c.play.ParticleS2CPacket
import net.minecraft.network.packet.s2c.play.WorldEventS2CPacket
import net.minecraft.particle.*
import net.minecraft.server.PlayerManager
import net.minecraft.util.math.BlockPos
import net.minecraft.util.registry.RegistryKey
import net.minecraft.world.World
import org.spongepowered.api.effect.particle.ParticleEffect
import org.spongepowered.api.effect.particle.ParticleOptions
import org.spongepowered.math.vector.Vector3d
import org.spongepowered.math.vector.Vector3f
import kotlin.random.Random

@Suppress("UNCHECKED_CAST")
object CelluloseParticleHelper {
    fun sendPackets(
        particleEffect: ParticleEffect,
        position: Vector3d,
        radius: Int,
        type: RegistryKey<World>,
        playerManager: PlayerManager
    ) {
        val packets = toPackets(particleEffect, position)
        val x = position.x
        val y = position.y
        val z = position.z
        packets.forEach { packet ->
            playerManager.sendToAround(null, x, y, z, radius.toDouble(), type, packet)
        }
    }

    fun toPackets(effect: ParticleEffect, position: Vector3d): List<Packet<*>> {
        effect as CelluloseParticleEffect
        val packets = ArrayList<Packet<*>>()
        effect.cachedPacket.process(position, packets)
        return packets
    }

    fun getCachedPacket(effect: CelluloseParticleEffect): CachedParticlePacket {
        val type = effect.type
        return if (type is NumericalParticleType) {
            getNumericalPacket(effect, type)
        } else {
            getNamedPacket(effect, type as ParticleType<*>)
        }
    }

    fun getNumericalPacket(effect: ParticleEffect, type: NumericalParticleType) =
        NumericalCachedPacket(type.id, type.getData(effect), false)

    fun getNamedPacket(effect: ParticleEffect, internalType: ParticleType<*>): CachedParticlePacket {
        // Named particles always support OFFSET and QUANTITY.
        val offset = effect.getOptionOrDefault(ParticleOptions.OFFSET).get().toFloat()
        val quantity = effect.getOptionOrDefault(ParticleOptions.QUANTITY).get()
        val velocity = effect.getOptionOrDefault(ParticleOptions.VELOCITY).orElse(Vector3d.ZERO).toFloat()

        if (internalType is DefaultParticleType) {
            // Simple named particle without any additional supported options.
            return NamedCachedPacket(internalType, offset, quantity, velocity)
        }

        // The only way we can see what options are supported for a particular named particle
        // is to compare the internal type's deserializer to some static deserializer fields.
        // If only mojang had some type akin to our ParticleEffect...
        return when (internalType.codec) {
            BlockStateParticleEffect.PARAMETERS_FACTORY -> {
                // This particle type supports a block state option.
                val state = effect.getOptionOrDefault(ParticleOptions.BLOCK_STATE).get()
                val particleData = BlockStateParticleEffect(
                    internalType as ParticleType<BlockStateParticleEffect>,
                    state as BlockState
                )
                NamedCachedPacket(particleData, offset, quantity, velocity)
            }
            ItemStackParticleEffect.PARAMETERS_FACTORY -> {
                // This particle type supports an item option.
                val snapshot = effect.getOptionOrDefault(ParticleOptions.ITEM_STACK_SNAPSHOT).get()
                val particleData = ItemStackParticleEffect(
                    internalType as ParticleType<ItemStackParticleEffect>,
                    snapshot.createStack() as ItemStack
                )
                NamedCachedPacket(particleData, offset, quantity, velocity)
            }
            DustParticleEffect.PARAMETERS_FACTORY -> {
                // This particle type supports a color option.
                val color = effect.getOptionOrDefault(ParticleOptions.COLOR).get()
                val particleData = DustParticleEffect(
                    color.red.toFloat() / 255,
                    color.green.toFloat() / 255,
                    color.blue.toFloat() / 255,
                    1.0f
                )
                NamedCachedPacket(particleData, offset, quantity, velocity)
            }
            // Otherwise, we don't really know how to get a valid IParticleData. Sorry mods!
            else -> EmptyCachedPacket
        }
    }

    object EmptyCachedPacket : CachedParticlePacket {
        override fun process(position: Vector3d, output: MutableList<Packet<*>>) {
        }
    }

    data class NamedCachedPacket(
        val particleEffect: net.minecraft.particle.ParticleEffect,
        val offset: Vector3f,
        val count: Int,
        val velocity: Vector3f
    ) : CachedParticlePacket {
        override fun process(position: Vector3d, output: MutableList<Packet<*>>) {
            val posX = position.x
            val posY = position.y
            val posZ = position.z

            val offX = offset.x
            val offY = offset.y
            val offZ = offset.z

            val packet = if (velocity == Vector3d.ZERO) {
                ParticleS2CPacket(
                    particleEffect,
                    true,
                    posX, posY, posZ,
                    offX, offY, offZ,
                    0.0f,
                    count
                )
            } else {
                val px0 = posX + (Random.nextFloat() * 2f - 1f) * offX
                val py0 = posY + (Random.nextFloat() * 2f - 1f) * offY
                val pz0 = posZ + (Random.nextFloat() * 2f - 1f) * offZ
                ParticleS2CPacket(
                    particleEffect,
                    true,
                    px0, py0, pz0,
                    velocity.x, velocity.y, velocity.z,
                    1f,
                    0
                )
            }
            output.add(packet)
        }
    }

    data class NumericalCachedPacket(
        val type: Int,
        val data: Int,
        val broadcast: Boolean
    ) : CachedParticlePacket {
        override fun process(position: Vector3d, output: MutableList<Packet<*>>) {
            val blockPost = BlockPos(position.floorX, position.floorY, position.floorZ)
            val packet = WorldEventS2CPacket(type, blockPost, data, broadcast)
            output.add(packet)
        }
    }
}

fun interface CachedParticlePacket {
    fun process(position: Vector3d, output: MutableList<Packet<*>>)
}