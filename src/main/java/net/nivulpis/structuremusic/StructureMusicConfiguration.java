package net.nivulpis.structuremusic;

import com.google.common.collect.Lists;
import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.function.Predicate;

public class StructureMusicConfiguration {

    public static ModConfigSpec.ConfigValue<List<? extends String>> customMusicOne, customMusicTwo, customMusicThree, customMusicFour, customMusicFive, customMusicSix, customMusicSeven, customMusicEight, customMusicNine,
            customMusicTen, customMusicEleven, customMusicTwelve, customMusicThirteen, customMusicFourteen, customMusicFifteen, customMusicSixteen, customMusicSeventeen, customMusicEighteen;


    public static final StructureMusicConfiguration CONFIG;
    static final ModConfigSpec CONFIG_SPEC;

    static {
        final Pair<StructureMusicConfiguration, ModConfigSpec> specPair = new ModConfigSpec.Builder().configure(StructureMusicConfiguration::new);
        CONFIG = specPair.getLeft();
        CONFIG_SPEC = specPair.getRight();
    }

    public StructureMusicConfiguration(ModConfigSpec.Builder builder) {
        Predicate<Object> validator = o -> o instanceof String;

        customMusicOne = builder.defineList("Music One", Lists.newArrayList(), validator);
        customMusicTwo = builder.defineList("Music Two", Lists.newArrayList(), validator);
        customMusicThree = builder.defineList("Music Three", Lists.newArrayList(), validator);
        customMusicFour = builder.defineList("Music Four", Lists.newArrayList(), validator);
        customMusicFive = builder.defineList("Music Five", Lists.newArrayList(), validator);
        customMusicSix = builder.defineList("Music Six", Lists.newArrayList(), validator);
        customMusicSeven = builder.defineList("Music Seven", Lists.newArrayList(), validator);
        customMusicEight = builder.defineList("Music Eight", Lists.newArrayList(), validator);
        customMusicNine = builder.defineList("Music Nine", Lists.newArrayList(), validator);
        customMusicTen = builder.defineList("Music Ten", Lists.newArrayList(), validator);
        customMusicEleven = builder.defineList("Music Eleven", Lists.newArrayList(), validator);
        customMusicTwelve = builder.defineList("Music Twelve", Lists.newArrayList(), validator);
        customMusicThirteen = builder.defineList("Music Thirteen", Lists.newArrayList(), validator);
        customMusicFourteen = builder.defineList("Music Fourteen", Lists.newArrayList(), validator);
        customMusicFifteen = builder.defineList("Music Fifteen", Lists.newArrayList(), validator);
        customMusicSixteen = builder.defineList("Music Sixteen", Lists.newArrayList(), validator);
        customMusicSeventeen = builder.defineList("Music Seventeen", Lists.newArrayList(), validator);
        customMusicEighteen = builder.defineList("Music Eighteen", Lists.newArrayList(), validator);
    }

}
