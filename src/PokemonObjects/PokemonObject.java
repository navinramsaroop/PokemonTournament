package PokemonObjects;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import Moves.Moves;

public abstract class PokemonObject {
	protected int attack;
	protected int defense;
	protected int speed;
	protected int max_hp;
	protected int hp;
	protected String name;
	protected int level;
	protected int original_exp;
	protected int current_exp;
	protected boolean faint;
	protected String status;
	protected ImageIcon image;
	protected ImageIcon statusImage;
	protected String type1;
	protected String type2;
	protected ArrayList<Moves> moves = new ArrayList<Moves>();
	protected ImageIcon attackIcon;
	protected String tag; //Indicates legendary pokemon
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
	public PokemonObject(String name, int attack, 
			int defense, int speed, int max_hp, int hp, 
			int level, int original_exp, int current_exp, boolean faint, String status, String type1, String type2, ImageIcon statusImage, ImageIcon image) {
		this.name = name;
		this.attack = attack;
		this.defense = defense;
		this.speed = speed;
		this.max_hp = max_hp;
		this.hp = hp;
		this.level = level;
		this.original_exp = original_exp;
		this.current_exp = current_exp;
		this.faint = faint;
		this.status = status;
		this.image = image;
		this.type1 = type1;
		this.type2 = type2;
		this.statusImage = statusImage;
		
	}
	
	/**
	 * 
	 * @param move
	 */
	
	public String getMoveName (int num) {
		return moves.get(num).getName();
	}
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public ImageIcon getAttackIcon() {
		return attackIcon;
	}

	public void setAttackIcon(ImageIcon attackIcon) {
		this.attackIcon = attackIcon;
	}

	public ImageIcon getStatusImage() {
		return statusImage;
	}

	public void setStatusImage(ImageIcon statusImage) {
		this.statusImage = statusImage;
	}

	public String getType1() {
		return type1;
	}

	public void setType1(String type1) {
		this.type1 = type1;
	}

	public String getType2() {
		return type2;
	}

	public void setType2(String type2) {
		this.type2 = type2;
	}

	public ArrayList<Moves> getMoves() {
		return moves;
	}

	public void setMoves(ArrayList<Moves> moves) {
		this.moves = moves;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}

	public Moves getMove (int num) {
		return moves.get(num);
	}
	public void addMoves(Moves move) {
		this.moves.add(move);
	}
	public int getAttack() {
		return attack;
	}
	public int getCurrent_exp() {
		return current_exp;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getMax_hp() {
		return max_hp;
	}
	public void setMax_hp(int max_hp) {
		this.max_hp = max_hp;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getOriginal_exp() {
		return original_exp;
	}
	public void setOriginal_exp(int original_exp) {
		this.original_exp = original_exp;
	}
	public boolean isFaint() {
		return faint;
	}
	public void setFaint(boolean faint) {
		this.faint = faint;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	} 
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	public void setCurrent_exp(int current_exp) {
		this.current_exp = current_exp;
	}
	public int getDefense() {
		return defense;
	}
	public ImageIcon getImage() {
		return image;
	}
	public String toString() {
		String newLine = "\n";
		if(type2.equals("")) {
			return name + newLine+ 
					"    Attack: " + attack + newLine + 
					"    Defense: " + defense  + newLine + 
					"    Type: " + type1;
		}
		else {
			return name + newLine + 
					"    Attack: " + attack + newLine + 
					"    Defense: " + defense  + newLine + 
					"    Type: " + type1 + newLine  +
					"    Type 2: " + type2;
		}
	}
	
}
