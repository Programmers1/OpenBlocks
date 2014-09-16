package tk.mattrick.openblocks.game;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.*;
import tk.mattrick.openblocks.blob.Blob;
import tk.mattrick.openblocks.blob.BlobGenerator;
import tk.mattrick.openblocks.blob.BlobRenderer;
import tk.mattrick.openblocks.block.Block;
import tk.mattrick.openblocks.block.BlockAir;
import tk.mattrick.openblocks.block.BlockManager;
import tk.mattrick.openblocks.block.BlockStone;
import tk.mattrick.openblocks.location.World;
import tk.mattrick.openblocks.render.Render;

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
			Display.setTitle(Config.long_version);
		} catch (LWJGLException e) {
			e.printStackTrace();
		}

		Render.initGL();

		//Register Blocks
		BlockManager.getInstance().addBlock(new BlockAir()).addBlock(new BlockStone());

		World w = new World("world");
		Blob blob = new Blob(0, 0, 0, w);

		while (!Display.isCloseRequested()) {

			//BlobRenderer.renderBlob(blob);

			Render.renderTest();

			Display.update();
			Display.sync(60);
		}

	}

}
