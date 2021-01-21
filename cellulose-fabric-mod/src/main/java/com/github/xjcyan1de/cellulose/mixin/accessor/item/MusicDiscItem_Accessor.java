package com.github.xjcyan1de.cellulose.mixin.accessor.item;

import net.minecraft.item.MusicDiscItem;
import net.minecraft.sound.SoundEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(MusicDiscItem.class)
public interface MusicDiscItem_Accessor {
    @Accessor("sound")
    SoundEvent sound();
}
