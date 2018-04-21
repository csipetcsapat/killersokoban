package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import sokoban.*;

/**
 * tesztesetek lefuttatása
 */

public class Proto {
	public static final GameManager gm = new GameManager("gm");
	public static final Logger log = new Logger();
	
	private static boolean askInput() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		
		try {
			input = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return input.toLowerCase().equals("y");
	}

	public static void main(String[] args) {

		
		 
		
		return ;
		
		
		}
	}


