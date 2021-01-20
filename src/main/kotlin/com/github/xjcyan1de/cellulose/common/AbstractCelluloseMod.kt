package com.github.xjcyan1de.cellulose.common

import com.google.inject.Guice
import com.google.inject.Module
import com.google.inject.Stage
import net.fabricmc.loader.api.FabricLoader
import net.minecraft.server.MinecraftServer
import org.apache.logging.log4j.LogManager

abstract class AbstractCelluloseMod protected constructor() {
    init {
        instance = this
    }

    abstract val server: MinecraftServer?

    protected fun onInitialize() {
        val defaultStage =
            if (FabricLoader.getInstance().isDevelopmentEnvironment) Stage.DEVELOPMENT else Stage.PRODUCTION
        val stage = Stage.valueOf(System.getProperty("guice.stage", defaultStage.name))
        Guice.createInjector(stage, createModule())
    }

    protected abstract fun createModule(): Module

    companion object {
        val logger = LogManager.getLogger("Cellulose")
        lateinit var instance: AbstractCelluloseMod
            private set
    }
}