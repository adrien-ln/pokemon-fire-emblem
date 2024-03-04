package pokemon.modele.attaque.ListeAttaques;

import pokemon.modele.attaque.Attaquetypes.*;
import pokemon.modele.pokemon.Pokemon;

public class QueueDeFer extends AttaqueAcier{
    @Override
    public int getDistanceMaxAttaque(){
        return 1;
    }

    public String getInfo(){
        return "Attaque l'ennemi avec une queue de fer.";
    }

    @Override
    public String Attack(Pokemon p, Pokemon b){
        String info = p.getNom()+" utilise l'attaque Queue De Fer !\n";
        return info+super.Attack(p,b);
    }
}