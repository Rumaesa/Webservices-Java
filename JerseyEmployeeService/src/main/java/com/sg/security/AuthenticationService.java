package com.sg.security;

import java.util.StringTokenizer;

import java.util.Base64;


public class AuthenticationService {

	public boolean isAuthenticate(String authentication) {
		
		if(authentication== null) {
			return false;
		}
		
		String encodedUsernamePassword = authentication.replaceFirst("Basic", "");
		
		try {
			byte[] decodedUserPass = Base64.getDecoder().decode(encodedUsernamePassword);
			
			String decodeUserPass = new String(decodedUserPass, "UTF-8");
			StringTokenizer tokenizer = new StringTokenizer(decodeUserPass, ":");
			
			String username = tokenizer.nextToken();
			String password = tokenizer.nextToken();
			if(username.equals("rumaesa") && password.equals("@Rumi")) {
				return true;
			}
			else {
				return false;
			}
					
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
