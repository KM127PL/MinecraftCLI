package com.github.km127pl.MinecraftCLI;

public class MinecraftCLI {
	static String authToken;
	static String email;
	static String password;
	static String version;
	static boolean areTheySet = false;
	
	public static void main(String[] args) throws Exception {	
		
		for(int i = 0; i<args.length; i++) {
			switch(args[i].toString()) {
				case "-ver":
					System.out.println("Selected Version: " + args[i + 1].toString());
					version = args[i + 1].toString();
				break;
				
				case "-email":
					System.out.println("Email: " + args[i + 1].toString());
					email = args[i + 1].toString(); 
				break;
				
				case "-password":
					System.out.println("Password: " + args[i + 1].toString());
					password = args[i + 1].toString(); 
				break;
			}
		}
		
		if(!(email == null) && !(password == null) && !(version == null)) {
			areTheySet = true;
		} else {
			Logger.argList();
			System.exit(0);
		}
		startVersion(version, true);
	}
	
	
	
	public static void startVersion(String v, Boolean ignore) throws Exception {
		if(areTheySet) {
			if(VersionChecker.doesVersionExist(v)) {
				Logger.log("version exists");
				VersionDownloader.downloadVersion(v);
			} else {
				Logger.log("version does not exist");
			}
		} else {
			Logger.log("Email or Password not set! Exiting..");
			System.exit(0);
		}
		
	}
}