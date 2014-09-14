package tk.mattrick.openblocks.blob;

import java.util.List;
import java.util.Random;

import tk.mattrick.openblocks.block.Block;
import tk.mattrick.openblocks.block.BlockManager;
import tk.mattrick.openblocks.block.BlockType;

/**
 * @author mattrick
 *
 */

public class BlobGenerator {

	//TODO Make this not generate 100% random...

	private static BlobGenerator gen;
	private Random rand;

	public BlobGenerator() {
		gen = this;
		rand = new Random();
	}

	public static BlobGenerator getGenerator() {
		return gen;
	}

	public void setSeed(String seed) {
		rand = new Random(seed.hashCode());
	}

	//If you want to change generation, here is where you do it...
	public Block[][][] generateBlockList(Blob b) {
		Block[][][] bl = new Block[16][16][16];
		List<BlockType> blocks = BlockManager.getInstance().getBlocks();

		for (int x = 0; x < 16; x++) {
			for(int y = 0; y < 16; y++) {
				for(int z = 0; z < 16; z++) {
					bl[x][y][z] = new Block(blocks.get(rand.nextInt(blocks.size())), x, y, z);
				}
			}
		}

		return bl;
	}

}
