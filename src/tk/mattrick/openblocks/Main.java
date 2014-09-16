package tk.mattrick.openblocks;

import java.io.File;
/**
 * @author mattrick
 *
 */
import tk.mattrick.openblocks.game.Game;

public class Main {

	public static void main(String[] args) {
		String os = System.getProperty("os.name");
		os = os.toLowerCase();
		if ((os.indexOf("mac") >= 0) || (os.indexOf("darwin") >= 0)) {
			System.setProperty("org.lwjgl.librarypath", new File("natives/macosx").getAbsolutePath());
		} else if (os.indexOf("win") >= 0) {
			System.setProperty("org.lwjgl.librarypath", new File("natives/windows").getAbsolutePath());
		} else if (os.indexOf("nux") >= 0) {
			System.setProperty("org.lwjgl.librarypath", new File("natives/linux").getAbsolutePath());
		} else {
			System.err.println("Could not auto detect operating system! Please restart BinaryBlocks with the Djava.library.path=\"natives/\" argument.");
			System.out.println("(Operating System detected was " + System.getProperty("os.name") + ")");
			System.exit(0);
		}

		new Game();

	}

}
