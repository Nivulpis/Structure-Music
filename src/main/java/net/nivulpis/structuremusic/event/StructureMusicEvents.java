package net.nivulpis.structuremusic.event;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.protocol.common.ClientboundCustomPayloadPacket;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureStart;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.nivulpis.structuremusic.StructureMusicConfiguration;
import net.nivulpis.structuremusic.networking.PlayerStructureData;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@EventBusSubscriber(modid = "structuremusic")
public class StructureMusicEvents {
    private static final Map<ServerPlayer, ResourceLocation> playerStructure = new HashMap<>();
    private static int tickCounter = 0;
    private static final int CHECK_INTERVAL = 100;

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) return;
        if (tickCounter++ < CHECK_INTERVAL) return;

        tickCounter = 0;
        checkPlayerStructure(player);
    }

    @SubscribeEvent
    public static void onPlayerLogout(PlayerEvent.PlayerLoggedOutEvent event) {
        playerStructure.remove(event.getEntity());
    }

    private static void checkPlayerStructure(ServerPlayer player) {
        ServerLevel serverLevel = player.serverLevel();
        BlockPos playerPos = player.blockPosition();
        boolean foundStructure = false;

        for (ResourceKey<Structure> structureKey : serverLevel.registryAccess().registryOrThrow(Registries.STRUCTURE).registryKeySet()) {
            Optional<Structure> structureOptional = serverLevel.registryAccess().registryOrThrow(Registries.STRUCTURE).getOptional(structureKey);

            if (structureOptional.isPresent()) {
                Structure structure = structureOptional.get();
                StructureStart structureStart = serverLevel.structureManager().getStructureAt(playerPos, structure);

                if (structureStart.isValid()) {
                    ResourceLocation structureTag = structureKey.location();

                    if (isStructureInConfig(structureTag)) {
                        setPlayerStructure(player, serverLevel, structureTag);
                        foundStructure = true;
                        break;
                    }
                }
            }
        }

        if (!foundStructure) {
            setPlayerStructure(player, serverLevel, null);
        }
    }

    private static boolean isStructureInConfig(ResourceLocation structureTag) {
        return StructureMusicConfiguration.customMusicOne.get().contains(structureTag.toString()) ||
                StructureMusicConfiguration.customMusicTwo.get().contains(structureTag.toString()) ||
                StructureMusicConfiguration.customMusicThree.get().contains(structureTag.toString()) ||
                StructureMusicConfiguration.customMusicFour.get().contains(structureTag.toString()) ||
                StructureMusicConfiguration.customMusicFive.get().contains(structureTag.toString()) ||
                StructureMusicConfiguration.customMusicSix.get().contains(structureTag.toString()) ||
                StructureMusicConfiguration.customMusicSeven.get().contains(structureTag.toString()) ||
                StructureMusicConfiguration.customMusicEight.get().contains(structureTag.toString()) ||
                StructureMusicConfiguration.customMusicNine.get().contains(structureTag.toString()) ||
                StructureMusicConfiguration.customMusicTen.get().contains(structureTag.toString()) ||
                StructureMusicConfiguration.customMusicEleven.get().contains(structureTag.toString()) ||
                StructureMusicConfiguration.customMusicTwelve.get().contains(structureTag.toString()) ||
                StructureMusicConfiguration.customMusicThirteen.get().contains(structureTag.toString()) ||
                StructureMusicConfiguration.customMusicFourteen.get().contains(structureTag.toString()) ||
                StructureMusicConfiguration.customMusicFifteen.get().contains(structureTag.toString()) ||
                StructureMusicConfiguration.customMusicSixteen.get().contains(structureTag.toString()) ||
                StructureMusicConfiguration.customMusicSeventeen.get().contains(structureTag.toString()) ||
                StructureMusicConfiguration.customMusicEighteen.get().contains(structureTag.toString());
    }


    private static void setPlayerStructure(ServerPlayer player, Level world, ResourceLocation newStructure) {
        ResourceLocation oldTag = playerStructure.get(player);

        if (Objects.equals(oldTag, newStructure)) {
            return;
        }

        playerStructure.put(player, newStructure);

        String structureName = (newStructure != null) ? newStructure.toString() : "none";
        PlayerStructureData payload = new PlayerStructureData(structureName);
        player.connection.send(new ClientboundCustomPayloadPacket(payload));
    }

}