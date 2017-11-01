package PokemonObjects;

import javax.swing.ImageIcon;

import Moves.AquaTail;
import Moves.AuraSphere;
import Moves.EarthPower;
import Moves.HydroPump;

public class Palkia extends PokemonObject {

	public Palkia() {
		super("Palkia", 139, 112, 94, 150, 150, 50, 100, 0, false, "", "Dragon", "Water", null, null);
		setImage(new ImageIcon(getClass().getResource("Palkia.gif")));
		setTag("Legendary");
		//TODO: Add weaknesses
		//TODO: Add moves
		addMoves(new HydroPump());
		addMoves(new AuraSphere());
		addMoves(new EarthPower());
		addMoves(new AquaTail());
		
	}

	
}
