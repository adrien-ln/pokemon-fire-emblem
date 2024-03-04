package pokemon.controleur;
import java.util.*;

import pokemon.modele.attaque.Attaque;
import pokemon.modele.jeux.Jeux;
import pokemon.modele.pokemon.*;
import pokemon.modele.terrain.Case;
import pokemon.modele.terrain.Pair;
import pokemon.modele.terrain.Terrain;
import pokemon.vue.Vue;

public class Controleur {
    private boolean deplacerPokemon;
    private Terrain terrain;
    private Vue vue;
    private Jeux jeux;
    /**
     * dernières cases sélectionnées 
     */
    private HashSet<Pair> listCasesPossibles;
    private Pokemon dernierPokCible;

    public Controleur(Vue vue){
        this.vue=vue;
        HashMap<Pokemon,Case> pokemonsJ1=new HashMap<>();
        HashMap<Pokemon,Case> pokemonsJ2=new HashMap<>();
        
        LinkedList<Pokemon> listePokemons=new LinkedList<>();
        LinkedList<String> listePokemonsCommun=new LinkedList<>();
        LinkedList<String> listePokemonsPeuCommun=new LinkedList<>();
        LinkedList<String> listePokemonsRare=new LinkedList<>();

        listePokemonsCommun.add("Abo");
        listePokemonsCommun.add("Abra");
        listePokemonsCommun.add("Chenipan");
        listePokemonsCommun.add("Smogo");
        listePokemonsCommun.add("Evoli");
        listePokemonsCommun.add("Rattata");
        listePokemonsCommun.add("NidoranF");
        listePokemonsCommun.add("NidoranM");
        listePokemonsCommun.add("Melofee");
        listePokemonsCommun.add("Voltorbe");
        listePokemonsPeuCommun.add("Salameche"); 
        listePokemonsPeuCommun.add("Bulbizarre");
        listePokemonsPeuCommun.add("Carapuce");
        listePokemonsPeuCommun.add("Pikachu");
        listePokemonsPeuCommun.add("Riolu");
        listePokemonsPeuCommun.add("Minidraco");
        listePokemonsPeuCommun.add("Nodulithe");
        listePokemonsRare.add("Absol");
        listePokemonsRare.add("Oniglali");
        listePokemonsRare.add("Ronflex");
        listePokemonsRare.add("Milobellus");

        Random rand=new Random();
        for (int i = 0;i<8;i++){
            int rarete = (int)(Math.random()*100)+1; 
            if(rarete<=10){
                int aleaListe = rand.nextInt(listePokemonsRare.size());
                String pokemon = listePokemonsRare.get(aleaListe);
                switch(pokemon){
                    case "Absol":
                        listePokemons.add(new Absol());
                        break;
                    case "Oniglali":
                        listePokemons.add(new Oniglali());
                        break;
                    case "Ronflex":
                        listePokemons.add(new Ronflex());
                        break;
                    case "Milobellus":
                        listePokemons.add(new Milobellus());
                        break;
                }
            }
            else if (rarete>10 && rarete <=45){
                int aleaListe = rand.nextInt(listePokemonsPeuCommun.size());
                String pokemon = listePokemonsPeuCommun.get(aleaListe);
                switch(pokemon){
                    case "Salameche":
                        listePokemons.add(new Salameche());
                        break;
                    case "Bulbizarre":
                        listePokemons.add(new Bulbizarre());
                        break;
                    case "Carapuce":
                        listePokemons.add(new Carapuce());
                        break;
                    case "Pikachu":
                        listePokemons.add(new Pikachu());
                        break;
                    case "Riolu":
                        listePokemons.add(new Riolu());
                        break;
                    case "Minidraco":
                        listePokemons.add(new Minidraco());
                        break;
                    case "Nodulithe":
                        listePokemons.add(new Nodulithe());
                        break;
                }
            }
            else {
                int aleaListe = rand.nextInt(listePokemonsCommun.size());
                String pokemon = listePokemonsCommun.get(aleaListe);
                switch(pokemon){
                    case "Abo":
                        listePokemons.add(new Abo());
                        break;
                    case "Abra":
                        listePokemons.add(new Abra());
                        break;
                    case "Chenipan":
                        listePokemons.add(new Chenipan());
                        break;
                    case "Smogo":
                        listePokemons.add(new Smogo());
                        break;
                    case "Evoli":
                        listePokemons.add(new Evoli());
                        break;
                    case "Rattata":
                        listePokemons.add(new Rattata());
                        break;
                    case "NidoranF":
                        listePokemons.add(new NidoranF());
                        break;
                    case "NidoranM":
                        listePokemons.add(new NidoranM());
                        break;
                    case "Melofee":
                        listePokemons.add(new Melofee());
                        break;
                    case "Voltorbe":
                        listePokemons.add(new Voltorbe());
                        break;
                }
            }
        }

        int nbAlea=rand.nextInt(listePokemons.size());
		pokemonsJ1.put(listePokemons.get(nbAlea),null);
        listePokemons.remove(nbAlea);
        nbAlea=rand.nextInt(listePokemons.size());
        pokemonsJ2.put(listePokemons.get(nbAlea),null);
        listePokemons.remove(nbAlea);
        nbAlea=rand.nextInt(listePokemons.size());
        pokemonsJ1.put(listePokemons.get(nbAlea),null);
        listePokemons.remove(nbAlea);
        nbAlea=rand.nextInt(listePokemons.size());
        pokemonsJ2.put(listePokemons.get(nbAlea),null);
        listePokemons.remove(nbAlea);
        nbAlea=rand.nextInt(listePokemons.size());
        pokemonsJ1.put(listePokemons.get(nbAlea),null);
        listePokemons.remove(nbAlea);
        nbAlea=rand.nextInt(listePokemons.size());
        pokemonsJ2.put(listePokemons.get(nbAlea),null);
        listePokemons.remove(nbAlea);
        nbAlea=rand.nextInt(listePokemons.size());
		pokemonsJ1.put(listePokemons.get(nbAlea),null);
        listePokemons.remove(nbAlea);
        nbAlea=rand.nextInt(listePokemons.size());
        pokemonsJ2.put(listePokemons.get(nbAlea),null);
        listePokemons.remove(nbAlea);
        
		terrain=new Terrain(10,10);
		jeux= new Jeux(pokemonsJ1,pokemonsJ2,terrain);
		jeux.setControleur(this);
    }

    public void setVue(Vue vue){
        this.vue=vue;
    }

    /**
     * pose les pokémons des deux joueur sur le terrain
     * et sélectionne le premier pokémon à déplacer du joueur 1
     */
    public void commencer() {
        vue.miseAJourInformations("Joueur 1");
        jeux.poserPokemons();
        jeux.selectPokemon();
    }

    /**
     * met à jour le joueur actuel dans vue
     * @param joueur le joueur actuel
     */
    public void miseAJourInformations(String joueur) {
        vue.miseAJourInformations(joueur);
    }


    public void miseAJourInfosPokemons(Pokemon p, boolean joueur1){
        vue.miseAJourInfosPokemons(p, joueur1);
    }
    
    /**
     * sélectionne dans la vue toutes les cases possibles auquelles le pokémon
     * se trouvant sur la tile x,y peut y aller 
     * @param x coordonnée x de la tile
     * @param y coordonnée y de la tile
     */
    public void selectionnerCasePossibles(int x, int y) {
        listCasesPossibles=jeux.BFS(x, y);
        vue.selectTiles(listCasesPossibles,jeux.getJoueurActuel());
    }

    /**
     * désélectionne les cases qu'on a sélectionnées pour le déplacement du pokémon
     */
    public void deselectionnerCasesPossibles(){
        vue.deselectTiles(listCasesPossibles, jeux.getJoueurActuel());
    }

    /**
     * renvoie le chemin de d'image de la Tile de coordonnées (x,y)
     * @param x coordonnée x
     * @param y coordonnée y
     * @return chemin de l'image de la Tile
     */
    public String getPathImageTile(int x, int y){
        return terrain.getPathImageTile(x,y);
    }

    /**
     * renvoie le chemin de l'image selection la Tile de coordonnées (x,y)
     * @param x coordonnée x
     * @param y coordonnée y
     * @return chemin de l'image selection de la Tile
     */
    public String getPathImageSelectTile(int x, int y){
        return terrain.getPathImageSelectTile(x, y);
    }

    /**
     * renvoie le chemin de l'image attaque de la Tile de coordonnées (x,y)
     * @param x coordonnée x
     * @param y coordonnée y
     * @return chemin de l'image attaque de la Tile
     */
    public String getPathImageAttaqueTile(int x, int y) {
        return terrain.getPathImageAttaqueTile(x,y);
    }

    /**
     * renvoie la hauteur du plateau
     * @return la hauteur du plateau
     */
    public int getWidth() {
        return terrain.getWidth();
    }

    /**
     * renvoie la largeur du plateau
     * @return la largeur du plateau
     */
    public int getHeight() {
        return terrain.getHeight();
    }
    
    /**
     * met le pokémon p dans la tile x,y de vue
     * @param p le pokémon à placer
     * @param x coordonnée x de la tile
     * @param y coordonnée y de la tile 
     */
    public void placerPokemon(Pokemon p, int x, int y) {
        vue.placerPokemon(x, y, p.getCheminImage());
    }
  
    /**
     * déplace le pokémon qui doit être dans la case x,y dans model
     * @param x coordonnée x de la case d'arrivée 
     * @param y coordonnée y de la case d'arrivée 
     */
    public void deplacerPokemon(int x, int y) {
        jeux.deplacerPokemon(x,y);
    }

    /**
     * déplace le pokémon se trouvant sur le tile de coordonnées tile1 vers le tile de 
     * coordonnées tile2 dans vue 
     * @param tile1 coordonnées de la tile de départ
     * @param tile2 coordonnées de la tile d'arrivée
     * @param pathImagePokemon le chemin d'accès à l'image du pokémon à déplacer
     */
    public void deplacerPokemonDansVue(Pair tile1, Pair tile2, String pathImagePokemon){
        vue.deplacerPokemon(tile1, tile2, pathImagePokemon);
    }

    public Jeux getJeux(){
        return this.jeux;
    }

    public Map<String,Attaque> getListeAttaquesPokemon(){
        Pokemon p = jeux.getPokemonActuel();
        return p.getListeAttaque();
    }

    public void afficherBoutons(boolean joueur1){
        vue.showBoutons(joueur1);
    }

    public void selectTiles(HashSet<Pair> tiles, boolean joueur1){
        vue.selectTiles(tiles, joueur1);
    }
    public void deselectTiles(HashSet<Pair> tiles, boolean joueur1){
        vue.deselectTiles(tiles, joueur1);
    }
    public void deselectTile(Pair coordonnees) {
        vue.deselectTile(coordonnees.getFirst(), coordonnees.getSecond());
    }

    public void deselectionnerAutresCases(int x, int y) {
        jeux.deselectionnerAutresCases(x,y);
    }

    public void colorerCasesAAttaquer(String attaque){
        HashSet<Pair> casesAAttaquer=jeux.casesAAttaquer(attaque);
        vue.colorerCasesAAttaquer(casesAAttaquer);
    }

    public void decolorerCasesAAttaquer(HashSet<Pair> listCasesAAttaquer) {
        vue.decolorerCasesAAttaquer(listCasesAAttaquer);
        listCasesAAttaquer.clear();
    }

    public void decolorerCasesAAttaquer(){
        vue.decolorerCasesAAttaquer(jeux.getListCasesAAttaquer());
    }

    public Pair getCoordonneesPokemonActuel(){
        return jeux.getCoordonneesPokemonActuel();
    }

    public void attaquer(int x, int y) {
        jeux.attaquer(x,y);
    }

    public void partieFinie(boolean joueurGagnant){
        vue.afficherFinPartie(joueurGagnant);
    }    
    public Pokemon getPokeDansCase(int x,int y){
        return terrain.getPokemon(x, y);
    }

    public boolean getJoueurActuel(){
        return jeux.getJoueurActuel();
    }

    public void cibleVisible(int x, int y) {
        Pokemon p=getPokeDansCase(x, y);
        dernierPokCible = p;
        vue.cibleVisible(p, jeux.getJoueurActuel(), jeux.appartienAJoueur1(p));
    }

    public boolean pokInCaseAppartientAJoueur1(int x, int y){
        return jeux.appartienAJoueur1(terrain.getPokemon(x, y));
    }

    public void cibleInvisibleDernierPok(){
        vue.cibleInvisible(dernierPokCible, jeux.getJoueurActuel(), jeux.appartienAJoueur1(dernierPokCible));
    }

    public void cibleInvisible(int x, int y) {
        Pokemon p=getPokeDansCase(x, y);
        vue.cibleInvisible(p, jeux.getJoueurActuel(), jeux.appartienAJoueur1(p));
    }

    public void setVisibleBoutonRetour(boolean b) {
        vue.setVisibleBoutonRetour(b, jeux.getJoueurActuel());
    }

    public void setVisibleBoutonFin(boolean b) {
        vue.setVisibleBoutonFin(b, jeux.getJoueurActuel());
    }

    public Map<Pokemon, Case> getPokemonCaseJoueur1() {
        return jeux.getPokemonCaseJoueur1();
    }

    public Map<Pokemon, Case> getPokemonCaseJoueur2() {
        return jeux.getPokemonCaseJoueur2();
    }


    public boolean getDeplacerPokemon() {
        return deplacerPokemon;
    }

    public void setDeplacerPokemon(boolean b) {
        deplacerPokemon=b;
    }

    public void enleverPokemon(int x, int y) {
        vue.enleverPokemon(x, y);
    }
    public void annulerD(){
        jeux.annulerDeplacement(vue.getXPrec(jeux.getJoueurActuel()),vue.getYPrec(jeux.getJoueurActuel()));
    }

    public void setXPrec(int x){
        vue.setXPrec(x,jeux.getJoueurActuel());
    }

    public void setYPrec(int y){
        vue.setYPrec(y,jeux.getJoueurActuel());
    }

    public void testEffet(){
        jeux.testEffet();
        //miseAJourInfosPokemons(terrain.getPokemon(x, y),jeux.getJoueurActuel());
    }

    public void finTour(boolean pokemon){
        vue.finTour(jeux.getJoueurActuel(),pokemon);
    }

    public void hit(){
        vue.hit();
    }

    public void setInvisibleInfosAttaque(boolean joueur1) {
        vue.setInvisibleInfosAttaque(joueur1);
    }

    public Vue getVue(){
        return vue;
    }

    public void ecrireAttaquePokemon(String joueurAttaque, String joueurCible,String pokemonAttaque,String pokemonCible,int degats) {
        vue.ecrireAttaquePokemon(joueurAttaque, joueurCible, pokemonAttaque, pokemonCible, degats);
    }

    public void ecrireInitEffetPokemon(String pokemon,String effet) {
        vue.ecrireInitEffetPokemon(pokemon,effet);
    }

    public void ecrireHistorique(String historique) {
        vue.ecrireHistorique(historique);
    }

    public void ecrireEffetPokemon(String pokemon,String effet,int degats) {
        vue.ecrireEffetPokemon(pokemon,effet,degats);
    }
}

