package pokemon_tournament;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import PokemonObjects.Ampharos;
import PokemonObjects.Arcanine;
import PokemonObjects.Blastoise;
import PokemonObjects.Butterfree;
import PokemonObjects.Charizard;
import PokemonObjects.Cloyster;
import PokemonObjects.Dialga;
import PokemonObjects.Dragonite;
import PokemonObjects.Eevee;
import PokemonObjects.Flareon;
import PokemonObjects.Flygon;
import PokemonObjects.Gardevoir;
import PokemonObjects.Gengar;
import PokemonObjects.Giratina;
import PokemonObjects.Golem;
import PokemonObjects.Gyarados;
import PokemonObjects.Infernape;
import PokemonObjects.Jirachi;
import PokemonObjects.Jolteon;
import PokemonObjects.Lapras;
import PokemonObjects.Luxray;
import PokemonObjects.Machamp;
import PokemonObjects.Magneton;
import PokemonObjects.Manectric;
import PokemonObjects.Mewtwo;
import PokemonObjects.Nidoking;
import PokemonObjects.Ninetales;
import PokemonObjects.Onix;
import PokemonObjects.Palkia;
import PokemonObjects.Pidgeot;
import PokemonObjects.Pikachu;
import PokemonObjects.PokemonObject;
import PokemonObjects.Psyduck;
import PokemonObjects.Rapidash;
import PokemonObjects.Salamence;
import PokemonObjects.Scyther;
import PokemonObjects.Shaymin;
import PokemonObjects.Snorlax;
import PokemonObjects.Steelix;
import PokemonObjects.Typhlosion;
import PokemonObjects.Vaporeon;
import PokemonObjects.Venusaur;

public class TournamentHome implements KeyListener, MouseListener {
	private JPanel home = new JPanel();
	private JPanel title = new JPanel();
	private JPanel mainPanel = new JPanel();
	
	private JFrame frame = new JFrame();
	
	private static int TOTALPOKEMON = 41;
	
	private String namePlayer1 = "Player 1";
	private String namePlayer2 = "Player 2";
	
	private JLabel pickPoke = new JLabel();
	
	private JLabel[] p1ChosenPics = new JLabel[6];
	private JLabel[] p2ChosenPics = new JLabel[6];
	
	private JButton Random1 = new JButton("PICK RANDOM FOR EACH PLAYER");
	
	private int[] rPokemon = new int[12];
	
	private JButton[] pokemonButton = new JButton[TOTALPOKEMON];
	
	private ArrayList<PokemonObject> pokemonobjects= new ArrayList<PokemonObject>();
	private ArrayList<PokemonObject> player1 = new ArrayList<PokemonObject>();
	private ArrayList<PokemonObject> player2 = new ArrayList<PokemonObject>();
	
	private int firstChooserOfPokemon = 0;
	private int secondChooserOfPokemon = 0;
	
	private JLabel playername1;
	private JLabel playername2;
	
	private JScrollPane jsp = new JScrollPane(home);
	
	private ArrayList<ArrayList<PokemonObject>> gymleaders;
	private ArrayList<String> gymLeaderNames;
	
	
	public static enum MODE {
		SinglePlayer, DoublePlayer
	}
	public MODE mode;
	
	private static int pCounter = 0;
		
		public TournamentHome(MODE mode) {
		
			this.mode = mode;
			if(mode == MODE.DoublePlayer) {
				setUpDoublePlayer();
			}
			else if(mode == MODE.SinglePlayer) {
				setUpSinglePlayer();
			}
			
		}
		private void setUpSinglePlayer()  {
			namePlayer1 = JOptionPane.showInputDialog("Please enter your name!");
			
			gymleaders = GymLeaders.getGymLeaders();
			gymLeaderNames = GymLeaders.getGymLeaderNames();
			
			namePlayer2 = gymLeaderNames.get(0);
			player2 = gymleaders.get(0);
			
			pokemonobjects.add(new Arcanine());
			pokemonobjects.add(new Blastoise());
			pokemonobjects.add(new Butterfree());
			pokemonobjects.add(new Charizard());
			pokemonobjects.add(new Dragonite());
			pokemonobjects.add(new Eevee());
			pokemonobjects.add(new Flareon());
			pokemonobjects.add(new Gengar());
			pokemonobjects.add(new Golem());
			pokemonobjects.add(new Jolteon());
			pokemonobjects.add(new Lapras());
			pokemonobjects.add(new Machamp());
			pokemonobjects.add(new Magneton());
			pokemonobjects.add(new Nidoking());
			pokemonobjects.add(new Snorlax());
			pokemonobjects.add(new Ninetales());
			pokemonobjects.add(new Onix());
			pokemonobjects.add(new Pidgeot());
			pokemonobjects.add(new Pikachu());
			pokemonobjects.add(new Psyduck());
			pokemonobjects.add(new Rapidash());
			pokemonobjects.add(new Salamence());
			pokemonobjects.add(new Scyther());
			pokemonobjects.add(new Vaporeon());
			pokemonobjects.add(new Venusaur());
			pokemonobjects.add(new Flygon());
			pokemonobjects.add(new Palkia());
			pokemonobjects.add(new Dialga());
			pokemonobjects.add(new Giratina());
			pokemonobjects.add(new Shaymin());
			pokemonobjects.add(new Mewtwo());
			pokemonobjects.add(new Jirachi());
			pokemonobjects.add(new Typhlosion());
			pokemonobjects.add(new Infernape());
			pokemonobjects.add(new Cloyster());
			pokemonobjects.add(new Gyarados());
			pokemonobjects.add(new Gardevoir());
			pokemonobjects.add(new Steelix());
			pokemonobjects.add(new Ampharos());
			pokemonobjects.add(new Manectric());
			pokemonobjects.add(new Luxray());
			for( int y = 0; y < pokemonButton.length; y++) {
				pokemonButton[y] = new JButton();
			}
			
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			frame.setSize(new Dimension((int)screenSize.getWidth(), (int)screenSize.getHeight()));
			frame.setLocationRelativeTo(null);
			frame.setResizable(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.addKeyListener(this);
			
			mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
			
			title.setLayout(null);
			title.setPreferredSize(new Dimension(1200, 200));
			title.setBackground(Color.black);
			
		    pickPoke.setBounds(0,0,(int)screenSize.getWidth(),50);
		    pickPoke.setHorizontalAlignment(SwingConstants.CENTER);
		    pickPoke.setFont(new Font("Times New Roman", Font.BOLD, 30));
		    pickPoke.setForeground(Color.yellow);
		    pickPoke.setVisible(true);
		    pickPoke.setText(namePlayer1 + " -- Pick a pokemon!");
		    title.add(pickPoke);
		    
		    playername1 = new JLabel(namePlayer1);
		    playername1.setBounds(150,0,500,150);
		    playername1.setFont(new Font("Times New Roman", Font.BOLD, 100));
		    playername1.setForeground(Color.white);
		    title.add(playername1);
			
		    playername2 = new JLabel(namePlayer2);
		    playername2.setBounds((int)screenSize.getWidth() -  600 ,0,500,150);
		    playername2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		    playername2.setFont(new Font("Times New Roman", Font.BOLD, 100));
		    playername2.setForeground(Color.white);
		    title.add(playername2);
		    
		    for(int i = 0; i < p1ChosenPics.length; i++) {
		    	p1ChosenPics[i] = new JLabel();
		    	p1ChosenPics[i].setBounds( 25  + 100 * i, 0 , 100, 150);
		    	title.add(p1ChosenPics[i]);
		    	
		    	p2ChosenPics[i] = new JLabel();
		    	p2ChosenPics[i].setBounds((int) screenSize.getWidth() - 100 - i * 100, 0, 100, 150 );
		    	p2ChosenPics[i].setIcon(player2.get(i).getImage());
		    	title.add(p2ChosenPics[i]);
		    }
		    
			home.setLayout(new FlowLayout());
			home.setPreferredSize(new Dimension((int)screenSize.getWidth(), (int) screenSize.getHeight()));
		    home.setBackground(Color.black);
		    
		    Random1.setPreferredSize(new Dimension((int) screenSize.getWidth() - 50, 50));
		    Random1.setForeground(Color.blue);
		    Random1.setBackground(Color.red);
		    home.add(Random1);
		    Random1.addMouseListener(this);
		    
		    for(int counter = 0; counter < pokemonButton.length; counter++) {
		    	pokemonButton[counter].setPreferredSize(new Dimension(150,150));
	    		pokemonButton[counter].setBackground(Color.black);
	    		pokemonButton[counter].setForeground(Color.white);
	    		pokemonButton[counter].setOpaque(true);
	    		pokemonButton[counter].setIcon(pokemonobjects.get(counter).getImage());
	    		pokemonButton[counter].addMouseListener(this);
	    		home.add(pokemonButton[counter]);
		    }
		    
			jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			
			mainPanel.add(title);
			mainPanel.add(jsp);
			
			frame.add(mainPanel);
			
			home.setVisible(true);
			frame.setVisible(true);;
		}
		private void setUpDoublePlayer() {
			
			namePlayer1 = JOptionPane.showInputDialog("Please Enter Player 1's Name");
			
			namePlayer2 = JOptionPane.showInputDialog("Please Enter Player 2's Name");
			
			pokemonobjects.add(new Arcanine());
			pokemonobjects.add(new Blastoise());
			pokemonobjects.add(new Butterfree());
			pokemonobjects.add(new Charizard());
			pokemonobjects.add(new Dragonite());
			pokemonobjects.add(new Eevee());
			pokemonobjects.add(new Flareon());
			pokemonobjects.add(new Gengar());
			pokemonobjects.add(new Golem());
			pokemonobjects.add(new Jolteon());
			pokemonobjects.add(new Lapras());
			pokemonobjects.add(new Machamp());
			pokemonobjects.add(new Magneton());
			pokemonobjects.add(new Nidoking());
			pokemonobjects.add(new Snorlax());
			pokemonobjects.add(new Ninetales());
			pokemonobjects.add(new Onix());
			pokemonobjects.add(new Pidgeot());
			pokemonobjects.add(new Pikachu());
			pokemonobjects.add(new Psyduck());
			pokemonobjects.add(new Rapidash());
			pokemonobjects.add(new Salamence());
			pokemonobjects.add(new Scyther());
			pokemonobjects.add(new Vaporeon());
			pokemonobjects.add(new Venusaur());
			pokemonobjects.add(new Flygon());
			pokemonobjects.add(new Palkia());
			pokemonobjects.add(new Dialga());
			pokemonobjects.add(new Giratina());
			pokemonobjects.add(new Shaymin());
			pokemonobjects.add(new Mewtwo());
			pokemonobjects.add(new Jirachi());
			pokemonobjects.add(new Typhlosion());
			pokemonobjects.add(new Infernape());
			pokemonobjects.add(new Cloyster());
			pokemonobjects.add(new Gyarados());
			pokemonobjects.add(new Gardevoir());
			pokemonobjects.add(new Steelix());
			pokemonobjects.add(new Ampharos());
			pokemonobjects.add(new Manectric());
			pokemonobjects.add(new Luxray());
			
			for( int y = 0; y < pokemonButton.length; y++) {
				pokemonButton[y] = new JButton();
			}
			
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			frame.setSize(new Dimension((int)screenSize.getWidth(), (int)screenSize.getHeight()));
			frame.setLocationRelativeTo(null);
			frame.setResizable(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.addKeyListener(this);
			
			mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
			
			title.setLayout(null);
			title.setPreferredSize(new Dimension(1200, 200));
			title.setBackground(Color.black);
			
		    pickPoke.setBounds(0,0,(int)screenSize.getWidth(),50);
		    pickPoke.setHorizontalAlignment(SwingConstants.CENTER);
		    pickPoke.setFont(new Font("Times New Roman", Font.BOLD, 30));
		    pickPoke.setForeground(Color.yellow);
		    pickPoke.setVisible(true);
		    pickPoke.setText(namePlayer1 + " -- Pick a pokemon!");
		    title.add(pickPoke);
		    
		    playername1 = new JLabel(namePlayer1);
		    playername1.setBounds(150,0,500,150);
		    playername1.setFont(new Font("Times New Roman", Font.BOLD, 100));
		    playername1.setForeground(Color.white);
		    title.add(playername1);
			
		    playername2 = new JLabel(namePlayer2);
		    playername2.setBounds((int)screenSize.getWidth() -  600 ,0,500,150);
		    playername2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		    playername2.setFont(new Font("Times New Roman", Font.BOLD, 100));
		    playername2.setForeground(Color.white);
		    title.add(playername2);
		    
		    for(int i = 0; i < p1ChosenPics.length; i++) {
		    	p1ChosenPics[i] = new JLabel();
		    	p1ChosenPics[i].setBounds( 25  + 100 * i, 0 , 100, 150);
		    	title.add(p1ChosenPics[i]);
		    	
		    	p2ChosenPics[i] = new JLabel();
		    	p2ChosenPics[i].setBounds((int) screenSize.getWidth() - 100 - i * 100, 0, 100, 150 );
		    	title.add(p2ChosenPics[i]);
		    }
		    
			home.setLayout(new FlowLayout());
			home.setPreferredSize(new Dimension((int)screenSize.getWidth(), (int) screenSize.getHeight()));
		    home.setBackground(Color.black);
		    
		    Random1.setPreferredSize(new Dimension((int) screenSize.getWidth() - 50, 50));
		    Random1.setForeground(Color.blue);
		    Random1.setBackground(Color.red);
		    home.add(Random1);
		    Random1.addMouseListener(this);
		    
		    Random r = new Random();
		    if(r.nextInt(2) == 1 ) {
		    	firstChooserOfPokemon = 1;
		    	secondChooserOfPokemon = 0;
		    }
		    else {
		    	firstChooserOfPokemon = 0;
		    	secondChooserOfPokemon = 1;
		    	pickPoke.setText(namePlayer2 + " -- Pick a pokemon!");
		    }
		    
		    for(int counter = 0; counter < pokemonButton.length; counter++) {
		    	pokemonButton[counter].setPreferredSize(new Dimension(150,150));
	    		pokemonButton[counter].setBackground(Color.black);
	    		pokemonButton[counter].setForeground(Color.white);
	    		pokemonButton[counter].setOpaque(true);
	    		pokemonButton[counter].setIcon(pokemonobjects.get(counter).getImage());
	    		pokemonButton[counter].addMouseListener(this);
	    		home.add(pokemonButton[counter]);
		    }
		    
			jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			
			mainPanel.add(title);
			mainPanel.add(jsp);
			
			frame.add(mainPanel);
			
			home.setVisible(true);
			frame.setVisible(true);;
		}
		@Override
		public void keyPressed(KeyEvent arg0) {
			
		}
		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			
			if(mode == MODE.DoublePlayer) { 	
				for(int i = 0; i < pokemonButton.length; i++) {
					if(e.getSource() == pokemonButton[i]){
						if(pokemonButton[i].isEnabled()){
							pCounter++;
	
							if(pCounter % 2 == firstChooserOfPokemon) {
								player1.add(pokemonobjects.get(i));
								
								pokemonButton[i].setEnabled(false);	
								pickPoke.setText(namePlayer2 + " -- Pick a pokemon!");
								pickPoke.setForeground(Color.yellow);
								Random1.setVisible(false);
								
								p1ChosenPics[player1.size() - 1].setIcon(pokemonButton[i].getIcon());
										
								home.remove(pokemonButton[i]);
							}
							if(pCounter % 2 == secondChooserOfPokemon) {
								player2.add(pokemonobjects.get(i));
								pokemonButton[i].setEnabled(false);
								pickPoke.setText(namePlayer1 + " -- Pick a pokemon");
								pickPoke.setForeground(Color.red);
								
								p2ChosenPics[player2.size() - 1].setIcon(pokemonButton[i].getIcon());
								
								home.remove(pokemonButton[i]);
							}
							if(pCounter == 12) {
								new PokemonGameScreen(player1, player2, namePlayer1, namePlayer2);
							
								frame.dispose();
							}
						}
					}
				}
				if (e.getSource() == Random1) {
					pickPoke.setVisible(false);
					Random r = new Random();
					int choice = 0;
						for(int y = 0; y < 6; y++) {
								choice = r.nextInt(TOTALPOKEMON);
								while(numFinder(choice, rPokemon)){
									choice = r.nextInt(TOTALPOKEMON);
								}
								rPokemon[y] = choice;
								player1.add(pokemonobjects.get(choice));
								pokemonButton[choice].setEnabled(false);
						}
						pickPoke.setVisible(false);
						pCounter = 6;
						Random1.setVisible(false);
		
					choice = 0;
						for(int y = 6; y < 12; y++) {
								choice = r.nextInt(TOTALPOKEMON);
								while(numFinder(choice, rPokemon)){
									choice = r.nextInt(TOTALPOKEMON);
								}
								rPokemon[y] = choice;
								player2.add(pokemonobjects.get(choice));
								pokemonButton[choice].setEnabled(false);
							
						}
						frame.dispose(); 
						new PokemonGameScreen(player1, player2, namePlayer1, namePlayer2);
				}
			}	
			else if(mode == MODE.SinglePlayer) {
				for(int i = 0; i < pokemonButton.length; i++) {
					if(e.getSource() == pokemonButton[i]){
						if(pokemonButton[i].isEnabled()){
							pCounter++;

								pokemonButton[i].setEnabled(false);	
								pickPoke.setText(namePlayer2 + " -- Pick" + (6 - pCounter) + "more pokemon!");
								pickPoke.setForeground(Color.yellow);
								Random1.setVisible(false);
								player1.add(pokemonobjects.get(i));
								p1ChosenPics[player1.size() - 1].setIcon(pokemonButton[i].getIcon());
										
								home.remove(pokemonButton[i]);
							
							if(pCounter == 6) {
								new SinglePlayer(player1, namePlayer1, gymleaders, gymLeaderNames );
							
								frame.dispose();
							}
						}
					}
				}
				if (e.getSource() == Random1) {
					pickPoke.setVisible(false);
					Random r = new Random();
					int choice = 0;
						for(int y = 0; y < 6; y++) {
								choice = r.nextInt(TOTALPOKEMON);
								while(numFinder(choice, rPokemon)){
									choice = r.nextInt(TOTALPOKEMON);
								}
								rPokemon[y] = choice;
								player1.add(pokemonobjects.get(choice));
								pokemonButton[choice].setEnabled(false);
						}
						pickPoke.setVisible(false);
						pCounter = 6;
						Random1.setVisible(false);
		

						frame.dispose(); 
						new SinglePlayer(player1, namePlayer1, gymleaders, gymLeaderNames);
				}
			}
		}
		private boolean numFinder (int num, int[] array) {
			for(int y = 0; y < array.length; y++){
				if(num == array[y]) {
					return true;
				}
			}
				return false;
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			for(int i = 0; i < pokemonButton.length; i++) {
				if(e.getSource() == pokemonButton[i]){
					if(pCounter % 2 == firstChooserOfPokemon) {
						pokemonButton[i].setBackground(Color.yellow);
					}
					if(pCounter  % 2 == secondChooserOfPokemon) {
						pokemonButton[i].setBackground(Color.red);
					}
					if(pCounter == 12) {
						frame.dispose();
					}
				}
			}
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			for(int i = 0; i < pokemonButton.length; i++) {
				if(e.getSource() == pokemonButton[i]){
					pokemonButton[i].setBackground(Color.black);
				}
			}
			
		}
		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		public static void main(String[] args0){
		try {
	            // Set cross-platform Java L&F (also called "Metal")
	        UIManager.setLookAndFeel(
	            UIManager.getCrossPlatformLookAndFeelClassName());
	    } 
	    catch (UnsupportedLookAndFeelException e) {
	       // handle exception
	    }
	    catch (ClassNotFoundException e) {
	       // handle exception
	    }
	    catch (InstantiationException e) {
	       // handle exception
	    }
	    catch (IllegalAccessException e) {
	       // handle exception
	    }
		    
			new TournamentHome(TournamentHome.MODE.SinglePlayer); 
		}
}




