package com.github.xjcyan1de.cellulose.effect.record

import com.github.xjcyan1de.cellulose.mixin.accessor.item.MusicDiscItem_Accessor
import net.minecraft.item.MusicDiscItem
import net.minecraft.network.packet.s2c.play.WorldEventS2CPacket
import net.minecraft.util.math.BlockPos
import net.minecraft.util.registry.Registry
import org.spongepowered.api.effect.sound.SoundType
import org.spongepowered.api.effect.sound.music.MusicDisc
import org.spongepowered.math.vector.Vector3i

class CelluloseMusicDisc(
    val item: MusicDiscItem
) : MusicDisc {
    val id = Registry.ITEM.getRawId(item)

    override fun getSound(): SoundType {
        return (item as MusicDiscItem_Accessor).sound() as SoundType
    }

    companion object {
        /**
         * This is the effect ID that is used by the Effect packet to play a record effect.
         * https://wiki.vg/Protocol#Effect
         */
        private const val EFFECT_ID = 1010

        fun createPacket(position: Vector3i, musicDisc: MusicDisc?): WorldEventS2CPacket {
            val pos = BlockPos(position.x, position.y, position.z)
            return WorldEventS2CPacket(EFFECT_ID, pos, (musicDisc as? CelluloseMusicDisc)?.id ?: 0, false)
        }
    }
}