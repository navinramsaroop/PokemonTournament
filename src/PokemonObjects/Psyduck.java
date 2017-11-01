package PokemonObjects;

import javax.swing.ImageIcon;

import Moves.BubbleBeam;
import Moves.Splash;

public class Psyduck extends PokemonObject {

	public Psyduck() {
		super("Psyduck", 63, 49, 54, 110, 110, 50, 100, 0, false, "", "Water", "", null, null);
		setImage(new ImageIcon(getClass().getResource("Psyduck.gif")));
		//TODO: Add weaknesses
		//TODO: Add moves
		
		addMoves(new Splash());
		addMoves(new Splash());
		addMoves(new Splash());
		addMoves(new BubbleBeam());
	}

	
}
