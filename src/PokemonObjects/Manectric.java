package PokemonObjects;



import javax.swing.ImageIcon;

import Moves.Crunch;
import Moves.QuickAttack;
import Moves.Thunder;
import Moves.ThunderFang;

public class Manectric extends PokemonObject {

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
	public Manectric() {
		super("Manectric", 99, 58, 99, 130, 130, 50, 100, 0, false, "", "Electric", "", null, null);
		setImage(new ImageIcon(getClass().getResource("Manectric.gif")));
		addMoves(new ThunderFang());
		addMoves(new Thunder());
		addMoves(new Crunch());
		addMoves(new QuickAttack());
	}

	
}

