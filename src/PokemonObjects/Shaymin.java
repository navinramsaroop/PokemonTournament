package PokemonObjects;

import javax.swing.ImageIcon;

import Moves.AirSlash;
import Moves.MagicalLeaf;
import Moves.Psychic;
import Moves.SolarBeam;

public class Shaymin extends PokemonObject {

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
	public Shaymin() {
		super("Shaymin", 94, 94, 94, 160, 160, 50, 100, 0, false, "", "Grass", "Flying", null, null);
		setImage(new ImageIcon(getClass().getResource("Shaymin.gif")));
		setTag("Legendary");
		addMoves(new SolarBeam());
		addMoves(new MagicalLeaf());
		addMoves(new AirSlash());
		addMoves(new Psychic());
	}

	
}
