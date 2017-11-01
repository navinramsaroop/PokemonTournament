package pokemon_tournament;

import java.util.ArrayList;

import PokemonObjects.PokemonObject;

public class GymLeaders {

	
	public static  ArrayList<ArrayList<PokemonObject>> getGymLeaders() {

		 ArrayList<PokemonObject> opponent1 = PokemonTrainers.getBuzz();
		 ArrayList<PokemonObject> opponent2 = PokemonTrainers.getRed();
		 ArrayList<PokemonObject> opponent3 = PokemonTrainers.getVictoria();
		
		 ArrayList<ArrayList<PokemonObject>> gymleaders = new ArrayList<>();
		 
		 gymleaders.add(opponent1);
		 gymleaders.add(opponent2);
		 gymleaders.add(opponent3);
		 return gymleaders;
		 
	}
	
	public static ArrayList<String> getGymLeaderNames() {
		ArrayList<String> names = new ArrayList<>();
		names.add("Buzz");
		names.add("Red");
		names.add("Victoria");
		
		return names;
	}
}
