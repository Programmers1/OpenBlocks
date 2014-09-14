package tk.mattrick.openblocks.block;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mattrick
 *
 */

public class BlockManager {

	private static BlockManager instance;

	private List<BlockType> blocks = new ArrayList<BlockType>();

	public BlockManager() {
		if (instance != null) {
			instance = this;
		}
	}

	public static BlockManager getInstance() {
		return instance;
	}

	public void addBlock (Block b) {
		if (!blocks.contains(b)) {
			blocks.add(b.getType());
		}
	}

	public List<BlockType> getBlocks() {
		return blocks;
	}

}
