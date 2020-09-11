package com.github.km127pl.MinecraftCLI;

import java.io.IOException;

import org.apache.hc.core5.http.ParseException;

public class MinecraftCLI {
	static String authToken;
	static String email;
	static String password;
	static String version;
	
	public static void main(String[] args) throws ParseException, IOException {	
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
				
				default:
					argList();
				break;
			}
			
			// System.out.println("args[" + i + "]: " + args[i]);
		}
		startVersion(version, true);
	}
	
	public static void argList() {
		
	}
	
	public static void startVersion(String v, Boolean ignore) throws ParseException, IOException {
		System.out.println(Auth.getAuthToken(email, password));
		/*switch(v) {
			case "1.8":
			case "1.8.9":
				// start 1.8-9
				System.out.println("Downloading version: " + v);
				VersionDownloader.downloadVer(v, null);
			try {
				Logger.log(Auth.getAuthToken(email, password));
			} catch (ParseException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
			default:
				System.out.println("Selected version does not exist!");
			break;
		}
	*/}
}