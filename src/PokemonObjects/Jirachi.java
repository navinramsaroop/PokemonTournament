package PokemonObjects;

import javax.swing.ImageIcon;

import Moves.Confusion;
import Moves.Psychic;
import Moves.ShadowBall;
import Moves.Thunderbolt;

public class Jirachi extends PokemonObject {

	public Jirachi() {
		super("Jirachi", 94, 94, 94, 160, 160, 50, 100, 0, false, "", "Steel", "Psychic", null, null);
		setImage(new ImageIcon(getClass().getResource("Jirachi.gif")));
		setTag("Legendary");
		addMoves(new Confusion());
		addMoves(new Thunderbolt());
		addMoves(new Psychic());
		addMoves(new ShadowBall());
	}

	
}
