package PokemonObjects;

import javax.swing.ImageIcon;

import Moves.BrickBreak;
import Moves.Crunch;
import Moves.Headbutt;
import Moves.Hyperbeam;

public class Snorlax extends PokemonObject {

	public Snorlax() {
		super("Snorlax", 103, 103, 31, 220, 220, 50, 100, 0, false, "", "Normal", "", null, null);
		setImage(new ImageIcon(getClass().getResource("Snorlax.gif")));
		//TODO: Add weaknesses
		//TODO: Add moves
		addMoves(new Hyperbeam());
		addMoves(new Crunch());
		addMoves(new Headbutt());
		addMoves(new BrickBreak());
		
	}

	
}
