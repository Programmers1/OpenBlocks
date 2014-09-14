package tk.mattrick.openblocks.game;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import tk.mattrick.openblocks.blob.BlobGenerator;
import tk.mattrick.openblocks.block.BlockManager;

/**
 * @author mattrick
 *
 */

public class Game {

	public Game() {

		new BlockManager();
		new BlobGenerator();

		try {
			Display.setDisplayMode(new DisplayMode(640,480));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}

		while (!Display.isCloseRequested()) {

			Display.update();
		}

	}

}
