package net.nivulpis.structuremusic;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class AdditionalMusic
{
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, StructureMusic.MOD_ID);

    public static final Supplier<SoundEvent> STRUCTURE_ONE = registerSoundEvent("music.structure_one");
    public static final Supplier<SoundEvent> STRUCTURE_TWO = registerSoundEvent("music.structure_two");
    public static final Supplier<SoundEvent> STRUCTURE_THREE = registerSoundEvent("music.structure_three");
    public static final Supplier<SoundEvent> STRUCTURE_FOUR = registerSoundEvent("music.structure_four");
    public static final Supplier<SoundEvent> STRUCTURE_FIVE = registerSoundEvent("music.structure_five");
    public static final Supplier<SoundEvent> STRUCTURE_SIX = registerSoundEvent("music.structure_six");
    public static final Supplier<SoundEvent> STRUCTURE_SEVEN = registerSoundEvent("music.structure_seven");
    public static final Supplier<SoundEvent> STRUCTURE_EIGHT = registerSoundEvent("music.structure_eight");
    public static final Supplier<SoundEvent> STRUCTURE_NINE = registerSoundEvent("music.structure_nine");

    public static Supplier<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(StructureMusic.MOD_ID, name);
    return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }

}