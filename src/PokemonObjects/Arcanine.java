package PokemonObjects;

import javax.swing.ImageIcon;

import Moves.CloseCombat;
import Moves.Crunch;
import Moves.Flamethrower;
import Moves.FlareBlitz;

public class Arcanine extends PokemonObject {

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
	public Arcanine() {
		super("Arcanine", 103, 76, 90, 150, 150, 50, 100, 0, false, "", "Fire", "", null, null);
		setImage(new ImageIcon(getClass().getResource("Arcanine.gif")));
		
		addMoves(new Flamethrower());
		addMoves(new FlareBlitz());
		addMoves(new Crunch());
		addMoves(new CloseCombat());
	}

	
}
