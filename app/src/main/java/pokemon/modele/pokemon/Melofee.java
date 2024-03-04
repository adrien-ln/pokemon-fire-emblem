package pokemon.modele.pokemon;

public class Melofee extends Pokemon{
    public Melofee() {
        super("Melofee",2,"Fee");
        int randPDV = (int)(Math.random()*(177-130))+130; 
        int randATK = (int)(Math.random()*(15-6))+6; 
        this.setPdv(randPDV);
        this.setAtk(randATK);
        randShiny("src/main/resources/melofee_shiny.png", "src/main/resources/melofee.png");
        this.addAttaqueListe("Charge");
        this.addAttaqueListe("Voix Enjoleuse");
        this.addAttaqueListe("Vent Feerique");
    }

}
