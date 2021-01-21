package com.github.xjcyan1de.cellulose.mixin.accessor.server.world;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.server.world.ChunkHolder;
import net.minecraft.server.world.ThreadedAnvilChunkStorage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(ThreadedAnvilChunkStorage.class)
public interface ThreadedAnvilChunkStorage_Accessor {
    @Accessor("entityTrackers")
    Int2ObjectMap<EntityTracker_Accessor> entityTrackers();

    @Invoker("save")
    void save(boolean flush);

    @Invoker("entryIterator")
    Iterable<ChunkHolder> entryIterator();
}
