package net.nivulpis.structuremusic;

import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.nivulpis.structuremusic.client.ClientPacketHandler;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.nivulpis.structuremusic.event.StructureMusicEvents;
import net.nivulpis.structuremusic.networking.PlayerStructureData;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.fml.event.config.ModConfigEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(StructureMusic.MOD_ID)
public class StructureMusic {
    public static final String MOD_ID = "structuremusic";
    private static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public StructureMusic(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        AdditionalMusic.register(modEventBus);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.SERVER, StructureMusicConfiguration.CONFIG_SPEC);

        // Register the config loading event listener
        modEventBus.addListener(this::onConfigLoad);

        modEventBus.addListener(this::registerPayloads);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Common setup logic here
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        // Add creative tab items here
    }

    // Event handler for when the config is loaded
    private void onConfigLoad(ModConfigEvent.Loading event) {
        if (event.getConfig().getModId().equals(MOD_ID)) {
            // Now it's safe to access config values
            LOGGER.info("Config loaded successfully!");
            // For example, you can access the config values like this:
            // List<String> musicOne = StructureMusicConfiguration.customMusicOne.get();
        }
    }

    private void registerPayloads(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar("1");
        registrar.playToClient(
                PlayerStructureData.TYPE,
                PlayerStructureData.STREAM_CODEC,
                (packet, context) -> ClientPacketHandler.handlePlayerStructureData(packet)
        );
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Handle server starting event here
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // Client setup logic here
        }
    }
}
