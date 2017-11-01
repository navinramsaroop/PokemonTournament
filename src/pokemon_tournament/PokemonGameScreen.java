package pokemon_tournament;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;

import Moves.Moves;
import PokemonObjects.PokemonObject;

public class PokemonGameScreen implements ActionListener, KeyListener, MouseListener {
	private JFrame screen = new JFrame();
	
	private ArrayList<PokemonObject> PLAYER1 = new ArrayList<PokemonObject>();
	private ArrayList<PokemonObject> PLAYER2 = new ArrayList<PokemonObject>();
	
	
	private JButton[] player1Button = new JButton[6];
	private JButton[] player2Button = new JButton[6];
	
	private JLabel p1pokemonCurrentIcon;
	private JLabel p2pokemonCurrentIcon;
	
	private JScrollPane scrollPane;
	private JButton[] player1Moves = new JButton [4];
	private JButton[] player2Moves = new JButton [4];
	
	private JLabel[] statuslabelsP1 = new JLabel[4]; // first box, Pokemon Name! second box, Hp and Changable Hp! 
	private JLabel[] statuslabelsP2 = new JLabel[4]; // first box, Pokemon Name! second box, Hp and Changable Hp! 
	
	private JProgressBar player1_health;
	private JProgressBar player2_health;
	
	private PokemonObject p1Active;
	private PokemonObject p2Active;
	
	private String player1Name;
	private String player2Name;
	
	
	private int player1MoveSave = 0;
	private int player2MoveSave = 0;
	
	private Timer t = new Timer(50, this);
	private Timer t2 = new Timer(50, this);
	
	private JTextArea output = new JTextArea();
	
	private int turnCounterPlayer1 = 0;
	private int turnCounterPlayer2 = 0;
	
	private final String newline = "\n";
	
	private ImageIcon burnedSymbol = new ImageIcon(getClass().getResource("BurnedSymbol.jpeg"));
	private ImageIcon poisonSymbol = new ImageIcon(getClass().getResource("PoisonSymbol.jpeg"));
	private ImageIcon frozenSymbol = new ImageIcon(getClass().getResource("FrozenSymbol.png"));
	private ImageIcon paralyzedSymbol = new ImageIcon(getClass().getResource("ParalyzedSymbol.png"));
	
	private JLabel statusL1 = new JLabel();
	private JLabel statusL2 = new JLabel();
	
	private JLabel player_name_label = new JLabel();
	private JLabel player2_name_label = new JLabel();
	private Random r = new Random();

	/**
	 * 
	 * @param PLAYER1 ArrayList<PokemonObject>
	 * @param PLAYER2 ArrayList<PokemonObject>
	 */
	public PokemonGameScreen(ArrayList<PokemonObject> PLAYER1, ArrayList<PokemonObject> PLAYER2, String player_1_name, String player_2_name) {

		this.PLAYER1 = PLAYER1;
		this.PLAYER2 = PLAYER2;
		player1Name = player_1_name;
		player2Name = player_2_name;
		
		screen.setLayout(null);
		screen.setVisible(true);
		screen.setSize(1200, 625);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		screen.setLocationRelativeTo(null);
		screen.setResizable(false);
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    screen.getContentPane().setBackground(Color.black);

	   
	    p1Active = PLAYER1.get(0);
	    p2Active = PLAYER2.get(0);
	    
	    player1_health = new JProgressBar();
	    player2_health = new JProgressBar();
	    
	    Font bigFont = new Font("Times New Roman", Font.BOLD, 30);
	    
		player_name_label.setText(player_1_name);
		player_name_label.setBounds(200, 0, 800, 100);
		player_name_label.setFont(bigFont);
		player_name_label.setForeground(Color.yellow);
		screen.add(player_name_label);
		
		player2_name_label.setText(player_2_name);
		player2_name_label.setBounds(100, 0, 900, 100);
		player2_name_label.setFont(bigFont);
		player2_name_label.setForeground(Color.yellow);
		player2_name_label.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		screen.add(player2_name_label);
	    
	    setstatuslabels();
	    setAndAddPokemonButtons();
	    setPokemonIcon(); 
	    addMoveButtons();
	    addHpBar();
	    addTextBox();
	    statusSetup();
	    player2MovesToggle(false);
	    
	  //ImageIcon pokemonBackground = new ImageIcon(getClass().getResource("pokemonBackground" + (r.nextInt(4) + 2) + ".png"));
	    ImageIcon pokemonBackground = new ImageIcon(getClass().getResource("pokemonBackground6.png"));
		JLabel background = new JLabel(pokemonBackground); 
		background.setBounds(0, 0, 1200, 625);
		screen.add(background);
	   
		screen.requestFocusInWindow();
		screen.setFocusable(true);
	    screen.addKeyListener(this);
	    
		ArrayList<String> musicFiles = new ArrayList<>();
		musicFiles.add(getClass().getResource("08-normal-battle.wav").getPath());
		musicFiles.add(getClass().getResource("battleMusic1.wav").getPath());
		musicFiles.add(getClass().getResource("battleMusic2.wav").getPath());

		MusicClass mc = new MusicClass(musicFiles);
		mc.start();
	
	}
	/**
	 * Sets up Label that displays images for the status effects
	 */
	private void statusSetup() {
		statusL1.setBounds(400, 400, 100, 100);
		screen.add(statusL1);
		
		statusL2.setBounds(700,400, 100, 100);
		screen.add(statusL2);
	}
	
	/**
	 * Adds output box
	 */
	private void addTextBox() {
		output.setEditable(false);
		output.setFont(new Font("Verdana", Font.PLAIN, 13));
		scrollPane = new JScrollPane(output); 
		scrollPane.setBounds(400, 0, 400, 200);
		scrollPane.setEnabled(false);
		output.setLineWrap(true);
		output.setWrapStyleWord(true);
		screen.add(scrollPane);

	}
	
	/**
	 * Add HP Bar for both players
	 */
	private void addHpBar(){
		player1_health.setMaximum(p1Active.getMax_hp());
		player1_health.setValue(p1Active.getHp());
		player1_health.setBounds(125,300,275,15);;
		player1_health.setVisible(true);
		//player1_health.setBackground(Color.green);
		player1_health.setForeground(Color.green);
		
		screen.add(player1_health);
				
		player2_health.setMaximum(p2Active.getMax_hp());
		player2_health.setValue(p2Active.getHp());
		player2_health.setBounds(800,300,275,15);;
		player2_health.setVisible(true);
		player2_health.setForeground(Color.green);
		screen.add(player2_health);
	}
	
	/**
	 * Add labels onto screen for the name, hp current, and hp max
	 */
	private void setstatuslabels() {
		statuslabelsP1[0] = new JLabel(p1Active.getName());
		statuslabelsP1[0].setBounds(215, 255, 200, 50);
		statuslabelsP1[0].setFont(new Font("Times New Roman", Font.BOLD, 30));
		statuslabelsP1[0].setForeground(Color.WHITE);
		screen.add(statuslabelsP1[0]);
		
		statuslabelsP2[0] = new JLabel(p2Active.getName());
		statuslabelsP2[0].setBounds(885, 255, 200, 50);
		statuslabelsP2[0].setFont(new Font("Times New Roman", Font.BOLD, 30));
		statuslabelsP2[0].setForeground(Color.WHITE);
		screen.add(statuslabelsP2[0]);
		
		statuslabelsP1[1] = new JLabel(p1Active.getHp() + "/" + p1Active.getMax_hp());
		statuslabelsP1[1].setBounds(230, 310, 200, 50);
		statuslabelsP1[1].setFont(new Font("Times New Roman", Font.BOLD, 20));
		statuslabelsP1[1].setForeground(Color.WHITE);
		screen.add(statuslabelsP1[1]);
		
		statuslabelsP2[1] = new JLabel(p2Active.getHp() + "/" + p2Active.getMax_hp());
		statuslabelsP2[1].setBounds(900, 310, 200, 50);
		statuslabelsP2[1].setFont(new Font("Times New Roman", Font.BOLD, 20));
		statuslabelsP2[1].setForeground(Color.WHITE);
		screen.add(statuslabelsP2[1]);
	}
	private void addMoveButtons() {
		int temp = 0;
		for(int x = 0; x < 2; x++) {
			for(int y = 0; y < 2; y++) {
				player1Moves[temp] = new JButton(p1Active.getMoveName(temp));
				player1Moves[temp].setBounds(115 + 150 * x, 400 + 50 * y, 150, 50);
				player1Moves[temp].addActionListener(this);
				player1Moves[temp].setToolTipText(p1Active.getMoves().get(temp).toString());
				player1Moves[temp].setBackground(Color.WHITE);
				player1Moves[temp].setFont(new Font("Verdana", Font.BOLD, 13));
				screen.add(player1Moves[temp]);
				
				player2Moves[temp] = new JButton(p2Active.getMoveName(temp));
				player2Moves[temp].setBounds(805 + 150 * x, 400 + 50 * y, 150, 50);
				player2Moves[temp].addActionListener(this);
				player2Moves[temp].setToolTipText(p2Active.getMoves().get(temp).toString());
				player2Moves[temp].setBackground(Color.WHITE);
				player2Moves[temp].setFont(new Font("Verdana", Font.BOLD, 13));
				screen.add(player2Moves[temp]);
				temp++;
			}
		}
	}
	
	private void setAndAddPokemonButtons() {
		for(int i = 0; i < player1Button.length; i++){
			player1Button[i] = new JButton();
			player1Button[i].setBounds(0,100*i, 100, 100);
			player1Button[i].setIcon(PLAYER1.get(i).getImage());
			player1Button[i].addActionListener(this);
			player1Button[i].addMouseListener(this);
			player1Button[i].setToolTipText(PLAYER1.get(i).toString());
			player1Button[i].setContentAreaFilled(false);
			player1Button[i].setBorderPainted(false);
			screen.add(player1Button[i]);
		}
		for(int c = 0; c < player2Button.length; c++){
			player2Button[c] = new JButton();
			player2Button[c].setBounds(1100,100*c, 100, 100);
			player2Button[c].setIcon(PLAYER2.get(c).getImage());
			player2Button[c].addActionListener(this);
			player2Button[c].addMouseListener(this);
			player2Button[c].setToolTipText(PLAYER2.get(c).toString());
			player2Button[c].setContentAreaFilled(false);
			player2Button[c].setBorderPainted(false);
			screen.add(player2Button[c]);
		}
	}
	
	private void setPokemonIcon() {
		p1pokemonCurrentIcon = new JLabel();
		p1pokemonCurrentIcon.setIcon(p1Active.getImage());
		p1pokemonCurrentIcon.setBounds(235, 90, 200, 200);
		screen.add(p1pokemonCurrentIcon);
		
		p2pokemonCurrentIcon = new JLabel();
		p2pokemonCurrentIcon.setIcon(p2Active.getImage());
		p2pokemonCurrentIcon.setBounds(900, 90, 200, 200);
		screen.add(p2pokemonCurrentIcon);
	}
	
	public void setHpPlayer1(int move) {
		
		if(turnCounterPlayer1 > 0) {
			//Player 2 Cannot Attack
			turnCounterPlayer1--;
			if(turnCounterPlayer1 == 0) {
				output.append(player1Name + "'s " + p1Active.getName() + "is no longer" + p1Active.getStatus());
				p1Active.setStatus("");
			}
			else {
				output.append(player1Name + "'s " + p1Active.getName() + " cannot move!");
				return;
			}
		
		}
		
		Moves move_chosen = p1Active.getMove(move);
		
		int attack = p1Active.getAttack();
		int defense = p2Active.getDefense();
		int levelAttack = p1Active.getLevel();

		double stab = 1;
		
		if(p1Active.getType1().equals(move_chosen.getType()) || p1Active.getType2().equals(move_chosen.getType())){
			stab = 1.5;
		}
		int crit = critHit();
		double randomMultiplier = random();
		String critHit = "";
		
		double type = MoveType.getMult(move_chosen.getType(), p2Active.getType1(), p2Active.getType2());
		
		int power = move_chosen.getPower();
		
		double Damage = (((2 * levelAttack / 5 + 2) * attack / defense  * power) / 50 + 2) * crit * randomMultiplier * stab * type;
		
		String typeHit = "";
		
		if(type > 1.0 && Damage >= 0.9) {
			typeHit = " and it was super effective!";
		}
		
		if(type < 1.0 && type != 0 && Damage >= 0.9) {
			typeHit = " and it was not very effective...";
		}
		
		if(accuracyCalc1(move_chosen)!= true){
			typeHit = " but missed!";
			critHit = "";
			Damage = 0;
		}
		if(type == 0){
			typeHit = "..." + move_chosen.getName() + " does not affect the foe " + p2Active.getName() + newline;
		}
		else if(crit > 1) {
			critHit += " Critical Hit!";
		}
		
		p2Active.setHp((int) (p2Active.getHp() - Damage));
		if(p2Active.getHp() < 0) {
			p2Active.setHp(0);
		}
		if(Damage > 0 ) {
			setProgressBarP2();
			setHpLabelBar2();
		}
		
		output.append(player1Name + "'s " + p1Active.getName() + " used " + move_chosen.getName()  + typeHit + newline);
		output.setCaretPosition(output.getDocument().getLength());
		
		if(critHit != "" && Damage != 0) {
			output.append(critHit + newline);
		} 
		//setStatus2(Damage, move);

		checkFaint2();
	}

	public void setHpPlayer2(int move) {
		//playerAttack = the person who presses the move button
		//playerDefense = the person who is defending against that move
		if(turnCounterPlayer2 > 0) {
			//Player 2 Cannot Attack
			turnCounterPlayer2--;
			if(turnCounterPlayer2 == 0) {
				output.append(player2Name + "'s " + p2Active.getName() + " is no longer " + p2Active.getStatus() +  "!" + newline);
				p2Active.setStatus("");
			}
			else {
				output.append(player2Name + "'s " + p2Active.getName() + " cannot move!" + newline);
				return;
			}
		
		}
		Moves move_chosen = p2Active.getMove(move);
		
		int attack = p2Active.getAttack();
		int defense = p1Active.getDefense();
		int levelAttack = p2Active.getLevel();
		int power = move_chosen.getPower();
		int crit = critHit();
		double randomMultiplier = random();
		double stab = 1;
		
		if(p2Active.getType1().equals(move_chosen.getType()) || p2Active.getType2().equals(move_chosen.getType())){
			stab = 1.5;
		}
	
		double type = MoveType.getMult(move_chosen.getType(), p1Active.getType1(), p1Active.getType2());
	
		double Damage = (((2 * levelAttack / 5 + 2) * attack / defense * power ) / 50  + 2) * crit * randomMultiplier * stab * type ;
		
		String typeHit = "";
		String critHit = "";
		
		if(crit > 1) {
			critHit += "Critical Hit!";
		}
		else if(type > 1.0 ) {
			typeHit = " and it was super effective!";
		}
		else if(type < 1.0 && type != 0 ) {
			typeHit = " and it was not very effective...";
		}
		else if(type == 0){
			typeHit = newline + "..." + move_chosen.getType() + " does not affect the foe " + p1Active.getName();
		}
		if(accuracyCalc2(move_chosen)!= true){
			typeHit = " but missed!";
			critHit = "";
			Damage = 0;
		}
		 
		p1Active.setHp(p1Active.getHp() - (int)Damage);
		if(p1Active.getHp() <= 0) {
			p1Active.setHp(0);
		}
		if(Damage > 0) {
			setProgressBarP1();
			setHpLabelBar1();
		}
		output.append(player2Name + "'s " + p2Active.getName() + " used " + move_chosen.getName() + typeHit + "!" +  newline);
		output.setCaretPosition(output.getDocument().getLength());
		
		if(critHit != "" && Damage != 0) {
			output.append(critHit + newline);
		}
		checkFaint1();
		//setStatus1(Damage, move_chosen);
	
		}
	
	/**
	 * 
	 * @param damage
	 * @param move
	 */
	private void setStatus1(double damage, Moves move_chosen) {		
		
		if(!p1Active.isFaint() && damage != 0 &&  p1Active.getStatus().equals("")){
				if(r.nextInt(150) < 20) {
					if(move_chosen.getType().equals("Fire")) {
						p1Active.setStatus("Burned");
						p1Active.setHp(p1Active.getHp() - 7);
						setProgressBarP1();	
						statusL1.setIcon(burnedSymbol);
						output.append(p1Active.getName() + " was burned!" + newline);
						checkFaint1();
					}
					if(move_chosen.getType() == "Ice") {
						p1Active.setStatus("Frozen");
						output.append(p1Active.getName() + " was frozen!" + newline);
						statusL1.setIcon(frozenSymbol);
						turnCounterPlayer1 = r.nextInt(2) + 2;
					}
					if(move_chosen.getType() == "Electric") {
						p1Active.setStatus("Paralyzed");
						turnCounterPlayer1 = r.nextInt(2) + 2;
						statusL1.setIcon(paralyzedSymbol);
						output.append(p1Active.getName() + " was paralyzed!" + newline);
					}
					if(move_chosen.getType() == "Poison") {
						p1Active.setStatus("Poisoned");
						p1Active.setHp(p1Active.getHp() - 8);
						setProgressBarP1();	
						statusL1.setIcon(poisonSymbol); 
						output.append(move_chosen.getName() + " was poisoned!" + newline);
						checkFaint1();
					}
				}
			}
			
	}
	private void setStatus2(double Damage, int move1) {
		Moves move_chosen = p1Active.getMove(move1);

		if(!p2Active.isFaint() && Damage != 0 &&  p2Active.getStatus().equals("")){
				if(r.nextInt(150) < 20) {
					if(move_chosen.getType().equals("Fire")) {
						p2Active.setStatus("Burned");
						p2Active.setHp(p2Active.getHp() - 7);
						setProgressBarP2();	
						statusL2.setIcon(burnedSymbol);
						output.append(p2Active.getName() + " was burned!" + newline);
						checkFaint2();
					}
					else if(move_chosen.getType().equals("Ice")) {
						p2Active.setStatus("Frozen");
						output.append(p2Active.getName() + " was frozen!" + newline);
						statusL2.setIcon(frozenSymbol);
						turnCounterPlayer2 = r.nextInt(2) + 1;
					}
					else if(move_chosen.getType().equals("Electric")) {
						p2Active.setStatus("Paralyzed");
						output.append(p2Active.getName() + " was paralyzed!" + newline);
						statusL2.setIcon(paralyzedSymbol);
						turnCounterPlayer2 = r.nextInt(2) + 1;
					}
					else if(move_chosen.getType().equals("Poison")) {
						p2Active.setStatus("Poisoned");
						p2Active.setHp(p2Active.getHp() -  9);
						setProgressBarP2();	
						statusL2.setIcon(poisonSymbol); 
						output.append(p2Active.getName() + " was poisoned!" + newline);
						checkFaint2();
					}
				}
			}
			
	}
	private void checkStatusUpdate1() {
		if(!p1Active.isFaint()  && !p1Active.getStatus().equals("")) { //not fainted and has a status
			if(p1Active.getStatus().equals("Burned")) {
				p1Active.setHp(p1Active.getHp() - 7);
				setProgressBarP1();	
				setHpLabelBar1();
				output.append(p1Active.getName() + " is hurt by its burn!" + newline);
				checkFaint1(); // check setStatus, input if statement saying if fainted dont do this method
			}
			else if(p1Active.getStatus().equals("Frozen")) {
				output.append(p1Active.getName() + " is frozen, and can't move!" + newline);
			}
			else if(p1Active.getStatus().equals("Paralyzed")) {
				output.append(p1Active.getName() + " is paralyzed, and can't move!" + newline);
			}
			else if(p1Active.getStatus().equals("Poisoned")) {
				p1Active.setHp(p1Active.getHp() - 9);
				setHpLabelBar1();
				setProgressBarP1();	
				output.append(p1Active.getName() + " is hurt by its poison!" + newline);
				checkFaint1();
			}
		}
	}
	private void checkStatusUpdate2() {
		if(!p2Active.isFaint() && !p2Active.getStatus().equals("")) {
			if(p2Active.getStatus().equals("Burned")) {
				p2Active.setHp(p2Active.getHp() -  7);
				setProgressBarP2();	
				setHpLabelBar2();
				output.append(p2Active.getName() + " is hurt by its burn!" + newline);
				checkFaint2();
			}
			else if(p2Active.getStatus().equals("Frozen")) {
				output.append(p2Active.getName() + " is frozen, and can't move!" + newline);
			}
			else if(p2Active.getStatus().equals("Paralyzed")) {
				output.append(p2Active.getName() + " is paralyzed, and can't move!" + newline);
			}
			else if(p2Active.getStatus().equals("Poisoned")) {
				p2Active.setHp(p2Active.getHp() - 9);
				setHpLabelBar2();
				setProgressBarP2();	
				output.append(p2Active.getName() + " is hurt by its poison!" + newline);
				checkFaint2();
			}
		}
	}
	private void checkFaint1() {
		if(p1Active.getHp() < 0.9) {			
			player1Button[PLAYER1.indexOf(p1Active)].removeActionListener(this);
			player1MovesToggle(false);
			p1Active.setFaint(true);
		}
	}
	private void checkFaint2() {
		if(p2Active.getHp() < 0.9) {	
			player2Button[PLAYER2.indexOf(p2Active)].removeActionListener(this);
			player2MovesToggle(false);
			p2Active.setFaint(true);
		}
	

	}

	private boolean accuracyCalc1(Moves move){
		
		int x = move.getAccuracy();
		if(r.nextInt(100) < x)
			return true;
		return false;
	}
	
	
	private boolean accuracyCalc2(Moves move){
		int x = move.getAccuracy();
		if(r.nextInt(100) < x)
			return true;
		return false;
	}
	
	
	private void player2MovesToggle(boolean b) {
		for ( int x = 0; x < player2Moves.length; x++){
			player2Moves[x].setVisible(b);
		}
		
	}
	
	
	private void player1MovesToggle(boolean b) {
		for ( int x = 0; x < player1Moves.length; x++){
			player1Moves[x].setVisible(b);
		}
		
	}
	private void setHpLabelBar1() {
		
	}
	private void setHpLabelBar2() {

	}
	private void setProgressBarP1() {
		t.start();
	}
	
	
	private void setProgressBarP2() {
		t2.start();
	}
	
	
	private double random(){
		double num = 0;
		while(num < 0.85 )
			 num = Math.random();
		
		return num;
		
	}
	
	
	private int critHit() {
		int num = r.nextInt(100);
		if(num < 10){
			return 2;
		}
		return 1;	
	}
	
	
	public void switchPokemonPlayer1(PokemonObject newPoke){

		player1_health.setMaximum(newPoke.getMax_hp());
		player1_health.setValue(newPoke.getHp());
		if(player1_health.getValue() >= p1Active.getMax_hp() / 2) {
			player1_health.setForeground(Color.green);
		}
		else if(player1_health.getValue() < p1Active.getMax_hp() / 2 && player1_health.getValue() > 0.2 * p1Active.getMax_hp()) {
			player1_health.setForeground(Color.yellow);
		}
		else {
			player1_health.setForeground(Color.red);
		}
		statusL1.setIcon(null); 
		statusL1.setIcon(newPoke.getStatusImage());
		
	
		p1pokemonCurrentIcon.setIcon(player1Button[PLAYER1.indexOf(newPoke)].getIcon());	
		
		for(int x = 0; x < player1Moves.length; x++) {
			player1Moves[x].setText(newPoke.getMoveName(x)); //Change Move Buttons
			player1Moves[x].setToolTipText(newPoke.getMove(x).toString());
		}
		
		statuslabelsP1[0].setText(newPoke.getName()); //Change Name
		
		if(p1Active.isFaint()){
			player1MovesToggle(true);
			player2MovesToggle(false);
		}
		else if (!p1Active.isFaint()){
			player1MovesToggle(false);
			player2MovesToggle(true);
		}
		output.append(player1Name + " switched out " + p1Active.getName() + " for " + newPoke.getName()  + "!" + newline);
		

		
		statuslabelsP1[1].setText(newPoke.getHp() + "/" + newPoke.getMax_hp());
		
		p1Active = newPoke;
		
		player1MoveSave = -1;
		screen.requestFocusInWindow();
		screen.setFocusable(true);
		//checkStatusUpdate2();
		
	}
	public void switchPokemonPlayer2(PokemonObject newPoke){
		
		player2_health.setMaximum(newPoke.getMax_hp());
		player2_health.setValue(newPoke.getHp());
		if(player2_health.getValue() >= p2Active.getMax_hp() / 2) {
			player2_health.setForeground(Color.green);
		}
		else if(player2_health.getValue() < p2Active.getMax_hp() / 2 && player2_health.getValue() > 0.2 * p2Active.getMax_hp()) {
			player2_health.setForeground(Color.yellow);
		}
		else {
			player2_health.setForeground(Color.red);
		}
		statusL2.setIcon(null);
		
		statusL2.setIcon(newPoke.getStatusImage());
		p2pokemonCurrentIcon.setIcon(player2Button[PLAYER2.indexOf(newPoke)].getIcon());
		
		for(int x = 0; x < player2Moves.length; x++) {
			player2Moves[x].setText(newPoke.getMoveName(x)); //Change Move Buttons
			player2Moves[x].setToolTipText(newPoke.getMove(x).toString());
		}
		
		statuslabelsP2[0].setText(newPoke.getName()); //Change Name
		
		if(p2Active.isFaint()){
			player2MovesToggle(false);
			player1MovesToggle(true);
		}
		else if (!p2Active.isFaint()){
			player2MovesToggle(false);
			player1MovesToggle(true);
		}
		output.append(player2Name + " switched out " + p2Active.getName() + " for " + newPoke.getName()  + "!" + newline);
		
		statuslabelsP2[1].setText(newPoke.getHp() + "/" + newPoke.getMax_hp());
		
		boolean switched_at_death = false;
		
		if(p2Active.isFaint()) {
			switched_at_death = true;
		}
		
		p2Active = newPoke;
		
		player2MoveSave =  -1;
		
		if(!switched_at_death) {
			determineAttack();
		}
		screen.requestFocusInWindow();
		screen.setFocusable(true);

		
	}
//	public void mouseClicked(MouseEvent e) {
//		for(int x = 0; x < player1Button.length; x++){
//			if(e.getSource() == player1Button[x]){
//				switchPokemonPlayer1(PLAYER1.get(x));
//			}
//		}
//		for(int y = 0; y < player2Button.length; y++){
//			if(e.getSource() == player2Button[y]){
//				switchPokemonPlayer2(PLAYER2.get(y));
//			}
//		}
//		
//		for(int q = 0; q < player1Moves.length; q++ ){
//			if(e.getSource() == player1Moves[q]){
//				player1MoveSave = q;
//			player2MovesToggle(true);
//			player1MovesToggle(false);
//			}
//		}
//		for(int q = 0; q < player2Moves.length; q++ ){
//			if(e.getSource() == player2Moves[q]){
//				player2MoveSave = q;
//				player2MovesToggle(false);
//				player1MovesToggle(true);
//				determineAttack();
//			}
//		}
//	}
	private void determineAttack() {

			if(player1MoveSave >= 0 && player2MoveSave >= 0) {
				if(p1Active.getSpeed() < p2Active.getSpeed()) {
					setHpPlayer2(player2MoveSave);
					if(!p1Active.isFaint())
						setHpPlayer1(player1MoveSave);
				}
				else if(p1Active.getSpeed() > p2Active.getSpeed()){
					setHpPlayer1(player1MoveSave);
					if(!p2Active.isFaint())
						setHpPlayer2(player2MoveSave);
				}	
				else {
					if(r.nextInt(2) < 1){
						setHpPlayer1(player1MoveSave);
						if(!p2Active.isFaint())
							setHpPlayer2(player2MoveSave);
					}
					else {
						setHpPlayer2(player2MoveSave);
						if(!p1Active.isFaint())
							setHpPlayer1(player1MoveSave);
					}
				}
				player1MovesToggle(true);
				player2MovesToggle(false);
				if(p1Active.isFaint()|| p2Active.isFaint()) {
					player1MovesToggle(false);
				}
			}
			else if(player2MoveSave < 0 && player1MoveSave < 0) {
				player1MovesToggle(true);
				player2MovesToggle(false);
			}
			else if(player2MoveSave < 0 ){
				setHpPlayer1(player1MoveSave);
			}
			else if(player1MoveSave < 0) {
				setHpPlayer2(player2MoveSave);
			}
		
		checkStatusUpdate1();
		checkStatusUpdate2();
		output.append(newline);
	}
//	@Override
//	public void mousePressed(MouseEvent e) {
//		
//	}
//
//	@Override
//	public void mouseReleased(MouseEvent e) {
//		
//	}
//
//	@Override
//	public void mouseEntered(MouseEvent e) {
//
//	}
//	@Override
//	public void mouseExited(MouseEvent e) {
//		
//	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == t) {
			if(player1_health.getValue() > p1Active.getHp()){
				player1_health.setValue(player1_health.getValue() - 1);
				statuslabelsP1[1].setText(player1_health.getValue() + "/" + p1Active.getMax_hp());
				if(player1_health.getValue() <= p1Active.getMax_hp() / 2 && player1_health.getValue() >= 0.2 * p1Active.getMax_hp()) {
					player1_health.setForeground(Color.YELLOW);
				}
				else if(player1_health.getValue() < 0.20 * p1Active.getMax_hp()) {
					player1_health.setForeground(Color.RED);
				}
			}
			else {

				if(player1_health.getValue() <= 0) {
					p1pokemonCurrentIcon.setIcon(null);
					output.append(player1Name + "'s " + p1Active.getName() + " fainted! Choose another pokemon!" + newline);
					player1Button[PLAYER1.indexOf(p1Active)].setEnabled(false);
				}
				t.stop();
			}
		}	
		else if(e.getSource() == t2) {
			if(player2_health.getValue() > p2Active.getHp()){
				player2_health.setValue(player2_health.getValue() - 1);
				statuslabelsP2[1].setText(player2_health.getValue()+ "/" + p2Active.getMax_hp());
				if(player2_health.getValue() <= p2Active.getMax_hp() / 2 && player2_health.getValue() >= 0.2 * p2Active.getMax_hp()) {
					player2_health.setForeground(Color.YELLOW);
				}
				else if(player2_health.getValue() < 0.20 * p2Active.getMax_hp()) {
					player2_health.setForeground(Color.RED);
				}
			}
			else {
				if(player2_health.getValue() == 0) {
					p2pokemonCurrentIcon.setIcon(null);
					output.append(player2Name + "'s " + p2Active.getName() + " fainted! Choose another pokemon!" + newline);
					player2Button[PLAYER2.indexOf(p2Active)].setEnabled(false);
				}
				t2.stop();
			}
		}
		for(int x = 0; x < player1Button.length; x++){
			if(e.getSource() == player1Button[x]){
				switchPokemonPlayer1(PLAYER1.get(x));
			}
		}
		for(int y = 0; y < player2Button.length; y++){
			if(e.getSource() == player2Button[y]){
				switchPokemonPlayer2(PLAYER2.get(y));
			}
		}
		
		for(int q = 0; q < player1Moves.length; q++ ){
			if(e.getSource() == player1Moves[q]){
				player1MoveSave = q;
			player2MovesToggle(true);
			player1MovesToggle(false);
			}
		}
		for(int q = 0; q < player2Moves.length; q++ ){
			if(e.getSource() == player2Moves[q]){
				player2MoveSave = q;
				player2MovesToggle(false);
				player1MovesToggle(true);
				determineAttack();
			}
		}
	}

	public void keyTyped(KeyEvent e) {
		
		
	}

	public void keyPressed(KeyEvent e) {
		
			if(e.getKeyCode() == KeyEvent.VK_Q) {
				if(player1Moves[0].isVisible()){
					
					player1MoveSave = 0;
					player2MovesToggle(true);
					player1MovesToggle(false);
				}
				

			}
			if(e.getKeyCode() == KeyEvent.VK_A) {
				if(player1Moves[1].isVisible()){
					player1MoveSave = 1;
					player2MovesToggle(true);
					player1MovesToggle(false);
				}
			}
			if(e.getKeyCode() == KeyEvent.VK_W) {
				if(player1Moves[2].isVisible()){
					player1MoveSave = 2;
					player2MovesToggle(true);
					player1MovesToggle(false);
					
				}
			}
			if(e.getKeyCode() == KeyEvent.VK_S) {
				if(player1Moves[3].isVisible()){
					player1MoveSave = 3;
					player2MovesToggle(true);
					player1MovesToggle(false);
				}
			}
			if(e.getKeyCode() == KeyEvent.VK_O) {
				if(player2Moves[0].isVisible()){
					player2MoveSave = 0;
					player2MovesToggle(false);
					player1MovesToggle(true);
					determineAttack();
				}
	
			}
			if(e.getKeyCode() == KeyEvent.VK_K) {
				if(player2Moves[1].isVisible()){
					player2MoveSave = 1;
					player2MovesToggle(false);
					player1MovesToggle(true);
					determineAttack();
				}
			}
			if(e.getKeyCode() == KeyEvent.VK_P) {
				if(player2Moves[2].isVisible()){
					player2MoveSave = 2;
					player2MovesToggle(false);
					player1MovesToggle(true);
					determineAttack();
					
				}
			}
			if(e.getKeyCode() == KeyEvent.VK_L) {
				if(player2Moves[3].isVisible()){
					player2MoveSave = 3;
					player2MovesToggle(false);
					player1MovesToggle(true);
					determineAttack();
				}
			}
			
	

	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		for(int i = 0; i < player1Button.length; i++) {
			if(e.getSource() == player1Button[i]) {
				player1Button[i].setContentAreaFilled(true);
				player1Button[i].setBackground(Color.YELLOW);
			}
			if(e.getSource() == player2Button[i]) {
				player2Button[i].setContentAreaFilled(true);
				player2Button[i].setBackground(Color.YELLOW);
			}
		}
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		for(int i = 0; i < player1Button.length; i++) {
			if(e.getSource() == player1Button[i]) {
				player1Button[i].setContentAreaFilled(false);
				player1Button[i].setBackground(null);
			}
			if(e.getSource() == player2Button[i]) {
				player2Button[i].setContentAreaFilled(false);
				player2Button[i].setBackground(null);
			}
		}
		
		
	}
}