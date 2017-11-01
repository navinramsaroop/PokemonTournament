package PokemonObjects;

import javax.swing.ImageIcon;

import Moves.DarkPulse;
import Moves.ShadowBall;
import Moves.ShadowClaw;
import Moves.SludgeBomb;

public class Gengar extends PokemonObject {

	public Gengar() {
		super("Gengar", 121, 72, 103, 120, 120, 50, 100, 0, false, "", "Ghost", "Poison", null, null);
		setImage(new ImageIcon(getClass().getResource("Gengar.gif")));
		//TODO: Add weaknesses
		//TODO: Add moves
		addMoves(new ShadowBall());
		addMoves(new ShadowClaw());
		addMoves(new DarkPulse());
		addMoves(new SludgeBomb());
	}

	
}
