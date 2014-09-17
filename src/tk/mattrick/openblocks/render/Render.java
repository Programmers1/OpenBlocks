package tk.mattrick.openblocks.render;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;


/**
 * @author mattrick
 *
 */

public class Render {

	static float width, height;

	public static void initGL(float w, float h) {

		width = w;
		height = h;

		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();

		//        Calculate the aspect ratio of the window
		GLU.gluPerspective(45.0f,(width)/(height),0.1f,100.0f);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glLoadIdentity();

		GL11.glEnable(GL11.GL_TEXTURE_2D);                                    // Enable Texture Mapping ( NEW )
		GL11.glShadeModel(GL11.GL_SMOOTH);
		GL11.glClearColor(0.40f, 0.52f, 1.0f, 0.0f);
		GL11.glClearDepth(1.0f);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glDepthFunc(GL11.GL_LEQUAL);
		GL11.glHint(GL11.GL_PERSPECTIVE_CORRECTION_HINT, GL11.GL_NICEST);
	}

	public static void renderTest() {
		for (int x = 0; x < 5; x++) {
			renderCube();
			GL11.glTranslatef(5, 0, 0);
		}
	}

	public static void renderCube() {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT|GL11.GL_DEPTH_BUFFER_BIT);

		GL11.glTranslatef(0.0f,0.0f,0.0f);                              // Move Into The Screen 5 Units

		GL11.glBegin(GL11.GL_QUADS);
		//HERE IS WHERE YOU BIND A TEXTURE
		// Front Face
		GL11.glTexCoord2f(0.0f, 0.0f);
		GL11.glVertex3f(-1.0f, -1.0f,  1.0f);   // Bottom Left Of The Texture and Quad
		GL11.glTexCoord2f(1.0f, 0.0f);
		GL11.glVertex3f( 1.0f, -1.0f,  1.0f);   // Bottom Right Of The Texture and Quad
		GL11.glTexCoord2f(1.0f, 1.0f);
		GL11.glVertex3f( 1.0f,  1.0f,  1.0f);   // Top Right Of The Texture and Quad
		GL11.glTexCoord2f(0.0f, 1.0f);
		GL11.glVertex3f(-1.0f,  1.0f,  1.0f);   // Top Left Of The Texture and Quad

		// Back Face
		GL11.glTexCoord2f(1.0f, 0.0f);
		GL11.glVertex3f(-1.0f, -1.0f, -1.0f);   // Bottom Right Of The Texture and Quad
		GL11.glTexCoord2f(1.0f, 1.0f);
		GL11.glVertex3f(-1.0f,  1.0f, -1.0f);   // Top Right Of The Texture and Quad
		GL11.glTexCoord2f(0.0f, 1.0f);
		GL11.glVertex3f( 1.0f,  1.0f, -1.0f);   // Top Left Of The Texture and Quad
		GL11.glTexCoord2f(0.0f, 0.0f);
		GL11.glVertex3f( 1.0f, -1.0f, -1.0f);   // Bottom Left Of The Texture and Quad

		// Top Face
		GL11.glTexCoord2f(0.0f, 1.0f);
		GL11.glVertex3f(-1.0f,  1.0f, -1.0f);   // Top Left Of The Texture and Quad
		GL11.glTexCoord2f(0.0f, 0.0f);
		GL11.glVertex3f(-1.0f,  1.0f,  1.0f);   // Bottom Left Of The Texture and Quad
		GL11.glTexCoord2f(1.0f, 0.0f);
		GL11.glVertex3f( 1.0f,  1.0f,  1.0f);   // Bottom Right Of The Texture and Quad
		GL11.glTexCoord2f(1.0f, 1.0f);
		GL11.glVertex3f( 1.0f,  1.0f, -1.0f);   // Top Right Of The Texture and Quad

		// Bottom Face
		GL11.glTexCoord2f(1.0f, 1.0f);
		GL11.glVertex3f(-1.0f, -1.0f, -1.0f);   // Top Right Of The Texture and Quad
		GL11.glTexCoord2f(0.0f, 1.0f);
		GL11.glVertex3f( 1.0f, -1.0f, -1.0f);   // Top Left Of The Texture and Quad
		GL11.glTexCoord2f(0.0f, 0.0f);
		GL11.glVertex3f( 1.0f, -1.0f,  1.0f);   // Bottom Left Of The Texture and Quad
		GL11.glTexCoord2f(1.0f, 0.0f);
		GL11.glVertex3f(-1.0f, -1.0f,  1.0f);   // Bottom Right Of The Texture and Quad

		// Right face
		GL11.glTexCoord2f(1.0f, 0.0f);
		GL11.glVertex3f( 1.0f, -1.0f, -1.0f);   // Bottom Right Of The Texture and Quad
		GL11.glTexCoord2f(1.0f, 1.0f);
		GL11.glVertex3f( 1.0f,  1.0f, -1.0f);   // Top Right Of The Texture and Quad
		GL11.glTexCoord2f(0.0f, 1.0f);
		GL11.glVertex3f( 1.0f,  1.0f,  1.0f);   // Top Left Of The Texture and Quad
		GL11.glTexCoord2f(0.0f, 0.0f);
		GL11.glVertex3f( 1.0f, -1.0f,  1.0f);   // Bottom Left Of The Texture and Quad

		// Left Face
		GL11.glTexCoord2f(0.0f, 0.0f);
		GL11.glVertex3f(-1.0f, -1.0f, -1.0f);   // Bottom Left Of The Texture and Quad
		GL11.glTexCoord2f(1.0f, 0.0f);
		GL11.glVertex3f(-1.0f, -1.0f,  1.0f);   // Bottom Right Of The Texture and Quad
		GL11.glTexCoord2f(1.0f, 1.0f);
		GL11.glVertex3f(-1.0f,  1.0f,  1.0f);   // Top Right Of The Texture and Quad
		GL11.glTexCoord2f(0.0f, 1.0f);
		GL11.glVertex3f(-1.0f,  1.0f, -1.0f);   // Top Left Of The Texture and Quad
		GL11.glEnd();
	}


}
