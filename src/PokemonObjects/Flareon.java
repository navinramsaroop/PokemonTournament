package PokemonObjects;

import javax.swing.ImageIcon;

import Moves.Crunch;
import Moves.FireFang;
import Moves.Flamethrower;
import Moves.QuickAttack;

public class Flareon extends PokemonObject {

	public Flareon() {
		super("Flareon", 121, 103, 63, 125, 125, 50, 100, 0, false, "", "Fire", "", null, null);
		setImage(new ImageIcon(getClass().getResource("Flareon.gif")));
		//TODO: Add weaknesses
		//TODO: Add moves
		addMoves(new Flamethrower());
		addMoves(new FireFang());
		addMoves(new Crunch());
		addMoves(new QuickAttack());
		
	}

	
}
