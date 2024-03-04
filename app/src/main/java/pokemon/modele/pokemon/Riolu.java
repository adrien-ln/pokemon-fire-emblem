package pokemon.modele.pokemon;

public class Riolu extends Pokemon {
    public Riolu() {
        super("Riolu",3,"Combat");
        int randPDV = (int)(Math.random()*(147-100))+100; 
        int randATK = (int)(Math.random()*(25-16))+16; 
        this.setPdv(randPDV);
        this.setAtk(randATK);
        randShiny("src/main/resources/riolu_shiny.png", "src/main/resources/riolu.png");
        this.addAttaqueListe("Vive-Attaque");
        this.addAttaqueListe("Forte-Paume");
    }
}
