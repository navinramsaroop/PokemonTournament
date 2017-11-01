package pokemon_tournament;

public class MoveType {

	/**
	 * 
	 * @param move_type
	 * @param player_type1
	 * @param player_type2
	 * @return Multiplier
	 */
	public static double getMult(String move_type, String player_type1, String player_type2 ) {
		return multiplier(move_type, player_type1) * multiplier(move_type,player_type2);
		
	}
	private static double multiplier (String move, String player_type) {
		double multiplier = 1; 
		String type = player_type; 
		
		//TODO: ADD PSYCHIC
		if(move.equalsIgnoreCase("Psychic")) {
			if(type.equalsIgnoreCase("Fighting") || 
					type.equalsIgnoreCase("Poison")) {
				multiplier *= 2;
			}
			if(type.equalsIgnoreCase("Psychic") ||
					type.equalsIgnoreCase("Steel")) {
				multiplier *= 0.5;
			}
		}
		if(move.equalsIgnoreCase("Poison")) {
			if(type.equalsIgnoreCase("Poison") || 
					type.equalsIgnoreCase("Ground") ||
					type.equalsIgnoreCase("Rock") ||
					type.equalsIgnoreCase("Ghost")){
					
				multiplier *= 0.5;
			}
			if(type.equalsIgnoreCase("Steel")) {
				multiplier = 0;
			}
			if(type.equalsIgnoreCase("Grass") || type.equalsIgnoreCase("Fairy")) {
				multiplier *= 2;
			}
		}
		if(move.equalsIgnoreCase("Fire")) {
			if(type.equalsIgnoreCase("Grass") ||
					type.equalsIgnoreCase("Steel") || 
					type.equalsIgnoreCase("Ice") || 
					type.equalsIgnoreCase("Bug")){
				multiplier = multiplier * 2;
			}
			else if(type.equalsIgnoreCase("Dragon") ||
					type.equalsIgnoreCase("Rock") ||
					type.equalsIgnoreCase("Fire") || 
					type.equalsIgnoreCase("Water")) {
				multiplier = multiplier * 0.5;
			}
		}
		if(move.equalsIgnoreCase("Ice")){
			if(type.equalsIgnoreCase("Dragon") ||
					type.equalsIgnoreCase("Grass") ||
					type.equalsIgnoreCase("Ground") || 
					type.equalsIgnoreCase("Flying")) {
				multiplier = multiplier * 2;
			}
			else if(type.equalsIgnoreCase("Fire") || 
					type.equalsIgnoreCase("Steel") || 
					type.equalsIgnoreCase("Water") || 
					type.equalsIgnoreCase("Ice")) {
				multiplier = multiplier * 0.5;
			}
		}
		if(move.equalsIgnoreCase("Flying")) {
			if(type.equalsIgnoreCase("Grass") || 
					type.equalsIgnoreCase("Fighting") || 
					type.equalsIgnoreCase("Bug")) {
				multiplier = multiplier * 2;
			}
			else if(type.equalsIgnoreCase("Rock") ||
					type.equalsIgnoreCase("Electric") || 
					type.equalsIgnoreCase("Steel")) {
				multiplier = multiplier * 0.5;
			}
		}
		
		if(move.equalsIgnoreCase("Water")) {
			if(type.equalsIgnoreCase("Grass") ||
					type.equalsIgnoreCase("Water") || 
					type.equalsIgnoreCase("Dragon")) {
				multiplier = multiplier * 0.5;
			}
			else if(type.equalsIgnoreCase("Fire") || 
					type.equalsIgnoreCase("Ground") ||
					type.equalsIgnoreCase("Rock")) {
				multiplier = multiplier * 2;
			}
		}
		if(move.equalsIgnoreCase("Ground")) {
			if(type.equalsIgnoreCase("Flying")){
				multiplier = 0;
			}
			if(type.equalsIgnoreCase("Poison") ||
					type.equalsIgnoreCase("Rock") || 
					type.equalsIgnoreCase("Steel") ||
					type.equalsIgnoreCase("Fire") ||
					type.equalsIgnoreCase("Electric")) {
				multiplier *= 2;
			}
			if(type.equalsIgnoreCase("Bug") ||
					type.equalsIgnoreCase("Grass")) {
				multiplier *= 0.5;
			}
		}
		if(move.equalsIgnoreCase("Dragon")) {
			if(type.equalsIgnoreCase("Dragon")) {
				multiplier = multiplier * 2;
			}
			else if(type.equalsIgnoreCase("Steel")) {
				multiplier = multiplier * 0.5;
			}
			else if(type.equalsIgnoreCase("Fairy")) {
				multiplier = 0;
			}
		}
		if(move.equalsIgnoreCase("Electric")) {
			if(type.equalsIgnoreCase("Flying") ||
					type.equalsIgnoreCase("Water")) {
				multiplier = multiplier * 2;
			}
			else if(type.equalsIgnoreCase("Dragon") || 
					type.equalsIgnoreCase("Electric") || 
					type.equalsIgnoreCase("Grass")) {
				multiplier = multiplier * 0.5;
			}
			else if(type.equalsIgnoreCase("Ground")) {
				multiplier = 0;
			}
		}
		if(move.equalsIgnoreCase("Dark")){
			if(type.equalsIgnoreCase("Ghost") || 
					type.equalsIgnoreCase("Psychic")){
				multiplier = multiplier * 2;
			}
			if(type.equalsIgnoreCase("Fighting") || 
					type.equalsIgnoreCase("Dark") || 
					type.equalsIgnoreCase("Fairy")) {
				multiplier *= 0.5;
			}
		}
		if(move.equalsIgnoreCase("Grass")) {
			if(type.equalsIgnoreCase("Fire") || 
					type.equalsIgnoreCase("Flying") || 
					type.equalsIgnoreCase("Grass") || 
					type.equalsIgnoreCase("Poison") || 
					type.equalsIgnoreCase("Bug") || 
					type.equalsIgnoreCase("Steel") || 
					type.equalsIgnoreCase("Dragon")){
				multiplier = multiplier * 0.5;
			}
			else if(type.equalsIgnoreCase("Water") ||
					type.equalsIgnoreCase("Rock") || 
					type.equalsIgnoreCase("Ground")){
				multiplier = multiplier * 2;
			}
		}
		
		if(move.equalsIgnoreCase("Fighting")){
			if(type.equalsIgnoreCase("Normal") || 
					type.equalsIgnoreCase("Rock") || 
					type.equalsIgnoreCase("Steel")
					||type.equalsIgnoreCase("Ice") ||
					type.equalsIgnoreCase("Dark")) {
				multiplier = multiplier * 2;
			}
			else if(type.equalsIgnoreCase("Flying") || 
					type.equalsIgnoreCase("Poison")
					|| type.equalsIgnoreCase("Bug") || 
					type.equalsIgnoreCase("Psychic") ||
					type.equalsIgnoreCase("Fairy")) {
				multiplier = multiplier * 0.5;
			}
			else if(type.equalsIgnoreCase("Ghost")) {
				multiplier = 0;
			}
		}
		if(move.equalsIgnoreCase("Steel")) {
			if(type.equalsIgnoreCase("Rock") ||
					type.equalsIgnoreCase("Ice") || 
					type.equalsIgnoreCase("Fairy")){
				multiplier = multiplier * 2;
			}
			else if(type.equalsIgnoreCase("Steel") || 
					type.equalsIgnoreCase("Fire") || 
					type.equalsIgnoreCase("Water") || 
					type.equalsIgnoreCase("Electric") || 
					type.equalsIgnoreCase("Normal")){
				multiplier = multiplier * 0.5;
			}
		}
		if(move.equalsIgnoreCase("Normal")) {
			if(type.equalsIgnoreCase("Ghost")) {
				multiplier = 0; 
			}
			if(type.equalsIgnoreCase("Metal") || 
					type.equalsIgnoreCase("Rock")){
				multiplier = multiplier * 0.5;
			}
		}
		if(move.equalsIgnoreCase("Rock")){
			if(type.equalsIgnoreCase("Flying") || 
					type.equalsIgnoreCase("Bug") || 
					type.equalsIgnoreCase("Fire") ||
					type.equalsIgnoreCase("Ice")){
				multiplier = multiplier * 2;
			}
			if(type.equalsIgnoreCase("Fighting") || 
					type.equalsIgnoreCase("Ground")||
					type.equalsIgnoreCase("Steel")){
				multiplier *= 0.5;
			}
		}
		if(move.equalsIgnoreCase("Ghost")) {
			if(type.equalsIgnoreCase("Normal")) {
				multiplier = 0;
			}
			if(type.equalsIgnoreCase("Dark")) {
				multiplier *= 0.5;
			}
			if(type.equalsIgnoreCase("Psychic") ||
					type.equalsIgnoreCase("Ghost")) {
				multiplier *= 2;
			}
		if(move.equalsIgnoreCase("Bug")) {
			if(type.equalsIgnoreCase("Fighting") ||
					type.equalsIgnoreCase("Flying") || 
					type.equalsIgnoreCase("Poison") || 
					type.equalsIgnoreCase("Ghost") || 
					type.equalsIgnoreCase("Steel") || 
					type.equalsIgnoreCase("Fire") ||
					type.equalsIgnoreCase("Fairy") ) {
				multiplier *= 0.5;
			}
			if(type.equalsIgnoreCase("Grass") || 
					type.equalsIgnoreCase("Psychic") || 
					type.equalsIgnoreCase("Dark")) {
				multiplier *= 2;
			}
		}
		}
		return multiplier; 
		
	}

}
