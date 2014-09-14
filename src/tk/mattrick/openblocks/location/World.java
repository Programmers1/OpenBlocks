package tk.mattrick.openblocks.location;

import java.util.ArrayList;
import java.util.List;

import tk.mattrick.openblocks.blob.Blob;

/**
 * @author mattrick
 *
 */

public class World {

	private String name;
	private List<Blob> blobs = new ArrayList<Blob>();

	public World (String name) {
		this.name = name;
	}

	public void addBlob(Blob b){
		blobs.add(b);
	}

	public void removeBlob(Blob b) {
		blobs.remove(b);
	}

	public String getName() {
		return this.name;
	}

	public List<Blob> getBlobList() {
		return this.blobs;
	}

	public Blob getBlobAt(int x, int y, int z) {
		for (Blob b : blobs){
			if (b.getX() == x && b.getY() == y && b.getZ() == z) {
				return b;
			}
		}
		return null;
	}

}
