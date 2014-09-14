package tk.mattrick.openblocks.block;

import tk.mattrick.openblocks.material.Material;
import tk.mattrick.openblocks.material.MaterialManager;

/**
 * @author mattrick
 *
 */

public class BlockAir implements BlockType {

	private static Material mat = MaterialManager.registerMaterial("block_air");

	public Material getMaterial() {
		return mat;
	}

	public boolean isSolid() {
		return false;
	}

}
