package PokemonObjects;

import javax.swing.ImageIcon;

import Moves.Crunch;
import Moves.QuickAttack;
import Moves.Splash;
import Moves.Tackle;

public class Eevee extends PokemonObject {

	public Eevee() {
		super("Eevee", 54, 63, 54, 115, 115, 50, 100, 0, false, "", "Normal", "", null, null);
		setImage(new ImageIcon(getClass().getResource("Eevee.gif")));
		//TODO: Add weaknesses
		//TODO: Add moves
		addMoves(new Crunch());
		addMoves(new QuickAttack());
		addMoves(new Tackle());
		addMoves(new Splash());
	}

	
}
