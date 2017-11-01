package PokemonObjects;

import javax.swing.ImageIcon;

import Moves.BubbleBeam;
import Moves.Discharge;
import Moves.HydroPump;
import Moves.Thunderbolt;

public class Lanturn extends PokemonObject {

	public Lanturn() {
		super("Lanturn", 72, 72, 64, 185, 185, 50, 100, 0, false, "", "Water", "Electric", null, null);
		setImage(new ImageIcon(getClass().getResource("Lanturn.gif")));
		//TODO: Add weaknesses
		//TODO: Add moves
		addMoves(new BubbleBeam());
		addMoves(new Discharge());
		addMoves(new HydroPump());
		addMoves(new Thunderbolt());
	}

	
}
