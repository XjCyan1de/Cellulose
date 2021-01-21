package com.github.xjcyan1de.cellulose.world.storage

import org.spongepowered.api.world.storage.ChunkLayout
import org.spongepowered.math.vector.Vector3i

object CelluloseChunkLayout : ChunkLayout {
    val CHUNK_SIZE = Vector3i(16, 256, 16)
    private val CHUNK_MASK = CHUNK_SIZE.sub(1, 1, 1)
    private val SPACE_MAX = Vector3i(30000000, 256, 30000000).sub(1, 1, 1).div(CHUNK_SIZE)
    private val SPACE_MIN = Vector3i(-30000000, 0, -30000000).div(CHUNK_SIZE)
    private val SPACE_SIZE = SPACE_MAX.sub(SPACE_MIN).add(1, 1, 1)

    override fun getChunkSize(): Vector3i = CHUNK_SIZE

    override fun getSpaceMax(): Vector3i = SPACE_MAX

    override fun getSpaceMin(): Vector3i = SPACE_MIN

    override fun getSpaceSize(): Vector3i = SPACE_SIZE

    override fun getSpaceOrigin(): Vector3i = Vector3i.ZERO

    // no bits allowed outside the mask!
    override fun isInChunk(x: Int, y: Int, z: Int): Boolean = x and CHUNK_MASK.x.inv() == 0 &&
            y and CHUNK_MASK.y.inv() == 0 &&
            z and CHUNK_MASK.z.inv() == 0

    override fun isInChunk(wx: Int, wy: Int, wz: Int, cx: Int, cy: Int, cz: Int): Boolean =
        isInChunk(wx - (cx shl 4), wy - (cy shl 8), wz - (cz shl 4))

    override fun forceToChunk(x: Int, y: Int, z: Int): Vector3i = Vector3i(x shr 4, y shr 8, z shr 4)

    override fun forceToWorld(x: Int, y: Int, z: Int): Vector3i = Vector3i(x shl 4, y shl 8, z shl 4)
}