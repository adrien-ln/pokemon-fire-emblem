package pokemon.modele.pokemon;

public class Rattata extends Pokemon{
    public Rattata() {
        super("Rattata",3,"Normal");
        int randPDV = (int)(Math.random()*(137-90))+90; 
        int randATK = (int)(Math.random()*(14-5))+5; 
        this.setPdv(randPDV);
        this.setAtk(randATK);
        randShiny("src/main/resources/rattata_shiny.png", "src/main/resources/rattata.png");
        this.addAttaqueListe("Vive-Attaque");
        this.addAttaqueListe("Charge");
        this.addAttaqueListe("Morsure");
    }

}
