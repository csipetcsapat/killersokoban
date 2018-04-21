package sokoban;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Map {
	
	private ArrayList<Goal> goals;
	private ArrayList<Field> fields;
	private ArrayList<Field> spawns;
	
	private int width;
	private int height;
	
	public Map() {
		goals = new ArrayList<>();
		fields = new ArrayList<>();
		spawns = new ArrayList<>();
	}
	
	public ArrayList<Field> GetSpawns(){
		return spawns;
	}
	
	public ArrayList<Goal> GetGoals() {
		return goals;
	}
	
	void LoadMap(int playerCount, String mapName, GameManager gm) {
	
		// TODO:read map file
		try {
            BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
            String line;
            
            line = buffer.readLine();
            String[] tokens = line.split(",");
            width = Integer.parseInt(tokens[0]);
            height = Integer.parseInt(tokens[1]);
            
            ArrayList<Hole> holes = new ArrayList<>();
            ArrayList<Lever> levers = new ArrayList<>();
            
            // TODO:create Fields, and place things
            while((line = buffer.readLine()) != null && line.length() !=0){
                tokens = line.split(" ");
                for (int i = 0; i < tokens.length; i++)
                {
                	//read roughness
                	int roughness = tokens[i].charAt(0);
                	tokens[i] = tokens[i].substring(1);
                	
                	Field newField;
                	
                	//read fieldType and create field accordingly
                	switch (tokens[i].charAt(0)) {
                	
                	case 'G' : 	Goal g = new Goal(gm);
                				goals.add(g);
                				newField = g;
                				break;               
                	
                	case 'H' : 	Hole h = new Hole(tokens[i].charAt(1));
                				tokens[i] = tokens[i].substring(1);	
                				holes.add(h);
                				newField = h;
    							break;
                		
                	case 'L' :  Lever l = new Lever(tokens[i].charAt(1));
    							tokens[i] = tokens[i].substring(1);	
    							levers.add(l);
    							newField = l;
    							break;
                		
                	case 'F' :	
                	
                	default : 	newField = new Field();
                	
                	}
                	// set roughness for the new field and store field in the ArrayList
                	newField.SetRoughness(roughness);
                	fields.add(newField);
                	
                	
                	// if true it means something is on the field so lets create and place it
                	if (tokens[i].length() > 1) {
                		tokens[i] = tokens[i].substring(1);	
                		
                		
                		
                	}
                	
                	
                	
                	
                }
                
                for (int i = 0; i < width-tokens.length; i++)
                {
                	Field f = new Field();
    				fields.add(f);
    				
    				
                }
                
                
              
              
                               
            }
        } catch (IOException ex) {
            System.err.println("IOException");
        }
		
		
		
		
		
		// TODO: Link Fields
		
		
	}
	
	
	
	

}
