package pokemon.modele.pokemon;

public class NidoranM extends Pokemon {
    public NidoranM() {
        super("NidoranM",3,"Poison");
        int randPDV = (int)(Math.random()*(153-106))+106; 
        int randATK = (int)(Math.random()*(17-8))+8; 
        this.setPdv(randPDV);
        this.setAtk(randATK);
        randShiny("src/main/resources/nidoranM_shiny.png", "src/main/resources/nidoranM.png");
        this.addAttaqueListe("Picpic");
        this.addAttaqueListe("Dard-Venin");
        this.addAttaqueListe("Double Pied");
    }
}
