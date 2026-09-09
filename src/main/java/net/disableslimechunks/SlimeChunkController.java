package net.disableslimechunks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FaceAttachedHorizontalDirectionalBlock;
import net.minecraft.world.level.block.LeverBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.chunk.LevelChunkSection;

public final class SlimeChunkController {
	private SlimeChunkController() {
	}

	public static boolean disablesNaturalSlimeSpawning(ServerLevel level, BlockPos spawnPos) {
		// Never load or wait for a chunk from inside a spawn check.
		LevelChunk chunk = level.getChunkSource().getChunkNow(spawnPos.getX() >> 4, spawnPos.getZ() >> 4);
		return chunk != null && ((ControllerCache) chunk).disableSlimeChunks$hasController();
	}

	public interface ControllerCache {
		boolean disableSlimeChunks$hasController();
	}

	public static boolean isControllerBlock(BlockState state) {
		return state.is(Blocks.LEVER) || state.is(Blocks.SLIME_BLOCK) || state.is(Blocks.NOTE_BLOCK);
	}

	public static boolean scan(LevelChunk chunk) {
		BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
		LevelChunkSection[] sections = chunk.getSections();
		for (int index = 0; index < sections.length; index++) {
			LevelChunkSection section = sections[index];
			if (!section.maybeHas(SlimeChunkController::isPoweredFloorLever)) continue;
			int baseY = chunk.getSectionYFromSectionIndex(index) << 4;
			for (int y = 0; y < 16; y++) {
				for (int z = 0; z < 16; z++) {
					for (int x = 0; x < 16; x++) {
						if (!isPoweredFloorLever(section.getBlockState(x, y, z))) continue;
						pos.set(chunk.getPos().getMinBlockX() + x, baseY + y,
								chunk.getPos().getMinBlockZ() + z);
						if (isController(chunk, pos)) return true;
					}
				}
			}
		}
		return false;
	}

	private static boolean isPoweredFloorLever(BlockState state) {
		return state.is(Blocks.LEVER)
				&& state.getValue(FaceAttachedHorizontalDirectionalBlock.FACE) == AttachFace.FLOOR
				&& state.getValue(LeverBlock.POWERED);
	}

	private static boolean isController(LevelChunk level, BlockPos leverPos) {
		BlockPos slimeBlockPos = leverPos.below();
		return level.getBlockState(slimeBlockPos).is(Blocks.SLIME_BLOCK)
				&& level.getBlockState(slimeBlockPos.below()).is(Blocks.NOTE_BLOCK);
	}
}
