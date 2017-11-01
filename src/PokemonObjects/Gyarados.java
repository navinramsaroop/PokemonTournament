package PokemonObjects;

import javax.swing.ImageIcon;

import Moves.HydroPump;
import Moves.Hyperbeam;
import Moves.IceBeam;
import Moves.Surf;

public class Gyarados extends PokemonObject {

	public Gyarados() {
		super("Gyarados", 117, 94, 77, 155, 155, 50, 100, 0, false, "", "Water", "Flying", null, null);
		setImage(new ImageIcon(getClass().getResource("Gyarados.gif")));
		//TODO: Add weaknesses
		//TODO: Add moves
		addMoves(new HydroPump());
		addMoves(new IceBeam());
		addMoves(new Surf());
		addMoves(new Hyperbeam());
	}

	
}
