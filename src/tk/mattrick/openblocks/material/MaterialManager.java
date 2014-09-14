package tk.mattrick.openblocks.material;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import tk.mattrick.openblocks.game.Config;

/**
 * @author mattrick
 *
 */

public class MaterialManager {

	public static List<Texture> textures = new ArrayList<Texture>();
	public static List<Material> materials = new ArrayList<Material>();

	/**
	 * @param name Loads a texture with given name
	 * @return The Texture that was loaded (null if it could not be loaded)
	 */
	public static Texture loadTexture (String name) {
		try {
			Texture texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(Config.resource_path + "textures/blocks/" + name + ".png"));
			textures.add(texture);
			return texture;
		} catch (IOException e) {
			System.err.println("Could not load texture: " + name + ". Expect missing textures!");
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param Name for Material to use
	 * @return Weather of not the Material could be registered
	 */
	public static Material registerMaterial (String name) {
		Material material = new Material(name);
		for (Material m : materials) {
			if (m.getName() == name) {
				return null;
			}
		}

		materials.add(material);
		loadTexture(name);
		return material;
	}

}
