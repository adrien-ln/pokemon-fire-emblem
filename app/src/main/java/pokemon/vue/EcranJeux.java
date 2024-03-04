package pokemon.vue;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pokemon.audio.Audio;
import pokemon.controleur.Controleur;
import pokemon.modele.attaque.Attaque;
import pokemon.modele.pokemon.Pokemon;
import pokemon.modele.terrain.Pair;

public class EcranJeux extends JFrame{
    private JPanel panelTerrain=new JPanel();
	private JPanel panelInfos=new JPanel();
	private PanelJoueurs panelJoueurs;
	private JLabel labelJoueur=new JLabel();
	PanelBoutons panelBoutons;
	private Controleur controleur;
	public Tile[][] arrayTile;
	private JButton buttonRecommencer;
	private String joueur;
	private int xPrec;
    private int yPrec;
    
    public EcranJeux(Controleur c, JButton buttonRecommencer, String joueur){ 
		//avoir la dimension de l'écran   
		Rectangle bounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
		int height = bounds.height;
		int width  = bounds.width;
		setPreferredSize(new Dimension(width/2,6*height/7));
		setSize(new Dimension(width/2,6*height/7));
		//placer les JFrames sur l'écran
		if(joueur=="Joueur 1")
			setLocation(0,0);
		else
			setLocation((int)(width/2+bounds.getX()), 0);

		this.joueur=joueur;

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(joueur);   
        controleur=c; 
        panelBoutons=new PanelBoutons(controleur, buttonRecommencer);
		arrayTile=new Tile[controleur.getHeight()][controleur.getWidth()];
		setLayout(new GridLayout(0,2));
		panelTerrain.setBackground(Color.black);
		panelInfos.setBackground(Color.green);
		panelInfos.setLayout(new GridLayout(2,0));
		panelJoueurs=new PanelJoueurs(controleur);
		panelJoueurs.setBackground(Color.DARK_GRAY);
		panelJoueurs.setLayout(null);
		panelInfos.add(panelJoueurs);
		panelInfos.add(panelBoutons);
		panelJoueurs.add(labelJoueur);
		labelJoueur.setBounds(0,0,300,15);
		labelJoueur.setForeground(Color.white);
		add(panelInfos);
		add(panelTerrain);
		panelTerrain.setLayout(new GridLayout(controleur.getHeight(),controleur.getWidth(),1,1));
		if(joueur=="Joueur 2"){
			for(int i=0; i<controleur.getHeight(); i++){
				for(int j=0;j<controleur.getWidth();j++){
					String path = controleur.getPathImageTile(i, j);
					String pathSelect = controleur.getPathImageSelectTile(i, j);
					String pathAttaque = controleur.getPathImageAttaqueTile(i, j);
					Tile tile=new Tile(path,pathSelect,pathAttaque,i,j,controleur, joueur);
					panelTerrain.add(tile);
					arrayTile[i][j]=tile;
				}
			}
		}
		else{
			for(int i=controleur.getHeight()-1; i>=0; i--){
				for(int j=controleur.getWidth()-1;j>=0;j--){
					String path = controleur.getPathImageTile(i, j);
					String pathSelect = controleur.getPathImageSelectTile(i, j);
					String pathAttaque = controleur.getPathImageAttaqueTile(i, j);
					Tile tile=new Tile(path,pathSelect,pathAttaque,i,j,controleur, joueur);
					panelTerrain.add(tile);
					arrayTile[i][j]=tile;
				}
			}
		}	

        panelBoutons.getBoutonAttaque().addActionListener(event ->{
			Map<String,Attaque> listeAttaques=controleur.getListeAttaquesPokemon();
			panelBoutons.getBoutonAttaque().setVisible(false);
			panelBoutons.getBoutonFin().setVisible(false);
			panelBoutons.getBoutonAnnulerD().setVisible(false);
			panelBoutons.getBoutonRetour().setVisible(true);
			panelBoutons.getListeBoutonAttaque().clear();
			for(String nom : listeAttaques.keySet()){
				panelBoutons.addListeBouton(nom);
				JButton tmp = panelBoutons.getBoutonDeListe(nom);
				addActionListenerBouton(nom,listeAttaques.get(nom),tmp);
				panelBoutons.add(tmp);
				tmp.setVisible(true);
			}
			panelBoutons.repaint();
		});
		
		panelBoutons.getBoutonFin().addActionListener(event ->{
			finTour(true);
		});
		
		panelBoutons.getBoutonAnnulerD().addActionListener(event ->{
			int x=controleur.getCoordonneesPokemonActuel().getFirst();
			int y=controleur.getCoordonneesPokemonActuel().getSecond();
			deselectTile(x, y);
			enleverFleche(x, y);
		});

		this.buttonRecommencer=buttonRecommencer;
	}

	/**
	 * enlève la flèche su le tile de coordonnées x,y
	 * @param x coordonnée x du tile
	 * @param y coordonnée y du tile
	 */
    private void enleverFleche(int x, int y) {
		arrayTile[x][y].enleverFleche();
	}

	public void addActionListenerBouton(String nom,Attaque atk,JButton b){
		b.addMouseListener(new java.awt.event.MouseAdapter() {
			boolean clicked = false;
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				controleur.colorerCasesAAttaquer(nom);
				panelBoutons.setVisibleInfosAttaque(nom,atk);
			}
		
			public void mouseExited(java.awt.event.MouseEvent evt) {
				if(!clicked){
					controleur.decolorerCasesAAttaquer();
					panelBoutons.setInvisibleInfosAttaque();
				}
			}
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				//fonction de choix du pokemon a attaquer.
				for(String key : panelBoutons.getListeBoutonAttaque().keySet()){
					panelBoutons.getBoutonDeListe(key).setVisible(false);
				}
				clicked = true;
				controleur.colorerCasesAAttaquer(nom);
			}
		});
	}

	/**
	 * affiche le joueur à qui c'est le tour sur le panel informations
	 * @param joueur "joueur 1" ou "joueur 2"
	 */
	public void miseAJourInformations(String joueur) {
		labelJoueur.setText("Tour du joueur : " + joueur );
	}

	/**
	 * mets à jour l'affichage des stats du pokemon p dans le panelJoueur 
	 * @param p Pokemon
	 * @param joueur1 true si le pokémon appartient à joueur 2, false sinon
	 */
	public void miseAJourInfosPokemons(Pokemon p, boolean joueur1){
		StatsPokemon tmp=panelJoueurs.getStatsPokemons(joueur1).get(p);
		tmp.setPdv(p.getPdv());
		if(p.getEffet()!=null){
			tmp.setEffet(p.getEffet());
		}
		else {
			tmp.cacherEffet();
		}
		if(p.getConfus())
			tmp.setConfus(true,p.getConfusTour());
		else
			tmp.setConfus(false,p.getConfusTour());
		if(p.getPeur())
			tmp.setPeur(true);
		else
			tmp.setPeur(false);
	}

	/**
	 * sélectionne tous les tiles dont les coordonnées se trouvent dans la liste listPaires
	 * @param listPaires liste des coordonnées des tiles à sélectionner
	 */
	public void selectTiles(HashSet<Pair> listPaires){
		for(Pair p : listPaires){
			selectTile(p.getFirst(),p.getSecond());
		}
	}

	/**
	 * désélectionne tous les tiles dont les coordonnées se trouvent dans la liste listPaires
	 * @param listPaires liste des coordonnées des tiles à désélectionner
	 */
	public void deselectTiles(HashSet<Pair> listPaires){
		for(Pair p : listPaires){
			deselectTile(p.getFirst(),p.getSecond());
		}
	}

	/**
	 * sélectionne le tile de coordonnées (x,y)
	 * @param x coordonnée x sur le plateau
	 * @param y coordonnée y sur le plateau
	 */
	public void selectTile(int x, int y){
		arrayTile[x][y].select();
	}

	/**
	 * désélectionne le tile de coordonnées (x,y)
	 * @param x coordonnée x sur le plateau
	 * @param y coordonnée y sur le plateau
	 */
	public void deselectTile(int x, int y){
		arrayTile[x][y].deselect();
	}

	/**
	 * colore la liste des cases en rouges 
	 * @param casesAAttaquer liste des coordonnées des cases qui peuvent être attaquées
	 */
	public void colorerCasesAAttaquer(HashSet<Pair> casesAAttaquer){
		for(Pair p : casesAAttaquer)
			coloreCaseAAttaquer(p.getFirst(), p.getSecond());
	}

	/**
	 * décolore la liste des cases 
	 * @param casesAAttaquer liste des coordonnées des cases qui peuvent être attaquées
	 */
	public void decolorerCasesAAttaquer(HashSet<Pair> casesAAttaquer){
		for(Pair p : casesAAttaquer)
			decolorerCaseAAttaquer(p.getFirst(), p.getSecond());
	}

	/**
	 * colore la case de coordonnées x,y en rouge
	 * @param x coordonnée x de la case à colorer
	 * @param y coordonnée y de la case à colorer
	 */
	public void coloreCaseAAttaquer(int x, int y){
		arrayTile[x][y].colorerCaseAAttaquer();
	}

	/**
	 * décolore la case de coordonnées x,y 
	 * @param x coordonnée x de la case à décolorer
	 * @param y coordonnée y de la case à décolorer
	 */
	public void decolorerCaseAAttaquer(int x, int y){
		arrayTile[x][y].decolorerCaseAAttaquer();
	}

	/**
	 * déplace le pokémon du tile qui a comme coordonnées tile1 vers le tile qui a comme coordonnées tile2
	 * @param tile1 une pair contenant les coordonnées du tile où se trouve le Pokémon à déplacer
	 * @param tile2 une pair contenant les coordonnées du tile où le Pokémon sera déplacé
	 * @param cheminImagePokemon le chemin de l'image du Pokémon
	 */
	public void deplacerPokemon(Pair tile1, Pair tile2, String pathImagePokemon){
		enleverPokemon(tile1.getFirst(),tile1.getSecond());
		placerPokemon(tile2.getFirst(),tile2.getSecond(),pathImagePokemon);
	}

	/**
	 * dessine le Pokémon sur le tile de coordonnées (x,y)
	 * @param x coordonnée x du tile dans le plateau
	 * @param y coordonnée y du tile dans le plateau
	 * @param cheminImagePokemon chemin de l'image du Pokémon
	 */
	public void placerPokemon(int x, int y, String pathImagePokemon){
		arrayTile[x][y].setPokemonPresent(true, pathImagePokemon);
	}

	/**
	 * enlève le Pokémon du le tile de coordonnées (x,y)
	 * @param x coordonnée x du tile dans le plateau
	 * @param y coordonnée y du tile dans le plateau
	 */
	public void enleverPokemon(int x, int y){
		arrayTile[x][y].setPokemonPresent(false, "");
	}

	/**
	 * affiche winner sur le panelBoutons de la fenêtre du joueur gagnat ainsi que le bouton recommencer;
	 * et loser sur le panelBoutons de la fenêtre du joueur perdant ainsi que le bouton recommencer
	 * @param joueurGagnant le joueur gagnant, true pour joueur 1 ; false pour joueur 2
	 */
	public void afficherFinPartie(boolean joueurGagnant){
		panelBoutons.removeAll();
        int height=panelBoutons.getSize().height;
        int width=panelBoutons.getSize().width;
        try{
			if(joueurGagnant==true)
				panelBoutons.afficherFinPartie(ImageIO.read(new File("src/main/resources/winner.png")));
			else
				panelBoutons.afficherFinPartie(ImageIO.read(new File("src/main/resources/loser.png")));
		}catch(IOException e){
			System.out.println("impossible d'ouvrir l'image de fin de partie");
		}
		panelBoutons.add(buttonRecommencer);
		buttonRecommencer.setBounds(0,5*height/6,width,height/6);
        panelBoutons.setBackground(Color.white);
	}
	
	/**
	 * selectionne le panel des stats du pokémon p, en vert si pokAllieOuEnnemi=true, en rouge sinon
	 * @param p le pokémon
	 * @param pokAllieOuEnnemi true si le pokémon appartient au joueur de cette fenêtre, false sinon
	 */
	public void cibleVisible(Pokemon p, boolean pokAllieOuEnnemi){
		panelJoueurs.cibleVisible(p,true,pokAllieOuEnnemi);

	}

	/**
	 * déselectionne le panel des stats du pokémon p
	 * @param p le pokémon
	 * @param pokAllieOuEnnemi true si le pokémon appartient au joueur de cette fenêtre, false sinon
	 */
	public void cibleInvisible(Pokemon p, boolean pokAllieOuEnnemi){
		panelJoueurs.cibleVisible(p,false,pokAllieOuEnnemi);
	}

	/**
	 * renvoie le panel des boutons
	 * @return le panel des boutons
	 */
    public PanelBoutons getPanelBoutons() {
        return panelBoutons;
    }

	public void showBoutons(){
		this.panelBoutons.getBoutonFin().setVisible(true);
		this.panelBoutons.getBoutonAttaque().setVisible(true);
		this.panelBoutons.getBoutonAnnulerD().setVisible(true);
	}

	public void setXPrec(int x){
		this.xPrec=x;
	}

	public void setYPrec(int y){
		this.yPrec=y;
	}

	public int getXPrec(){
		return this.xPrec;
	}

	public int getYPrec(){
		return this.yPrec;
	}
	public void hit(){
		try{
            Audio audioPlayer =new Audio("src/main/resources/Hit.wav",5f,false);
            audioPlayer.play();
        } 
        catch (Exception ex){
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
	}

	public void finTour(boolean pokemon){
		if (pokemon){
			int x=controleur.getCoordonneesPokemonActuel().getFirst();
			int y=controleur.getCoordonneesPokemonActuel().getSecond();
			controleur.testEffet();
			controleur.miseAJourInfosPokemons(controleur.getPokeDansCase(x, y),!controleur.getJoueurActuel());
			deselectTile(x, y);
			enleverFleche(x, y);
		}
		panelBoutons.getBoutonFin().setVisible(false);
		panelBoutons.getBoutonAttaque().setVisible(false);
		panelBoutons.getBoutonAnnulerD().setVisible(false);
		panelBoutons.getBoutonRetour().setVisible(false);
		controleur.getJeux().selectPokemon();
	}

  public void setInvisibleInfosAttaque() {
		panelBoutons.setInvisibleInfosAttaque();
  }

	public PanelJoueurs getPanelJoueurs() {
		return panelJoueurs;
	}

	public void ecrireAttaquePokemon(String joueurAttaque, String joueurCible, String pokemonAttaque, String pokemonCible, int degats) {
		panelBoutons.ecrireAttaquePokemon(joueurAttaque, joueurCible, pokemonAttaque, pokemonCible, degats);
	}

	public void ecrireInitEffetPokemon(String pokemon, String effet) {
		panelBoutons.ecrireInitEffetPokemon(pokemon, effet);
	}

	public void ecrireHistorique(String historique) {
		panelBoutons.ecrireHistorique(historique);
	}

	public void ecrireEffetPokemon(String pokemon, String effet, int degats) {
		panelBoutons.ecrireEffetPokemon(pokemon, effet, degats);
	}

}
