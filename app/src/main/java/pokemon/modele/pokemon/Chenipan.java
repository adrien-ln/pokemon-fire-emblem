package pokemon.modele.pokemon;

public class Chenipan extends Pokemon {
    public Chenipan() {
        super("Chenipan",3,"Insecte");
        int randPDV = (int)(Math.random()*(152-105))+105; 
        int randATK = (int)(Math.random()*(16-9))+9; 
        this.setPdv(randPDV);
        this.setAtk(randATK);
        randShiny("src/main/resources/chenipan_shiny.png", "src/main/resources/chenipan.png");
        this.addAttaqueListe("Charge");
        this.addAttaqueListe("Piqure");
    }
}
