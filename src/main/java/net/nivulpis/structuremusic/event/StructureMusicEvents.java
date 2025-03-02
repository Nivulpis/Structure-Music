package net.nivulpis.structuremusic.event;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureStart;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import java.util.Optional;

@EventBusSubscriber(modid = "structuremusic")
public class StructureMusicEvents {
    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) return;

        ServerLevel serverLevel = player.serverLevel();
        BlockPos playerPos = player.blockPosition();

        for (ResourceKey<Structure> structureKey : serverLevel.registryAccess().registryOrThrow(Registries.STRUCTURE).registryKeySet()) {
            Optional<Structure> structureOptional = serverLevel.registryAccess().registryOrThrow(Registries.STRUCTURE).getOptional(structureKey);

            if (structureOptional.isPresent()) {
                Structure structure = structureOptional.get();
                StructureStart structureStart = serverLevel.structureManager().getStructureAt(playerPos, structure);

                if (structureStart.isValid()) {
                    System.out.println(player.getName().getString() + " is inside structure: " + structureKey.location());
                    break;
                }
            }
        }
    }
}