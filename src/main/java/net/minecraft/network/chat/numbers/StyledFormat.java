package net.minecraft.network.chat.numbers;

import com.mojang.serialization.MapCodec;
import net.minecraft.ChatFormatting;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.network.codec.StreamCodec;

public class StyledFormat implements NumberFormat {
    public static final NumberFormatType<StyledFormat> TYPE = new NumberFormatType<StyledFormat>() {
        private static final MapCodec<StyledFormat> CODEC = Style.Serializer.MAP_CODEC.xmap(StyledFormat::new, p_311299_ -> p_311299_.style);
        private static final StreamCodec<RegistryFriendlyByteBuf, StyledFormat> STREAM_CODEC = StreamCodec.composite(
            Style.Serializer.TRUSTED_STREAM_CODEC, p_326089_ -> p_326089_.style, StyledFormat::new
        );

        @Override
        public MapCodec<StyledFormat> mapCodec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, StyledFormat> streamCodec() {
            return STREAM_CODEC;
        }
    };
    public static final StyledFormat NO_STYLE = new StyledFormat(Style.EMPTY);
    public static final StyledFormat SIDEBAR_DEFAULT = new StyledFormat(Style.EMPTY.withColor(ChatFormatting.RED));
    public static final StyledFormat PLAYER_LIST_DEFAULT = new StyledFormat(Style.EMPTY.withColor(ChatFormatting.YELLOW));
    final Style style;

    public StyledFormat(Style p_311279_) {
        this.style = p_311279_;
    }

    @Override
    public MutableComponent format(int p_312267_) {
        return Component.literal(Integer.toString(p_312267_)).withStyle(this.style);
    }

    @Override
    public NumberFormatType<StyledFormat> type() {
        return TYPE;
    }
}