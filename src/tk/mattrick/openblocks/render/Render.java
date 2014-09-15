package tk.mattrick.openblocks.render;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.util.glu.GLU;
import org.newdawn.slick.opengl.Texture;

import tk.mattrick.openblocks.material.MaterialManager;


/**
 * @author mattrick
 *
 */

public class Render {

	static float xrot, yrot, zrot;

	public static void initGL() {
		glEnable(GL_TEXTURE_2D);
		glShadeModel(GL_SMOOTH);
		glClearColor(0.439f, 0.69f, 1f, 0f);
		glClearDepth(1.0);
		glEnable(GL_DEPTH_TEST);
		glDepthFunc(GL_LEQUAL);

		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();


		GLU.gluPerspective(
				45.0f,
				(float)640/(float)480,
				0.1f,
				100.0f);

		glMatrixMode(GL_MODELVIEW);
		glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);
	}

	public static void render() {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		glLoadIdentity();

		glTranslatef(0f,0.0f,-7f);
		glRotatef(45f,0.0f,1.0f,0.0f);
		//glColor3f(0.5f,0.5f,1.0f);

		Texture tex = MaterialManager.getMaterial("block_stone").getTexture();

		glClear(GL_COLOR_BUFFER_BIT|GL_DEPTH_BUFFER_BIT);
		glLoadIdentity();

		xrot+=0.1f;
		yrot+=0.1f;
		zrot+=0.1f;

		glTranslatef(0.0f,0.0f,-5.0f); // Move Into The Screen 5 Units
		glRotatef(xrot,1.0f,0.0f,0.0f); // Rotate On The X Axis
		glRotatef(yrot,0.0f,1.0f,0.0f); // Rotate On The Y Axis
		glRotatef(zrot,0.0f,0.0f,1.0f); // Rotate On The Z Axis

		tex.bind(); // or glBind(texture.getTextureID());

		glBegin(GL_QUADS);

		// Front Face
		glTexCoord2f(0.0f, 0.0f);
		glVertex3f(-1.0f, -1.0f, 1.0f); // Bottom Left Of The Texture and Quad
		glTexCoord2f(1.0f, 0.0f);
		glVertex3f( 1.0f, -1.0f, 1.0f); // Bottom Right Of The Texture and Quad
		glTexCoord2f(1.0f, 1.0f);
		glVertex3f( 1.0f, 1.0f, 1.0f); // Top Right Of The Texture and Quad
		glTexCoord2f(0.0f, 1.0f);
		glVertex3f(-1.0f, 1.0f, 1.0f); // Top Left Of The Texture and Quad

		// Back Face
		glTexCoord2f(1.0f, 0.0f);
		glVertex3f(-1.0f, -1.0f, -1.0f); // Bottom Right Of The Texture and Quad
		glTexCoord2f(1.0f, 1.0f);
		glVertex3f(-1.0f, 1.0f, -1.0f); // Top Right Of The Texture and Quad
		glTexCoord2f(0.0f, 1.0f);
		glVertex3f( 1.0f, 1.0f, -1.0f); // Top Left Of The Texture and Quad
		glTexCoord2f(0.0f, 0.0f);
		glVertex3f( 1.0f, -1.0f, -1.0f); // Bottom Left Of The Texture and Quad

		// Top Face
		glTexCoord2f(0.0f, 1.0f);
		glVertex3f(-1.0f, 1.0f, -1.0f); // Top Left Of The Texture and Quad
		glTexCoord2f(0.0f, 0.0f);
		glVertex3f(-1.0f, 1.0f, 1.0f); // Bottom Left Of The Texture and Quad
		glTexCoord2f(1.0f, 0.0f);
		glVertex3f( 1.0f, 1.0f, 1.0f); // Bottom Right Of The Texture and Quad
		glTexCoord2f(1.0f, 1.0f);
		glVertex3f( 1.0f, 1.0f, -1.0f); // Top Right Of The Texture and Quad

		// Bottom Face
		glTexCoord2f(1.0f, 1.0f);
		glVertex3f(-1.0f, -1.0f, -1.0f); // Top Right Of The Texture and Quad
		glTexCoord2f(0.0f, 1.0f);
		glVertex3f( 1.0f, -1.0f, -1.0f); // Top Left Of The Texture and Quad
		glTexCoord2f(0.0f, 0.0f);
		glVertex3f( 1.0f, -1.0f, 1.0f); // Bottom Left Of The Texture and Quad
		glTexCoord2f(1.0f, 0.0f);
		glVertex3f(-1.0f, -1.0f, 1.0f); // Bottom Right Of The Texture and Quad

		// Right face
		glTexCoord2f(1.0f, 0.0f);
		glVertex3f( 1.0f, -1.0f, -1.0f); // Bottom Right Of The Texture and Quad
		glTexCoord2f(1.0f, 1.0f);
		glVertex3f( 1.0f, 1.0f, -1.0f); // Top Right Of The Texture and Quad
		glTexCoord2f(0.0f, 1.0f);
		glVertex3f( 1.0f, 1.0f, 1.0f); // Top Left Of The Texture and Quad
		glTexCoord2f(0.0f, 0.0f);
		glVertex3f( 1.0f, -1.0f, 1.0f); // Bottom Left Of The Texture and Quad

		// Left Face
		glTexCoord2f(0.0f, 0.0f);
		glVertex3f(-1.0f, -1.0f, -1.0f); // Bottom Left Of The Texture and Quad
		glTexCoord2f(1.0f, 0.0f);
		glVertex3f(-1.0f, -1.0f, 1.0f); // Bottom Right Of The Texture and Quad
		glTexCoord2f(1.0f, 1.0f);
		glVertex3f(-1.0f, 1.0f, 1.0f); // Top Right Of The Texture and Quad
		glTexCoord2f(0.0f, 1.0f);
		glVertex3f(-1.0f, 1.0f, -1.0f); // Top Left Of The Texture and Quad
		glEnd();
	}


}
