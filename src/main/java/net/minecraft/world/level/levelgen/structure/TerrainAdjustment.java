package net.minecraft.world.level.levelgen.structure;

import com.mojang.serialization.Codec;
import net.minecraft.util.StringRepresentable;

public enum TerrainAdjustment implements StringRepresentable {
    NONE("none"),
    BURY("bury"),
    BEARD_THIN("beard_thin"),
    BEARD_BOX("beard_box"),
    ENCAPSULATE("encapsulate");

    public static final Codec<TerrainAdjustment> CODEC = StringRepresentable.fromEnum(TerrainAdjustment::values);
    private final String id;

    private TerrainAdjustment(final String p_226925_) {
        this.id = p_226925_;
    }

    @Override
    public String getSerializedName() {
        return this.id;
    }
}