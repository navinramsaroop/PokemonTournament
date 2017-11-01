package PokemonObjects;

import javax.swing.ImageIcon;

import Moves.BigBuzz;
import Moves.Confusion;
import Moves.Fly;
import Moves.SilverWind;

public class Butterfree extends PokemonObject {

	public Butterfree() {
		super("Butterfree", 76, 76, 67, 120, 120, 50, 100, 0, false, "", "Flying", "Bug", null, null);
		setImage(new ImageIcon(getClass().getResource("Butterfree.gif")));
		//TODO: Add weaknesses
		//TODO: Add moves
		addMoves(new Fly());
		addMoves(new BigBuzz());
		addMoves(new SilverWind());
		addMoves(new Confusion());
	}

	
}
