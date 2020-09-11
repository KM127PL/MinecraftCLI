package com.github.km127pl.MinecraftCLI;

import java.nio.file.Path;

public class VersionDownloader {
	
	public static String APPDATA = System.getenv("APPDATA") + "\\.MCCLI";
	
	public static void downloadVer(String name, Path path) {
		if(!(FileManager.doesItExist(false, APPDATA + "//version_manifest.json"))) {
			FileManager.createDir(APPDATA);
			FileManager.download("https://launchermeta.mojang.com/mc/game/version_manifest.json", "version_manifest.json");
		}
		
	}
	
}
