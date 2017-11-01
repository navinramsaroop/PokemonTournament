package PokemonObjects;

import javax.swing.ImageIcon;

import Moves.CloseCombat;
import Moves.Earthquake;
import Moves.Flamethrower;
import Moves.FlareBlitz;

public class Infernape extends PokemonObject {

	public Infernape() {
		super("Infernape", 98, 68, 101, 136, 136, 50, 100, 0, false, "", "Fire", "", null, null);
		setImage(new ImageIcon(getClass().getResource("Infernape.gif")));
		//TODO: Add weaknesses
		//TODO: Add moves
		addMoves(new CloseCombat());
		addMoves(new Flamethrower());
		addMoves(new FlareBlitz());
		addMoves(new Earthquake());
		
	}

	
}
