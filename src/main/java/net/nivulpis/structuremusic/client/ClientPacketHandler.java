package net.nivulpis.structuremusic.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.sounds.MusicManager;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.nivulpis.structuremusic.AdditionalMusic;
import net.nivulpis.structuremusic.StructureMusicConfiguration;
import net.nivulpis.structuremusic.networking.PlayerStructureData;

import java.util.List;

public class ClientPacketHandler {
    private static SoundEvent lastPlayedMusic = null;

    public static void handlePlayerStructureData(final PlayerStructureData data) {
        Minecraft.getInstance().execute(() -> {
            ResourceLocation structureLocation = ResourceLocation.tryParse(data.structure());

            if (structureLocation == null) {
                stopCurrentMusic();
                return;
            }

            SoundEvent musicToPlay = getMusicForStructure(structureLocation);

            if (musicToPlay != null) {
                playMusic(musicToPlay);
            } else {
                stopCurrentMusic();
            }
        });
    }

    private static SoundEvent getMusicForStructure(ResourceLocation structure) {
        if (matchesConfig(StructureMusicConfiguration.customMusicOne, structure)) return AdditionalMusic.STRUCTURE_ONE.get();
        if (matchesConfig(StructureMusicConfiguration.customMusicTwo, structure)) return AdditionalMusic.STRUCTURE_TWO.get();
        if (matchesConfig(StructureMusicConfiguration.customMusicThree, structure)) return AdditionalMusic.STRUCTURE_THREE.get();
        if (matchesConfig(StructureMusicConfiguration.customMusicFour, structure)) return AdditionalMusic.STRUCTURE_FOUR.get();
        if (matchesConfig(StructureMusicConfiguration.customMusicFive, structure)) return AdditionalMusic.STRUCTURE_FIVE.get();
        if (matchesConfig(StructureMusicConfiguration.customMusicSix, structure)) return AdditionalMusic.STRUCTURE_SIX.get();
        if (matchesConfig(StructureMusicConfiguration.customMusicSeven, structure)) return AdditionalMusic.STRUCTURE_SEVEN.get();
        if (matchesConfig(StructureMusicConfiguration.customMusicEight, structure)) return AdditionalMusic.STRUCTURE_EIGHT.get();
        if (matchesConfig(StructureMusicConfiguration.customMusicNine, structure)) return AdditionalMusic.STRUCTURE_NINE.get();
        return null;
    }

    private static boolean matchesConfig(ModConfigSpec.ConfigValue<List<? extends String>> configList, ResourceLocation structure) {
        return configList.get().contains(structure.toString());
    }

    private static void playMusic(SoundEvent music) {
        Minecraft mc = Minecraft.getInstance();
        MusicManager musicManager = mc.getMusicManager();

        if (mc.player != null && mc.level != null) {
            if (music != lastPlayedMusic) {
                stopCurrentMusic();
                musicManager.startPlaying(new Music(Holder.direct(music), 0, 0, true));
                lastPlayedMusic = music;
            }
        }
    }

    private static void stopCurrentMusic() {
        Minecraft mc = Minecraft.getInstance();
        MusicManager musicManager = mc.getMusicManager();

        if (lastPlayedMusic != null) {
            musicManager.stopPlaying();
            lastPlayedMusic = null;
        }
    }
}