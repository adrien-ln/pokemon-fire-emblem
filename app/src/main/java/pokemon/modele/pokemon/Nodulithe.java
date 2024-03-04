package pokemon.modele.pokemon;

public class Nodulithe extends Pokemon {
    public Nodulithe() {
        super("Nodulithe",3,"Roche");
        int randPDV = (int)(Math.random()*(162-115))+115; 
        int randATK = (int)(Math.random()*(25-19))+19; 
        this.setPdv(randPDV);
        this.setAtk(randATK);
        randShiny("src/main/resources/nodulithe_shiny.png", "src/main/resources/nodulithe.png");
        this.addAttaqueListe("Charge");
        this.addAttaqueListe("Lame de Roc");
        this.addAttaqueListe("Coud'Boue");
    }
}
