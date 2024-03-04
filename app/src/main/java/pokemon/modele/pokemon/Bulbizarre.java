package pokemon.modele.pokemon;

public class Bulbizarre extends Pokemon {
    public Bulbizarre() {
        super("Bulbizarre",3,"Plante");
        int randPDV = (int)(Math.random()*(152-105))+105; 
        int randATK = (int)(Math.random()*(23-15))+15; 
        this.setPdv(randPDV);
        this.setAtk(randATK);
        randShiny("src/main/resources/bulbizarre_shiny.png", "src/main/resources/bulbizarre.png");
        this.addAttaqueListe("Charge");
        this.addAttaqueListe("Fouet Lianes");
        this.addAttaqueListe("Tranch'Herbe");
    }
}
