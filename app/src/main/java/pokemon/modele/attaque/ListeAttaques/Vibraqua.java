package pokemon.modele.attaque.ListeAttaques;

import pokemon.modele.attaque.Attaquetypes.*;
import pokemon.modele.pokemon.Pokemon;

public class Vibraqua extends AttaqueEau{
    @Override
    public int getDistanceMaxAttaque(){
        return 2;
    }

    public String getInfo(){
        return "Le lanceur envoie un puissant jet d'eau sur l'ennemi. Peut le rendre confus. \n(20%. Confus = 33% de rater son attaque et se blesser , disparait entre 1 et 3 tour.";
    }

    public void effet(Pokemon b){
        int tmp = (int)(Math.random()*100)+1; 
        if(tmp <= 20){
            b.setConfus(true);
        }
    }

    @Override
    public String Attack(Pokemon p, Pokemon b){
        String info = p.getNom()+" utilise l'attaque Vibraqua !\n";
        info += super.Attack(p,b);
        effet(b);
        return info;
    }
}