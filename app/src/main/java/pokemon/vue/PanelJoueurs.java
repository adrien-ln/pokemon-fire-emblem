package pokemon.vue;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;

import pokemon.controleur.Controleur;
import pokemon.modele.pokemon.Pokemon;
import pokemon.modele.terrain.Case;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.*;


public class PanelJoueurs extends JPanel{
	/**
	 * HashMap qui associe à chaque pokémon du joueur 1 ses stats
	 */
    private HashMap<Pokemon,StatsPokemon> statsPokemonsJ1=new HashMap<>();
	/**
	 * HashMap qui associe à chaque pokémon du joueur 2 ses stats 
	 */
	private HashMap<Pokemon,StatsPokemon> statsPokemonsJ2=new HashMap<>();
	private JLabel j1=new JLabel("Pokemons du Joueur 1:");
	private JLabel j2=new JLabel("Pokemons du Joueur 2:");
	/**
	 * jScrollPaneJ1 contient le panelJ1;
	 * jScrollPaneJ2 contient le panelJ2
	 */
	private JScrollPane jScrollPaneJ1,jScrollPaneJ2;
	/**
	 * panelJ1 contient panelStatsJ1;
	 * panelJ2 contient panelStatsJ2
	 */
	private JPanel panelJ1, panelJ2;
	/**
	 * panelStatsJ1 contient les stats des pokémons du joueur 1;
	 * panelStatsJ2 contient les stats des pokémons du joueur 2
	 */
	private JPanel panelStatsJ1, panelStatsJ2;
	/**
	 * la largeur d'un panel statsPokemon
	 */
	protected static final int largeurStats=164;

	JTextPane description=new JTextPane();
	JScrollPane panelDescription;

	/**
	 * true si le joueur a cliqué sur l'icone de l'effet
	 */
	private boolean clickedEffet=false;
	/**
	 * true si le joueur a cliqué sur l'icone de la peur
	 */
	private boolean clickedPeur=false;
	/**
	 * true si le joueur a cliqué sur l'icone de la confusion
	 */
	private boolean clickedConfus=false;
	

    public PanelJoueurs(Controleur controleur) {
		panelJ1=new JPanel();
		panelJ2=new JPanel();
		panelStatsJ1=new JPanel();
		panelStatsJ2=new JPanel();
		panelJ1.setLayout(null);
		panelJ2.setLayout(null);
		panelStatsJ1.setLayout(null);
		panelStatsJ2.setLayout(null);
		jScrollPaneJ1=new JScrollPane(panelJ1);
		jScrollPaneJ2=new JScrollPane(panelJ2);
		panelJ1.add(panelStatsJ1);
		panelJ2.add(panelStatsJ2);
		panelStatsJ1.setBackground(Color.DARK_GRAY);
		panelStatsJ2.setBackground(Color.DARK_GRAY);
		panelJ1.setBackground(Color.DARK_GRAY);
		panelJ2.setBackground(Color.DARK_GRAY);
		add(jScrollPaneJ1);
		add(jScrollPaneJ2);

        Map<Pokemon,Case> pokemonsJ1 = controleur.getPokemonCaseJoueur1();
		j1.setForeground(Color.WHITE);
		panelStatsJ1.add(j1);
		for(Pokemon p: pokemonsJ1.keySet()){//créer les statsPokemon pour chaque pokémon du joueur 1, et les ajouter au panelStatsJ1
			StatsPokemon tmp=new StatsPokemon(p.getNom(),p.getType(),p.getPdv(),p.getAtk());
			addActionListenerAuxJPanels(tmp);
			panelStatsJ1.add(tmp);
			statsPokemonsJ1.put(p,tmp);
		}

		Map<Pokemon,Case> pokemonsJ2 = controleur.getPokemonCaseJoueur2();
		j2.setForeground(Color.WHITE);
	    panelStatsJ2.add(j2);
		for(Pokemon p: pokemonsJ2.keySet()){//créer les statsPokemon pour chaque pokémon du joueur 2, et les ajouter au panelStatsJ2
			StatsPokemon tmp=new StatsPokemon(p.getNom(),p.getType(),p.getPdv(),p.getAtk());
			addActionListenerAuxJPanels(tmp);
			panelStatsJ2.add(tmp);
			statsPokemonsJ2.put(p,tmp);
		}

		panelDescription=new JScrollPane(description,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    	description.setBackground(Color.DARK_GRAY);
    	description.setEditable(false);
		panelDescription.setVisible(false);
		add(panelDescription);
	}

	/**
	 * selectionne les stats du pokémon p si b=true, en vert si pokAllieOuEnnemi=true, en rouge sinon.
	 * déselectionne les stats du pokémon p si b=false
	 * @param p le pokemon selectionné
	 * @param b	selectionner les stats du pokemon si true, déselectionner si false
	 * @param pokAllieOuEnnemi le pokémon appartient au joueur actuel si true, au joueur adverse si false
	 */
	public void cibleVisible(Pokemon p, boolean b, boolean pokAllieOuEnnemi) {
		if(getStatsPokemons(true).containsKey(p)){//le pokémon p appartient à joueur 2
			getStatsPokemons(true).get(p).cibleVisible(b, pokAllieOuEnnemi);
			StatsPokemon s=getStatsPokemons(true).get(p);
			//bouger le scroll pour faire apparaitre le stat selectionné
			jScrollPaneJ2.getVerticalScrollBar().setValue((panelStatsJ2.getSize().height*s.getBounds().y)/panelJ2.getSize().height);
		}
		else if(getStatsPokemons(false).containsKey(p)){//le pokémon p appartient à joueur 1
			getStatsPokemons(false).get(p).cibleVisible(b, pokAllieOuEnnemi);
			StatsPokemon s=getStatsPokemons(false).get(p);
			//bouger le scroll pour faire apparaitre le stat selectionné
			jScrollPaneJ1.getVerticalScrollBar().setValue((panelStatsJ1.getSize().height*s.getBounds().y)/panelJ1.getSize().height);
		}
	}

	/**
	 * renvoie la liste des stats des pokemons de, 
	 * 		joueur 1, si joueur1=false
	 * 		joueur 2, si joueur1=true
	 * @param joueur1 true si c'est le tour de joueur 1, fasle si c'est le tour de joueur 2
	 * @return la liste des stats des pokemons de joueur 1 ou joueur 2
	 */
    public Map<Pokemon, StatsPokemon> getStatsPokemons(boolean joueur1) {
		if(!joueur1)
        	return statsPokemonsJ1;
		return statsPokemonsJ2;
    }

    @Override
    protected void paintComponent(Graphics g){
		super.paintComponent(g);
        int height=getSize().height;
        int width=getSize().width;
		if(jScrollPaneJ1!=null && jScrollPaneJ2!=null){
			//partager le panelJoueurs entre les deux jScrollPane
			jScrollPaneJ1.setBounds(0,40,width/2,height-40);
			jScrollPaneJ2.setBounds(width/2,40,width/2,height-40);
			revalidate();
		}
		if(panelDescription!=null)
			panelDescription.setBounds(0,0,width,40);
		if(j1!=null && j2!=null){
			j1.setBounds(0,0,largeurStats,15);
			j2.setBounds(0,0,largeurStats,15);
		}
		
		if(panelJ1!=null && panelJ2!=null){
			//determiner la hauteur de chacun des panel en fonction du nombre des stats
			//chaque panel stats a une hauteur de 55 plus 10 entre chaque deux panels 
			int countJ1=15+(statsPokemonsJ1.values().size()*(72+10))+10,countJ2=15+(statsPokemonsJ2.values().size()*(72+10))+10;
			if(jScrollPaneJ1.getSize().width<=largeurStats){//si le jScrollPanelJ1 a une largeur inférieure à largeurStats, la largeur de panelJ1 et panelStatsJ1 est largeurStats
				panelJ1.setPreferredSize(new Dimension(largeurStats,countJ1));
				panelStatsJ1.setBounds(0, 0, largeurStats, countJ1);
			}
			else{//sinon, la larguer de panelJ1 est égale à celle du jScrollPaneJ1, et on positionne le panelStatsJ1 au milieu avec une largeur largeurStats
				panelJ1.setPreferredSize(new Dimension(jScrollPaneJ1.getSize().width,countJ1));
				panelStatsJ1.setBounds((jScrollPaneJ1.getSize().width-largeurStats)/2, 0, largeurStats, countJ1);
			}
			if(jScrollPaneJ2.getSize().width<=largeurStats){//si le jScrollPanelJ2 a une largeur inférieure à largeurStats, la largeur de panelJ2 et panelStatsJ2 est largeurStats
				panelJ2.setPreferredSize(new Dimension(largeurStats,countJ2));
				panelStatsJ2.setBounds(0, 0, largeurStats, countJ2);
			}
			else{//sinon, la larguer de panelJ2 est égale à celle du jScrollPaneJ2, et on positionne le panelStatsJ2 au milieu avec une largeur largeurStats
				panelJ2.setPreferredSize(new Dimension(jScrollPaneJ2.getSize().width,countJ2));
				panelStatsJ2.setBounds((jScrollPaneJ2.getSize().width-largeurStats)/2, 0, largeurStats, countJ2);
			}
		}
		
		if(statsPokemonsJ1!=null && statsPokemonsJ2!=null){
			int i=0;
			//positionner les statsPokemonsJ1 sur panelStatsJ1
			for(StatsPokemon s : statsPokemonsJ1.values()){
				s.setBounds(0, i*(72+10)+25, largeurStats, 72);
				i++;
			}
			i=0;//positionner les statsPokemonsJ2 sur panelStatsJ2
			for(StatsPokemon s : statsPokemonsJ2.values()){
				s.setBounds(0, i*(72+10)+25, largeurStats, 72);
				i++;
			}
		}

    }

	public String descPeur(){
		return "Peur : Ne peut rien faire pendant 1 tour.";
	}
	
	public String descBrule(){
		return "Brulure : -1/16 des pdv actuel après chaque action. 25% de disparaitre apres chaque action.";
	}
	
	public String descConfus(){
		return "Confus : 33% de rater son attaque et se blesser de 1/16 de ses pdv actuel , disparait entre 1 et 3 tour.";
	}
	
	public String descParalyse(){
		return "Paralyse : 25% de rater son attaque et avance de 1 case de moins. 25% de disparaitre apres chaque action.";
	}

	public String descGele(){
		return "Gele : Ne peut plus se deplacer. 25% de disparaitre apres chaque action.";
	}

	public String descPoison(){
		return "Poison : -1/16 des pdv actuel après chaque action. 25% de disparaitre apres chaque action.";
	}
    
	private void addActionListenerAuxJPanels(StatsPokemon tmp) {
		tmp.getJPanelEffet().addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				if(tmp.estBRN()){
					ecrireDescripion(descBrule());
					panelDescription.setVisible(true);
					clickedPeur=false;
					clickedConfus=false;
				}
				else if(tmp.estPAR()){
					ecrireDescripion(descParalyse());
					panelDescription.setVisible(true);
					clickedPeur=false;
					clickedConfus=false;
				}
				else if(tmp.estPSN()){
					ecrireDescripion(descPoison());
					panelDescription.setVisible(true);
					clickedPeur=false;
					clickedConfus=false;
				}
				else if(tmp.estFRZ()){
					ecrireDescripion(descGele());
					panelDescription.setVisible(true);
					clickedPeur=false;
					clickedConfus=false;
				}
				
			}
			public void mouseExited(java.awt.event.MouseEvent evt) {
				if(!clickedEffet && (tmp.estBRN() || tmp.estPAR() || tmp.estPSN() || tmp.estFRZ()))
					panelDescription.setVisible(false);
			}
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				if(clickedEffet && panelDescription.isVisible() && (tmp.estBRN() || tmp.estPAR() || tmp.estPSN() || tmp.estFRZ())){
					panelDescription.setVisible(false);
					clickedEffet=false;
				}
				else{
					if(tmp.estBRN()){
						ecrireDescripion(descBrule());
						panelDescription.setVisible(true);
						clickedEffet=true;
						clickedPeur=false;
						clickedConfus=false;
					}
					else if(tmp.estPAR()){
						ecrireDescripion(descParalyse());
						panelDescription.setVisible(true);
						clickedEffet=true;
						clickedPeur=false;
						clickedConfus=false;
					}
	
					else if(tmp.estPSN()){
						ecrireDescripion(descPoison());
						panelDescription.setVisible(true);
						clickedEffet=true;
						clickedPeur=false;
						clickedConfus=false;
					}

					else if(tmp.estFRZ()){
						ecrireDescripion(descGele());
						panelDescription.setVisible(true);
						clickedEffet=true;
						clickedPeur=false;
						clickedConfus=false;
					}
				}
			}
		});

		tmp.getJPanelPeur().addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				if(tmp.aPeur()){
					ecrireDescripion(descPeur());
					panelDescription.setVisible(true);
					clickedEffet=false;
					clickedConfus=false;
				}
			}
			public void mouseExited(java.awt.event.MouseEvent evt) {
				if(!clickedPeur && tmp.aPeur())
					panelDescription.setVisible(false);
			}
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				if(clickedPeur && panelDescription.isVisible() && tmp.aPeur()){
					panelDescription.setVisible(false);
					clickedPeur=false;
				}
				else if(tmp.aPeur()){
					ecrireDescripion(descPeur());
					panelDescription.setVisible(true);
					clickedPeur=true;
					clickedEffet=false;
					clickedConfus=false;
				}
			}
		});

		tmp.getJpanelConfus().addMouseListener(new java.awt.event.MouseAdapter() {
			
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				if(tmp.estConfus()){
					ecrireDescripion(descConfus());
					panelDescription.setVisible(true);
					clickedEffet=false;
					clickedPeur=false;
				}
			}
			public void mouseExited(java.awt.event.MouseEvent evt) {
				if(!clickedConfus && tmp.estConfus())
					panelDescription.setVisible(false);
			}
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				if(clickedConfus && panelDescription.isVisible() && tmp.estConfus()){
					panelDescription.setVisible(false);
					clickedConfus=false;
				}
				else if(tmp.estConfus()){
					ecrireDescripion(descConfus());
					panelDescription.setVisible(true);
					clickedConfus=true;
					clickedEffet=false;
					clickedPeur=false;
				}
			}
		});
	}

	public void ecrireDescripion(String s){
		Style defaut=description.getStyle("default");
		StyleConstants.setForeground(defaut, Color.red);
		Document doc=description.getDocument();
		try{
			  doc.remove(0,doc.getLength());
			  doc.insertString(0,s, defaut);
		}catch(BadLocationException e){
			  System.out.println(e.getMessage());
		} 
	}

	public StatsPokemon getStatsPokemonFromStatsPokemonJ1(Pokemon p){
		return statsPokemonsJ1.get(p);
	}

	public StatsPokemon getStatsPokemonFromStatsPokemonJ2(Pokemon p){
		return statsPokemonsJ2.get(p);
	}
	
}
