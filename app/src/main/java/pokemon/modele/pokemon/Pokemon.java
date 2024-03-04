package pokemon.modele.pokemon;

import pokemon.modele.attaque.*;
import pokemon.modele.attaque.ListeAttaques.*;
import pokemon.modele.terrain.Case.TypeCase;

import java.util.*;

public class Pokemon {
    
	String nom;
	private int crit;
	private int pdv;
	private int atk;
	private String type;
	private String cheminImage;
	private String effet;
	private boolean confus;
	private int confusTour;
	private boolean peur;
	Map<String,Attaque> listeAttaques = new TreeMap<String,Attaque>();
	/**
	 * le nombre de cases maximal qu'on peut déplacer le pokémon
	 */
	private int capaciteDeplacement;
	

	public Pokemon(String nom,int capaciteDeplacement,String type) {
		this.nom = nom;
		this.pdv = 1;
		this.crit = 15;
		this.setAtk(1);
		this.setType(type);
		this.effet=null;
		this.confus=false;
		this.confusTour=3;
		this.peur=false;
		cheminImage=null;
		this.capaciteDeplacement=capaciteDeplacement;
	}

	public String getNom(){
		return this.nom;
	}
	
    public String getCheminImage(){
        return cheminImage;
    }

	public void setCheminImage(String chemin){
		this.cheminImage=chemin;
	}


	public int getPdv() {
		return this.pdv;
	}

	public void setPdv(int pdv) {
		this.pdv = pdv;
	}

	public int getAtk() {
		return this.atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public String getType() {
		return this.type;
	}

	public int getCrit(){
		return this.crit;
	}

	public void setEffet(String effet){
		this.effet=effet;
	}

	public void removeEffet(){
		this.effet=null;
	}

	public String getEffet(){
		return this.effet;
	}
	
	/**
	 * Verifie si le pokemon a l'effet "Brule" ou "Poison" et si c'est true , enleve au pokemon 1/16 de ses pdv actuels.
	 */
	public void testEffet(){
		if(this.effet=="Brule"){
			this.setPdv(pdv-(pdv/16));
		}
		if(this.effet=="Poison"){
			this.setPdv(pdv-(pdv/16));
		}
	}

	public void setCrit(int n){
		this.crit = n;
	}

	public boolean getConfus(){
		return this.confus;
	}

	public void setConfus(boolean confus){
		this.confus = confus;
	}

	public int getConfusTour(){
		return this.confusTour;
	}
	
	public void setConfusTour(int n){
		this.confusTour = n;
	}

	public boolean getPeur(){
		return this.peur;
	}

	public void setPeur(boolean peur){
		this.peur = peur;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Map<String,Attaque> getListeAttaque(){
		return this.listeAttaques;
	}
	
	/**
	 * Ajoute a la map listeAttaques<String, Attaque> la nouvelle attaque du pokemon.
	 * @param nom Nom de l'attaque
	 */
	public void addAttaqueListe(String nom){
		if(nom == "Flammeche"){
			this.listeAttaques.put(nom, new Flammeche());
		}
		else if (nom == "Eclair"){
			this.listeAttaques.put(nom, new Eclair());
		}
		else if (nom == "Acide"){
			this.listeAttaques.put(nom, new Acide());
		}
		else if (nom == "Ball'Ombre"){
			this.listeAttaques.put(nom, new BallOmbre());
		}
		else if (nom == "Belier"){
			this.listeAttaques.put(nom, new Belier());
		}
		else if (nom == "Charge"){
			this.listeAttaques.put(nom, new Charge());
		}
		else if (nom == "Choc Psy"){
			this.listeAttaques.put(nom, new ChocPsy());
		}
		else if (nom == "Dard-Venin"){
			this.listeAttaques.put(nom, new DardVenin());
		}
		else if (nom == "Fouet Lianes"){
			this.listeAttaques.put(nom, new FouetLianes());
		}
		else if (nom == "Griffe"){
			this.listeAttaques.put(nom, new Griffe());
		}
		else if (nom == "Morsure"){
			this.listeAttaques.put(nom, new Morsure());
		}
		else if (nom == "Pistolet a O"){
			this.listeAttaques.put(nom, new PistoletAO());
		}
		else if (nom == "Tranch'Herbe"){
			this.listeAttaques.put(nom, new TranchHerbe());
		}
		else if (nom == "Vibraqua"){
			this.listeAttaques.put(nom, new Vibraqua());
		}
		else if (nom == "Vive-Attaque"){
			this.listeAttaques.put(nom, new ViveAttaque());
		}
		else if (nom == "Crocs Feu"){
			this.listeAttaques.put(nom, new CrocsFeu());
		}
		else if (nom == "Coud'Boue"){
			this.listeAttaques.put(nom, new CoudBoue());
		}
		else if (nom == "Double Pied"){
			this.listeAttaques.put(nom, new DoublePied());
		}
		else if (nom == "Draco Charge"){
			this.listeAttaques.put(nom, new DracoCharge());
		}
		else if (nom == "Eclats Glace"){
			this.listeAttaques.put(nom, new EclatsGlace());
		}
		else if (nom == "Etonnement"){
			this.listeAttaques.put(nom, new Etonnement());
		}
		else if (nom == "Lame de Roc"){
			this.listeAttaques.put(nom, new LameDeRoc());
		}
		else if (nom == "Meteores"){
			this.listeAttaques.put(nom, new Meteores());
		}
		else if (nom == "Ouragan"){
			this.listeAttaques.put(nom, new Ouragan());
		}
		else if (nom == "Piqure"){
			this.listeAttaques.put(nom, new Piqure());
		}
		else if (nom == "Poudreuse"){
			this.listeAttaques.put(nom, new Poudreuse());
		}
		else if (nom == "Souplesse"){
			this.listeAttaques.put(nom, new Souplesse());
		}
		else if (nom == "Forte-Paume"){
			this.listeAttaques.put(nom, new FortePaume());
		}
		else if (nom == "Puredpois"){
			this.listeAttaques.put(nom, new Puredpois());
		}
		else if (nom == "Picpic"){
			this.listeAttaques.put(nom, new Picpic());
		}
		else if (nom == "Voix Enjoleuse"){
			this.listeAttaques.put(nom, new VoixEnjoleuse());
		}
		else if (nom == "Vent Feerique"){
			this.listeAttaques.put(nom, new VentFeerique());
		}
		else if (nom == "Lechouille"){
			this.listeAttaques.put(nom, new Lechouille());
		}
		else if (nom == "Queue De Fer"){
			this.listeAttaques.put(nom, new QueueDeFer());
		}
	}

	/**
	 * Fait les test necessaires pour retourner la bonne valeur de la distance de deplacement maximale du pokemon.
	 * @return la distance de deplacement maximale du pokemon
	 */
	public int getCapaciteDeplacement(){
		if(this.effet=="Paralyse"){
			return capaciteDeplacement-1;
		}
		if(this.effet=="Gele"){
			return 0;
		}
		return capaciteDeplacement;
	}

	/**
	 * Setter pour la capacite de deplacement du pokemon.
	 * @param int valeur de la capacite de deplacement du pokemon
	 */
	public void setCapaciteDeplacement(int cap){
		this.capaciteDeplacement=cap;
	}

	/**
	 * Cherche dans la liste d'attaque du pokemon attaquant l'attaque puis attaque le pokemon en parametre avec celle-ci. 
	 * @param Pokemon pokemon recevant l'attaque
	 * @param String nom de l'attaque
	 */
	public void Attack(Pokemon p, String nomAttack){
		if(listeAttaques.containsKey(nomAttack)){
			Attaque tmp = listeAttaques.get(nomAttack);
			tmp.Attack(this,p);
		}
		else {
			System.out.println("Ce pokemon ne connait pas cette attaque.");
		}
		if(p.getPdv()<=0){
            System.out.println(p.getNom() + " est KO !");
        }
	}

	/**
	 * Verifie le type de la case cible par rapport a celle du pokemon pour savoir si le pokemon est apte a aller sur cette case.
	 * @param TypeCase type de la case cible
	 */
	public boolean peutAllerA(TypeCase typeCase){
		if(typeCase==TypeCase.Water){
			if(type!="Eau" && type!="Glace" && type!="Vol")
				return false;
		}
		if(typeCase==TypeCase.Lava){
            if(type!="Vol" && type!="Feu")
                return false;
        }
		if(typeCase==TypeCase.Roof){
            if(type!="Vol")
                return false;
        }  
		return true;
	}

	/**
	 * Fait un tirage aleatoire qui transforme le pokemon en shiny si elle tombe en dessous de 5% et si c'est le cas,
	 * donne a ce pokemon 30 pdv et 5 point d'attaque en plus que la normale.
	 * @param String chemin vers le fichier png du pokemon shiny
	 * @param String chemin vers le fichier png du pokemon normal
	 */
	public void randShiny(String cheminShiny , String chemin){
		int randShiny = (int)(Math.random()*100)+1; 
        if(randShiny <=5){
            this.setCheminImage(cheminShiny);
            this.setPdv(this.getPdv()+30);
            this.setAtk(this.getAtk()+5);
        }
        else {
            this.setCheminImage(chemin);
        }
	}
}