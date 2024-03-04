package pokemon.modele.attaque.ListeAttaques;

import pokemon.modele.attaque.Attaquetypes.*;
import pokemon.modele.pokemon.Pokemon;

public class DracoCharge extends AttaqueDragon{
    @Override
    public int getDistanceMaxAttaque(){
        return 1;
    }

    public String getInfo(){
        return "Le lanceur frappe l’ennemi en prenant un air menaçant. Peut aussi l’apeurer. \n(20%. Peur = ne peut rien faire pendant 1 tour";
    }

    public void effet(Pokemon b){
        int tmp = (int)(Math.random()*100)+1; 
        if(tmp <= 20){
            b.setPeur(true);
        }
    }

    @Override
    public String Attack(Pokemon p, Pokemon b){
        String info = p.getNom()+" utilise l'attaque Draco Charge !\n";
        info += super.Attack(p,b);
        effet(b);
        return info;
    }
}