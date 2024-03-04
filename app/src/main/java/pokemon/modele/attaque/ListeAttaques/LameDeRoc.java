package pokemon.modele.attaque.ListeAttaques;

import pokemon.modele.attaque.Attaquetypes.*;
import pokemon.modele.pokemon.Pokemon;

public class LameDeRoc extends AttaqueRoche{
    @Override
    public int getDistanceMaxAttaque(){
        return 1;
    }

    public String getInfo(){
        return "Fait surgir des pierres aiguisees sous l'ennemi. Taux de critiques eleve. (2x)";
    }

    @Override
    public String Attack(Pokemon p, Pokemon b){
        String info = p.getNom()+" utilise l'attaque Lame De Roc !\n";
        p.setCrit(p.getCrit()*2);
        info += super.Attack(p,b);
        p.setCrit(p.getCrit()/2);
        return info;
    }
}
