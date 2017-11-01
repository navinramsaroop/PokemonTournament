package PokemonObjects;

import javax.swing.ImageIcon;

import Moves.Earthquake;
import Moves.RockSmash;
import Moves.Splash;
import Moves.Tackle;

public class Onix extends PokemonObject {

	public Onix() {
		super("Onix", 45, 148, 67, 95, 95, 50, 100, 0, false, "", "Rock", "Ground", null, null);
		setImage(new ImageIcon(getClass().getResource("Onix.gif")));
		//TODO: Add weaknesses
		//TODO: Add moves
		
		addMoves(new Earthquake());
		addMoves(new RockSmash());
		addMoves(new Tackle());
		addMoves(new Splash());
	}

	
}
