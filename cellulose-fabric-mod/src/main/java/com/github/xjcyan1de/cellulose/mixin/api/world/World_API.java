package com.github.xjcyan1de.cellulose.mixin.api.world;


import com.github.xjcyan1de.cellulose.hook.world.WorldHook;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.Engine;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.entity.BlockEntity;
import org.spongepowered.api.data.DataTransactionResult;
import org.spongepowered.api.data.Key;
import org.spongepowered.api.data.persistence.DataContainer;
import org.spongepowered.api.data.persistence.DataView;
import org.spongepowered.api.data.persistence.InvalidDataException;
import org.spongepowered.api.data.value.MergeFunction;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.data.value.ValueContainer;
import org.spongepowered.api.effect.particle.ParticleEffect;
import org.spongepowered.api.effect.sound.music.MusicDisc;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.fluid.FluidState;
import org.spongepowered.api.fluid.FluidType;
import org.spongepowered.api.registry.RegistryHolder;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.scheduler.ScheduledUpdateList;
import org.spongepowered.api.service.context.Context;
import org.spongepowered.api.util.AABB;
import org.spongepowered.api.world.*;
import org.spongepowered.api.world.biome.Biome;
import org.spongepowered.api.world.chunk.Chunk;
import org.spongepowered.api.world.difficulty.Difficulty;
import org.spongepowered.api.world.storage.WorldProperties;
import org.spongepowered.api.world.volume.archetype.ArchetypeVolume;
import org.spongepowered.api.world.volume.stream.StreamOptions;
import org.spongepowered.api.world.volume.stream.VolumeStream;
import org.spongepowered.api.world.weather.Weather;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.math.vector.Vector3d;
import org.spongepowered.math.vector.Vector3i;

import java.util.*;
import java.util.function.Predicate;

@SuppressWarnings({"unchecked", "rawtypes"})
@Mixin(net.minecraft.world.World.class)
public class World_API<W extends World<W, L>, L extends Location<W, L>> implements World<W, L> {
    private final WorldHook<W, L> hook = new WorldHook((net.minecraft.world.World) (Object) this, this);

    @Override
    public WorldProperties getProperties() {
        return hook.getProperties();
    }

    @Override
    public boolean isLoaded() {
        return hook.isLoaded();
    }

    @Override
    public Collection<? extends Player> getPlayers() {
        return hook.getPlayers();
    }

    @Override
    public Optional<Entity> getEntity(UUID uuid) {
        return hook.getEntity(uuid);
    }

    @Override
    public <T extends Entity> Collection<? extends T> getEntities(Class<? extends T> entityClass, AABB box, @Nullable Predicate<? super T> predicate) {
        return hook.getEntities(entityClass, box, predicate);
    }

    @Override
    public Collection<? extends Entity> getEntities(AABB box, Predicate<? super Entity> filter) {
        return hook.getEntities(box, filter);
    }

    @Override
    public Optional<? extends Player> getClosestPlayer(int x, int y, int z, double distance, Predicate<? super Player> predicate) {
        return hook.getClosestPlayer(x, y, z, distance, predicate);
    }

    @Override
    public Chunk getChunkAtBlock(Vector3i blockPosition) {
        return hook.getChunkAtBlock(blockPosition);
    }

    @Override
    public Chunk getChunkAtBlock(int bx, int by, int bz) {
        return hook.getChunkAtBlock(bx, by, bz);
    }

    @Override
    public boolean isChunkLoaded(int x, int y, int z, boolean allowEmpty) {
        return hook.isChunkLoaded(x, y, z, allowEmpty);
    }

    @Override
    public boolean hasChunk(int x, int y, int z) {
        return hook.hasChunk(x, y, z);
    }

    @Override
    public boolean hasChunk(Vector3i position) {
        return hook.hasChunk(position);
    }

    @Override
    public Chunk getChunk(int cx, int cy, int cz) {
        return hook.getChunk(cx, cy, cz);
    }

    @Override
    public Optional<Chunk> loadChunk(int cx, int cy, int cz, boolean shouldGenerate) {
        return hook.loadChunk(cx, cy, cz, shouldGenerate);
    }

    @Override
    public Iterable<Chunk> getLoadedChunks() {
        return hook.getLoadedChunks();
    }

    @Override
    public void sendWorldType(WorldType worldType) {
        hook.sendWorldType(worldType);
    }

    @Override
    public void spawnParticles(ParticleEffect particleEffect, Vector3d position, int radius) {
        hook.spawnParticles(particleEffect, position, radius);
    }

    @Override
    public void playMusicDisc(Vector3i position, MusicDisc musicDiscType) {
        hook.playMusicDisc(position, musicDiscType);
    }

    @Override
    public void stopMusicDisc(Vector3i position) {
        hook.stopMusicDisc(position);
    }

    @Override
    public void sendBlockChange(int x, int y, int z, BlockState state) {
        hook.sendBlockChange(x, y, z, state);
    }

    @Override
    public void resetBlockChange(int x, int y, int z) {
        hook.resetBlockChange(x, y, z);
    }

    @Override
    public RegistryScope registryScope() {
        return hook.registryScope();
    }

    @Override
    public RegistryHolder registries() {
        return hook.registries();
    }

    @Override
    public Context getContext() {
        return hook.getContext();
    }

    @Override
    public L getLocation(Vector3i position) {
        return hook.getLocation(position);
    }

    @Override
    public L getLocation(Vector3d position) {
        return hook.getLocation(position);
    }

    @Override
    public Engine getEngine() {
        return hook.getEngine();
    }

    @Override
    public long getSeed() {
        return hook.getSeed();
    }

    @Override
    public Difficulty getDifficulty() {
        return hook.getDifficulty();
    }

    @Override
    public boolean setBlock(int x, int y, int z, BlockState state, BlockChangeFlag flag) {
        return hook.setBlock(x, y, z, state, flag);
    }

    @Override
    public boolean removeBlock(int x, int y, int z) {
        return hook.removeBlock(x, y, z);
    }

    @Override
    public boolean destroyBlock(Vector3i pos, boolean performDrops) {
        return hook.destroyBlock(pos, performDrops);
    }

    @Override
    public ArchetypeVolume createArchetypeVolume(Vector3i min, Vector3i max, Vector3i origin) {
        return hook.createArchetypeVolume(min, max, origin);
    }

    @Override
    public boolean setBiome(int x, int y, int z, Biome biome) {
        return hook.setBiome(x, y, z, biome);
    }

    @Override
    public void addBlockEntity(int x, int y, int z, BlockEntity blockEntity) {
        hook.addBlockEntity(x, y, z, blockEntity);
    }

    @Override
    public void removeBlockEntity(int x, int y, int z) {
        hook.removeBlockEntity(x, y, z);
    }

    @Override
    public <E extends Entity> E createEntity(EntityType<E> type, Vector3d position) throws IllegalArgumentException, IllegalStateException {
        return hook.createEntity(type, position);
    }

    @Override
    public <E extends Entity> E createEntityNaturally(EntityType<E> type, Vector3d position) throws IllegalArgumentException, IllegalStateException {
        return hook.createEntityNaturally(type, position);
    }

    @Override
    public Optional<Entity> createEntity(DataContainer entityContainer) {
        return hook.createEntity(entityContainer);
    }

    @Override
    public Optional<Entity> createEntity(DataContainer entityContainer, Vector3d position) {
        return hook.createEntity(entityContainer, position);
    }

    @Override
    public boolean spawnEntity(Entity entity) {
        return hook.spawnEntity(entity);
    }

    @Override
    public Collection<Entity> spawnEntities(Iterable<? extends Entity> entities) {
        return hook.spawnEntities(entities);
    }

    @Override
    public boolean hasBlockState(int x, int y, int z, Predicate<? super BlockState> predicate) {
        return hook.hasBlockState(x, y, z, predicate);
    }

    @Override
    public <E> DataTransactionResult offer(int x, int y, int z, Key<? extends Value<E>> key, E value) {
        return hook.offer(x, y, z, key, value);
    }

    @Override
    public DataTransactionResult remove(int x, int y, int z, Key<?> key) {
        return hook.remove(x, y, z, key);
    }

    @Override
    public DataTransactionResult undo(int x, int y, int z, DataTransactionResult result) {
        return hook.undo(x, y, z, result);
    }

    @Override
    public DataTransactionResult copyFrom(int xTo, int yTo, int zTo, ValueContainer from) {
        return hook.copyFrom(xTo, yTo, zTo, from);
    }

    @Override
    public DataTransactionResult copyFrom(int xTo, int yTo, int zTo, ValueContainer from, MergeFunction function) {
        return hook.copyFrom(xTo, yTo, zTo, from, function);
    }

    @Override
    public DataTransactionResult copyFrom(int xTo, int yTo, int zTo, int xFrom, int yFrom, int zFrom, MergeFunction function) {
        return hook.copyFrom(xTo, yTo, zTo, xFrom, yFrom, zFrom, function);
    }

    @Override
    public boolean validateRawData(int x, int y, int z, DataView container) {
        return hook.validateRawData(x, y, z, container);
    }

    @Override
    public void setRawData(int x, int y, int z, DataView container) throws InvalidDataException {
        hook.setRawData(x, y, z, container);
    }

    @Override
    public WorldType getWorldType() {
        return hook.getWorldType();
    }

    @Override
    public WorldBorder getBorder() {
        return hook.getBorder();
    }

    @Override
    public boolean isInBorder(Entity entity) {
        return hook.isInBorder(entity);
    }

    @Override
    public boolean canSeeSky(int x, int y, int z) {
        return hook.canSeeSky(x, y, z);
    }

    @Override
    public boolean hasLiquid(int x, int y, int z) {
        return hook.hasLiquid(x, y, z);
    }

    @Override
    public boolean containsAnyLiquids(AABB aabb) {
        return hook.containsAnyLiquids(aabb);
    }

    @Override
    public int getSkylightSubtracted() {
        return hook.getSkylightSubtracted();
    }

    @Override
    public int getSeaLevel() {
        return hook.getSeaLevel();
    }

    @Override
    public boolean isCollisionBoxesEmpty(@Nullable Entity entity, AABB aabb) {
        return hook.isCollisionBoxesEmpty(entity, aabb);
    }

    @Override
    public boolean isAreaLoaded(int xStart, int yStart, int zStart, int xEnd, int yEnd, int zEnd, boolean allowEmpty) {
        return hook.isAreaLoaded(xStart, yStart, zStart, xEnd, yEnd, zEnd, allowEmpty);
    }

    @Override
    public Random getRandom() {
        return hook.getRandom();
    }

    @Override
    public VolumeStream<W, Biome> getBiomeStream(Vector3i min, Vector3i max, StreamOptions options) {
        return hook.getBiomeStream(min, max, options);
    }

    @Override
    public VolumeStream<W, BlockState> getBlockStateStream(Vector3i min, Vector3i max, StreamOptions options) {
        return hook.getBlockStateStream(min, max, options);
    }

    @Override
    public VolumeStream<W, BlockEntity> getBlockEntityStream(Vector3i min, Vector3i max, StreamOptions options) {
        return hook.getBlockEntityStream(min, max, options);
    }

    @Override
    public VolumeStream<W, Entity> getEntityStream(Vector3i min, Vector3i max, StreamOptions options) {
        return hook.getEntityStream(min, max, options);
    }

    @Override
    public int getLight(LightType type, int x, int y, int z) {
        return hook.getLight(type, x, y, z);
    }

    @Override
    public Biome getBiome(int x, int y, int z) {
        return hook.getBiome(x, y, z);
    }

    @Override
    public Collection<? extends BlockEntity> getBlockEntities() {
        return hook.getBlockEntities();
    }

    @Override
    public Optional<? extends BlockEntity> getBlockEntity(int x, int y, int z) {
        return hook.getBlockEntity(x, y, z);
    }

    @Override
    public ScheduledUpdateList<BlockType> getScheduledBlockUpdates() {
        return hook.getScheduledBlockUpdates();
    }

    @Override
    public ScheduledUpdateList<FluidType> getScheduledFluidUpdates() {
        return hook.getScheduledFluidUpdates();
    }

    @Override
    public BlockState getBlock(int x, int y, int z) {
        return hook.getBlock(x, y, z);
    }

    @Override
    public FluidState getFluid(int x, int y, int z) {
        return hook.getFluid(x, y, z);
    }

    @Override
    public int getHighestYAt(int x, int z) {
        return hook.getHighestYAt(x, z);
    }

    @Override
    public Vector3i getBlockMin() {
        return hook.getBlockMin();
    }

    @Override
    public Vector3i getBlockMax() {
        return hook.getBlockMax();
    }

    @Override
    public Vector3i getBlockSize() {
        return hook.getBlockSize();
    }

    @Override
    public boolean containsBlock(int x, int y, int z) {
        return hook.containsBlock(x, y, z);
    }

    @Override
    public boolean isAreaAvailable(int x, int y, int z) {
        return hook.isAreaAvailable(x, y, z);
    }

    @Override
    public int getHeight(HeightType type, int x, int z) {
        return hook.getHeight(type, x, z);
    }

    @Override
    public <E> Optional<E> get(int x, int y, int z, Key<? extends Value<E>> key) {
        return hook.get(x, y, z, key);
    }

    @Override
    public <E, V extends Value<E>> Optional<V> getValue(int x, int y, int z, Key<V> key) {
        return hook.getValue(x, y, z, key);
    }

    @Override
    public boolean supports(int x, int y, int z, Key<?> key) {
        return hook.supports(x, y, z, key);
    }

    @Override
    public Set<Key<?>> getKeys(int x, int y, int z) {
        return hook.getKeys(x, y, z);
    }

    @Override
    public Set<Value.Immutable<?>> getValues(int x, int y, int z) {
        return hook.getValues(x, y, z);
    }

    @Override
    public Weather weather() {
        return hook.weather();
    }
}
