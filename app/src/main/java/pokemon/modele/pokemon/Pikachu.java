package pokemon.modele.pokemon;

public class Pikachu extends Pokemon {
    public Pikachu() {
        super("Pikachu",3, "Electrique");
        int randPDV = (int)(Math.random()*(142-95))+95; 
        int randATK = (int)(Math.random()*(24-15))+15; 
        this.setPdv(randPDV);
        this.setAtk(randATK);
        randShiny("src/main/resources/pikachu_shiny.png", "src/main/resources/pikachu.png");
        this.addAttaqueListe("Eclair");
        this.addAttaqueListe("Vive-Attaque");
        this.addAttaqueListe("Double Pied");
        this.addAttaqueListe("Queue De Fer");
    }
}
