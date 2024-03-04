package pokemon.modele.attaque.ListeAttaques;

import pokemon.modele.attaque.Attaquetypes.*;
import pokemon.modele.pokemon.Pokemon;

public class Belier extends AttaqueNormal{
    @Override
    public int getDistanceMaxAttaque(){
        return 1;
    }

    public String getInfo(){
        return "Une charge violente qui blesse aussi legerement le lanceur. (-1/16 des pdv actuel)";
    }

    @Override
    public String Attack(Pokemon p, Pokemon b){
        String info = p.getNom()+" utilise l'attaque Belier !\n";
        int tmp = p.getAtk();
        int degats =p.getPdv()/16;
        p.setAtk(tmp+5);
        info += super.Attack(p,b);
        p.setAtk(tmp);
        p.setPdv(p.getPdv()-degats);
        hit();
        info += p.getNom()+" se blesse a cause du contrecoup ! [-"+degats+" pdv]\n";
        return info;
    }
}