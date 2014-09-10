package tk.mattrick.openblocks.location;

/**
 * @author mattrick
 *
 */

public class Point {

	double x, y, z;

	World world;

	public Point (double x, double y, double z, World world) {
		this.x = x;
		this.y = y;
		this.z = z;

		this.world = world;
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public double getZ() {
		return this.z;
	}

	public World getWorld() {
		return this.world;
	}

}
