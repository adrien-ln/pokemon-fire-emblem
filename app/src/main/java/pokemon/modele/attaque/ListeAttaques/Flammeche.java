package pokemon.modele.attaque.ListeAttaques;

import pokemon.modele.attaque.Attaquetypes.*;
import pokemon.modele.pokemon.Pokemon;

public class Flammeche extends AttaqueFeu{
    @Override
    public int getDistanceMaxAttaque(){
        return 2;
    }

    public String getInfo(){
        return "L'ennemi est attaque par une faible flamme. Peut aussi le bruler. \n(10%. Brulure = -1/16 des pdv actuel après chaque action.)";
    }

    public void effet(Pokemon b){
        int tmp = (int)(Math.random()*100)+1; 
        if(tmp <= 10){
            b.setEffet("Brule");
        }
    }

    @Override
    public String Attack(Pokemon p, Pokemon b){
        String info = p.getNom()+" utilise l'attaque Flammeche !\n";
        info += super.Attack(p,b);
        effet(b);
        return info;
    }
}