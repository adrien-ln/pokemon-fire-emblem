package pokemon.modele.pokemon;

public class Abo extends Pokemon {
    public Abo() {
        super("Abo",2,"Poison");
        int randPDV = (int)(Math.random()*(142-95))+95; 
        int randATK = (int)(Math.random()*(17-7))+7; 
        this.setPdv(randPDV);
        this.setAtk(randATK);
        randShiny("src/main/resources/abo_shiny.png", "src/main/resources/abo.png");
        this.addAttaqueListe("Morsure");
        this.addAttaqueListe("Dard-Venin");
        this.addAttaqueListe("Acide");
    }
}
