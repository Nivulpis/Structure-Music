package net.nivulpis.structuremusic.networking;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record PlayerStructureData(String structure) implements CustomPacketPayload {

    public static final CustomPacketPayload.Type<PlayerStructureData> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath("structuremusic", "player_structure_data"));

    public static final StreamCodec<ByteBuf, PlayerStructureData> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8,
            PlayerStructureData::structure,
            PlayerStructureData::new
    );

    @Override
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
