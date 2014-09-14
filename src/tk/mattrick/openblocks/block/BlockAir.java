package tk.mattrick.openblocks.block;

import tk.mattrick.openblocks.material.Material;
import tk.mattrick.openblocks.material.MaterialManager;

/**
 * @author mattrick
 *
 */

public class BlockAir extends BlockType{

	private static Material mat = MaterialManager.registerMaterial("block_air");

	public static Material getMaterial() {
		return mat;
	}

}
