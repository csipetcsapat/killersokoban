package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import sokoban.*;

/**
 * tesztesetek lefuttatása
 */

public class Proto {
	public static final GameManager gm = new GameManager();
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Interpreter interpreter = new Interpreter();
		while (in.hasNextLine()) {
			String input = in.nextLine();
			interpreter.execute(input);
		}
	}
}


