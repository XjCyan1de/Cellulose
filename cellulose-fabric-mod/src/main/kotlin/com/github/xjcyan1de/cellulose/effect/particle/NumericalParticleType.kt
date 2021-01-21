package com.github.xjcyan1de.cellulose.effect.particle

import com.github.xjcyan1de.cellulose.util.asOptional
import com.google.common.collect.ImmutableMap
import org.spongepowered.api.effect.particle.ParticleEffect
import org.spongepowered.api.effect.particle.ParticleOption
import org.spongepowered.api.effect.particle.ParticleType
import java.util.*

class NumericalParticleType(
    val id: Int,
    defaultOptions: Map<ParticleOption<*>, Any> = ImmutableMap.of(),
    val dataCalculator: DataCalculator? = null
) : ParticleType {
    private val defaultOptions = ImmutableMap.copyOf(defaultOptions)

    override fun <V : Any?> getDefaultOption(option: ParticleOption<V>): Optional<V> =
        defaultOptions[option].asOptional()

    override fun getDefaultOptions(): Map<ParticleOption<*>, Any> = defaultOptions

    fun getData(effect: ParticleEffect) = dataCalculator?.getData(effect) ?: 0

    fun interface DataCalculator {
        fun getData(effect: ParticleEffect): Int
    }
}