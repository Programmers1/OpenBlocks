package tk.mattrick.openblocks.block;

import java.util.HashMap;
import java.util.Map;

import tk.mattrick.openblocks.location.Point;

/**
 * @author mattrick
 *
 */

public class Block {

	BlockType type;
	Map<String, String> data = new HashMap<String, String>();
	int x, y, z;

	/**
	 * @param mat Material for the block to use
	 * @param x X position of Block
	 * @param y Y position of Block
	 * @param z Z position of Block
	 */
	public Block (BlockType type, int x, int y, int z) {
		this.type = type;
		this.x = x;
		this.y = y;
		this.z = z;

		BlockManager.getInstance().addBlock(this);
	}

	/**
	 * @param mat Material for the block to use
	 * @param name Name for the block to use
	 * @param p Point where block should be placed
	 */
	public Block (BlockType type, Point p) {
		this.type = type;
		this.x = (int) p.getX();
		this.y = (int) p.getY();
		this.z = (int) p.getZ();

		BlockManager.getInstance().addBlock(this);
	}

	/**
	 * @return Material used by the Block
	 */
	public BlockType getType() {
		return type;
	}

	/**
	 * @return Data used by Block
	 */
	public Map<String, String> getData() {
		return data;
	}

	//TODO Check to make sure methods below work, not tested (I'm horrible with HashMaps)
	/**
	 * @param data Data for Block to use
	 */
	public void setData (Map<String, String> data) {
		this.data = data;
	}

	/**
	 * @param key Data type to add (ex: color)
	 * @param value Data value to add (ex: red)
	 */
	public void addData (String key, String value) {
		if (data.containsKey(key)) {
			changeData(key, value);
		}
		else {
			this.data.put(key, value);
		}
	}

	/**
	 * @param key Data type to remove (ex: color)
	 */
	public void removeData (String key) {
		this.data.remove(key);
	}

	/**
	 * @param key Data type to change (ex: color)
	 * @param value Data value to change (ex: red)
	 */
	public void changeData (String key, String value) {
		this.data.remove(key);
		this.data.put(key, value);
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.z;
	}

	public int getZ() {
		return this.z;
	}



}
