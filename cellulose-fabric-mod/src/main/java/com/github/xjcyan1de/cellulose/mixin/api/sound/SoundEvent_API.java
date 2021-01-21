package com.github.xjcyan1de.cellulose.mixin.api.sound;

import net.kyori.adventure.key.Key;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.effect.sound.SoundType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(SoundEvent.class)
public abstract class SoundEvent_API implements SoundType {
    @Shadow
    public abstract Identifier getId();

    @Override
    public ResourceKey getKey() {
        return (ResourceKey) (Object) getId();
    }

    @Override
    public @NonNull Key key() {
        return (ResourceKey) (Object) getId();
    }
}