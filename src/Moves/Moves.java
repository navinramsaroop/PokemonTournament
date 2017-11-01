package Moves;

public abstract class Moves {
	protected String name;
	protected int power;
	protected int accuracy;

	protected String type;
	
	/**
	 * 
	 * @param name
	 * @param power
	 * @param accuracy
	 * @param type
	 */
	public Moves(String name, int power, int accuracy, String type) {
		this.name = name;
		this.power = power;
		this.accuracy = accuracy;
		this.type = type;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String toString() {
		return name + "    Type: " + type + "\n   Power: " + power + "   Accuracy: " + accuracy;
	}
}
