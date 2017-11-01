package PokemonObjects;

import javax.swing.ImageIcon;

import Moves.EarthPower;
import Moves.Earthquake;
import Moves.RockSmash;
import Moves.Stonehenge;

public class Golem extends PokemonObject {

	public Golem() {
		super("Golem", 103, 121, 45, 140, 140, 50, 100, 0, false, "", "Rock", "Ground", null, null);
		setImage(new ImageIcon(getClass().getResource("Golem.gif")));
		addMoves(new Stonehenge());
		addMoves(new Earthquake());
		addMoves(new RockSmash());
		addMoves(new EarthPower());
	}

	
}
