package PokemonObjects;

import javax.swing.ImageIcon;

import Moves.Hyperbeam;
import Moves.Splash;
import Moves.Thunder;
import Moves.Thunderbolt;

public class Magneton extends PokemonObject {

	public Magneton() {
		super("Magneton", 112, 90, 67, 110, 110, 50, 100, 0, false, "", "Steel", "Electric", null, null);
		setImage(new ImageIcon(getClass().getResource("Magneton.gif")));
		//TODO: Add weaknesses
		//TODO: Add moves
		
		addMoves(new Thunderbolt());
		addMoves(new Thunder());
		addMoves(new Hyperbeam());
		addMoves(new Splash());
	}

	
}
