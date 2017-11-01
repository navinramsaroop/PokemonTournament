package PokemonObjects;

import javax.swing.ImageIcon;

import Moves.Flamethrower;
import Moves.Fly;
import Moves.Hyperbeam;
import Moves.Thunder;

public class Dragonite extends PokemonObject {

	public Dragonite() {
		super("Dragonite", 125, 94, 76, 151, 151, 50, 100, 0, false, "", "Dragon", "Flying", null, null);
		setImage(new ImageIcon(getClass().getResource("Dragonite.gif")));

		addMoves(new Flamethrower());
		addMoves(new Thunder());
		addMoves(new Hyperbeam());
		addMoves(new Fly());
		
	}

	
}
