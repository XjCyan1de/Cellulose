package com.github.xjcyan1de.cellulose.mixin.api.server.network;

import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ServerPlayerEntity.class)
@Implements(value = @Interface(iface = ServerPlayer.class, prefix = "sponge$"))
public abstract class ServerPlayerEntity_API implements ServerPlayer {

}
