package com.github.xjcyan1de.cellulose.mixin.accessor.server.world;

import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Set;

@Mixin(targets = "net/minecraft/server/world/ThreadedAnvilChunkStorage$EntityTracker")
public interface EntityTracker_Accessor {
    @Accessor("playersTracking")
    Set<ServerPlayerEntity> accessor$playersTracking();
}
