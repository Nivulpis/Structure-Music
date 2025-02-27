package net.nivulpis.structuremusic.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.structure.Structure;

public class StructureMusicTags {
    public static final TagKey<Structure> CUSTOM_MUSIC_ONE = create("custom_music_one");
    public static final TagKey<Structure> CUSTOM_MUSIC_TWO = create("custom_music_two");
    public static final TagKey<Structure> CUSTOM_MUSIC_THREE = create("custom_music_three");
    public static final TagKey<Structure> CUSTOM_MUSIC_FOUR = create("custom_music_four");
    public static final TagKey<Structure> CUSTOM_MUSIC_FIVE = create("custom_music_five");
    public static final TagKey<Structure> CUSTOM_MUSIC_SIX = create("custom_music_six");
    public static final TagKey<Structure> CUSTOM_MUSIC_SEVEN = create("custom_music_seven");
    public static final TagKey<Structure> CUSTOM_MUSIC_EIGHT = create("custom_music_eight");
    public static final TagKey<Structure> CUSTOM_MUSIC_NINE = create("custom_music_nine");

    private static TagKey<Structure> create(String name) {
        return TagKey.create(Registries.STRUCTURE, ResourceLocation.fromNamespaceAndPath("structuremusic", name));
    }
}