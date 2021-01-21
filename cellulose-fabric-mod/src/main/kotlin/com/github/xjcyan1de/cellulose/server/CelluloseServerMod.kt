package com.github.xjcyan1de.cellulose.server

import com.github.xjcyan1de.cellulose.common.AbstractCelluloseMod
import com.google.inject.Module
import net.fabricmc.api.DedicatedServerModInitializer
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.fabricmc.loader.api.FabricLoader
import net.minecraft.server.MinecraftServer

@Environment(EnvType.SERVER)
class CelluloseServerMod : AbstractCelluloseMod(), DedicatedServerModInitializer {
    override val server: MinecraftServer
        get() = FabricLoader.getInstance().gameInstance as MinecraftServer

    override fun createModule(): Module = CelluloseServerModule()

    override fun onInitializeServer() {
        logger.info("Initializing server environment...")
        onInitialize()
    }
}