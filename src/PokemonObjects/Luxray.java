package PokemonObjects;

import javax.swing.ImageIcon;

import Moves.Crunch;
import Moves.Discharge;
import Moves.Thunder;
import Moves.ThunderFang;

public class Luxray extends PokemonObject {

	public Luxray() {
		super("Luxray", 112, 75, 67, 140, 140, 50, 100, 0, false, "", "Electric", "", null, null);
		setImage(new ImageIcon(getClass().getResource("Luxray.gif")));
		//TODO: Add weaknesses
		//TODO: Add moves
		addMoves(new Discharge());
		addMoves(new ThunderFang());
		addMoves(new Crunch());
		addMoves(new Thunder());
	}

	
}
