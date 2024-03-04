package pokemon.modele.pokemon;

public class Oniglali extends Pokemon {
    public Oniglali() {
        super("Oniglali",3,"Glace");
        int randPDV = (int)(Math.random()*(187-140))+140; 
        int randATK = (int)(Math.random()*(30-19))+19; 
        this.setPdv(randPDV);
        this.setAtk(randATK);
        randShiny("src/main/resources/oniglali_shiny.png", "src/main/resources/oniglali.png");
        this.addAttaqueListe("Eclats Glace");
        this.addAttaqueListe("Etonnement");
        this.addAttaqueListe("Poudreuse");
    }
}
