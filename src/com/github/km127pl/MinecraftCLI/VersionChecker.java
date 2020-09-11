package com.github.km127pl.MinecraftCLI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.parser.ParseException;

public class VersionChecker {
	static StringBuilder content = new StringBuilder();
    static String line;
    
	public static boolean doesVersionExist(String name) throws IOException, ParseException {
		
		if(!(FileManager.doesItExist(false, VersionDownloader.APPDATA + "//version_manifest.json"))) {
			FileManager.download("https://launchermeta.mojang.com/mc/game/version_manifest.json", "version_manifest.json");
		}
		BufferedReader reader =  new BufferedReader(new FileReader(VersionDownloader.APPDATA + "//version_manifest.json"));
		
		while ((line = reader.readLine()) != null) {
	        content.append(line);
	        content.append(System.lineSeparator());
	    }
		
		reader.close();
		if(content.toString().contains(name))
			return true;
        return false;
	}
}
