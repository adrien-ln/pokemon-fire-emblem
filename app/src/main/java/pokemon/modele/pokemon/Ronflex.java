package pokemon.modele.pokemon;

public class Ronflex extends Pokemon{
    public Ronflex() {
        super("Ronflex",2,"Normal");
        int randPDV = (int)(Math.random()*(217-170))+170; 
        int randATK = (int)(Math.random()*(31-17))+17; 
        this.setPdv(randPDV);
        this.setAtk(randATK);
        randShiny("src/main/resources/ronflex_shiny.png", "src/main/resources/ronflex.png");
        this.addAttaqueListe("Lechouille");
        this.addAttaqueListe("Charge");
        this.addAttaqueListe("Morsure");
    }

}
