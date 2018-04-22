package sokoban;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class Map {
	
	private ArrayList<Goal> goals;
	private ArrayList<ArrayList<Field>> fields;
	
	public Map() {
		goals = new ArrayList<>();
		fields = new ArrayList<>();
	}
	
	public ArrayList<Goal> GetGoals() {
		return goals;
	}
	
	private Field processField(String token, ArrayList<Box> boxes, ArrayList<Worker> players,
			ArrayList<Hole> holes, ArrayList<Lever> levers,
			java.util.Map<Integer, Integer> forceMap, GameManager gm) {
		Field field = null;
		Thing thing = null;
		
		if (token.equals("#")) {
			field = new Field();
			thing = new Wall(field);
		} else {
			int index = 0;
			int roughness = token.charAt(index++) - '0';
			
			switch (token.charAt(index++)) {
			case 'F':
				field = new Field();
				break;
				
			case 'H':
				field = new Hole(token.charAt(index++) - '0');
				holes.add((Hole)field);
				break;
				
			case 'L':
				field = new Lever(token.charAt(index++) - '0');
				levers.add((Lever)field);
				break;
				
			case 'G':
				field = new Goal(gm);
				goals.add((Goal)field);
				break;

			default:
				break;
			}
			
			field.SetRoughness(roughness);
			
			if (token.length() - 1 >= index) {
				switch (token.charAt(index++)) {
				case 'P':
					int id = token.charAt(index++) - '0';
					thing = new Worker(field, forceMap.get(id), id);
					players.add((Worker)thing);
					break;
				case 'B':
					thing = new Box(field);
					boxes.add((Box)thing);
					break;
				}
			}
		}
		
		if (thing != null)
			field.SetThing(thing);;
		
		return field;
	}
	
	public void LoadMap(int playerCount, String mapName, GameManager gm) {
		ArrayList<Box> boxes = new ArrayList<>();
		ArrayList<Worker> players = new ArrayList<>();
		ArrayList<Hole> holes = new ArrayList<>();
		ArrayList<Lever> levers = new ArrayList<>();
		
		Scanner in = null;
		try {
			in = new Scanner(new File(mapName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return; //exit if no such file
		}
		
		java.util.Map<Integer, Integer> forceMap = new TreeMap<>();
		
		while(in.hasNextLine()) {
			String line = in.nextLine();
			
			String[] tokens = line.split(" ");
			
			if (tokens[0].charAt(0) != '#') {
				forceMap.put(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
				continue;
			}
			
			ArrayList<Field> thisLine = new ArrayList<>();
			int i = 0;
			for (String token : tokens) {
				Field field = processField(token, boxes, players, holes, levers, forceMap, gm);
				
				//setting vertical neighbours
				if (thisLine.size() > 0) {
					Field previousField = thisLine.get(thisLine.size() - 1);
					previousField.SetNeighbour(Directions.RIGHT, field);
					field.SetNeighbour(Directions.LEFT, previousField);
				}
				
				//setting horizontal neighbours
				 if (fields.size() > 0 && fields.get(fields.size() - 1).size() > i) {
					 Field upperField = fields.get(fields.size() - 1).get(i);
					 upperField.SetNeighbour(Directions.DOWN, field);
					 field.SetNeighbour(Directions.UP, upperField);
				 }
				
				thisLine.add(field);
				++i;
			}
			
			fields.add(thisLine);
		}
		
		in.close();
		
		for (Lever lever : levers) {
			for (Hole hole : holes) {
				if (hole.GetID() == lever.GetID()) {
					lever.SetHole(hole);
					break;
				}
			}
		}
		
		gm.SetBoxes(boxes);
		gm.SetPlayers(players);
		gm.SetMap(this);
	}
	
	
	public void PrintMap() {
		for (ArrayList<Field> arrayList : fields) {
			for (Field field : arrayList) {
				System.out.print(field.toString() + " ");
			}
			
			System.out.println();
		}
	}
}
