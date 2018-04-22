package sokoban;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
	
	public void LoadMap(int playerCount, String mapName, GameManager gm) {
			ArrayList<Hole> holes = new ArrayList<>();
            ArrayList<Lever> levers = new ArrayList<>();
            ArrayList<Box> boxes = new ArrayList<>();
            ArrayList<Worker> workers = new ArrayList<>();
            
            int currPlayer = 0;
            
            
        // TODO:read map file
		try {
            BufferedReader buffer=new BufferedReader(new FileReader(mapName));
            String line;
            
            line = buffer.readLine();
            String[] tokens = line.split(",");
            width = Integer.parseInt(tokens[0]);
            height = Integer.parseInt(tokens[1]);
            
            
            
            // TODO:create Fields, and place things
            while((line = buffer.readLine()) != null && line.length() !=0){
                tokens = line.split(" ");
                for (int i = 0; i < tokens.length; i++)
                {
                	Field newField;
                	Thing newThing = null;
                	
                	//check if it is wall
                	if (tokens[i].charAt(0) == '#') {
                		newField = new Field();
                		fields.add(newField);
                		
                		newThing = new Wall(newField);
                		newField.SetThing(newThing);
                		
                		continue;
                	}
                	
                	
                	//read roughness
                	int roughness = Character.getNumericValue(tokens[i].charAt(0));
                	//delete the first char(roughness) from string (pop from front)
                	tokens[i] = tokens[i].substring(1);
                	
                	//read fieldType and create field accordingly
                	switch (tokens[i].charAt(0)) {
                	
	                	case 'G' : 	Goal g = new Goal(gm);
	                				goals.add(g);
	                				newField = g;
	                				break;               
	                	
	                	case 'H' : 	Hole h = new Hole(Character.getNumericValue(tokens[i].charAt(1)));
	                				tokens[i] = tokens[i].substring(1);	
	                				holes.add(h);
	                				newField = h;
	    							break;
	                		
	                	case 'L' :  Lever l = new Lever(Character.getNumericValue(tokens[i].charAt(1)));
	    							tokens[i] = tokens[i].substring(1);	
	    							levers.add(l);
	    							newField = l;
	    							break;
	                		
	                	case 'F' :	
	                	
	                	default : 	newField = new Field();
                	
                	}
                	// delete character representing fieldtype
                	tokens[i] = tokens[i].substring(1);	
                	// set roughness for the new field and store field in the ArrayList
                	newField.SetRoughness(roughness);
                	fields.add(newField);
                	
                	
                	// if not empty it means something is on the field so lets create and place it
                	if (!tokens[i].isEmpty()) {
                		
                		
                		switch (tokens[i].charAt(0)) {
                    	
		                	case 'B' : 	Box b = new Box(newField);
		                				
		                				boxes.add(b);		                	
		                				newThing = b;
		                				break;               
		                	
		                	
		                	case 'S' : 	newThing = null;
		                				spawns.add(newField);		                		
		    							break;
		                		
		                	// ez elvileg valos k0rnyezetben nem kell hogy olvashato legyen mert 
		    				// a playerek a spawnokra kerulnek , de igy mondjuk olyan mapot is be lehet tolteni ahol playerek vannak lerakva
		    							//a magic konstans az ero nem tudom honnan fog jonni
		                	case 'P' :  if (currPlayer < playerCount) {
		                					Worker p = new Worker(newField, 12, Character.getNumericValue(tokens[i].charAt(1)));
		                					newThing = p;
		                					
		                					workers.add(p);
		                					currPlayer++;
		                				}
		                				break;
		                	
		                	default : // ide esetleg hibakezeles
		                				newThing = null;
		                				break;
	                	
	                	}
                		
                		newField.SetThing(newThing);
                	}
                	
                	
                	
                	
                	
                }
                // ha nem azonos hosszuak a sorok kitolti fallal
                for (int i = 0; i < width-tokens.length; i++)
                {
                	Field f = new Field();
                	Thing w = new Wall(f);
                	f.SetThing(w);
                	
    				fields.add(f);
    				
                }
                
                
              
              
                               
            }
            buffer.close();
        } catch (IOException ex) {
            System.err.println("IOException");
        }
		
		
		//creating players on spawn

		for ( int i = 0; i < playerCount; i++) {
			if (i < spawns.size()  ) {
				//magic constant worker power
				Worker p = new Worker(spawns.get(i), 12, i);
				spawns.get(i).SetThing(p);
				workers.add(p);
			}
		}
		
		//  Link Fields
		
		
		
		for (int j = 0; j < height; j++) {
			for (int i = 0; i < width ; i++ ) {
				
				fields.get(j*width + i).SetNeighbour(Directions.UP,  	j == 0 ? 		null : fields.get((j-1)*width + i) ); 
				fields.get(j*width + i).SetNeighbour(Directions.DOWN,	j == height-1 ? null : fields.get((j+1)*width + i) );
				fields.get(j*width + i).SetNeighbour(Directions.LEFT,	i == 0 ? 		null : fields.get((j)*width + i-1) );
				fields.get(j*width + i).SetNeighbour(Directions.RIGHT,	i == width -1 ? null : fields.get((j)*width + i+1) );
				
			}
			
		}
		
		
		//  Link Holes
		for (Lever l : levers) {
			for (Hole h : holes) {
				if (l.GetID() == h.GetID()) {
					l.SetHole(h);
				}
			}
		}
		
		
		
		
		
		gm.SetPlayers(workers);
		gm.SetBoxes(boxes);
		gm.SetMap(this);
		
		
	}
	
	
	public void PrintMap() {
		for (int j = 0; j < height; j++) {
			for (int i = 0; i < width; i++) {
				
				System.out.print(fields.get(j*width+i).toString()+" ");
					
				
			}
			System.out.println("");
		}
	
	}
	

}
