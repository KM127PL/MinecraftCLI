package com.github.km127pl.MinecraftCLI;

import java.nio.file.Path;

public class VersionDownloader {
	public static void downloadVer(String name, Path path) {
		switch(name) {
			case "1.8":
				FileManager.download("https://launcher.mojang.com/v1/objects/3870888a6c3d349d3771a3e9d16c9bf5e076b908/client.jar", "1.8.9.jar");
				Logger.log("Downloading 1.8.9 jar");
				if(!(FileManager.doesItExist(true, "C:\\Users\\" + FileManager.getWindowsUser() + "\\AppData\\Roaming\\.MCCLI"))) {
					Logger.log("Creating directory .MCCLI");
					FileManager.createDir("C:\\Users\\" + FileManager.getWindowsUser() + "\\AppData\\Roaming\\.MCCLI");
				}
				FileManager.moveFile("1.8.9.jar", "C:\\Users\\" + FileManager.getWindowsUser() + "\\AppData\\Roaming\\.MCCLI\\1.8.9.jar");
			break;
		}
	}
	
}
