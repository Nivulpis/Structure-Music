package net.nivulpis.structuremusic.client;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.nivulpis.structuremusic.networking.PlayerStructureData;

public class    ClientPacketHandler {
    public static void handlePlayerStructureData(final PlayerStructureData data) {
        Minecraft.getInstance().execute(() -> {

            ResourceLocation structureLocation = ResourceLocation.tryParse(data.structure());

            String message = (structureLocation != null)
                    ? "Received structure: " + structureLocation.toString()
                    : "Received an invalid structure tag!";

            Minecraft.getInstance().player.sendSystemMessage(Component.literal(message));
        });
    }
}
