package net.disableslimechunks;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class DisableSlimeChunks implements ModInitializer {
	public static final String MOD_ID = "disable_slime_chunks";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Disable Slime Chunks initialized");
	}
}
