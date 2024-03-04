package pokemon.modele.attaque.ListeAttaques;

import pokemon.modele.attaque.Attaquetypes.*;
import pokemon.modele.pokemon.Pokemon;

public class VentFeerique extends AttaqueFee{
    @Override
    public int getDistanceMaxAttaque(){
        return 2;
    }

    public boolean jusquADistanceMax(){
        return false;
    }

    public String getInfo(){
        return "Dechaine un vent magique qui cingle l'ennemi.";
    }

    @Override
    public String Attack(Pokemon p, Pokemon b){
        String info = p.getNom()+" utilise l'attaque Vent Feerique !\n";
        return info+super.Attack(p,b);
    }
}