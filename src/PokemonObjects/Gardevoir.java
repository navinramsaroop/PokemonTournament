package PokemonObjects;

import javax.swing.ImageIcon;

import Moves.Confusion;
import Moves.MagicalLeaf;
import Moves.MoonBlast;
import Moves.Psychic;

public class Gardevoir extends PokemonObject {

	public Gardevoir() {
		super("Gardevoir", 117, 108, 80, 128, 128, 50, 100, 0, false, "", "Psychic", "Fairy", null, null);
		setImage(new ImageIcon(getClass().getResource("Gardevoir.gif")));
		//TODO: Add weaknesses
		//TODO: Add moves
		addMoves(new Confusion());
		addMoves(new MagicalLeaf());
		addMoves(new Psychic());
		addMoves(new MoonBlast());
		
	}

	
}
