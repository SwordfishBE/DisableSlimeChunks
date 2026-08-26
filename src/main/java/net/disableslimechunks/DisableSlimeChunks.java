package net.disableslimechunks;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class DisableSlimeChunks implements ModInitializer {
	public static final String MOD_ID = "disable_slime_chunks";
	private static final String LOG_PREFIX = "[DisableSlimeChunks]";
	private static final Logger LOGGER = LoggerFactory.getLogger("DisableSlimeChunks");

	@Override
	public void onInitialize() {
		String version = FabricLoader.getInstance()
				.getModContainer(MOD_ID)
				.orElseThrow()
				.getMetadata()
				.getVersion()
				.getFriendlyString();

		LOGGER.info("{} Mod initialized. Version: {}", LOG_PREFIX, version);
	}
}
