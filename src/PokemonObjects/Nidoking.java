package PokemonObjects;

import javax.swing.ImageIcon;

import Moves.Crunch;
import Moves.EarthPower;
import Moves.SludgeBomb;
import Moves.Tackle;

public class Nidoking extends PokemonObject {

	public Nidoking() {
		super("Nidoking", 87, 73, 81, 141, 141, 50, 100, 0, false, "", "Poison", "Ground", null, null);
		setImage(new ImageIcon(getClass().getResource("Nidoking.gif")));
		//TODO: Add weaknesses
		//TODO: Add moves
		
		addMoves(new EarthPower());
		addMoves(new SludgeBomb());
		addMoves(new Crunch());
		addMoves(new Tackle());
	}

	
}
