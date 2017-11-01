package PokemonObjects;

import javax.swing.ImageIcon;

import Moves.QuickAttack;
import Moves.Thunder;
import Moves.Thunderbolt;
import Moves.VoltTackle;

public class Pikachu extends PokemonObject {

	public Pikachu() {
		super("Pikachu", 54, 40, 85, 95, 95, 50, 100, 0, false, "", "Electric", "", null, null);
		setImage(new ImageIcon(getClass().getResource("Pikachu.gif")));
		//TODO: Add weaknesses
		//TODO: Add moves
		
		addMoves(new Thunderbolt());
		addMoves(new QuickAttack());
		addMoves(new VoltTackle());
		addMoves(new Thunder());
	}

	
}
