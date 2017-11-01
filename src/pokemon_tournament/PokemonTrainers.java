package pokemon_tournament;

import java.util.ArrayList;

import PokemonObjects.Ampharos;
import PokemonObjects.Arcanine;
import PokemonObjects.Blastoise;
import PokemonObjects.Charizard;
import PokemonObjects.Eevee;
import PokemonObjects.Flareon;
import PokemonObjects.Jolteon;
import PokemonObjects.Lanturn;
import PokemonObjects.Lapras;
import PokemonObjects.Luxray;
import PokemonObjects.Manectric;
import PokemonObjects.Pikachu;
import PokemonObjects.PokemonObject;
import PokemonObjects.Psyduck;
import PokemonObjects.Snorlax;
import PokemonObjects.Vaporeon;
import PokemonObjects.Venusaur;

public class PokemonTrainers {
	 
	 public static ArrayList<PokemonObject> getBuzz() {
		 ArrayList<PokemonObject> Buzz = new ArrayList<>();
		 //Electric
		 Buzz.add(new Pikachu());
		 Buzz.add(new Jolteon());
		 Buzz.add(new Manectric());
		 Buzz.add(new Ampharos());
		 Buzz.add(new Luxray());
		 Buzz.add(new Lanturn());
		 return Buzz;
	 }
	 public static ArrayList<PokemonObject> getVictoria() {
		 ArrayList<PokemonObject> Victoria = new ArrayList<>();
		 Victoria.add(new Eevee());
		 Victoria.add(new Vaporeon());
		 Victoria.add(new Flareon());
		 Victoria.add(new Jolteon());
		 Victoria.add(new Arcanine());
		 Victoria.add(new Luxray());
		 return Victoria;
	 }
	 
	 public static ArrayList<PokemonObject> getRed() {
		 ArrayList<PokemonObject> Victoria = new ArrayList<>();
		 Victoria.add(new Venusaur());
		 Victoria.add(new Charizard());
		 Victoria.add(new Pikachu());
		 Victoria.add(new Snorlax());
		 Victoria.add(new Blastoise());
		 Victoria.add(new Lapras());
		 return Victoria;
	 }
	 
	 public static ArrayList<PokemonObject> getKaren() {
		 ArrayList<PokemonObject> Karen = new ArrayList<>();
		 Karen.add(new Psyduck());
		 Karen.add(new Psyduck());
		 Karen.add(new Psyduck());
		 Karen.add(new Psyduck());
		 Karen.add(new Psyduck());
		 Karen.add(new Psyduck());
		 return Karen;
	 }
}
