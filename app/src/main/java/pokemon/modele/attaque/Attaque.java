package pokemon.modele.attaque;

import javax.swing.plaf.ColorUIResource;

import pokemon.audio.Audio;
import pokemon.modele.pokemon.Pokemon;


public abstract class Attaque {
    /**
	 * Fait tout les test necessaire pour les differents types d'attaque sur le type du pokemon et 
     * s'occupe aussi des effets de confusion , paralysie et coup critiques par rapport au pokemon attaquant.
	 * @param p Pokemon attaquant
	 * @param b Pokemon qui recoit l'attaque
	 */
    public String Attack(Pokemon p,Pokemon b){
        if(p.getConfus() == true){
            if (p.getConfusTour()>1){
                int nonConfus = (int)(Math.random()*100)+1;
                if(nonConfus<=33){
                    return paralyse(p, b);
                } 
                else {
                    int tmp=p.getPdv()/16;
                    p.setPdv(p.getPdv()-tmp);
                    hit();
                    return p.getNom()+" est confus , il se blesse dans sa confusion. [-"+tmp+" pdv]";
                }
            }
            else {
                p.setConfusTour(3);
                p.setConfus(false);
                return paralyse(p, b);
            }
        }
        else{
            return paralyse(p, b);
        }
    }

    /**
	 * renvoie la distance d'attaque du pokemon
	 * @return la distance d'attaque du pokemon
	 */
    public int getDistanceMaxAttaque(){
        return 1;
    }

    /**
	 * Lance l'effet sonore "hit" 
	 */
    public void hit(){
        try{
            Audio audioPlayer =new Audio("src/main/resources/Hit.wav",5f,false);
            audioPlayer.play();
        } 
        catch (Exception ex){
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

    /**
	 * Lance l'effet sonore "coup critique" 
	 */
    public void crit(){
        try{
            Audio audioPlayer =new Audio("src/main/resources/IMHIT.wav",5f,false);
            audioPlayer.play();
        } 
        catch (Exception ex){
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

    /**
	 * Lance l'effet sonore "super efficace" 
	 */
    public void supEff(){
        try{
            Audio audioPlayer =new Audio("src/main/resources/IMHITSUPER.wav",5f,false);
            audioPlayer.play();
        } 
        catch (Exception ex){
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

    /**
	 * Lance l'effet sonore "pas tres efficace" 
	 */
    public void pasEff(){
        try{
            Audio audioPlayer =new Audio("src/main/resources/IMHITWEAK.wav",5f,false);
            audioPlayer.play();
            
        } 
        catch (Exception ex){
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

    /**
	 * Partie de fonction appelle par la fonction Attack , qui s'occupe de la partie de l'attaque si le pokemon attaquant n'a aucun effet de status
     * @param p Pokemon attaquant
	 * @param b Pokemon qui recoit l'attaque
	 */
    public abstract String attackBis(Pokemon p,Pokemon b);

    /**
	 * Partie de fonction appelle par la fonction Attack , qui s'occupe de la partie de la paralysie du pokemon attaquant
     * @param p Pokemon attaquant
	 * @param b Pokemon qui recoit l'attaque
	 */
    public String paralyse(Pokemon p, Pokemon b){
        String info="";
        if(p.getEffet()=="Paralyse"){
            int tmp = (int)(Math.random()*100)+1;
            if(tmp>=25){
                info = attackBis(p,b);
            } 
            else {
                info = p.getNom()+" est paralyse , il ne peut pas attaquer .";
            }
            int tmp2 = (int)(Math.random()*100)+1;
            if(tmp2<=20){
                p.setEffet(null);
                info += "\n "+p.getNom()+" n'est plus Paralyse !";
            } 
            return info;
        }
        else {
            return attackBis(p, b);
        }
    }

    /**
     * renvoie true si l'ataque ne peut pas être bloqué par un pokémon
     * @return true si l'ataque ne peut pas être bloqué par un pokémon
     */
    public boolean passeObstacle(){
        return false;
    }

    /**
     * renvoie true si l'attaque peut attaquer toutes les cases jusqu'à distance max
     * sinon false si l'attaque peut attaquer qu'une case loin de exactement distance max
     * @return true si l'attaque peut attaquer toutes les cases jusqu'à distance max
     * sinon false si l'attaque peut attaquer qu'une case loin de exactement distance max
     */
    public boolean jusquADistanceMax(){
        return true;
    }
    public abstract String getInfo();
    public abstract String getType();
    public abstract ColorUIResource getColorLabelType();
}
