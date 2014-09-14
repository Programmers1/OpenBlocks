package tk.mattrick.openblocks.block;

import tk.mattrick.openblocks.material.Material;
import tk.mattrick.openblocks.material.MaterialManager;

/**
 * @author mattrick
 *
 */

public class BlockStone implements BlockType {

	private static Material mat = MaterialManager.registerMaterial("block_stone");

	@Override
	public Material getMaterial() {
		return mat;
	}

	@Override
	public boolean isSolid() {
		return true;
	}

}
