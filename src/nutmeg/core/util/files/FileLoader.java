package nutmeg.core.util.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileLoader {
	private static FileLoader fl;
	
	public static FileLoader get() {
		if(fl == null) fl = new FileLoader();
		return fl;
	}
	
	/**
	 * 
	 * @param file - The File To Read From
	 * @return A String[] containing all lines in the input file
	 */
	public String[] loadTextFile(File file) {
		if(!file.exists()) return new String[] {"FNF"};
		if(!file.canRead()) return new String[] {"FNR"};
		
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String line = "";
			StringBuilder source = new StringBuilder();
			while((line = reader.readLine()) != null) {
				source.append(line + "\n");
			}
			
			return source.toString().split("\n");
			
		} catch(Exception ex) {
			return new String[] {"IOEX"};
		} finally {
			if(reader != null)
				try {
					reader.close();
				} catch (IOException e) {
				}
		}
	}
	/**
	 * 
	 * @param file - The File to read
	 * @return A Single String containing all characters in the file
	 */
	public String loadTextFileRaw(File file) {
		if(!file.exists()) return "FNF";
		if(!file.canRead()) return "FNR";
		
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String line = "";
			StringBuilder source = new StringBuilder();
			while((line = reader.readLine()) != null) {
				source.append(line + "\n");
			}
			
			return source.toString();
			
		} catch(Exception ex) {
			return "IOEX";
		} finally {
			if(reader != null)
				try {
					reader.close();
				} catch (IOException e) {
				}
		}
	}
	
}
