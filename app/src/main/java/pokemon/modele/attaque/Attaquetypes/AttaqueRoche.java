package pokemon.modele.attaque.Attaquetypes;

import javax.swing.plaf.ColorUIResource;

import pokemon.modele.attaque.Attaque;
import pokemon.modele.pokemon.Pokemon;

public class AttaqueRoche extends Attaque{  
    String info ="";
    String crit = "Coup Critique !";
    String pEff = "L'attaque n'est pas tres efficace...\n";
    String eff = "L'attaque est super efficace !\n";
    String pasAff ="L'attaque n'affecte pas le pokemon enemi...\n";
 
    public String attackBis(Pokemon p, Pokemon b){
        int tmp = (int)(Math.random()*100)+1; 
        if(tmp <= p.getCrit()){
            info = crit;
            if(b.getType()=="Acier" || b.getType()=="Combat" || b.getType()=="Sol"){
                b.setPdv(b.getPdv() - p.getAtk());
                pasEff();
                info += " "+pEff;
            }
            else{
                if(b.getType()=="Feu" || b.getType()=="Glace" || b.getType()=="Insecte" || b.getType()=="Vol"){
                    b.setPdv(b.getPdv() - p.getAtk()*4);
                    supEff();
                    info += " "+eff;
                }
                else {
                    b.setPdv(b.getPdv() - p.getAtk()*2);
                    info += "\n";
                }
                crit();
            }        
        }
        else {
            if(b.getType()=="Feu" || b.getType()=="Glace" || b.getType()=="Insecte" || b.getType()=="Vol"){
                b.setPdv(b.getPdv() - p.getAtk()*2);
                supEff();
                info =eff;
            }
            else if(b.getType()=="Acier" || b.getType()=="Combat" || b.getType()=="Sol"){
                b.setPdv(b.getPdv() - p.getAtk()/2);
                pasEff();
                info = pEff;
            }
            else {
                b.setPdv(b.getPdv() - p.getAtk());
                hit();
            }
        }
        return info;
    }

    @Override
    public String getType() {
        return "Roche";
    }

    public ColorUIResource getColorLabelType(){
        return new ColorUIResource(182, 161, 54);
    }
    
    @Override
    public String getInfo() {
        return null;
    }
}