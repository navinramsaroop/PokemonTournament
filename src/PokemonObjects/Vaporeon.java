package PokemonObjects;

import javax.swing.ImageIcon;

import Moves.BubbleBeam;
import Moves.Crunch;
import Moves.HydroPump;
import Moves.QuickAttack;

public class Vaporeon extends PokemonObject {

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
	public Vaporeon() {
		super("Vaporeon", 103, 90, 63, 190, 190, 50, 100, 0, false, "", "Water", "", null, null);
		setImage(new ImageIcon(getClass().getResource("Vaporeon.gif")));
		//TODO: Add weaknesses
		//TODO: Add moves
		
		addMoves(new BubbleBeam());
		addMoves(new HydroPump());
		addMoves(new Crunch());
		addMoves(new QuickAttack());
	}

	
}
