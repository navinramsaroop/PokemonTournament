package PokemonObjects;

import javax.swing.ImageIcon;

import Moves.Confusion;
import Moves.Hyperbeam;
import Moves.Psychic;
import Moves.Thunderbolt;

public class Mewtwo extends PokemonObject {

	public Mewtwo() {
		super("Mewtwo", 143, 85, 121, 166, 166, 50, 100, 0, false, "", "Psychic", "", null, null);
		setImage(new ImageIcon(getClass().getResource("Mewtwo.gif")));
		setTag("Legendary");
		addMoves(new Confusion());
		addMoves(new Psychic());
		addMoves(new Thunderbolt());
		addMoves(new Hyperbeam());
	}

	
}