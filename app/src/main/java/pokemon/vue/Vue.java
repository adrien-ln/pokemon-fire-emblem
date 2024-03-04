package pokemon.vue;

import javax.swing.JButton;
import javax.swing.JFrame;
import pokemon.audio.Audio;
import pokemon.controleur.Controleur;
import pokemon.modele.pokemon.*;
import pokemon.modele.terrain.*;
import java.util.HashSet;

public class Vue extends JFrame{
	
	private Controleur controleur;
	private JButton buttonCommencer=new JButton("Jouer");
	private JButton buttonRecommencerJ1=new JButton("Recommencer");
	private JButton buttonRecommencerJ2=new JButton("Recommencer");
	private EcranJeux ecranJeuxJ1;
	private EcranJeux ecranJeuxJ2;
	private Thread threadJ1;
	private Thread threadJ2;
	public Vue() {
		controleur=new Controleur(this);
		this.setTitle("Pokemon");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Accueil panelAccueil=new Accueil(buttonCommencer);
		setContentPane(panelAccueil);
		
		buttonCommencer.addActionListener( event -> {
			try{
				Audio audioPlayer =new Audio("src/main/resources/Pokemon Bleu Rouge Jaune Musique  - Combat Vs Dresseur Pokemon.wav",20f,true);
				audioPlayer.play();
			} 
			catch (Exception ex){
				System.out.println("Error with playing sound.");
				ex.printStackTrace();
			}
			threadJ1=new Thread(){
				public void run(){
					ecranJeuxJ1=new EcranJeux(controleur, buttonRecommencerJ1, "Joueur 1");
					ecranJeuxJ1.pack();
					ecranJeuxJ1.setVisible(true);
				}
			};
			threadJ2=new Thread(){
				public void run(){
					ecranJeuxJ2=new EcranJeux(controleur, buttonRecommencerJ2, "Joueur 2");
					ecranJeuxJ2.pack();
					ecranJeuxJ2.setVisible(true);
				}
			};
			threadJ1.run();
			threadJ2.run();
			setVisible(false);
			controleur.commencer();
		});	
		addActionListenerButtonRecommencer(buttonRecommencerJ1);
		addActionListenerButtonRecommencer(buttonRecommencerJ2);	
	}

	public void addActionListenerButtonRecommencer(JButton buttonRecommencer){
		buttonRecommencer.addActionListener( event-> {
			Controleur controleur=new Controleur(this);
			controleur.setVue(this);
			EcranJeux tmp=ecranJeuxJ1;
			ecranJeuxJ1=new EcranJeux(controleur, buttonRecommencerJ1, "Joueur 1");
			tmp.dispose();
			ecranJeuxJ1.pack();
			ecranJeuxJ1.setVisible(true);
			tmp=ecranJeuxJ2;
			ecranJeuxJ2=new EcranJeux(controleur, buttonRecommencerJ2, "Joueur 2");
			tmp.dispose();
			ecranJeuxJ2.pack();
			ecranJeuxJ2.setVisible(true);
			controleur.commencer();
		});
	}

	/**
	 * affiche winner sur le panelBoutons de la fenêtre du joueur gagnant, et 
	 * loser sur le panelBoutons de la fenêtre dujoueur perdant, ainsi que le 
	 * bouton recommencer
	 * @param joueurGagnant true si le joueur gagnat est joueur 1, false sinon
	 */
    public void afficherFinPartie(boolean joueurGagnant) {
		ecranJeuxJ1.afficherFinPartie(joueurGagnant);
		ecranJeuxJ2.afficherFinPartie(!joueurGagnant);
    }

	/**
	 * décolore les cases qui peuvent être attaquées sur les fenêtres des deux joueurs
	 * @param listCasesAAttaquer liste des coordonnées des case qui peuvent être attaquées
	 */
    public void decolorerCasesAAttaquer(HashSet<Pair> listCasesAAttaquer) {
		ecranJeuxJ1.decolorerCasesAAttaquer(listCasesAAttaquer);
		ecranJeuxJ2.decolorerCasesAAttaquer(listCasesAAttaquer);
	}

	/**
	 * colore en rouge les cases qui peuvent être attaquées sur les fenêtres des deux joueurs 
	 * @param casesAAttaquer liste des coordonnées des cases qui peuvent être attaquées
	 */
    public void colorerCasesAAttaquer(HashSet<Pair> casesAAttaquer) {
		ecranJeuxJ1.colorerCasesAAttaquer(casesAAttaquer);
		ecranJeuxJ2.colorerCasesAAttaquer(casesAAttaquer);
    }

    public void deselectTile(int first, int second) {
		ecranJeuxJ1.deselectTile(first,second);
		ecranJeuxJ2.deselectTile(first,second);
    }

	/**
	 * déselectionne les tile sur la list tiles, sur la fenêtre de joueur 1 si joueur1=true;
	 * sur la fenêtre de joueur 2 sinon
	 * @param tiles liste des coordonnées des tiles à déselectionner
	 * @param joueur1 true si c'est sur la fêtre de joueur 1, false pour la fenêtre de joueur 2
	 */
    public void deselectTiles(HashSet<Pair> tiles, boolean joueur1) {
		if(joueur1)
			ecranJeuxJ1.deselectTiles(tiles);
		else
			ecranJeuxJ2.deselectTiles(tiles);
    }

	/**
	 * selectionne les tile sur la list tiles, sur la fenêtre de joueur 1 si joueur1=true;
	 * sur la fenêtre de joueur 2 sinon
	 * @param tiles liste des coordonnées des tiles à selectionner
	 * @param joueur1 true si c'est sur la fêtre de joueur 1, false pour la fenêtre de joueur 2
	 */
    public void selectTiles(HashSet<Pair> tiles, boolean joueur1) {
		if(joueur1)
			ecranJeuxJ1.selectTiles(tiles);
		else
			ecranJeuxJ2.selectTiles(tiles);
    }

    public void showBoutons(boolean joueur1) {
		if(joueur1)
			ecranJeuxJ1.showBoutons();
		else
			ecranJeuxJ2.showBoutons();
    }

	/**
	 * déplace le pokémon du tile qui a comme coordonnées tile1 vers le tile qui a comme coordonnées tile2
	 * @param tile1 une pair contenant les coordonnées du tile où se trouve le Pokémon à déplacer
	 * @param tile2 une pair contenant les coordonnées du tile où le Pokémon sera déplacé
	 * @param pathImagePokemon le chemin de l'image du Pokémon
	 */
    public void deplacerPokemon(Pair tile1, Pair tile2, String pathImagePokemon) {
		ecranJeuxJ1.deplacerPokemon(tile1, tile2, pathImagePokemon);
		ecranJeuxJ2.deplacerPokemon(tile1, tile2, pathImagePokemon);
    }

	/**
	 * dessine le Pokémon sur le tile de coordonnées (x,y)
	 * @param x coordonnée x du tile dans le plateau
	 * @param y coordonnée y du tile dans le plateau
	 * @param cheminImagePokemon chemin de l'image du Pokémon
	 */
    public void placerPokemon(int x, int y, String cheminImage) {
		ecranJeuxJ1.placerPokemon(x, y, cheminImage);
		ecranJeuxJ2.placerPokemon(x, y, cheminImage);
    }

	/**
	 * mets à jour l'affichage des stats du pokemon p dans le panelJoueur 
	 * @param p Pokemon
	 * @param joueur1 true si le pokémon appartient à joueur 2, false sinon
	 */
    public void miseAJourInfosPokemons(Pokemon p, boolean joueur1) {
		ecranJeuxJ1.miseAJourInfosPokemons(p, joueur1);
		ecranJeuxJ2.miseAJourInfosPokemons(p, joueur1);
    }

	/**
	 * affiche le joueur à qui c'est le tour sur le panel informations
	 * @param joueur "joueur 1" ou "joueur 2"
	 */
    public void miseAJourInformations(String string) {
		ecranJeuxJ1.miseAJourInformations(string);
		ecranJeuxJ2.miseAJourInformations(string);
    }

	/**
	 * enlève le Pokémon du le tile de coordonnées (x,y)
	 * @param x coordonnée x du tile dans le plateau
	 * @param y coordonnée y du tile dans le plateau
	 */
    public void enleverPokemon(int x, int y) {
		ecranJeuxJ1.enleverPokemon(x, y);
		ecranJeuxJ2.enleverPokemon(x, y);
    }

	public PanelBoutons getPanelBoutons(boolean joueur1) {
		if(joueur1)
			return ecranJeuxJ1.getPanelBoutons();
		return ecranJeuxJ2.getPanelBoutons();
	}

	/**
	 * selectionne le panel des stats du pokémon p, en vert si pokJoueur1=joueur1, en rouge sinon
	 * @param pokeDansCase le pokémon
	 * @param joueur1 true pour selectionner les stats sur la fenêtre du joueur1;
	 * 					false pour la fenêtre du joueur 2
	 * @param pokAJoueur1 true si le pokémon appartient à joueur 1, false s'il appartient
	 * 			à joueur 2
	 */
	public void cibleVisible(Pokemon pokeDansCase, boolean joueur1, boolean pokAJoueur1) {
		if(joueur1)
			ecranJeuxJ1.cibleVisible(pokeDansCase, joueur1==pokAJoueur1);
		else
			ecranJeuxJ2.cibleVisible(pokeDansCase, joueur1==pokAJoueur1);
	}

	/**
	 * déselectionne le panel des stats du pokémon p
	 * @param pokeDansCase le pokémon
	 * @param joueur1 true pour déselectionner les stats sur la fenêtre du joueur1;
	 * 					false pour la fenêtre du joueur 2
	 * @param pokAJoueur1 true si le pokémon appartient à joueur 1, false s'il appartient
	 * 			à joueur 2
	 */
    public void cibleInvisible(Pokemon pokeDansCase, boolean joueur1, boolean pokAJoueur1) {
		if(joueur1)
			ecranJeuxJ1.cibleInvisible(pokeDansCase, joueur1==pokAJoueur1);
		else
			ecranJeuxJ2.cibleInvisible(pokeDansCase, joueur1==pokAJoueur1);
    }
	/*
	public void waitThreadJ1(){
		try{
			ecranJeuxJ1.wait();
			ecranJeuxJ2.notify();
		}catch(InterruptedException e){
			System.out.println("probleme thread");
		}
	}

	public void waitThreadJ2(){
		try{
			ecranJeuxJ2.wait();
			ecranJeuxJ1.notify();
		}catch(InterruptedException e){
			System.out.println("probleme thread");
		}
	}
	*/

	public void setVisibleBoutonRetour(boolean b, boolean joueur1) {
		getPanelBoutons(joueur1).getBoutonRetour().setVisible(b);
	}

	public void setVisibleBoutonFin(boolean b, boolean joueur1) {
		getPanelBoutons(joueur1).getBoutonFin().setVisible(b);
	}

	public int getXPrec(boolean joueur1){
		if(joueur1)
			return ecranJeuxJ1.getXPrec();
		else
			return ecranJeuxJ2.getXPrec();
	}

	public int getYPrec(boolean joueur1){
		if(joueur1)
			return ecranJeuxJ1.getYPrec();
		else
			return ecranJeuxJ2.getYPrec();
	}

	public void setXPrec(int x,boolean joueur1){
		if(joueur1)
			ecranJeuxJ1.setXPrec(x);
		else
			ecranJeuxJ2.setXPrec(x);
	}

	public void setYPrec(int y,boolean joueur1){
		if(joueur1)
			ecranJeuxJ1.setYPrec(y);
		else
			ecranJeuxJ2.setYPrec(y);
	}

	public void finTour(boolean joueur1,boolean pokemon){
		if(joueur1)
			ecranJeuxJ1.finTour(pokemon);
		else
			ecranJeuxJ2.finTour(pokemon);
	}

	public void hit(){
		ecranJeuxJ1.hit();
	}

  public void setInvisibleInfosAttaque(boolean joueur1) {
		if(joueur1)
			ecranJeuxJ1.setInvisibleInfosAttaque();
		else
			ecranJeuxJ2.setInvisibleInfosAttaque();
  }
	
	public EcranJeux getEcranJeuxJ1() {
			return ecranJeuxJ1;
		}
	
		public EcranJeux getEcranJeuxJ2() {
			return ecranJeuxJ2;
		}

		public void ecrireAttaquePokemon(String joueurAttaque, String joueurCible, String pokemonAttaque,String pokemonCible, int degats) {
			ecranJeuxJ1.ecrireAttaquePokemon(joueurAttaque, joueurCible, pokemonAttaque, pokemonCible, degats);
			ecranJeuxJ2.ecrireAttaquePokemon(joueurAttaque, joueurCible, pokemonAttaque, pokemonCible, degats);
		}

		public void ecrireInitEffetPokemon(String pokemon, String effet) {
			ecranJeuxJ1.ecrireInitEffetPokemon(pokemon,effet);
			ecranJeuxJ2.ecrireInitEffetPokemon(pokemon,effet);
		}

		public void ecrireHistorique(String historique) {
			ecranJeuxJ1.ecrireHistorique(historique);
			ecranJeuxJ2.ecrireHistorique(historique);
		}

		public void ecrireEffetPokemon(String pokemon, String effet, int degats) {
			ecranJeuxJ1.ecrireEffetPokemon(pokemon, effet, degats);
			ecranJeuxJ2.ecrireEffetPokemon(pokemon, effet, degats);
		}
	
}
