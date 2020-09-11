package com.github.km127pl.MinecraftCLI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONObject;

public class VersionDownloader {
	
	static StringBuilder content = new StringBuilder();
    static String line;
	public static String APPDATA = System.getenv("APPDATA") + "\\.MCCLI";
	
	public static void downloadManifest() {
		if(!(FileManager.doesItExist(false, APPDATA + "//version_manifest.json"))) {
			FileManager.createDir(APPDATA);
			FileManager.download("https://launchermeta.mojang.com/mc/game/version_manifest.json", "version_manifest.json");
		}
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void downloadVersion(String version) throws Exception {
		try {
			if(VersionChecker.doesVersionExist(version)) {
				if(!(FileManager.doesItExist(false, VersionDownloader.APPDATA + "//version_manifest.json"))) {
					FileManager.download("https://launchermeta.mojang.com/mc/game/version_manifest.json", "version_manifest.json");
				}
				BufferedReader reader =  new BufferedReader(new FileReader(VersionDownloader.APPDATA + "//version_manifest.json"));
				
				while ((line = reader.readLine()) != null) {
			        content.append(line);
			        content.append(System.lineSeparator());
			    }
				
				reader.close();
				JSONObject jsonObject = (JSONObject) FileManager.readJson( VersionDownloader.APPDATA + "//version_manifest.json" );
				
				List versions = (List<String>) jsonObject.get("versions");
				for (int i = 0; i < versions.size(); i++) {
					JSONObject versionObject = (JSONObject) versions.get(i);
					System.out.println(versions.get(i));
					if(versionObject.get("id") == version) {
						System.out.println("found the version!");
						break;
					}
				}

				
				
				
				/*
				FileManager.download(versionFile, version + ".json");
				if(!(FileManager.doesItExist(false, VersionDownloader.APPDATA + "//versions//" + version))) {
					FileManager.createDir(VersionDownloader.APPDATA + "//versions//" + version);
				}
				FileManager.moveFile(VersionDownloader.APPDATA + "//versions//" + version, VersionDownloader.APPDATA + "//versions//" + version + "//" + version + ".json");
				*/
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
