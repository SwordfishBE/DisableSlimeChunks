package net.disableslimechunks.mixin;

import net.disableslimechunks.SlimeChunkController;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.cubemob.Slime;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Slime.class)
abstract class SlimeMixin {
	@Inject(method = "checkSlimeSpawnRules", at = @At("HEAD"), cancellable = true)
	private static void disableSlimeSpawningInControlledChunks(
			EntityType<Slime> entityType,
			LevelAccessor level,
			EntitySpawnReason spawnReason,
			BlockPos pos,
			RandomSource random,
			CallbackInfoReturnable<Boolean> callback
	) {
		if (spawnReason == EntitySpawnReason.NATURAL
				&& level instanceof ServerLevel serverLevel
				&& SlimeChunkController.disablesNaturalSlimeSpawning(serverLevel, pos)) {
			callback.setReturnValue(false);
		}
	}
}
