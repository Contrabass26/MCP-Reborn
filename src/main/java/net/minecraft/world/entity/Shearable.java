package net.minecraft.world.entity;

import net.minecraft.sounds.SoundSource;

public interface Shearable {
    void shear(SoundSource p_21749_);

    boolean readyForShearing();
}