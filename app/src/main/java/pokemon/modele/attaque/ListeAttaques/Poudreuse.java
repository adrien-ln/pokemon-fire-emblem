package pokemon.modele.attaque.ListeAttaques;

import pokemon.modele.attaque.Attaquetypes.*;
import pokemon.modele.pokemon.Pokemon;

public class Poudreuse extends AttaqueGlace{
    @Override
    public int getDistanceMaxAttaque(){
        return 2;
    }

    public String getInfo(){
        return "Le lanceur projette de la neige poudreuse. Peut aussi geler l'ennemi. \n(10%. Gele = Ne peut plus se deplacer.";
    }

    public void effet(Pokemon b){
        int tmp = (int)(Math.random()*100)+1; 
        if(tmp <= 10){
            b.setEffet("Gele");
        }
    }

    @Override
    public String Attack(Pokemon p, Pokemon b){
        String info = p.getNom()+" utilise l'attaque Poudreuse !\n";
        info += super.Attack(p,b);
        effet(b);
        return info;
    }
}