package tk.mattrick.openblocks.game;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import tk.mattrick.openblocks.block.Block;
import tk.mattrick.openblocks.manager.MaterialManager;
import tk.mattrick.openblocks.material.Material;

/**
 * @author mattrick
 *
 */

public class Game {

	public Game() {

		try {
			Display.setDisplayMode(new DisplayMode(640,480));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}

		//TODO Testing registering stuffs

		Material mat_stone = MaterialManager.registerMaterial("block_stone");

		if (mat_stone != null) {
			Block block_stone = new Block(mat_stone, "stone", 0 , 0, 0);
			System.out.println("Block: " + block_stone.getName() + " at X:" + block_stone.getX() + " Y:" + block_stone.getY() + " Z:" + block_stone.getZ());
		}

		while (!Display.isCloseRequested()) {

			Display.update();
		}

	}

}
