package pokemon.modele.attaque.ListeAttaques;

import pokemon.modele.attaque.Attaquetypes.*;
import pokemon.modele.pokemon.Pokemon;

public class DoublePied extends AttaqueCombat{
    @Override
    public int getDistanceMaxAttaque(){
        return 1;
    }

    public String getInfo(){
        return "Deux coups de pied qui frappent l'ennemi deux fois d'affilee.";
    }

    @Override
    public String Attack(Pokemon p, Pokemon b){
        String info = p.getNom()+" utilise l'attaque Double Pied !\n";
        int tmp = p.getAtk();
        p.setAtk((tmp/5)*3);
        info += "Coup 1 : "+super.Attack(p,b);
        info += "Coup 2 : "+super.Attack(p,b);
        p.setAtk(tmp);
        return info;
    }
}