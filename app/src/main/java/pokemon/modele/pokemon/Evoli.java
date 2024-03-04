package pokemon.modele.pokemon;

public class Evoli extends Pokemon{
    public Evoli() {
        super("Evoli",4,"Normal");
        int randPDV = (int)(Math.random()*(162-115))+115; 
        int randATK = (int)(Math.random()*(23-16))+16; 
        this.setPdv(randPDV);
        this.setAtk(randATK);
        randShiny("src/main/resources/evoli_shiny.png", "src/main/resources/evoli.png");
        this.addAttaqueListe("Vive-Attaque");
        this.addAttaqueListe("Double Pied");
        this.addAttaqueListe("Meteores");
    }

}
