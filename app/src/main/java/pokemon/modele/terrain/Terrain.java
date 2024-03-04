package pokemon.modele.terrain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import pokemon.modele.attaque.Attaque;
import pokemon.modele.pokemon.Pokemon;
import pokemon.modele.terrain.Case.TypeCase;

public class Terrain{

    private TypeCase[][] terrainVolcan = {
		{TypeCase.Rock, TypeCase.Rock , TypeCase.Rock,TypeCase.Rock, TypeCase.Rock , TypeCase.Rock,TypeCase.Rock, TypeCase.Rock,TypeCase.Rock,TypeCase.Lava},
		{TypeCase.Rock, TypeCase.Rock , TypeCase.Rock,TypeCase.Rock, TypeCase.Rock , TypeCase.Rock,TypeCase.Rock, TypeCase.Rock,TypeCase.Rock,TypeCase.Rock},
		{TypeCase.Lava, TypeCase.Rock , TypeCase.Rock,TypeCase.Rock, TypeCase.Rock , TypeCase.Rock,TypeCase.Lava, TypeCase.Lava,TypeCase.Rock,TypeCase.Rock},
		{TypeCase.Lava, TypeCase.Lava , TypeCase.Rock,TypeCase.Rock, TypeCase.Rock , TypeCase.Lava,TypeCase.Lava, TypeCase.Lava,TypeCase.Lava,TypeCase.Rock},
		{TypeCase.Lava, TypeCase.Lava, TypeCase.Rock,TypeCase.Rock, TypeCase.Rock , TypeCase.Lava,TypeCase.Lava, TypeCase.Lava,TypeCase.Rock,TypeCase.Rock},
		{TypeCase.Lava, TypeCase.Lava , TypeCase.Rock,TypeCase.Rock, TypeCase.Rock , TypeCase.Lava,TypeCase.Lava, TypeCase.Lava,TypeCase.Rock,TypeCase.Rock},
        {TypeCase.Lava, TypeCase.Rock , TypeCase.Rock,TypeCase.Rock, TypeCase.Rock , TypeCase.Rock,TypeCase.Lava, TypeCase.Lava,TypeCase.Rock,TypeCase.Rock},
        {TypeCase.Lava, TypeCase.Rock , TypeCase.Rock,TypeCase.Rock, TypeCase.Rock , TypeCase.Rock,TypeCase.Rock, TypeCase.Rock,TypeCase.Rock,TypeCase.Rock},
        {TypeCase.Rock, TypeCase.Rock , TypeCase.Rock,TypeCase.Rock, TypeCase.Rock , TypeCase.Rock,TypeCase.Rock, TypeCase.Rock,TypeCase.Rock,TypeCase.Rock},
        {TypeCase.Rock, TypeCase.Rock , TypeCase.Rock,TypeCase.Rock, TypeCase.Rock , TypeCase.Rock,TypeCase.Lava, TypeCase.Lava,TypeCase.Lava,TypeCase.Rock},
    };

    private TypeCase[][] terrainMontagne = {
		{TypeCase.Rock, TypeCase.Rock , TypeCase.Rock,TypeCase.Rock, TypeCase.Rock , TypeCase.Rock,TypeCase.Rock, TypeCase.Rock,TypeCase.Water,TypeCase.Water},
		{TypeCase.Rock, TypeCase.Rock , TypeCase.Rock,TypeCase.Rock, TypeCase.Rock , TypeCase.Rock,TypeCase.Rock, TypeCase.Rock,TypeCase.Rock,TypeCase.Water},
		{TypeCase.Water, TypeCase.Water , TypeCase.Rock,TypeCase.Rock, TypeCase.Rock , TypeCase.Rock,TypeCase.Rock, TypeCase.Water,TypeCase.Rock,TypeCase.Water},
		{TypeCase.Water, TypeCase.Water , TypeCase.Water,TypeCase.Rock, TypeCase.Rock , TypeCase.Rock,TypeCase.Water, TypeCase.Water,TypeCase.Rock,TypeCase.Water},
		{TypeCase.Water, TypeCase.Water, TypeCase.Water,TypeCase.Rock, TypeCase.Rock , TypeCase.Rock,TypeCase.Water, TypeCase.Water,TypeCase.Rock,TypeCase.Rock},
		{TypeCase.Water, TypeCase.Water , TypeCase.Rock,TypeCase.Rock, TypeCase.Rock , TypeCase.Rock,TypeCase.Water, TypeCase.Water,TypeCase.Rock,TypeCase.Rock},
        {TypeCase.Water, TypeCase.Water , TypeCase.Rock,TypeCase.Rock, TypeCase.Rock , TypeCase.Rock,TypeCase.Water, TypeCase.Water,TypeCase.Rock,TypeCase.Rock},
        {TypeCase.Water, TypeCase.Rock , TypeCase.Rock,TypeCase.Rock, TypeCase.Rock , TypeCase.Rock,TypeCase.Water, TypeCase.Water,TypeCase.Water,TypeCase.Rock},
        {TypeCase.Rock, TypeCase.Rock , TypeCase.Rock,TypeCase.Rock, TypeCase.Rock , TypeCase.Rock,TypeCase.Water, TypeCase.Rock,TypeCase.Rock,TypeCase.Rock},
        {TypeCase.Rock, TypeCase.Rock , TypeCase.Rock,TypeCase.Rock, TypeCase.Rock , TypeCase.Rock,TypeCase.Rock, TypeCase.Rock,TypeCase.Rock,TypeCase.Rock},
    };

    private TypeCase[][] terrainVillage = {
		{TypeCase.Grass, TypeCase.Grass, TypeCase.Roof,TypeCase.Roof, TypeCase.Grass, TypeCase.Grass,TypeCase.Grass, TypeCase.Grass,TypeCase.Rock,TypeCase.Rock},
		{TypeCase.Grass, TypeCase.Grass , TypeCase.Roof, TypeCase.Roof, TypeCase.Grass, TypeCase.Grass,TypeCase.Rock, TypeCase.Rock,TypeCase.Rock,TypeCase.Rock},
		{TypeCase.Grass, TypeCase.Grass , TypeCase.Grass, TypeCase.Grass, TypeCase.Grass , TypeCase.Rock,TypeCase.Rock, TypeCase.Rock,TypeCase.Rock,TypeCase.Rock},
		{TypeCase.Grass, TypeCase.Grass, TypeCase.Grass, TypeCase.Grass, TypeCase.Grass , TypeCase.Rock,TypeCase.Rock,TypeCase.Rock,TypeCase.Water,TypeCase.Rock},
		{TypeCase.Grass, TypeCase.Grass, TypeCase.Grass,TypeCase.Grass, TypeCase.Grass , TypeCase.Rock,TypeCase.Water, TypeCase.Water,TypeCase.Water,TypeCase.Rock},
		{TypeCase.Grass, TypeCase.Grass, TypeCase.Grass,TypeCase.Grass, TypeCase.Grass , TypeCase.Rock,TypeCase.Water, TypeCase.Water,TypeCase.Water,TypeCase.Water},
        {TypeCase.Roof, TypeCase.Grass, TypeCase.Grass, TypeCase.Grass, TypeCase.Grass , TypeCase.Rock, TypeCase.Water, TypeCase.Water,TypeCase.Water,TypeCase.Water},
        {TypeCase.Roof, TypeCase.Grass, TypeCase.Grass,TypeCase.Grass, TypeCase.Grass , TypeCase.Grass, TypeCase.Rock, TypeCase.Water,TypeCase.Water,TypeCase.Rock},
        {TypeCase.Roof, TypeCase.Grass, TypeCase.Grass,TypeCase.Grass, TypeCase.Grass, TypeCase.Grass, TypeCase.Rock, TypeCase.Rock,TypeCase.Water,TypeCase.Rock},
        {TypeCase.Grass, TypeCase.Grass , TypeCase.Grass, TypeCase.Grass, TypeCase.Grass, TypeCase.Grass, TypeCase.Grass, TypeCase.Rock,TypeCase.Rock,TypeCase.Rock},
    };

	public Case [][] tab;
	
	public Terrain(int x, int y) {
		tab=new Case[x][y];
        int tmp = (int)(Math.random()*3)+1;
        switch(tmp){
            case 1://volcan
                for(int i=0; i<x; i++){
                    for(int j=0; j<y; j++){
                        tab[i][j]=new Case(i,j,null, terrainVolcan[i][j]);
                    }
                }
                break;
            case 2://montage
                for(int i=0; i<x; i++){
                    for(int j=0; j<y; j++){
                        tab[i][j]=new Case(i,j,null, terrainMontagne[i][j]);
                    }
                }
                break;
            case 3://village
                for(int i=0; i<x; i++){
                    for(int j=0; j<y; j++){
                        tab[i][j]=new Case(i,j,null, terrainVillage[i][j]);
                    }
                }
                break;
        }
	}
	
    
    // Direction vectors
    static int dRow[] = { -1, 0, 1, 0 };
    static int dCol[] = { 0, 1, 0, -1 };
    
    // Function to check if a cell
    // is be visited or not
    private boolean isValid(Boolean vis[][],int rowPokemon, int colPokemon, int row, int col,int distance, int capaciteDeplacement, String TypePokemon, boolean pokemonAuJoueur1,HashMap<Pokemon,Case> pokemonCaseJoueur1, HashSet<Pair> pairsASupprimer, Pokemon p )
    {
        // If cell lies out of bounds
        if (row < 0 || col < 0 || row >= vis.length || col >= vis[0].length)
            return false;
    
        // If cell is already visited
        if (vis[row][col])
            return false;

		//vérifier si le pokémon a la capacité de déplacement néccessaire
        if(distance>capaciteDeplacement)
            return false;

        if(!p.peutAllerA(tab[row][col].getType()))
            return false; 

        //vérifier si il y a un pokémon ennemi sur la case
        Pokemon pokemonSurLACase=tab[row][col].getPokemon();
        //il y a un pokémon et il n'appartient pas au joueur courant
        if(pokemonSurLACase!=null && pokemonCaseJoueur1.keySet().contains(pokemonSurLACase)!=pokemonAuJoueur1)
            return false;
        //le pokémon appartient au joueur courant en renvoie true, on supprime par la suite cette case
        //car un pokémon a le droit de passer sur un pokémon allié
        if(pokemonSurLACase!=null){
            pairsASupprimer.add(new Pair(row,col,0));
            return true;
        }
        // Otherwise
        return true;
    }
    
    // Function to perform the BFS traversal
    public HashSet<Pair> BFS(int row, int col, HashMap<Pokemon,Case> pokemonCaseJoueur1)
    {
        //avoir le type et capacité de déplacement du pokemon se trouvant sur la case row,col
        Pokemon p=tab[row][col].getPokemon();
        int capaciteDeplacement=p.getCapaciteDeplacement();
        String typePokemon=p.getType();
        boolean pokemonAuJouer1=pokemonCaseJoueur1.keySet().contains(p);//true si le pokémon appartient au joueur 1, false s'il appartient au joueur 2
        //savoir si le pokémon appartient au joueur 1 ou 2
        
        //création d'un tableau de boolean de la taille de tab avec valeur false pour toute les case
		Boolean vis[][]=new Boolean[tab.length][tab[0].length];
		for(int i=0; i<vis.length; i++){
			for(int j=0; j<vis[0].length; j++){
				vis[i][j]=false;
			}
		}

		HashSet<Pair> res=new HashSet<>();

        // Stores indices of the matrix cells
        Queue<Pair > q = new LinkedList<>();
    
        // Mark the starting cell as visited
        // and push it into the queue
        q.add(new Pair(row, col,0));
        res.add(new Pair(row,col,0));
        vis[row][col] = true;
    

        //list des case à supprimer à la fin(on les ajouter juste pour qu'un pokémon passe sur un pokémon allié)
        HashSet<Pair> pairsASupprimer=new HashSet<>(); 

        // Iterate while the queue
        // is not empty
        while (!q.isEmpty() ){
            Pair cell = q.peek();
            int x = cell.getFirst();
            int y = cell.getSecond();
            int distance  = cell.getDistance();
    
            q.remove();
            // Go to the adjacent cells
            for(int i = 0; i < 4; i++){
                int adjx = x + dRow[i];
                int adjy = y + dCol[i];
                
                if (isValid(vis, row, col, adjx, adjy,distance+1, capaciteDeplacement, typePokemon,pokemonAuJouer1,pokemonCaseJoueur1,pairsASupprimer,p)){
                    q.add(new Pair(adjx, adjy,distance+1));
                    vis[adjx][adjy] = true;
					res.add(new Pair(adjx,adjy,distance+1));
                }
            }
        }
        res.removeAll(pairsASupprimer);
        return res;
    }

    /**
     * renvoie le chemin d'accès à l'image du tile correspondant a la case x,y
     * @param x coordonnée x de la case
     * @param y coordonnée y de la case
     * @return le chemin d'accés à l'image du tile correspondant à la case x,y
     */
    public String getPathImageTile(int x, int y) {
        return tab[x][y].getPathImage();
    }

    /**
     * renvoie le chemin d'accès à l'image de sélection du tile correspondant a la case x,y
     * @param x coordonnée x de la case
     * @param y coordonnée y de la case
     * @return le chemin d'accés à l'image de sélection du tile correspondant à la case x,y
     */
    public String getPathImageSelectTile(int x, int y) {
        return tab[x][y].getPathImageSelect();
    }

    /**
     * renvoie le chemin d'accès à l'image attaque du tile correspondant a la case x,y
     * @param x coordonnée x de la case
     * @param y coordonnée y de la case
     * @return le chemin d'accés à l'image attque du tile correspondant à la case x,y
     */
    public String getPathImageAttaqueTile(int x, int y) {
        return tab[x][y].getPathImageAttaque();
    }

    /**
     * renvoie la case x,y du plateau
     * @param x coordonnée x de la case
     * @param y coordonnée y de la case 
     * @return la case x,y
     */
    public Case getCase(int x, int y){
        return tab[x][y];
    }

    /**
     * renvoie la hauteur du plateau
     * @return la hauteur du plateau
     */
    public int getHeight() {
        return tab.length;
    }

    /**
     * renvoie la largeur du plateau
     * @return la largeur du plateau
     */
    public int getWidth() {
        return tab[0].length;
    }

    /**
     * met le pokémon p sur la case x,y, ou enlève le pokémon présent si p=null
     * @param x coordonnée x de la case
     * @param y coordonnée y de la case 
     * @param p pokémon à mettre sur la case, ou null
     */
    public void setPokemon(int x, int y, Pokemon p){
        tab[x][y].setPokemon(p);
    }

    /**
     * renvoie le pokémon qui se trouve sur la case x,y, null si aucun pokémon ne s'y trouve
     * @param x coordonnée x de la case
     * @param y coordonnée y de la case
     * @return le pokémon qui se trouve sur la case x,y, null si aucun pokémon ne s'y trouve
     */
    public Pokemon getPokemon(int x, int y){
        return tab[x][y].getPokemon();
    }

    /**
     * renvoie un ensemble de toutes les coordonnées des cases ou se trouvent
     * les pokémons que le pokémon actuel peut attaquer
     * @param x coordonnée x de la case du pokémon actuel
     * @param y coordonnée y de la case du pokémon actuel
     * @param attaque type d'attaque que le pokémon actuel a choisi pour attaquer
     * @param joueur1 le joueur à qui c'est le tour
     * @param pokemonCaseJoueur1 hashmap pokemon,case du joueur1
     * @return un ensemble de toutes les coordonnées des cases ou se trouvent
     * les pokémons que le pokémon actuel peut attaquer
     */
    public HashSet<Pair> casesAAttaquer(int x,int y, Attaque attaque, boolean joueur1, HashMap<Pokemon, Case> pokemonCaseJoueur1) {
        HashSet<Pair> res=new HashSet<>();
        boolean haut=false,bas=false,droite=false,gauche=false;
        if(attaque.jusquADistanceMax()){//on peut attaquer toutes les cases jusqu'à distance max
            for(int i=1; i<=attaque.getDistanceMaxAttaque(); i++){
                if(x-i>=0 && getPokemon(x-i,y)!=null && appartientAuJoueur(getPokemon(x-i,y),!joueur1,pokemonCaseJoueur1) && (!gauche || attaque.passeObstacle())){
                    res.add(new Pair(x-i,y,0));
                    gauche=true;
                }
                if(x-i>=0 && getPokemon(x-i,y)!=null)
                    gauche=true;
                if(x+i<getHeight() && getPokemon(x+i,y)!=null && appartientAuJoueur(getPokemon(x+i,y),!joueur1,pokemonCaseJoueur1) && (!droite || attaque.passeObstacle())){
                    res.add(new Pair(x+i,y,0));
                    droite=true;
                }
                if(x+i<getHeight() && getPokemon(x+i,y)!=null)
                    droite=true;
                if(y+i<getWidth() && getPokemon(x,y+i)!=null && appartientAuJoueur(getPokemon(x,y+i),!joueur1,pokemonCaseJoueur1) && (!haut || attaque.passeObstacle())){
                    res.add(new Pair(x,y+i,0));
                    haut=true;
                }
                if(y+i<getWidth() && getPokemon(x,y+i)!=null)
                    haut=true;
                if(y-i>=0 && getPokemon(x,y-i)!=null && appartientAuJoueur(getPokemon(x,y-i),!joueur1,pokemonCaseJoueur1) && (!bas || attaque.passeObstacle())){
                    res.add(new Pair(x,y-i,0));
                    bas=true;
                }
                if(y-i>=0 && getPokemon(x,y-i)!=null)
                    bas=true;
            }
        }
        else{//on peut attaquer les cases plus loin de exactement distance max
            for(int i=1; i<attaque.getDistanceMaxAttaque(); i++){
                if(x-i>=0 && getPokemon(x-i,y)!=null && !gauche)
                    gauche=true;
                if(x+i<getHeight() && getPokemon(x+i,y)!=null && !droite)
                    droite=true;
                if(y+i<getWidth() && getPokemon(x,y+i)!=null && !haut)
                    haut=true;
                if(y-i>=0 && getPokemon(x,y-i)!=null && !bas)
                    bas=true;
            }
            int i=attaque.getDistanceMaxAttaque();
            if(x-i>=0 && getPokemon(x-i,y)!=null && appartientAuJoueur(getPokemon(x-i,y),!joueur1,pokemonCaseJoueur1) && (!gauche || attaque.passeObstacle()))
                res.add(new Pair(x-i,y,0));
            if(x+i<getHeight() && getPokemon(x+i,y)!=null && appartientAuJoueur(getPokemon(x+i,y),!joueur1,pokemonCaseJoueur1) && (!droite || attaque.passeObstacle()))
                res.add(new Pair(x+i,y,0));
            if(y+i<getWidth() && getPokemon(x,y+i)!=null && appartientAuJoueur(getPokemon(x,y+i),!joueur1,pokemonCaseJoueur1) && (!haut || attaque.passeObstacle()))
                res.add(new Pair(x,y+i,0));
            if(y-i>=0 && getPokemon(x,y-i)!=null && appartientAuJoueur(getPokemon(x,y-i),!joueur1,pokemonCaseJoueur1) && (!bas || attaque.passeObstacle()))
                res.add(new Pair(x,y-i,0));
        }
        return res;
    }

    /**
     * renvoie true si le pokémon pokemon appartient au 
     *  joueur1 si joueur1=true
     *  joueur2 si joueur1=false
     *  false sinon
     * @param pokemon un pokémon
     * @param joueur1 true pour joueur1, et false pour joueur 2
     * @param pokemonCaseJoueur1 hashmap pokemon,case du joueur1
     * @return  renvoie true si le pokémon pokemon appartient au 
     *  joueur1 si joueur1=true
     *  joueur2 si joueur1=false
     *  false sinon 
     */
    private boolean appartientAuJoueur(Pokemon pokemon, boolean joueur1, HashMap<Pokemon, Case> pokemonCaseJoueur1) {
        //si joueur1 et pokemon est dans la liste de joueur1
        if(joueur1 && pokemonCaseJoueur1.keySet().contains(pokemon))
            return true;
        //si joueur2 et pokemon est dans la liste du joueur2
        else if(!joueur1 && !pokemonCaseJoueur1.keySet().contains(pokemon))
            return true;
        //sinon le pokemon n'est pas au joueur
        return false;
    }

    
}
