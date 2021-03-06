package tk.mattrick.openblocks.player;

import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;


public class Camera {
	//3d vector to store the camera's position in
	private Vector3f    position    = null;
	//the rotation around the Y axis of the camera
	private float       yaw         = 0.0f;
	//the rotation around the X axis of the camera
	private float       pitch       = 0.0f;
	public Camera(float x, float y, float z)
	{
		//instantiate position Vector3f to the x y z params.
		position = new Vector3f(x, y, z);
	}
	public void yaw(float amount)
	{
		//increment the yaw by the amount param
		yaw += amount;
	}

	//increment the camera's current yaw rotation
	public void pitch(float amount)
	{
		//increment the pitch by the amount param
		pitch += amount;
	}
	public void walkForward(float distance)
	{
		position.x -= distance * (float)Math.sin(Math.toRadians(yaw));
		position.z += distance * (float)Math.cos(Math.toRadians(yaw));
	}

	//moves the camera backward relitive to its current rotation (yaw)
	public void walkBackwards(float distance)
	{
		position.x += distance * (float)Math.sin(Math.toRadians(yaw));
		position.z -= distance * (float)Math.cos(Math.toRadians(yaw));
	}

	//strafes the camera left relitive to its current rotation (yaw)
	public void strafeLeft(float distance)
	{
		position.x -= distance * (float)Math.sin(Math.toRadians(yaw-90));
		position.z += distance * (float)Math.cos(Math.toRadians(yaw-90));
	}

	//strafes the camera right relitive to its current rotation (yaw)
	public void strafeRight(float distance)
	{
		position.x -= distance * (float)Math.sin(Math.toRadians(yaw+90));
		position.z += distance * (float)Math.cos(Math.toRadians(yaw+90));
	}

	//this dose basic what gluLookAt() does
	public void lookThrough()
	{
		//roatate the pitch around the X axis
		GL11.glRotatef(pitch, 1.0f, 0.0f, 0.0f);
		//roatate the yaw around the Y axis
		GL11.glRotatef(yaw, 0.0f, 1.0f, 0.0f);
		//translate to the position vector's location
		GL11.glTranslatef(position.x, position.y, position.z);
	}

	public void update() {

	}

}

