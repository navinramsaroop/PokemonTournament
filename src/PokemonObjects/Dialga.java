package PokemonObjects;

import javax.swing.ImageIcon;

import Moves.AuraSphere;
import Moves.DragonClaw;
import Moves.EarthPower;
import Moves.FlashCannon;

public class Dialga extends PokemonObject {

	public Dialga() {
		super("Dialga", 139, 112, 85, 160, 160, 50, 100, 0, false, "", "Dragon", "Steel", null, null);
		setImage(new ImageIcon(getClass().getResource("Dialga.gif")));
		setTag("Legendary");
		//TODO: Add weaknesses
		//TODO: Add moves
		addMoves(new FlashCannon());
		addMoves(new EarthPower());
		addMoves(new DragonClaw());
		addMoves(new AuraSphere());
		
	}

	
}
