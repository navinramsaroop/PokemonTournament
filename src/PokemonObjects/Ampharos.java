package PokemonObjects;



import javax.swing.ImageIcon;

import Moves.BrickBreak;
import Moves.Discharge;
import Moves.DragonPulse;
import Moves.Thunder;

public class Ampharos extends PokemonObject {

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
	public Ampharos() {
		super("Ampharos", 108, 85, 54, 159, 159, 50, 100, 0, false, "", "Electric", "", null, null);
		setImage(new ImageIcon(getClass().getResource("Ampharos.gif")));
		addMoves(new Thunder());
		addMoves(new Discharge());
		addMoves(new DragonPulse());
		addMoves(new BrickBreak());
	}

	
}

