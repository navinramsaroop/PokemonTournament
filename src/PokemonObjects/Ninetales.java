package PokemonObjects;

import javax.swing.ImageIcon;

import Moves.Confusion;
import Moves.FireFang;
import Moves.Flamethrower;
import Moves.FlareBlitz;

public class Ninetales extends PokemonObject {

	public Ninetales() {
		super("Ninetales", 77, 94, 94, 133, 133, 50, 100, 0, false, "", "Fire", "", null, null);
		setImage(new ImageIcon(getClass().getResource("Ninetales.gif")));
		//TODO: Add weaknesses
		//TODO: Add moves
		
		addMoves(new Flamethrower());
		addMoves(new FireFang());
		addMoves(new Confusion());
		addMoves(new FlareBlitz());
	}

	
}
