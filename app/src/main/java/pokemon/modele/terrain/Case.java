package pokemon.modele.terrain;

import pokemon.modele.pokemon.Pokemon;

public class Case {


	public enum TypeCase{
		Grass("Grass"),Rock("Rock"),Lava("Lava"),Water("Water"),Roof("Roof");
		private final String type;
		private TypeCase(String type){
			this.type = type;
		}
	}

	/**
	 * le type de la case Grass, Rock, Lava, Water ou Roof
	 */
	private TypeCase typeCase;
	/**
	 * pokémon se trouvant sur la case,
	 * ou null s'il n'y en a pas
	 */
	private Pokemon pokemon;  
	/**
	 * coordonnée x sur le plateau
	 */
	private int x;
	/**
	 * coordonnée y sur le plateau
	 */
	private int y;
	/**
	 * le chemin d'accès à l'image du tile correspondant à la case 
	 */
	private String pathImage;
	/**
	 * le chemin d'accès à l'image de sélection du tile correspondant à la case 
	 */
	private String pathImageSelect;
	/**
	 * le chemin d'accès à l'image attaque du tile correspondant à la case 
	 */
	private String pathImageAttaque;

	public Case(int i, int j, Pokemon p, TypeCase type){
		typeCase=type;
		x=i;
		y=j;
		pokemon=p;
		
		//choisir les images normal, selection et attaque en focntion du type de la case 
		switch(typeCase){
			case Grass:
				pathImage="src/main/resources/grass_texture.png";
				pathImageSelect="src/main/resources/grass_texture_select.png";
				pathImageAttaque="src/main/resources/grass_texture_red.png";
				break;
			case Rock:
				pathImage="src/main/resources/rock_texture.png";
				pathImageSelect="src/main/resources/rock_texture_select.png";
				pathImageAttaque="src/main/resources/rock_texture_red.png";
				break;
			case Lava:
				pathImage="src/main/resources/lava_texture.png";
				pathImageSelect="src/main/resources/lava_texture_select.png";
				pathImageAttaque="src/main/resources/lava_texture_red.png";
				break;
			case Water:
				pathImage="src/main/resources/water_texture.png";
				pathImageSelect="src/main/resources/water_texture_select.png";
				pathImageAttaque="src/main/resources/water_texture_red.png";
				break;
			case Roof:
				pathImage="src/main/resources/roof_texture.png";
				pathImageSelect="src/main/resources/roof_texture_select.png";
				pathImageAttaque="src/main/resources/roof_texture_red.png";
				break;
		}
	}

	/**
	 * renvoie la coordonnée x de la case sur le plateau
	 * @return coordonnée x de la case
	 */
	public int getPosI(){
		return x;
	}
	/**
	 * renvoie la coordonnée y de la case sur le plateau
	 * @return coordonnée y de la case
	 */
	public int getPosJ(){
		return y;
	}

	/**
	 * met à jour la valeur pokemon
	 * @param k un pokemon, ou null pour enlever le pokémon de la case 
	 */
    public void setPokemon(Pokemon k) {
		pokemon=k;
    }

	/**
	 * renvoie le pokémon se trouvant sur la case
	 * @return le pokémon se trouvant sur la case 
	 */
	public Pokemon getPokemon() {
		return pokemon;
	}

	/**
	 * renvoie le type de la case 
	 * @return le type de la case 
	 */
	public TypeCase getType(){
		return typeCase;
	}

	/**
	 * renvoie le chemin d'accès à l'image de la tile correspondante à la case 
	 * @return le chemin d'accès à l'image de la tile correspondante à la case 
	 */
	public String getPathImage(){
		return pathImage;
	}

	/**
	 * renvoie le chemin d'accès à l'image de sélection de la tile correspondante à la case 
	 * @return le chemin d'accès à l'image de sélection de la tile correspondante à la case
	 */
	public String getPathImageSelect(){
		return pathImageSelect;
	}

	/**
	 * renvoie le chemin d'accès à l'image attaque de la tile correspondante à la case 
	 * @return le chemin d'accès à l'image attaque de la tile correspondante à la case
	 */
    public String getPathImageAttaque() {
        return pathImageAttaque;
    }
}
