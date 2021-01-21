package com.github.xjcyan1de.cellulose.util

import org.spongepowered.api.ResourceKey
import org.spongepowered.api.data.persistence.DataQuery
import org.spongepowered.api.util.Direction
import org.spongepowered.math.vector.Vector3i

object Constants {
    object Particles {
        // Particle Effects
        val PARTICLE_TYPE = DataQuery.of("Type")
        val PARTICLE_OPTIONS = DataQuery.of("Options")
        val PARTICLE_OPTION_KEY = DataQuery.of("Option")
        val PARTICLE_OPTION_VALUE = DataQuery.of("Value")
    }

    /**
     * https://wiki.vg/Protocol#Effect
     */
    object WorldEvents {
        const val PLAY_RECORD_EVENT = 1010
        const val PLAY_WITHER_SPAWN_EVENT = 1023
        const val PLAY_ENDERDRAGON_DEATH_EVENT = 1028
        const val PLAY_BLOCK_END_PORTAL_SPAWN_EVENT = 1038
    }

    object World {
        val BLOCK_MIN = Vector3i(-30000000, 0, -30000000)
        val BIOME_MIN = Vector3i(BLOCK_MIN.x, 0, BLOCK_MIN.z)
        val BLOCK_MAX = Vector3i(30000000, 256, 30000000).sub(Vector3i.ONE)
        val BLOCK_SIZE: Vector3i = BLOCK_MAX.sub(BLOCK_MIN).add(Vector3i.ONE)
        val BIOME_MAX = Vector3i(BLOCK_MAX.x, 256, BLOCK_MAX.z)
        val INVALID_WORLD_KEY = ResourceKey.sponge("invalid_world")
        val LEVEL_DAT_OLD: String = "level.dat_old"
        const val DEFAULT_BLOCK_CHANGE_LIMIT = 512
    }

    object Chunk {
        val CARDINAL_DIRECTIONS = arrayOf(Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST)

        // Neighbor Constants
        const val NUM_XZ_BITS = 4
        const val NUM_SHORT_Y_BITS = 8
        const val NUM_INT_Y_BITS = 24
        const val XZ_MASK: Short = 0xF
        const val Y_SHORT_MASK: Short = 0xFF
        const val Y_INT_MASK = 0xFFFFFF
        const val CHUNK_DATA_SECTIONS = "Sections"
    }
}