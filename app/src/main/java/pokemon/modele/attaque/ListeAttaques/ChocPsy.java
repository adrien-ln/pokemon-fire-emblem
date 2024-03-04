package pokemon.modele.attaque.ListeAttaques;

import pokemon.modele.attaque.Attaquetypes.*;
import pokemon.modele.pokemon.Pokemon;

public class ChocPsy extends AttaquePsy{
    @Override
    public int getDistanceMaxAttaque(){
        return 3;
    }

    public String getInfo(){
        return "Le lanceur materialise des ondes mysterieuses qu’il projette sur l’ennemi. Inflige des degats physiques.";
    }

    @Override
    public String Attack(Pokemon p, Pokemon b){
        String info = p.getNom()+" utilise l'attaque Choc Psy !\n";
        return info+super.Attack(p,b);
    }
}