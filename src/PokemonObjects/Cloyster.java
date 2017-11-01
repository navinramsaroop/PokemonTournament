package PokemonObjects;

import javax.swing.ImageIcon;

import Moves.HydroPump;
import Moves.Hyperbeam;
import Moves.IceBeam;
import Moves.Surf;

public class Cloyster extends PokemonObject {

	public Cloyster() {
		super("Cloyster", 90, 166, 67, 110, 110, 50, 100, 0, false, "", "Water", "Ice", null, null);
		setImage(new ImageIcon(getClass().getResource("Cloyster.gif")));
		//TODO: Add weaknesses
		//TODO: Add moves
		addMoves(new HydroPump());
		addMoves(new IceBeam());
		addMoves(new Surf());
		addMoves(new Hyperbeam());
	}

	
}
