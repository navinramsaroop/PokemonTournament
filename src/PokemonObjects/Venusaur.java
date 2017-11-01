package PokemonObjects;

import javax.swing.ImageIcon;

import Moves.Earthquake;
import Moves.PetalDance;
import Moves.RazorLeaf;
import Moves.SolarBeam;

public class Venusaur extends PokemonObject {

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
	public Venusaur() {
		super("Venusaur", 94, 79, 80, 140, 140, 50, 100, 0, false, "", "Grass", "", null, null);
		setImage(new ImageIcon(getClass().getResource("Venusaur.gif")));
		//TODO: Add weaknesses
		//TODO: Add moves
		
		addMoves(new SolarBeam());
		addMoves(new PetalDance());
		addMoves(new RazorLeaf());
		addMoves(new Earthquake());
	}

	
}
