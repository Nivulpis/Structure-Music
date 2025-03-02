package net.nivulpis.structuremusic.mixin;

import net.minecraft.sounds.SoundEvents;
import net.nivulpis.structuremusic.AdditionalMusic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SoundEvents.class)
public class SoundEventsMixin {
    @Inject(method = "<clinit>", at = @At("RETURN"))
    private static void onInit(final CallbackInfo ci)
    {
        AdditionalMusic.init();
    }
}
