package PokemonObjects;



import javax.swing.ImageIcon;

import Moves.BubbleBeam;
import Moves.HydroPump;
import Moves.IceBeam;
import Moves.Splash;

public class Blastoise extends PokemonObject {

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
	public Blastoise() {
		super("Blastoise", 81, 99, 74, 139, 139, 50, 100, 0, false, "", "Water", "", null, null);
		setImage(new ImageIcon(getClass().getResource("Blastoise.gif")));
		addMoves(new HydroPump());
		addMoves(new BubbleBeam());
		addMoves(new IceBeam());
		addMoves(new Splash());
	}

	
}

