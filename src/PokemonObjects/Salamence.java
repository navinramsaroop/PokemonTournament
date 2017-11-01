package PokemonObjects;

import javax.swing.ImageIcon;

import Moves.Crunch;
import Moves.DragonClaw;
import Moves.Flamethrower;
import Moves.Headbutt;

public class Salamence extends PokemonObject {

	/**
	 * 
	 * @param name
	 * @param attack
	 * @param defense
	 * @param speed
	 * @param max_hp
	 * @param hp
	 * @param level
	 * @param original_exp
	 * @param current_exp
	 * @param faint
	 * @param status
	 * @param type1
	 * @param type2
	 * @param statusImage
	 * @param image
	 */
	public Salamence() {
		super("Salamence", 126, 76, 94, 155, 155, 50, 100, 0, false, "", "Dragon", "Flying", null, null);
		setImage(new ImageIcon(getClass().getResource("Salamence.gif")));
		//TODO: Add weaknesses
		//TODO: Add moves
		
		addMoves(new DragonClaw());
		addMoves(new Flamethrower());
		addMoves(new Crunch());
		addMoves(new Headbutt());
	}

	
}
