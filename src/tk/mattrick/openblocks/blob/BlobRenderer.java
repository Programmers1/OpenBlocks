package tk.mattrick.openblocks.blob;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex3f;

import org.newdawn.slick.opengl.Texture;

import tk.mattrick.openblocks.block.Block;

/**
 * @author mattrick
 *
 */

public class BlobRenderer {

	public static void renderBlob(Blob blob) {
		if (blob.needs_update) {
			for (Block[][] b1 : blob.getBlocks()) {
				for (Block[] b2 : b1) {
					for (Block b3 : b2) {
						glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
						glLoadIdentity();

						glTranslatef(0f,0.0f,-7f);
						glRotatef(45f,0.0f,1.0f,0.0f);
						//glColor3f(0.5f,0.5f,1.0f);

						Texture tex = b3.getType().getMaterial().getTexture();

						glClear(GL_COLOR_BUFFER_BIT|GL_DEPTH_BUFFER_BIT);
						glLoadIdentity();

						glTranslatef(0.0f,0.0f,-5.0f); // Move Into The Screen 5 Units

						tex.bind(); // or glBind(texture.getTextureID());

						glBegin(GL_QUADS);

						// Front Face
						glTexCoord2f(0.0f, 0.0f);
						glVertex3f(b3.getX() - 1.0f, b3.getY() - 1.0f, b3.getZ() + 1.0f); // Bottom Left Of The Texture and Quad
						glTexCoord2f(1.0f, 0.0f);
						glVertex3f(b3.getX() + 1.0f, b3.getY() - 1.0f, 1.0f); // Bottom Right Of The Texture and Quad
						glTexCoord2f(1.0f, 1.0f);
						glVertex3f(b3.getX() + 1.0f, b3.getY() + 1.0f, 1.0f); // Top Right Of The Texture and Quad
						glTexCoord2f(0.0f, 1.0f);
						glVertex3f(b3.getX() - 1.0f, b3.getY() + 1.0f, 1.0f); // Top Left Of The Texture and Quad

						// Back Face
						glTexCoord2f(1.0f, 0.0f);
						glVertex3f(b3.getX() - 1.0f, b3.getY() - 1.0f, -1.0f); // Bottom Right Of The Texture and Quad
						glTexCoord2f(1.0f, 1.0f);
						glVertex3f(b3.getX() - 1.0f, b3.getY() + 1.0f, -1.0f); // Top Right Of The Texture and Quad
						glTexCoord2f(0.0f, 1.0f);
						glVertex3f(b3.getX() + 1.0f, b3.getY() + 1.0f, -1.0f); // Top Left Of The Texture and Quad
						glTexCoord2f(0.0f, 0.0f);
						glVertex3f(b3.getX() + 1.0f, b3.getY() - 1.0f, -1.0f); // Bottom Left Of The Texture and Quad

						// Top Face
						glTexCoord2f(0.0f, 1.0f);
						glVertex3f(b3.getX() - 1.0f, b3.getY() + 1.0f, -1.0f); // Top Left Of The Texture and Quad
						glTexCoord2f(0.0f, 0.0f);
						glVertex3f(b3.getX() - 1.0f, b3.getY() + 1.0f, 1.0f); // Bottom Left Of The Texture and Quad
						glTexCoord2f(1.0f, 0.0f);
						glVertex3f(b3.getX() + 1.0f, b3.getY() + 1.0f, 1.0f); // Bottom Right Of The Texture and Quad
						glTexCoord2f(1.0f, 1.0f);
						glVertex3f( b3.getX() + 1.0f, b3.getY() + 1.0f, -1.0f); // Top Right Of The Texture and Quad

						// Bottom Face
						glTexCoord2f(1.0f, 1.0f);
						glVertex3f(b3.getX() - 1.0f, b3.getY() - 1.0f, -1.0f); // Top Right Of The Texture and Quad
						glTexCoord2f(0.0f, 1.0f);
						glVertex3f(b3.getX() + 1.0f, b3.getY() - 1.0f, -1.0f); // Top Left Of The Texture and Quad
						glTexCoord2f(0.0f, 0.0f);
						glVertex3f(b3.getX() + 1.0f, b3.getY() - 1.0f, 1.0f); // Bottom Left Of The Texture and Quad
						glTexCoord2f(1.0f, 0.0f);
						glVertex3f(b3.getX() - 1.0f, b3.getY() - 1.0f, 1.0f); // Bottom Right Of The Texture and Quad

						// Right face
						glTexCoord2f(1.0f, 0.0f);
						glVertex3f(b3.getX() + 1.0f, b3.getY() - 1.0f, -1.0f); // Bottom Right Of The Texture and Quad
						glTexCoord2f(1.0f, 1.0f);
						glVertex3f(b3.getX() + 1.0f, b3.getY() + 1.0f, -1.0f); // Top Right Of The Texture and Quad
						glTexCoord2f(0.0f, 1.0f);
						glVertex3f(b3.getX() + 1.0f, b3.getY() + 1.0f, 1.0f); // Top Left Of The Texture and Quad
						glTexCoord2f(0.0f, 0.0f);
						glVertex3f(b3.getX() + 1.0f, b3.getY() - 1.0f, 1.0f); // Bottom Left Of The Texture and Quad

						// Left Face
						glTexCoord2f(0.0f, 0.0f);
						glVertex3f(b3.getX() - 1.0f, b3.getY() - 1.0f, -1.0f); // Bottom Left Of The Texture and Quad
						glTexCoord2f(1.0f, 0.0f);
						glVertex3f(b3.getX() - 1.0f, b3.getY() - 1.0f, 1.0f); // Bottom Right Of The Texture and Quad
						glTexCoord2f(1.0f, 1.0f);
						glVertex3f(b3.getX() - 1.0f, b3.getY() + 1.0f, 1.0f); // Top Right Of The Texture and Quad
						glTexCoord2f(0.0f, 1.0f);
						glVertex3f(b3.getX() - 1.0f, b3.getY() + 1.0f, -1.0f); // Top Left Of The Texture and Quad
						glEnd();

						blob.needs_update = false;
					}
				}
			}
		}
	}

}
