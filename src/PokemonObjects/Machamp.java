package PokemonObjects;

import javax.swing.ImageIcon;

import Moves.BrickBreak;
import Moves.CloseCombat;
import Moves.RockSmash;
import Moves.Stonehenge;

public class Machamp extends PokemonObject {

	public Machamp() {
		super("Machamp", 121, 81, 54, 150, 150, 50, 100, 0, false, "", "Fighting", "", null, null);
		setImage(new ImageIcon(getClass().getResource("Machamp.gif")));
		//TODO: Add weaknesses
		//TODO: Add moves
		
		addMoves(new RockSmash());
		addMoves(new CloseCombat());
		addMoves(new BrickBreak());
		addMoves(new Stonehenge());
	}

	
}
