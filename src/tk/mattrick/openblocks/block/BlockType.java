package tk.mattrick.openblocks.block;

import tk.mattrick.openblocks.material.Material;

/**
 * @author mattrick
 *
 */

public interface BlockType {

	public Material getMaterial();

	public boolean isSolid();
}
