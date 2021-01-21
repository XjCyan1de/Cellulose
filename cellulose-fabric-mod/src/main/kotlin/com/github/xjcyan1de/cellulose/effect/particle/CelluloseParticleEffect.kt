package com.github.xjcyan1de.cellulose.effect.particle

import com.github.xjcyan1de.cellulose.util.Constants
import com.github.xjcyan1de.cellulose.util.asOptional
import com.google.common.collect.ImmutableMap
import org.spongepowered.api.data.persistence.DataContainer
import org.spongepowered.api.effect.particle.ParticleEffect
import org.spongepowered.api.effect.particle.ParticleOption
import org.spongepowered.api.effect.particle.ParticleType
import java.util.*

class CelluloseParticleEffect(
    private val type: ParticleType,
    options: Map<ParticleOption<*>, Any>
) : ParticleEffect {
    private val options = ImmutableMap.copyOf(options)
    private val hashCode by lazy {
        var result = type.hashCode()
        result = 31 * result + options.hashCode()
        result
    }
    private val toString by lazy {
        toContainer().toString()
    }
    val cachedPacket by lazy {
        CelluloseParticleHelper.getCachedPacket(this)
    }

    override fun getContentVersion(): Int = 1

    override fun toContainer(): DataContainer = DataContainer.createNew().apply {
        set(Constants.Particles.PARTICLE_TYPE, type)
        set(Constants.Particles.PARTICLE_OPTIONS, options.map { (key, value) ->
            DataContainer.createNew().apply {
                set(Constants.Particles.PARTICLE_OPTION_KEY, key)
                set(Constants.Particles.PARTICLE_OPTION_VALUE, value)
            }
        })
    }

    override fun getType(): ParticleType = type

    override fun <V : Any?> getOption(option: ParticleOption<V>?): Optional<V> = options[option].asOptional()

    override fun getOptions(): Map<ParticleOption<*>, Any> = options

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CelluloseParticleEffect

        if (type != other.type) return false
        if (options != other.options) return false

        return true
    }

    override fun hashCode(): Int = hashCode

    override fun toString(): String = toString
}