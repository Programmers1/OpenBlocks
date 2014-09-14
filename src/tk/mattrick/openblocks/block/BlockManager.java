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
		if (instance == null) {
			instance = this;
		}
	}

	public static BlockManager getInstance() {
		return instance;
	}

	public BlockManager addBlock (BlockType b) {
		if (!blocks.contains(b)) {
			blocks.add(b);
		}
		return instance;
	}

	public List<BlockType> getBlocks() {
		return blocks;
	}

}
