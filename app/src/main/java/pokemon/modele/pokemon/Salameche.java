package pokemon.modele.pokemon;

public class Salameche extends Pokemon {
    public Salameche() {
        super("Salameche",3,"Feu");
        int randPDV = (int)(Math.random()*(146-99))+99; 
        int randATK = (int)(Math.random()*(22-14))+14; 
        this.setPdv(randPDV);
        this.setAtk(randATK);
        randShiny("src/main/resources/salameche_shiny.png", "src/main/resources/salameche.png");
        this.addAttaqueListe("Griffe");
        this.addAttaqueListe("Flammeche");
        this.addAttaqueListe("Crocs Feu");
    }
}
