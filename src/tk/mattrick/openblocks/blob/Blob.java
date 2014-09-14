package tk.mattrick.openblocks.blob;

import tk.mattrick.openblocks.block.Block;
import tk.mattrick.openblocks.location.World;

/**
 * @author mattrick
 *
 */

public class Blob {

	private Block[][][] blocks = new Block[16][16][16];
	private int x, y, z;
	private World world;

	public Blob(int x, int y, int z, World world) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.world = world;

		world.addBlob(this);

		this.blocks = BlobGenerator.getGenerator().generateBlockList(this);
	}

	public World getWorld() {
		return world;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}

	public Block[][][] getBlocks() {
		return blocks;
	}

	public Block getBlockAt(int x, int y, int z) {
		return blocks[x][y][z];
	}

}
