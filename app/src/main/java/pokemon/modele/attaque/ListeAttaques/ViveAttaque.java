package pokemon.modele.attaque.ListeAttaques;

import pokemon.modele.attaque.Attaquetypes.*;
import pokemon.modele.pokemon.Pokemon;

public class ViveAttaque extends AttaqueNormal{
    @Override
    public int getDistanceMaxAttaque(){
        return 1;
    }

    public String getInfo(){
        return "Le lanceur fonce sur l'ennemi si rapidement qu'on parvient a peine a le discerner.";
    }

    @Override
    public String Attack(Pokemon p, Pokemon b){
        String info = p.getNom()+" utilise l'attaque Vive-Attaque !\n";
        return info+super.Attack(p,b);
    }
}