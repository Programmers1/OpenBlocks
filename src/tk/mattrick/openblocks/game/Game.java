package tk.mattrick.openblocks.game;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import tk.mattrick.openblocks.blob.Blob;
import tk.mattrick.openblocks.blob.BlobGenerator;
import tk.mattrick.openblocks.block.Block;
import tk.mattrick.openblocks.block.BlockAir;
import tk.mattrick.openblocks.block.BlockManager;
import tk.mattrick.openblocks.block.BlockStone;
import tk.mattrick.openblocks.location.World;

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

		//Register Blocks
		BlockManager.getInstance().addBlock(new BlockAir()).addBlock(new BlockStone());

		World w = new World("world");
		Blob blob = new Blob(0, 0, 0, w);

		Block block = blob.getBlockAt(2, 10, 1);

		System.out.println(block.getType() + " at x: " + block.getX() + " y: " + block.getY() + " z: " + block.getZ());


		while (!Display.isCloseRequested()) {

			Display.update();
		}

	}

}
