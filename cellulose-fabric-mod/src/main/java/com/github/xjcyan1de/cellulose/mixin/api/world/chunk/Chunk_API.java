package com.github.xjcyan1de.cellulose.mixin.api.world.chunk;

import com.github.xjcyan1de.cellulose.mixin.accessor.world.biome.source.BiomeArray_Accessor;
import com.github.xjcyan1de.cellulose.util.SmartCast;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.source.BiomeArray;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.api.world.biome.Biome;
import org.spongepowered.api.world.chunk.Chunk;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(net.minecraft.world.chunk.Chunk.class)
public abstract class Chunk_API implements Chunk {
    @Shadow
    @Nullable
    public abstract BiomeArray getBiomeArray();

    @Override
    public boolean setBiome(int x, int y, int z, Biome biome) {
        BiomeArray biomeArray = getBiomeArray();
        if (biomeArray == null) {
            return false;
        }
        net.minecraft.world.biome.Biome[] biomes = ((BiomeArray_Accessor) biomeArray).accessor$data();

        int maskedX = x & BiomeArray.HORIZONTAL_BIT_MASK;
        int maskedY = MathHelper.clamp(y, 0, BiomeArray.VERTICAL_BIT_MASK);
        int maskedZ = z & BiomeArray.HORIZONTAL_BIT_MASK;

        int horizontalSectionCount = BiomeArray_Accessor.accessor$HORIZONTAL_SECTION_COUNT();
        int posKey = maskedY << horizontalSectionCount | maskedZ << horizontalSectionCount | maskedX;
        biomes[posKey] = SmartCast.cast(biome);
        return false;
    }
}
