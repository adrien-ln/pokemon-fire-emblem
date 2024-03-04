package pokemon.modele.pokemon;

public class Smogo extends Pokemon {
    public Smogo() {
        super("Smogo",3,"Poison");
        int randPDV = (int)(Math.random()*(147-100))+100; 
        int randATK = (int)(Math.random()*(21-14))+14; 
        this.setPdv(randPDV);
        this.setAtk(randATK);
        randShiny("src/main/resources/smogo_shiny.png", "src/main/resources/smogo.png");
        this.addAttaqueListe("Charge");
        this.addAttaqueListe("Puredpois");
    }
}
