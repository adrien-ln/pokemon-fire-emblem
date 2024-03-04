package pokemon.modele.attaque.ListeAttaques;

import pokemon.modele.attaque.Attaquetypes.*;
import pokemon.modele.pokemon.Pokemon;

public class Etonnement extends AttaqueSpectre{
    @Override
    public int getDistanceMaxAttaque(){
        return 1;
    }

    public String getInfo(){
        return "Le lanceur attaque l'ennemi en poussant un cri terrifiant. Peut aussi l'apeurer.\n(30%. Peur = ne peut rien faire pendant 1 tour)";
    }

    public void effet(Pokemon b){
        int tmp = (int)(Math.random()*100)+1; 
        if(tmp <= 30){
            b.setPeur(true);
        }
    }

    @Override
    public String Attack(Pokemon p, Pokemon b){
        String info = p.getNom()+" utilise l'attaque Etonnement !\n";
        info += super.Attack(p,b);
        effet(b);
        return info;
    }
}