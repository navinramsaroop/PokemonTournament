package PokemonObjects;

import javax.swing.ImageIcon;

import Moves.DragonPulse;
import Moves.Earthquake;
import Moves.QuickAttack;
import Moves.Splash;

public class Flygon extends PokemonObject {

	public Flygon() {
		super("Flygon", 94, 76, 94, 140, 140, 50, 100, 0, false, "", "Ground", "Dragon", null, null);
		setImage(new ImageIcon(getClass().getResource("Flygon.gif")));
		//TODO: Add weaknesses
		//TODO: Add moves
		addMoves(new Earthquake());
		addMoves(new DragonPulse());
		addMoves(new Splash());
		addMoves(new QuickAttack());
		
	}

	
}
