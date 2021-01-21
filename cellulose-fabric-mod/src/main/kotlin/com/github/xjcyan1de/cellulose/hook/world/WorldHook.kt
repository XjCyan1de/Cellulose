package com.github.xjcyan1de.cellulose.hook.world

import com.github.xjcyan1de.cellulose.effect.particle.CelluloseParticleHelper
import com.github.xjcyan1de.cellulose.effect.record.CelluloseMusicDisc
import com.github.xjcyan1de.cellulose.mixin.accessor.server.world.ThreadedAnvilChunkStorage_Accessor
import com.github.xjcyan1de.cellulose.mixin.api.world.World_API
import com.github.xjcyan1de.cellulose.util.Constants
import com.github.xjcyan1de.cellulose.util.asImmutable
import com.github.xjcyan1de.cellulose.util.asOptional
import com.github.xjcyan1de.cellulose.world.storage.CelluloseChunkLayout
import net.minecraft.network.packet.s2c.play.BlockUpdateS2CPacket
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.server.world.ServerChunkManager
import net.minecraft.util.math.BlockPos
import net.minecraft.world.chunk.ChunkStatus
import org.spongepowered.api.Engine
import org.spongepowered.api.block.BlockState
import org.spongepowered.api.block.BlockType
import org.spongepowered.api.block.entity.BlockEntity
import org.spongepowered.api.data.DataTransactionResult
import org.spongepowered.api.data.Key
import org.spongepowered.api.data.persistence.DataContainer
import org.spongepowered.api.data.persistence.DataView
import org.spongepowered.api.data.value.MergeFunction
import org.spongepowered.api.data.value.Value
import org.spongepowered.api.data.value.ValueContainer
import org.spongepowered.api.effect.particle.ParticleEffect
import org.spongepowered.api.effect.sound.music.MusicDisc
import org.spongepowered.api.entity.Entity
import org.spongepowered.api.entity.EntityType
import org.spongepowered.api.entity.living.player.Player
import org.spongepowered.api.fluid.FluidState
import org.spongepowered.api.fluid.FluidType
import org.spongepowered.api.registry.RegistryHolder
import org.spongepowered.api.registry.RegistryScope
import org.spongepowered.api.scheduler.ScheduledUpdateList
import org.spongepowered.api.service.context.Context
import org.spongepowered.api.util.AABB
import org.spongepowered.api.world.*
import org.spongepowered.api.world.biome.Biome
import org.spongepowered.api.world.chunk.Chunk
import org.spongepowered.api.world.difficulty.Difficulty
import org.spongepowered.api.world.storage.WorldProperties
import org.spongepowered.api.world.volume.archetype.ArchetypeVolume
import org.spongepowered.api.world.volume.stream.StreamOptions
import org.spongepowered.api.world.volume.stream.VolumeStream
import org.spongepowered.api.world.weather.Weather
import org.spongepowered.math.vector.Vector3d
import org.spongepowered.math.vector.Vector3i
import java.util.*
import java.util.function.Predicate

class WorldHook<W : World<W, L>, L : Location<W, L>>(
    val handle: net.minecraft.world.World,
    val mixin: World_API<W, L>
) : World<W, L> {
    private val _context by lazy {
        Context(Context.WORLD_KEY, handle.registryKey.value.toString())
    }

    override fun getBlockMin(): Vector3i = Constants.World.BLOCK_MIN

    override fun getBlockMax(): Vector3i = Constants.World.BLOCK_MAX

    override fun getBlockSize(): Vector3i = Constants.World.BLOCK_SIZE

    override fun containsBlock(x: Int, y: Int, z: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun isAreaAvailable(x: Int, y: Int, z: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun getBlock(x: Int, y: Int, z: Int): BlockState {
        TODO("Not yet implemented")
    }

    override fun getFluid(x: Int, y: Int, z: Int): FluidState {
        TODO("Not yet implemented")
    }

    override fun getHighestYAt(x: Int, z: Int): Int = getHeight(HeightTypes.WORLD_SURFACE.get(), x, z)

    override fun getBlockEntities(): Collection<BlockEntity> = handle.blockEntities.asImmutable()

    override fun getBlockEntity(x: Int, y: Int, z: Int): Optional<out BlockEntity> {
        TODO("Not yet implemented")
    }

    override fun <E : Any?> get(x: Int, y: Int, z: Int, key: Key<out Value<E>>?): Optional<E> {
        TODO("Not yet implemented")
    }

    override fun <E : Any?, V : Value<E>?> getValue(x: Int, y: Int, z: Int, key: Key<V>?): Optional<V> {
        TODO("Not yet implemented")
    }

    override fun supports(x: Int, y: Int, z: Int, key: Key<*>?): Boolean {
        TODO("Not yet implemented")
    }

    override fun getKeys(x: Int, y: Int, z: Int): MutableSet<Key<*>> {
        TODO("Not yet implemented")
    }

    override fun getValues(x: Int, y: Int, z: Int): MutableSet<Value.Immutable<*>> {
        TODO("Not yet implemented")
    }

    override fun getHeight(type: HeightType?, x: Int, z: Int): Int {
        TODO("Not yet implemented")
    }

    override fun getBiome(x: Int, y: Int, z: Int): Biome {
        TODO("Not yet implemented")
    }

    override fun getLight(type: LightType?, x: Int, y: Int, z: Int): Int {
        TODO("Not yet implemented")
    }

    override fun getBiomeStream(min: Vector3i?, max: Vector3i?, options: StreamOptions?): VolumeStream<W, Biome> {
        TODO("Not yet implemented")
    }

    override fun getBlockStateStream(
        min: Vector3i?,
        max: Vector3i?,
        options: StreamOptions?
    ): VolumeStream<W, BlockState> {
        TODO("Not yet implemented")
    }

    override fun getPlayers(): MutableCollection<out Player> {
        TODO("Not yet implemented")
    }

    override fun getEntity(uuid: UUID?): Optional<Entity> {
        TODO("Not yet implemented")
    }

    override fun <T : Entity?> getEntities(
        entityClass: Class<out T>?,
        box: AABB?,
        predicate: Predicate<in T>?
    ): MutableCollection<out T> {
        TODO("Not yet implemented")
    }

    override fun getEntities(box: AABB?, filter: Predicate<in Entity>?): MutableCollection<out Entity> {
        TODO("Not yet implemented")
    }

    override fun getEntityStream(min: Vector3i?, max: Vector3i?, options: StreamOptions?): VolumeStream<W, Entity> {
        TODO("Not yet implemented")
    }

    override fun getBlockEntityStream(
        min: Vector3i?,
        max: Vector3i?,
        options: StreamOptions?
    ): VolumeStream<W, BlockEntity> {
        TODO("Not yet implemented")
    }

    override fun getChunk(cx: Int, cy: Int, cz: Int): Chunk =
        handle.getChunk(cx shr 4, cz shr 4, ChunkStatus.EMPTY, true) as Chunk

    override fun getChunkAtBlock(blockPosition: Vector3i?): Chunk {
        TODO("Not yet implemented")
    }

    override fun getChunkAtBlock(bx: Int, by: Int, bz: Int): Chunk {
        TODO("Not yet implemented")
    }

    override fun isChunkLoaded(x: Int, y: Int, z: Int, allowEmpty: Boolean): Boolean {
        TODO("Not yet implemented")
    }

    override fun hasChunk(x: Int, y: Int, z: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun hasChunk(position: Vector3i?): Boolean {
        TODO("Not yet implemented")
    }

    override fun getRandom(): Random {
        TODO("Not yet implemented")
    }

    override fun getWorldType(): WorldType {
        TODO("Not yet implemented")
    }

    override fun getBorder(): WorldBorder {
        TODO("Not yet implemented")
    }

    override fun isInBorder(entity: Entity?): Boolean {
        TODO("Not yet implemented")
    }

    override fun canSeeSky(x: Int, y: Int, z: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun hasLiquid(x: Int, y: Int, z: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsAnyLiquids(aabb: AABB?): Boolean {
        TODO("Not yet implemented")
    }

    override fun getSkylightSubtracted(): Int {
        TODO("Not yet implemented")
    }

    override fun getSeaLevel(): Int {
        TODO("Not yet implemented")
    }

    override fun isCollisionBoxesEmpty(entity: Entity?, aabb: AABB?): Boolean {
        TODO("Not yet implemented")
    }

    override fun isAreaLoaded(
        xStart: Int,
        yStart: Int,
        zStart: Int,
        xEnd: Int,
        yEnd: Int,
        zEnd: Int,
        allowEmpty: Boolean
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun setBiome(x: Int, y: Int, z: Int, biome: Biome?): Boolean {
        TODO("Not yet implemented")
    }

    override fun setBlock(x: Int, y: Int, z: Int, state: BlockState?, flag: BlockChangeFlag?): Boolean {
        TODO("Not yet implemented")
    }

    override fun removeBlock(x: Int, y: Int, z: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun <E : Entity?> createEntity(type: EntityType<E>?, position: Vector3d?): E {
        TODO("Not yet implemented")
    }

    override fun createEntity(entityContainer: DataContainer?): Optional<Entity> {
        TODO("Not yet implemented")
    }

    override fun createEntity(entityContainer: DataContainer?, position: Vector3d?): Optional<Entity> {
        TODO("Not yet implemented")
    }

    override fun <E : Entity?> createEntityNaturally(type: EntityType<E>?, position: Vector3d?): E {
        TODO("Not yet implemented")
    }

    override fun spawnEntity(entity: Entity?): Boolean {
        TODO("Not yet implemented")
    }

    override fun spawnEntities(entities: MutableIterable<Entity>?): MutableCollection<Entity> {
        TODO("Not yet implemented")
    }

    override fun addBlockEntity(x: Int, y: Int, z: Int, blockEntity: BlockEntity?) {
        TODO("Not yet implemented")
    }

    override fun removeBlockEntity(x: Int, y: Int, z: Int) {
        TODO("Not yet implemented")
    }

    override fun hasBlockState(x: Int, y: Int, z: Int, predicate: Predicate<in BlockState>?): Boolean {
        TODO("Not yet implemented")
    }

    override fun destroyBlock(pos: Vector3i?, performDrops: Boolean): Boolean {
        TODO("Not yet implemented")
    }

    override fun <E : Any?> offer(x: Int, y: Int, z: Int, key: Key<out Value<E>>?, value: E): DataTransactionResult {
        TODO("Not yet implemented")
    }

    override fun remove(x: Int, y: Int, z: Int, key: Key<*>?): DataTransactionResult {
        TODO("Not yet implemented")
    }

    override fun undo(x: Int, y: Int, z: Int, result: DataTransactionResult?): DataTransactionResult {
        TODO("Not yet implemented")
    }

    override fun copyFrom(xTo: Int, yTo: Int, zTo: Int, from: ValueContainer?): DataTransactionResult {
        TODO("Not yet implemented")
    }

    override fun copyFrom(
        xTo: Int,
        yTo: Int,
        zTo: Int,
        from: ValueContainer?,
        function: MergeFunction?
    ): DataTransactionResult {
        TODO("Not yet implemented")
    }

    override fun copyFrom(
        xTo: Int,
        yTo: Int,
        zTo: Int,
        xFrom: Int,
        yFrom: Int,
        zFrom: Int,
        function: MergeFunction?
    ): DataTransactionResult {
        TODO("Not yet implemented")
    }

    override fun validateRawData(x: Int, y: Int, z: Int, container: DataView?): Boolean {
        TODO("Not yet implemented")
    }

    override fun setRawData(x: Int, y: Int, z: Int, container: DataView?) {
        TODO("Not yet implemented")
    }

    override fun getScheduledBlockUpdates(): ScheduledUpdateList<BlockType> {
        TODO("Not yet implemented")
    }

    override fun getScheduledFluidUpdates(): ScheduledUpdateList<FluidType> {
        TODO("Not yet implemented")
    }

    override fun getEngine(): Engine {
        TODO("Not yet implemented")
    }

    override fun getSeed(): Long {
        TODO("Not yet implemented")
    }

    override fun getDifficulty(): Difficulty {
        TODO("Not yet implemented")
    }

    override fun getLocation(position: Vector3i?): L {
        TODO("Not yet implemented")
    }

    override fun getLocation(position: Vector3d?): L {
        TODO("Not yet implemented")
    }

    override fun getContext(): Context = _context

    override fun sendWorldType(worldType: WorldType?) {
        TODO("Not yet implemented")
    }

    override fun spawnParticles(particleEffect: ParticleEffect, position: Vector3d, radius: Int) {
        require(radius > 0) { "The radius has to be greater then zero!" }
        val playerManager = handle.server?.playerManager ?: return
        CelluloseParticleHelper.sendPackets(particleEffect, position, radius, handle.registryKey, playerManager)
    }

    override fun playMusicDisc(position: Vector3i, musicDiscType: MusicDisc?) {
        handle.server?.playerManager?.sendToDimension(
            CelluloseMusicDisc.createPacket(position, musicDiscType),
            handle.registryKey
        )
    }

    override fun stopMusicDisc(position: Vector3i) {
        handle.server?.playerManager?.sendToDimension(
            CelluloseMusicDisc.createPacket(position, null),
            handle.registryKey
        )
    }

    override fun sendBlockChange(x: Int, y: Int, z: Int, state: BlockState) {
        val packet = BlockUpdateS2CPacket(BlockPos(x, y, z), state as net.minecraft.block.BlockState)
        handle.players.forEach { player ->
            (player as? ServerPlayerEntity)?.networkHandler?.sendPacket(packet)
        }
    }

    override fun resetBlockChange(x: Int, y: Int, z: Int) {
        val packet = BlockUpdateS2CPacket(handle, BlockPos(x, y, z))
        handle.players.forEach { player ->
            (player as? ServerPlayerEntity)?.networkHandler?.sendPacket(packet)
        }
    }

    override fun createArchetypeVolume(min: Vector3i?, max: Vector3i?, origin: Vector3i?): ArchetypeVolume {
        TODO("Not yet implemented")
    }

    override fun weather(): Weather {
        TODO("Not yet implemented")
    }

    override fun registryScope(): RegistryScope {
        TODO("Not yet implemented")
    }

    override fun registries(): RegistryHolder {
        TODO("Not yet implemented")
    }

    override fun getProperties(): WorldProperties {
        TODO("Not yet implemented")
    }

    override fun isLoaded(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getClosestPlayer(
        x: Int,
        y: Int,
        z: Int,
        distance: Double,
        predicate: Predicate<in Player>
    ): Optional<out Player> = handle.getClosestPlayer(x.toDouble(), y.toDouble(), z.toDouble(), distance) {
        predicate.test(it as Player)
    }.asOptional()

    override fun loadChunk(cx: Int, cy: Int, cz: Int, shouldGenerate: Boolean): Optional<Chunk> {
        if (!CelluloseChunkLayout.isValidChunk(cx, cy, cz)) {
            return Optional.empty()
        }
        val chunkStatus = if (shouldGenerate) ChunkStatus.FULL else ChunkStatus.EMPTY
        return handle.chunkManager.getChunk(cx, cz, chunkStatus, true).asOptional()
    }

    override fun getLoadedChunks(): Iterable<Chunk> {
        val chunkManager = handle.chunkManager as? ServerChunkManager ?: return emptyList()
        val chunks = (chunkManager.threadedAnvilChunkStorage as ThreadedAnvilChunkStorage_Accessor).entryIterator()
        return chunks.mapNotNull { it.worldChunk as Chunk }
    }
}