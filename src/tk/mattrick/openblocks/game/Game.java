package tk.mattrick.openblocks.game;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import tk.mattrick.openblocks.blob.Blob;
import tk.mattrick.openblocks.blob.BlobGenerator;
import tk.mattrick.openblocks.blob.BlobRenderer;
import tk.mattrick.openblocks.block.BlockAir;
import tk.mattrick.openblocks.block.BlockManager;
import tk.mattrick.openblocks.block.BlockStone;
import tk.mattrick.openblocks.location.World;
import tk.mattrick.openblocks.player.Camera;
import tk.mattrick.openblocks.render.Render;

/**
 * @author mattrick
 *
 */

public class Game {

	public boolean[] keys = new boolean[256];
	Camera camera;

	public Game() {

		new BlockManager();
		new BlobGenerator();

		Camera camera = new Camera(0, 0, 0);

		try {
			Display.setDisplayMode(new DisplayMode(640,480));
			Display.create();
			Display.setTitle(Config.long_version);
		} catch (LWJGLException e) {
			e.printStackTrace();
		}

		Render.initGL(640, 480);

		BlockManager.getInstance().addBlock(new BlockAir()).addBlock(new BlockStone());

		World w = new World("world");
		Blob blob = new Blob(0, 0, 0, w);

		//TODO Move all camera stuff to Camera.java
		float dx        = 0.0f;
		float dy        = 0.0f;
		float dt        = 0.0f;
		long lastTime  = 0;
		long time      = 0;

		float mouseSensitivity = 0.1f;
		float movementSpeed = 3.0f;

		Mouse.setGrabbed(true);

		while (!Display.isCloseRequested()) {

			time = Sys.getTime();
			dt = (time - lastTime)/1000.0f;
			lastTime = time;

			dx = Mouse.getDX();
			dy = Mouse.getDY();

			camera.yaw(dx * mouseSensitivity);

			camera.pitch(-dy * mouseSensitivity);

			if (Keyboard.isKeyDown(Keyboard.KEY_W))
			{
				camera.walkForward(movementSpeed*dt);
				System.out.println("W" + movementSpeed*dt);
			}
			if (Keyboard.isKeyDown(Keyboard.KEY_S))
			{
				camera.walkBackwards(movementSpeed*dt);
				System.out.println("S" + movementSpeed*dt);
			}
			if (Keyboard.isKeyDown(Keyboard.KEY_A))
			{
				camera.strafeLeft(movementSpeed*dt);
				System.out.println("A" + movementSpeed*dt);
			}
			if (Keyboard.isKeyDown(Keyboard.KEY_D))
			{
				camera.strafeRight(movementSpeed*dt);
				System.out.println("D" + movementSpeed*dt);
			}

			GL11.glLoadIdentity();

			camera.lookThrough();

			//TODO SLOW AS HECK
			//BlobRenderer.renderBlob(blob);

			Render.renderTest();

			Display.update();



		}

	}

}
