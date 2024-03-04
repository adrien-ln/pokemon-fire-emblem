package pokemon.modele.attaque.ListeAttaques;

import pokemon.modele.attaque.Attaquetypes.*;
import pokemon.modele.pokemon.Pokemon;

public class VoixEnjoleuse extends AttaqueFee{
    @Override
    public int getDistanceMaxAttaque(){
        return 1;
    }

    public String getInfo(){
        return "Laisse s'échapper une voix enchanteresse qui inflige des degats psychiques à l'ennemi.";
    }

    @Override
    public String Attack(Pokemon p, Pokemon b){
        String info = p.getNom()+" utilise l'attaque Voix Enjoleuse !\n";
        return info+super.Attack(p,b);
    }
}