package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import sokoban.*;

public class Skeleton {
	public static final GameManager gm = new GameManager("gm");
	public static final Logger log = new Logger();

	public static void main(String[] args) {
//		Field f1 = new Field("f1");
//		Field f2 = new Field("f2");
//		Field f3 = new Field("f3");
//		
//		f1.SetNeighbour(Directions.RIGHT, f2);
//		f2.SetNeighbour(Directions.RIGHT, f3);
//		
//		Worker w = new Worker("w", f1);
//		Box b = new Box("b", f2);
//		f2.SetThing(b);
//		w.Move(Directions.RIGHT);
		Test test = null;
		String input;
		boolean isOpen;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Welcome to the Skeleton program of Csipet-csapat !");
		
		
		
		while(true) {
			System.out.println("Please pick from the following options:");
			
			System.out.println(" [1] Worker step on Empty Field \n"
							+  " [2] Worker step on Hole \n"
							+  " [3] Worker push Box on Empty Field\n"
							+  " [4] Worker push Box on Hole \n"
							+  " [5] Worker push Box on Lever\n"
							+  " [6] Worker push Box on Goal \n"
							+  " [7] Worker push Box on Worker to Empty Field \n"
							+  " [8] Worker push Box on Worker to Box \n"
							+  " [9] Worker push Box on Worker to Wall\n"
							+  "[10] Worker push Box on Worker to Worker\n"
							+  "[11] Worker push Box to Box \n"
							+  "[12] Worker push Box to Wall \n"
							+  "[13] Worker push Worker \n"
							+  "[14] Worker push Wall \n"
							+  " [e] EXIT Skeleton"						
							);
			
			
			try {
				input = reader.readLine();
			switch (input) {
			case "1":  
				test = new StepEmpty();
				break;
			case "2":  
				System.out.println("Is hole open? Y/N");
				input = reader.readLine();
				if(input.equals("Y"))
					isOpen = true;
				else if(input.equals("N"))
					isOpen = false;
				else break;
				test = new StepHole(isOpen);
				break;
			case "3":  
				test = new PushBoxEmpty();
				break;
			case "4":  
				System.out.println("Is hole open? Y/N");
				input = reader.readLine();
				if(input.equals("Y"))
					isOpen = true;
				else if(input.equals("N"))
					isOpen = false;
				else break;
				test = new PushBoxHole(isOpen);
				break;
			case "5": 
				System.out.println("Is hole field empty Y/N");
				input = reader.readLine();
				if(input.equals("Y"))
					isOpen = true;
				else if(input.equals("N"))
					isOpen = false;
				else break;
				test = new PushBoxLever(isOpen);
				break;
			case "6":  
				test = new PushBoxGoal();
				break;
			case "7":  
				test = new PushBoxPlayerEmpty();
				break;
			case "8":  
				test = new PushBoxPlayerBox();
				break;
			case "9":  
				test = new PushBoxPlayerWall();
				break;
			case "10":  
				test = new PushBoxPlayerPlayer();
				break;
			case "11":  
				test = new PushBoxBox();
				break;
			case "12":  
				test = new PushBoxWall();
				break;
			case "13":  
				test = new PushPlayer();
				break;
			case "14":  
				test = new PushWall();
				break;
			case "e":  
				return;
			default: 
				System.out.println("Unknown option, please try again...");
				break;
			}	
			} catch (IOException e) {
				System.out.println("Reading Error"); 
			}
			
			if (test != null) {
				log.reset();
				test.Run();
				log.printCallStack();
			}
		
		
		}
	}

}
