package net.nivulpis.structuremusic;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AdditionalMusic
{
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, StructureMusic.MOD_ID);

    // Music Entries
    public static final DeferredHolder<SoundEvent, SoundEvent> STRUCTURE_ONE = register("music", "structure_one");
    public static final DeferredHolder<SoundEvent, SoundEvent> STRUCTURE_TWO = register("music", "structure_two");
    public static final DeferredHolder<SoundEvent, SoundEvent> STRUCTURE_THREE = register("music", "structure_three");
    public static final DeferredHolder<SoundEvent, SoundEvent> STRUCTURE_FOUR = register("music", "structure_four");
    public static final DeferredHolder<SoundEvent, SoundEvent> STRUCTURE_FIVE = register("music", "structure_five");
    public static final DeferredHolder<SoundEvent, SoundEvent> STRUCTURE_SIX = register("music", "structure_six");
    public static final DeferredHolder<SoundEvent, SoundEvent> STRUCTURE_SEVEN = register("music", "structure_seven");
    public static final DeferredHolder<SoundEvent, SoundEvent> STRUCTURE_EIGHT = register("music", "structure_eight");
    public static final DeferredHolder<SoundEvent, SoundEvent> STRUCTURE_NINE = register("music", "structure_nine");
    public static final DeferredHolder<SoundEvent, SoundEvent> STRUCTURE_TEN = register("music", "structure_ten");
    public static final DeferredHolder<SoundEvent, SoundEvent> STRUCTURE_ELEVEN = register("music", "structure_eleven");
    public static final DeferredHolder<SoundEvent, SoundEvent> STRUCTURE_TWELVE = register("music", "structure_twelve");
    public static final DeferredHolder<SoundEvent, SoundEvent> STRUCTURE_THIRTEEN = register("music", "structure_thirteen");
    public static final DeferredHolder<SoundEvent, SoundEvent> STRUCTURE_FOURTEEN = register("music", "structure_fourteen");
    public static final DeferredHolder<SoundEvent, SoundEvent> STRUCTURE_FIFTEEN = register("music", "structure_fifteen");
    public static final DeferredHolder<SoundEvent, SoundEvent> STRUCTURE_SIXTEEN = register("music", "structure_sixteen");
    public static final DeferredHolder<SoundEvent, SoundEvent> STRUCTURE_SEVENTEEN = register("music", "structure_seventeen");
    public static final DeferredHolder<SoundEvent, SoundEvent> STRUCTURE_EIGHTEEN = register("music", "structure_eighteen");

    private static DeferredHolder<SoundEvent, SoundEvent> register(String category, String name) {
        return SOUND_EVENTS.register(category + "_" + name,
                () -> SoundEvent.createVariableRangeEvent(
                        ResourceLocation.fromNamespaceAndPath(StructureMusic.MOD_ID, category + "." + name)
                ));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}