package pokemon.modele.pokemon;

public class Voltorbe extends Pokemon {
    public Voltorbe() {
        super("Voltorbe",3,"Electrique");
        int randPDV = (int)(Math.random()*(147-100))+100; 
        int randATK = (int)(Math.random()*(14-6))+6; 
        this.setPdv(randPDV);
        this.setAtk(randATK);
        randShiny("src/main/resources/voltorbe_shiny.png", "src/main/resources/voltorbe.png");
        this.addAttaqueListe("Charge");
        this.addAttaqueListe("Eclair");
    }
}
