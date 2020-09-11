package com.github.km127pl.MinecraftCLI;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileManager {
	public static void download(String url, String name) {
		try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
  		FileOutputStream fileOutputStream = new FileOutputStream(name)) {
			byte dataBuffer[] = new byte[1024];
  		    int bytesRead;
  		    while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
  		    	fileOutputStream.write(dataBuffer, 0, bytesRead);
  		    }
  		    Logger.log("Successfully downloaded the file: " + name);
  		} catch (IOException e) {
  		    // handle exception
  		} 
	}
	
	public static boolean doesItExist(Boolean isDir, String pth) {
		Path path = Paths.get(pth);
		if (isDir) {
			if (Files.exists(path)) {
				if (Files.isDirectory(path)) {
					return true;
				}
				return false;
			}
			return false;
		} else {
			if (Files.exists(path)) {
				return true;
			}
			return false;
		}
	}
	
	public static void createDir(String nameOfDir) {
		 File dir = new File(nameOfDir);
	     dir.mkdir();
	     Logger.log("Created directory: " + nameOfDir);
	}
	
	public static void moveFile(String src, String dest ) {
		Path result = null;
		try {
			result = Files.move(Paths.get(src), Paths.get(dest));
		} catch (IOException e) {
			Logger.log("Exception while moving file: " + e.getMessage());
		}
		if(result != null) {
			Logger.log("Moved the file: " + src + " to " + dest);
		} else {
			Logger.log("Successfully moved: " + src + " to " + dest);
		}
	}
	
	public static String getWindowsUser() {
		return System.getProperty("user.name");
	}
}
