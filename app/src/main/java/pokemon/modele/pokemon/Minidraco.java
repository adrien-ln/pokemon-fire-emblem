package pokemon.modele.pokemon;

public class Minidraco extends Pokemon {
    public Minidraco() {
        super("Minidraco",3,"Dragon");
        int randPDV = (int)(Math.random()*(148-101))+101; 
        int randATK = (int)(Math.random()*(25-18))+18; 
        this.setPdv(randPDV);
        this.setAtk(randATK);
        randShiny("src/main/resources/minidraco_shiny.png", "src/main/resources/minidraco.png");
        this.addAttaqueListe("Ouragan");
        this.addAttaqueListe("Draco-Charge");
        this.addAttaqueListe("Souplesse");
    }
}
