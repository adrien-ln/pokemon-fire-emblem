package pokemon.modele.attaque.ListeAttaques;

import pokemon.modele.attaque.Attaquetypes.*;
import pokemon.modele.pokemon.Pokemon;

public class DardVenin extends AttaquePoison{
    @Override
    public int getDistanceMaxAttaque(){
        return 1;
    }

    public String getInfo(){
        return "Un dard toxique qui transperce l'ennemi. Peut aussi l'empoisonner. \n(30%. Poison = 1/16 des pdv actuel apres chaque action.)";
    }

    public void effet(Pokemon b){
        int tmp = (int)(Math.random()*100)+1; 
        if(tmp <= 30){
            b.setEffet("Poison");
        }
    }

    @Override
    public String Attack(Pokemon p, Pokemon b){
        String info = p.getNom()+" utilise l'attaque Dard-Venin !";
        info += super.Attack(p,b);
        effet(b);
        return info;
    }
}