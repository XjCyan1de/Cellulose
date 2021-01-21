package com.github.xjcyan1de.cellulose.mixin.api.util;

import net.kyori.adventure.key.Key;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.api.ResourceKey;
import org.spongepowered.asm.mixin.*;

@Mixin(Identifier.class)
@Implements(value = {
        @Interface(iface = Key.class, prefix = "adventure$"),
        @Interface(iface = ResourceKey.class, prefix = "sponge$"),
})
public abstract class Identifier_API implements Key, ResourceKey {
    @Shadow
    public abstract String shadow$getNamespace();

    @Shadow
    public abstract String shadow$getPath();

    public @NotNull String adventure$namespace() {
        return this.shadow$getNamespace();
    }

    public @NotNull String adventure$value() {
        return this.shadow$getPath();
    }

    @Intrinsic
    public int adventure$compareTo(@NotNull Key o) {
        return ResourceKey.super.compareTo(o);
    }
}
