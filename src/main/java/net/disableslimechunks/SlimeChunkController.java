package net.disableslimechunks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FaceAttachedHorizontalDirectionalBlock;
import net.minecraft.world.level.block.LeverBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.chunk.LevelChunk;

public final class SlimeChunkController {
	private SlimeChunkController() {
	}

	public static boolean disablesNaturalSlimeSpawning(ServerLevel level, BlockPos spawnPos) {
		LevelChunk chunk = level.getChunkAt(spawnPos);
		boolean[] foundController = {false};

		chunk.findBlocks(SlimeChunkController::isPoweredFloorLever, (leverPos, leverState) -> {
			if (!foundController[0] && isController(level, leverPos)) {
				foundController[0] = true;
			}
		});

		return foundController[0];
	}

	private static boolean isPoweredFloorLever(BlockState state) {
		return state.is(Blocks.LEVER)
				&& state.getValue(FaceAttachedHorizontalDirectionalBlock.FACE) == AttachFace.FLOOR
				&& state.getValue(LeverBlock.POWERED);
	}

	private static boolean isController(ServerLevel level, BlockPos leverPos) {
		BlockPos slimeBlockPos = leverPos.below();
		return level.getBlockState(slimeBlockPos).is(Blocks.SLIME_BLOCK)
				&& level.getBlockState(slimeBlockPos.below()).is(Blocks.NOTE_BLOCK);
	}
}
