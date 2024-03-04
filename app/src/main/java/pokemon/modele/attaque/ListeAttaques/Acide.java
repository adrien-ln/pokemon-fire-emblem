package pokemon.modele.attaque.ListeAttaques;

import pokemon.modele.attaque.Attaquetypes.*;
import pokemon.modele.pokemon.Pokemon;

public class Acide extends AttaquePoison{
    @Override
    public int getDistanceMaxAttaque(){
        return 2;
    }

    public boolean jusquADistanceMax(){
        return false;
    }

    public String getInfo(){
        return "Le lanceur attaque l’ennemi avec un jet d’acide corrosif.";
    }

    @Override
    public String Attack(Pokemon p, Pokemon b){
        String info = p.getNom()+" utilise l'attaque Acide !\n";
        return info+super.Attack(p,b);
    }
}