package net.nivulpis.structuremusic.event;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
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

import java.util.HashMap;
import java.util.Map;
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

        for (ResourceKey<Structure> structureKey : serverLevel.registryAccess().registryOrThrow(Registries.STRUCTURE).registryKeySet()) {
            Optional<Structure> structureOptional = serverLevel.registryAccess().registryOrThrow(Registries.STRUCTURE).getOptional(structureKey);

            if (structureOptional.isPresent()) {
                Structure structure = structureOptional.get();
                StructureStart structureStart = serverLevel.structureManager().getStructureAt(playerPos, structure);

                if (structureStart.isValid()) {
                    ResourceLocation structureTag = structureKey.location();
                    setPlayerStructure(player, serverLevel, structureTag);
                    break;
                }
            }
        }
    }

    private static void setPlayerStructure(ServerPlayer player, Level world, ResourceLocation newTag) {
        ResourceLocation oldTag = playerStructure.get(player);
        if (oldTag != null && oldTag.equals(newTag)) return;

        playerStructure.put(player, newTag);

        System.out.println(player.getName().getString() + " is now in structure: " + (newTag != null ? newTag.toString() : "None"));
    }
}