package PokemonObjects;

import javax.swing.ImageIcon;

import Moves.DragonPulse;
import Moves.Flamethrower;
import Moves.FlareBlitz;
import Moves.Fly;

public class Charizard extends PokemonObject {

	public Charizard() {
		super("Charizard", 102, 81, 94, 138, 138, 50, 100, 0, false, "", "Fire", "Flying", null, null);
		setImage(new ImageIcon(getClass().getResource("Charizard.gif")));
		//TODO: Add weaknesses
		//TODO: Add moves
		addMoves(new Flamethrower());
		addMoves(new FlareBlitz());
		addMoves(new DragonPulse());
		addMoves(new Fly());
	}

	
}
