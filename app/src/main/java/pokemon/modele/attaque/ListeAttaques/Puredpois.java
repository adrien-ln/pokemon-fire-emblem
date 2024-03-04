package pokemon.modele.attaque.ListeAttaques;

import pokemon.modele.attaque.Attaquetypes.*;
import pokemon.modele.pokemon.Pokemon;

public class Puredpois extends AttaquePoison{
    @Override
    public int getDistanceMaxAttaque(){
        return 1;
    }

    public String getInfo(){
        return "Le lanceur attaque a l'aide d'une eruption de gaz repugnants. Peut aussi empoisonner l'ennemi. \n(40%. Poison = -1 pv après chaque action.)";
    }

    public void effet(Pokemon b){
        int tmp = (int)(Math.random()*100)+1; 
        if(tmp <= 40){
            b.setEffet("Poison");
        }
    }

    @Override
    public String Attack(Pokemon p, Pokemon b){
        String info = p.getNom()+" utilise l'attaque Puredpois !\n";
        info += super.Attack(p,b);
        effet(b);
        return info;
    }
}