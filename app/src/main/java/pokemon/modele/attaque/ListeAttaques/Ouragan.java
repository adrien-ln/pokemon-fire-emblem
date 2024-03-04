package pokemon.modele.attaque.ListeAttaques;

import pokemon.modele.attaque.Attaquetypes.*;
import pokemon.modele.pokemon.Pokemon;

public class Ouragan extends AttaqueDragon{
    @Override
    public int getDistanceMaxAttaque(){
        return 2;
    }
    
    public boolean jusquADistanceMax(){
        return false;
    }

    public String getInfo(){
        return "Declenche un terrible ouragan sur l'ennemi. Peut aussi l'apeurer. \n(20%. Peur = ne peut rien faire pendant 1 tour";
    }

    public void effet(Pokemon b){
        int tmp = (int)(Math.random()*100)+1; 
        if(tmp <= 20){
            b.setPeur(true);
        }
    }

    @Override
    public String Attack(Pokemon p, Pokemon b){
        String info = p.getNom()+" utilise l'attaque Ouragan !\n";
        info += super.Attack(p,b);
        effet(b);
        return info;
    }

    @Override
    public boolean passeObstacle(){
        return true;
    }
}