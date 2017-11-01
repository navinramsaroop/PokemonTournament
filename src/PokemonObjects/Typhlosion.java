package PokemonObjects;

import javax.swing.ImageIcon;

import Moves.FireBlast;
import Moves.Flamethrower;
import Moves.Headbutt;
import Moves.QuickAttack;

public class Typhlosion extends PokemonObject {

	public Typhlosion() {
		super("Typhlosion", 102, 81, 94, 138, 138, 50, 100, 0, false, "", "Fire", "", null, null);
		setImage(new ImageIcon(getClass().getResource("Typhlosion.gif")));
		//TODO: Add weaknesses
		//TODO: Add moves
		addMoves(new Flamethrower());
		addMoves(new QuickAttack());
		addMoves(new Headbutt());
		addMoves(new FireBlast());
		
	}

	
}
