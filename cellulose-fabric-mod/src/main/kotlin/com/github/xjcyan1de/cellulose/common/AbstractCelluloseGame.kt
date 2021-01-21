package com.github.xjcyan1de.cellulose.common

import net.fabricmc.loader.api.FabricLoader
import org.spongepowered.api.Game
import org.spongepowered.api.Platform
import org.spongepowered.api.Server
import org.spongepowered.api.SystemSubject
import org.spongepowered.api.asset.AssetManager
import org.spongepowered.api.command.manager.CommandManager
import org.spongepowered.api.config.ConfigManager
import org.spongepowered.api.data.DataManager
import org.spongepowered.api.event.EventManager
import org.spongepowered.api.network.channel.ChannelRegistry
import org.spongepowered.api.plugin.PluginManager
import org.spongepowered.api.registry.*
import org.spongepowered.api.scheduler.Scheduler
import org.spongepowered.api.service.ServiceProvider
import org.spongepowered.api.sql.SqlManager
import org.spongepowered.api.util.metric.MetricsConfigManager
import java.nio.file.Path
import java.util.*

abstract class AbstractCelluloseGame : Game {
    override fun registryScope(): RegistryScope {
        TODO("Not yet implemented")
    }

    override fun registries(): RegistryHolder {
        TODO("Not yet implemented")
    }

    override fun getAsyncScheduler(): Scheduler {
        TODO("Not yet implemented")
    }

    override fun getGameDirectory(): Path = FabricLoader.getInstance().gameDir

    override fun isServerAvailable(): Boolean = AbstractCelluloseMod.instance.server != null

    override fun getServer(): Server =
        AbstractCelluloseMod.instance.server as? Server ?: throw IllegalStateException("Server is not available")

    override fun getSystemSubject(): SystemSubject {
        TODO("Not yet implemented")
    }

    override fun getLocale(locale: String?): Locale {
        TODO("Not yet implemented")
    }

    override fun getPlatform(): Platform {
        TODO("Not yet implemented")
    }

    override fun getRegistry(): GameRegistry {
        TODO("Not yet implemented")
    }

    override fun getBuilderProvider(): BuilderProvider {
        TODO("Not yet implemented")
    }

    override fun getFactoryProvider(): FactoryProvider {
        TODO("Not yet implemented")
    }

    override fun getDataManager(): DataManager {
        TODO("Not yet implemented")
    }

    override fun getPluginManager(): PluginManager {
        TODO("Not yet implemented")
    }

    override fun getEventManager(): EventManager {
        TODO("Not yet implemented")
    }

    override fun getAssetManager(): AssetManager {
        TODO("Not yet implemented")
    }

    override fun getConfigManager(): ConfigManager {
        TODO("Not yet implemented")
    }

    override fun getChannelRegistry(): ChannelRegistry {
        TODO("Not yet implemented")
    }

    override fun getMetricsConfigManager(): MetricsConfigManager {
        TODO("Not yet implemented")
    }

    override fun getCommandManager(): CommandManager {
        TODO("Not yet implemented")
    }

    override fun getSqlManager(): SqlManager {
        TODO("Not yet implemented")
    }

    override fun getServiceProvider(): ServiceProvider.GameScoped {
        TODO("Not yet implemented")
    }
}