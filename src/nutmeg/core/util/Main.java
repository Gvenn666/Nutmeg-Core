package nutmeg.core.util;

import java.io.File;

import nutmeg.core.util.files.FileLoader;

public class Main {

	public static void main(String[] args) {
		FileLoader loader = FileLoader.get();
		loader.loadTextFile(new File("assets/TestInput.txt"));
	}

}
