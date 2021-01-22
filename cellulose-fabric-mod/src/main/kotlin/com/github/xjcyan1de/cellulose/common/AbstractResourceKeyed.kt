package com.github.xjcyan1de.cellulose.common

import org.spongepowered.api.ResourceKey
import org.spongepowered.api.ResourceKeyed

abstract class AbstractResourceKeyed(
    private val key: ResourceKey
) : ResourceKeyed {
    override fun getKey(): ResourceKey = key
}