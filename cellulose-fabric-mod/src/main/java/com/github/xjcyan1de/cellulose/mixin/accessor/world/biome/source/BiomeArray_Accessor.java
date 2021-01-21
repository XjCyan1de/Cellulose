package com.github.xjcyan1de.cellulose.mixin.accessor.world.biome.source;

import com.github.xjcyan1de.cellulose.exception.UntransformedAccessorError;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeArray;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(BiomeArray.class)
public interface BiomeArray_Accessor {
    @Accessor("HORIZONTAL_SECTION_COUNT")
    static int accessor$HORIZONTAL_SECTION_COUNT() {
        throw new UntransformedAccessorError();
    }

    @Accessor("data")
    Biome[] accessor$data();
}
