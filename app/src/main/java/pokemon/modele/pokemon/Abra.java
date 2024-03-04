package pokemon.modele.pokemon;

public class Abra extends Pokemon {
    public Abra() {
        super("Abra",2,"Psy");
        int randPDV = (int)(Math.random()*(132-85))+85; 
        int randATK = (int)(Math.random()*(14-6))+6; 
        this.setPdv(randPDV);
        this.setAtk(randATK);
        randShiny("src/main/resources/abra_shiny.png", "src/main/resources/abra.png");
        this.addAttaqueListe("Ball'Ombre");
        this.addAttaqueListe("Belier");
        this.addAttaqueListe("Choc Psy");
    }
}
