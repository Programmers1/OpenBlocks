package tk.mattrick.openblocks.block;

import tk.mattrick.openblocks.material.Material;
import tk.mattrick.openblocks.material.MaterialManager;

/**
 * @author mattrick
 *
 */

public class BlockStone extends BlockType{

	private static Material mat = MaterialManager.registerMaterial("block_stone");

	public static Material getMaterial() {
		return mat;
	}

}
