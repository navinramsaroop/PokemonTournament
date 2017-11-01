package PokemonObjects;

import javax.swing.ImageIcon;

import Moves.BigBuzz;
import Moves.SilverWind;
import Moves.SolarBeam;
import Moves.Tackle;

public class Scyther extends PokemonObject {

	public Scyther() {
		super("Scyther", 103, 76, 99, 130, 130, 50, 100, 0, false, "", "Bug", "Flying", null, null);
		setImage(new ImageIcon(getClass().getResource("Scyther.gif")));
		//TODO: Add weaknesses
		//TODO: Add moves
		
		addMoves(new Tackle());
		addMoves(new SolarBeam());
		addMoves(new BigBuzz());
		addMoves(new SilverWind());
	}

	
}
