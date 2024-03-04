package pokemon.modele.pokemon;

public class Carapuce extends Pokemon {
    public Carapuce() {
        super("Carapuce",3,"Eau");
        int randPDV = (int)(Math.random()*(151-104))+104; 
        int randATK = (int)(Math.random()*(24-13))+13; 
        this.setPdv(randPDV);
        this.setAtk(randATK);
        randShiny("src/main/resources/carapuce_shiny.png", "src/main/resources/carapuce.png");
        this.addAttaqueListe("Pistolet a O");
        this.addAttaqueListe("Morsure");
        this.addAttaqueListe("Vibraqua");
    }
}
