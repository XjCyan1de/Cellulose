package com.github.xjcyan1de.cellulose.server

import com.github.xjcyan1de.cellulose.common.AbstractCelluloseGame
import com.github.xjcyan1de.cellulose.common.AbstractCelluloseMod
import com.github.xjcyan1de.cellulose.common.AbstractCelluloseModule
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import org.spongepowered.api.Server

@Environment(EnvType.SERVER)
class CelluloseServerModule : AbstractCelluloseModule() {
    override fun configure() {
        super.configure()
        bind(Server::class.java).toInstance(AbstractCelluloseMod.instance.server as Server)
        bind(AbstractCelluloseGame::class.java).to(CelluloseServerGame::class.java)
    }
}