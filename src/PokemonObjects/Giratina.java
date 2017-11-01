package PokemonObjects;

import javax.swing.ImageIcon;

import Moves.DragonClaw;
import Moves.EarthPower;
import Moves.ShadowClaw;
import Moves.ShadowForce;

public class Giratina extends PokemonObject {

	public Giratina() {
		super("Giratina", 94, 100, 85, 210, 210, 50, 100, 0, false, "", "Dragon", "Ghost", null, null);
		setImage(new ImageIcon(getClass().getResource("Giratina.gif")));
		setTag("Legendary");
		addMoves(new EarthPower());
		addMoves(new DragonClaw());
		addMoves(new ShadowClaw());
		addMoves(new ShadowForce());
	}

	
}