package net.nivulpis.structuremusic;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.nivulpis.structuremusic.tags.StructureMusicTags;

import java.util.*;

public class AdditionalMusic
{
    public static Music STRUCTURE_ONE   = new Music(Registry.registerForHolder(BuiltInRegistries.SOUND_EVENT,
            ResourceLocation.fromNamespaceAndPath(StructureMusic.MOD_ID, "music.structure_one"),
            SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(StructureMusic.MOD_ID, "music.structure_one"))), 12000, 24000, false);
    public static Music STRUCTURE_TWO   = new Music(Registry.registerForHolder(BuiltInRegistries.SOUND_EVENT,
            ResourceLocation.fromNamespaceAndPath(StructureMusic.MOD_ID, "music.structure_two"),
            SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(StructureMusic.MOD_ID, "music.structure_two"))), 12000, 24000, false);
    public static Music STRUCTURE_THREE   = new Music(Registry.registerForHolder(BuiltInRegistries.SOUND_EVENT,
            ResourceLocation.fromNamespaceAndPath(StructureMusic.MOD_ID, "music.structure_three"),
            SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(StructureMusic.MOD_ID, "music.structure_three"))), 12000, 24000, false);
    public static Music STRUCTURE_FOUR   = new Music(Registry.registerForHolder(BuiltInRegistries.SOUND_EVENT,
            ResourceLocation.fromNamespaceAndPath(StructureMusic.MOD_ID, "music.structure_four"),
            SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(StructureMusic.MOD_ID, "music.structure_four"))), 12000, 24000, false);
    public static Music STRUCTURE_FIVE   = new Music(Registry.registerForHolder(BuiltInRegistries.SOUND_EVENT,
            ResourceLocation.fromNamespaceAndPath(StructureMusic.MOD_ID, "music.structure_five"),
            SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(StructureMusic.MOD_ID, "music.structure_five"))), 12000, 24000, false);
    public static Music STRUCTURE_SIX   = new Music(Registry.registerForHolder(BuiltInRegistries.SOUND_EVENT,
            ResourceLocation.fromNamespaceAndPath(StructureMusic.MOD_ID, "music.structure_six"),
            SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(StructureMusic.MOD_ID, "music.structure_six"))), 12000, 24000, false);
    public static Music STRUCTURE_SEVEN   = new Music(Registry.registerForHolder(BuiltInRegistries.SOUND_EVENT,
            ResourceLocation.fromNamespaceAndPath(StructureMusic.MOD_ID, "music.structure_seven"),
            SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(StructureMusic.MOD_ID, "music.structure_seven"))), 12000, 24000, false);
    public static Music STRUCTURE_EIGHT   = new Music(Registry.registerForHolder(BuiltInRegistries.SOUND_EVENT,
            ResourceLocation.fromNamespaceAndPath(StructureMusic.MOD_ID, "music.structure_eight"),
            SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(StructureMusic.MOD_ID, "music.structure_eight"))), 12000, 24000, false);
    public static Music STRUCTURE_NINE   = new Music(Registry.registerForHolder(BuiltInRegistries.SOUND_EVENT,
            ResourceLocation.fromNamespaceAndPath(StructureMusic.MOD_ID, "music.structure_nine"),
            SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(StructureMusic.MOD_ID, "music.structure_nine"))), 12000, 24000, false);

    public static final Map<TagKey<Structure>, List<Music>> taggedMusic = new HashMap<>();

    public static void init()
    {
        taggedMusic.computeIfAbsent(StructureMusicTags.CUSTOM_MUSIC_ONE, key -> new ArrayList<>()).add(STRUCTURE_ONE);
        taggedMusic.computeIfAbsent(StructureMusicTags.CUSTOM_MUSIC_TWO, key -> new ArrayList<>()).add(STRUCTURE_TWO);
        taggedMusic.computeIfAbsent(StructureMusicTags.CUSTOM_MUSIC_THREE, key -> new ArrayList<>()).add(STRUCTURE_THREE);
        taggedMusic.computeIfAbsent(StructureMusicTags.CUSTOM_MUSIC_FOUR, key -> new ArrayList<>()).add(STRUCTURE_FOUR);
        taggedMusic.computeIfAbsent(StructureMusicTags.CUSTOM_MUSIC_FIVE, key -> new ArrayList<>()).add(STRUCTURE_FIVE);
        taggedMusic.computeIfAbsent(StructureMusicTags.CUSTOM_MUSIC_SIX, key -> new ArrayList<>()).add(STRUCTURE_SIX);
        taggedMusic.computeIfAbsent(StructureMusicTags.CUSTOM_MUSIC_SEVEN, key -> new ArrayList<>()).add(STRUCTURE_SEVEN);
        taggedMusic.computeIfAbsent(StructureMusicTags.CUSTOM_MUSIC_EIGHT, key -> new ArrayList<>()).add(STRUCTURE_EIGHT);
        taggedMusic.computeIfAbsent(StructureMusicTags.CUSTOM_MUSIC_NINE, key -> new ArrayList<>()).add(STRUCTURE_NINE);
    }
}