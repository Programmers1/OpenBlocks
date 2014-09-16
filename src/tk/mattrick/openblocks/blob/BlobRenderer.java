package tk.mattrick.openblocks.blob;

import static org.lwjgl.opengl.GL11.*;
import tk.mattrick.openblocks.block.Block;

/**
 * @author mattrick
 *
 */

public class BlobRenderer {

	public static int index = glGenLists(1);

	public static void renderBlob(Blob blob) {
		if (blob.needs_update) {

			glNewList(index, GL_COMPILE);

			for (Block[][] b1 : blob.getBlocks()) {
				for (Block[] b2 : b1) {
					for (Block b3 : b2) {

						glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

						glTranslatef(b3.getX(), b3.getY(), b3.getZ()); // Translate to draw the cube.
						glBegin(GL_QUADS); // Start to draw the quad.
						glNormal3f(0f, 0f, 1f);
						glTexCoord2f(0f, 1f);
						glVertex3f(1f, 0f, 0f);
						glTexCoord2f(1f, 1f);
						glVertex3f(0f, 0f, 0f);
						glTexCoord2f(1f, 0f);
						glVertex3f(0f, 1f, 0f);
						glTexCoord2f(0f, 0f);
						glVertex3f(1f, 1f, 0f);

						//back face
						glNormal3f(0f, 0f, -1f);
						glTexCoord2f(0f, 1f);
						glVertex3f(0f, 0f, 1f);
						glTexCoord2f(1f, 1f);
						glVertex3f(1f, 0f, 1f);
						glTexCoord2f(1f, 0f);
						glVertex3f(1f, 1f, 1f);
						glTexCoord2f(0f, 0f);
						glVertex3f(0f, 1f, 1f);

						b3.getType().getMaterial().getTexture().bind(); // top texture
						//top face
						glNormal3f(0f, -1f, 0f);
						glTexCoord2f(0f, 1f);
						glVertex3f(1f, 1f, 0f);
						glTexCoord2f(1f, 1f);
						glVertex3f(0f, 1f, 0f);
						glTexCoord2f(1f, 0f);
						glVertex3f(0f, 1f, 1f);
						glTexCoord2f(0f, 0f);
						glVertex3f(1f, 1f, 1f);

						//bottom face
						glNormal3f(0f, 1f, 0f);
						glTexCoord2f(0f, 1f);
						glVertex3f(1f, 0f, 1f);
						glTexCoord2f(1f, 1f);
						glVertex3f(0f, 0f, 1f);
						glTexCoord2f(1f, 0f);
						glVertex3f(0f, 0f, 0f);
						glTexCoord2f(0f, 0f);
						glVertex3f(1f, 0f, 0f);

						b3.getType().getMaterial().getTexture().bind(); // top texture
						//left face
						glNormal3f(-1f, 0f, 0f);
						glTexCoord2f(0f, 1f);
						glVertex3f(1f, 0f, 1f);
						glTexCoord2f(1f, 1f);
						glVertex3f(1f, 0f, 0f);
						glTexCoord2f(1f, 0f);
						glVertex3f(1f, 1f, 0f);
						glTexCoord2f(0f, 0f);
						glVertex3f(1f, 1f, 1f);

						//right face
						glNormal3f(1f, 0f, 0f);
						glTexCoord2f(0f, 1f);
						glVertex3f(0f, 0f, 0f);
						glTexCoord2f(1f, 1f);
						glVertex3f(0f, 0f, 1f);
						glTexCoord2f(1f, 0f);
						glVertex3f(0f, 1f, 1f);
						glTexCoord2f(0f, 0f);
						glVertex3f(0f, 1f, 0f);
						glEnd(); // Finishes rendering.

					}

				}
			}
			glEndList();
		}
		glCallList(index);
	}
}
