package PokemonObjects;

import javax.swing.ImageIcon;

import Moves.Crunch;
import Moves.QuickAttack;
import Moves.Thunder;
import Moves.Thunderbolt;

public class Jolteon extends PokemonObject {

	public Jolteon() {
		super("Jolteon", 103, 90, 121, 125, 125, 50, 100, 0, false, "", "Electric", "", null, null);
		setImage(new ImageIcon(getClass().getResource("Jolteon.gif")));
		//TODO: Add weaknesses
		//TODO: Add moves
		
		addMoves(new Thunder());
		addMoves(new Thunderbolt());
		addMoves(new QuickAttack());
		addMoves(new Crunch());
	}

	
}
