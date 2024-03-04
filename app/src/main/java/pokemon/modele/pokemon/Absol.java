package pokemon.modele.pokemon;

public class Absol extends Pokemon {
    public Absol() {
        super("Absol",3,"Tenebres");
        int randPDV = (int)(Math.random()*(172-125))+125; 
        int randATK = (int)(Math.random()*(29-19))+19; 
        this.setPdv(randPDV);
        this.setAtk(randATK);
        randShiny("src/main/resources/absol_shiny.png", "src/main/resources/absol.png");
        this.addAttaqueListe("Vive-Attaque");
        this.addAttaqueListe("Morsure");
    }
}
