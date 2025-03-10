package net.nivulpis.structuremusic;

import net.minecraft.core.Holder;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.SoundEvent;

import java.util.ArrayList;
import java.util.List;

public class SMMusics {
    private static final List<Music> MUSICS = new ArrayList<>();

    public static final Music STRUCTURE_ONE = register(AdditionalMusic.STRUCTURE_ONE);
    public static final Music STRUCTURE_TWO = register(AdditionalMusic.STRUCTURE_TWO);
    public static final Music STRUCTURE_THREE = register(AdditionalMusic.STRUCTURE_THREE);
    public static final Music STRUCTURE_FOUR = register(AdditionalMusic.STRUCTURE_FOUR);
    public static final Music STRUCTURE_FIVE = register(AdditionalMusic.STRUCTURE_FIVE);
    public static final Music STRUCTURE_SIX = register(AdditionalMusic.STRUCTURE_SIX);
    public static final Music STRUCTURE_SEVEN = register(AdditionalMusic.STRUCTURE_SEVEN);
    public static final Music STRUCTURE_EIGHT = register(AdditionalMusic.STRUCTURE_EIGHT);
    public static final Music STRUCTURE_NINE = register(AdditionalMusic.STRUCTURE_NINE);
    public static final Music STRUCTURE_TEN = register(AdditionalMusic.STRUCTURE_TEN);
    public static final Music STRUCTURE_ELEVEN = register(AdditionalMusic.STRUCTURE_ELEVEN);
    public static final Music STRUCTURE_TWELVE = register(AdditionalMusic.STRUCTURE_TWELVE);
    public static final Music STRUCTURE_THIRTEEN = register(AdditionalMusic.STRUCTURE_THIRTEEN);
    public static final Music STRUCTURE_FOURTEEN = register(AdditionalMusic.STRUCTURE_FOURTEEN);
    public static final Music STRUCTURE_FIFTEEN = register(AdditionalMusic.STRUCTURE_FIFTEEN);
    public static final Music STRUCTURE_SIXTEEN = register(AdditionalMusic.STRUCTURE_SIXTEEN);
    public static final Music STRUCTURE_SEVENTEEN = register(AdditionalMusic.STRUCTURE_SEVENTEEN);
    public static final Music STRUCTURE_EIGHTEEN = register(AdditionalMusic.STRUCTURE_EIGHTEEN);


    private static Music register(Holder<SoundEvent> soundEvent) {
        Music music = new Music(soundEvent, 30, 60, true);
        MUSICS.add(music);
        return music;
    }

    public static List<Music> getAll() {
        return MUSICS;
    }
}
