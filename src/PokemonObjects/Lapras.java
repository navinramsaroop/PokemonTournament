package PokemonObjects;

import javax.swing.ImageIcon;

import Moves.BubbleBeam;
import Moves.HydroPump;
import Moves.IceBeam;
import Moves.Splash;

public class Lapras extends PokemonObject {

	public Lapras() {
		super("Lapras", 81, 90, 58, 190, 190, 50, 100, 0, false, "", "Water", "", null, null);
		setImage(new ImageIcon(getClass().getResource("Lapras.gif")));
		//TODO: Add weaknesses
		//TODO: Add moves
		
		addMoves(new BubbleBeam());
		addMoves(new HydroPump());
		addMoves(new IceBeam());
		addMoves(new Splash());
	}

	
}
