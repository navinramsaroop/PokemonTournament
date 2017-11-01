package PokemonObjects;

import javax.swing.ImageIcon;

import Moves.CloseCombat;
import Moves.Fly;
import Moves.Splash;
import Moves.Tackle;

public class Pidgeot extends PokemonObject {

	public Pidgeot() {
		super("Pidgeot", 76, 72, 86, 143, 143, 50, 100, 0, false, "", "Flying", "", null, null);
		setImage(new ImageIcon(getClass().getResource("Pidgeot.gif")));
		//TODO: Add weaknesses
		//TODO: Add moves
		
		addMoves(new Fly());
		addMoves(new Tackle());
		addMoves(new CloseCombat());
		addMoves(new Splash());
	}

	
}
