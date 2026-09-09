package net.disableslimechunks.mixin;

import net.disableslimechunks.SlimeChunkController;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.LevelChunk;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LevelChunk.class)
abstract class LevelChunkMixin implements SlimeChunkController.ControllerCache {
	// Owned by the chunk: unloading it also releases the cache, with no global references.
	@Unique private boolean disableSlimeChunks$cacheValid;
	@Unique private boolean disableSlimeChunks$active;

	@Override
	public boolean disableSlimeChunks$hasController() {
		if (!disableSlimeChunks$cacheValid) {
			disableSlimeChunks$active = SlimeChunkController.scan((LevelChunk) (Object) this);
			disableSlimeChunks$cacheValid = true;
		}
		return disableSlimeChunks$active;
	}

	@Inject(method = "setBlockState", at = @At("RETURN"))
	private void disableSlimeChunks$invalidate(BlockPos pos, BlockState state, int flags,
			CallbackInfoReturnable<BlockState> callback) {
		BlockState previous = callback.getReturnValue();
		if (previous != null && previous != state
				&& (SlimeChunkController.isControllerBlock(previous)
						|| SlimeChunkController.isControllerBlock(state))) {
			disableSlimeChunks$cacheValid = false;
		}
	}
}
