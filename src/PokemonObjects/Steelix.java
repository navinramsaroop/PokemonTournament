package PokemonObjects;

import javax.swing.ImageIcon;

import Moves.Crunch;
import Moves.DragonBreath;
import Moves.Earthquake;
import Moves.Stonehenge;

public class Steelix extends PokemonObject {

	public Steelix() {
		super("Steelix", 81, 184, 31, 135, 135, 50, 100, 0, false, "", "Steel", "Ground", null, null);
		setImage(new ImageIcon(getClass().getResource("Steelix.gif")));
		//TODO: Add weaknesses
		//TODO: Add moves
		addMoves(new Crunch());
		addMoves(new Stonehenge());
		addMoves(new DragonBreath());
		addMoves(new Earthquake());
		
	}

	
}
