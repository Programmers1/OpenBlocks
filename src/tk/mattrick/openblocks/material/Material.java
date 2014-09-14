package tk.mattrick.openblocks.material;

import org.newdawn.slick.opengl.Texture;


/**
 * @author mattrick
 *
 */

public class Material {

	String name;
	Texture texture;

	public Material (String name) {
		this.name = name;
		this.texture = MaterialManager.loadTexture(name);
	}

	public String getName () {
		return this.name;
	}

	public Texture getTexture() {
		return this.texture;
	}

}
