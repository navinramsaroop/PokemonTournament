package PokemonObjects;

import javax.swing.ImageIcon;

import Moves.Flamethrower;
import Moves.FlareBlitz;
import Moves.QuickAttack;
import Moves.SolarBeam;

public class Rapidash extends PokemonObject {

	public Rapidash() {
		super("Rapidash", 94, 76, 99, 125, 125, 50, 100, 0, false, "", "Fire", "", null, null);
		setImage(new ImageIcon(getClass().getResource("Rapidash.gif")));
		//TODO: Add weaknesses
		//TODO: Add moves
		
		addMoves(new FlareBlitz());
		addMoves(new SolarBeam());
		addMoves(new QuickAttack());
		addMoves(new Flamethrower());
	}

	
}
