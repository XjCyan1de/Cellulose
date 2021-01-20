package com.github.xjcyan1de.cellulose.mixin.api.server;

import com.google.common.collect.ImmutableList;
import net.kyori.adventure.audience.Audience;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.PlayerManager;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.spongepowered.api.Server;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Collection;
import java.util.List;

@SuppressWarnings({"unchecked", "rawtypes"})
@Mixin(MinecraftServer.class)
@Implements(value = @Interface(iface = Server.class, prefix = "server$"))
abstract class MinecraftServer_MixinAPI implements Server {
    private Iterable<Audience> audiences;

    @Shadow
    public abstract PlayerManager shadow$getPlayerManager();

    @Override
    public @NonNull Iterable<? extends Audience> audiences() {
        if (audiences == null) {
            audiences = (List) shadow$getPlayerManager().getPlayerList();
        }
        return audiences;
    }

    @Override
    public Collection<ServerPlayer> getOnlinePlayers() {
        final PlayerManager playerManager = shadow$getPlayerManager();
        if (playerManager == null || playerManager.getPlayerList() == null) {
            return ImmutableList.of();
        }
        return (List) ImmutableList.of(playerManager.getPlayerList());
    }
}
