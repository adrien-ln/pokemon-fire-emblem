package pokemon.vue;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;
import pokemon.controleur.Controleur;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.*;

public class Tile extends JPanel{
    /**
     * image de la case
     */
    private BufferedImage image;
    /**
     * image de sélection de la case
     */
    private BufferedImage imageSelect;
    /**
     * image du pokémon se trouvant sur la case
     */
    private BufferedImage imagePokemon;
    /**
     * image de la case quand on peut attaquer le pokémon se trouvant dessus 
     */
    private BufferedImage imageAttaque;
    /**
     * image de la flèche qui indique le pokémon qui attaque
     */
    private BufferedImage imageFleche;
    /**
     * cadre pour les pokémons du joueur 
     */
    private BufferedImage cadreVert;
    /**
     * coordonnée x de la case sur le terrain
     */
    private int x;
    /**
     * coordonnée y de la case sur le terrain
     */
    private int y;
    /**
     * on dessine le pokémon se trouvant sur la case si true
     */
    private boolean pokemonPresent;
    /**
     * on sélectionne la case si true
     */
    private boolean select;
    /**
     * on peut attaquer le pokémon se trouvant sur la case si true
     */
    private boolean peutAttaquer;
    /**
     * on dessine la flèche si true
     */
    private boolean fleche=false;

    private Controleur controleur;

    /**
     * le tile se trouve dans l'ecran du joueur 1 ou joueur 2
     */
    private boolean joueur;

    public Tile(String path, String pathSelect, String pathAttaque,int x, int y, Controleur controleur, String joueur){
        this.controleur=controleur;
        if(joueur=="Joueur 1")
            this.joueur=true;
        else
            this.joueur=false;
        try{
            image = ImageIO.read(new File(path));
            imageSelect=ImageIO.read(new File(pathSelect));
            imageAttaque=ImageIO.read(new File(pathAttaque));
            imageFleche=ImageIO.read(new File("src/main/resources/fleche_actuel.png"));
            cadreVert=ImageIO.read(new File("src/main/resources/selection_stat_vert.png"));
        }catch(IOException e){
            System.out.println("File not found!");
        }
        this.x=x;
        this.y=y;
        setLayout(new BorderLayout());
        addMouseListener(new MouseDeplace());
    }

    private class MouseDeplace implements MouseInputListener{
        @Override
        public void mouseClicked(MouseEvent e) {
            if(controleur.getJoueurActuel()==joueur){//si c'est la fenêtre du joueur auquel c'est le tour
                if(select && pokemonPresent && !controleur.getDeplacerPokemon()){
                    controleur.setDeplacerPokemon(true);
                    controleur.deselectionnerAutresCases(x,y);
                    controleur.selectionnerCasePossibles(x,y);
                    controleur.setXPrec(x);
                    controleur.setYPrec(y);
                }
                //si on peut déplacer le pokémon et le tile est selectionné
                else if(select && controleur.getDeplacerPokemon()){
                    controleur.deplacerPokemon(x,y);
                    controleur.setDeplacerPokemon(false);
                    fleche=true;//on dessine la flèche sur le pokémon qui attaque
                }
                else if(peutAttaquer){
                    controleur.attaquer(x,y); 
                    controleur.finTour(true);
                    //controleur.setVisibleBoutonRetour(false);
                    //controleur.setVisibleBoutonFin(true);
                }
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if(pokemonPresent && controleur.getJoueurActuel()==joueur){//si c'est la fenêtre du joueur auquel c'est le tour
                controleur.cibleVisible(x, y);
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(pokemonPresent && controleur.getJoueurActuel()==joueur){//si c'est la fenêtre du joueur auquel c'est le tour
                controleur.cibleInvisible(x, y);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int height=getSize().height;
        int width=getSize().width;
        if(select)//dessine image de selection du tile
            g.drawImage(imageSelect, 0, 0,width,height, this);
        else if(peutAttaquer)//dessine image attaque du tile
            g.drawImage(imageAttaque, 0, 0, width, height, this);
        else//sinon dessine image normale du tile
            g.drawImage(image, 0, 0, width, height, this);
        if(pokemonPresent){//s'il y a un pokemon sur cette case, on le dessine 
            g.drawImage(imagePokemon, 0, 0, width, height, this);
            if(joueur==controleur.pokInCaseAppartientAJoueur1(x, y))
                g.drawImage(cadreVert, 0, 0, width, height, this);
        }
        if(fleche){//si c'est au tour du pokémon d'attaquer
            g.drawImage(imageFleche, 0, 0, width, height, this);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(image.getWidth(this),image.getHeight(this));
    }

    /**
     * sélectionne le tile
     */
    public void select() {
        select=true;
        repaint();
    }

    /**
     * désélectionne le tile
     */
    public void deselect() {
        select=false;
        repaint();
    }

    /**
     * dessine l'image de l'attaque sur le tile
     */
    public void colorerCaseAAttaquer() {
        peutAttaquer=true;
        repaint();
    }

    /**
     * enlève l'image de l'attaque sur le tile
     */
    public void decolorerCaseAAttaquer() {
        peutAttaquer=false;
        repaint();
    }

    /**
     * dessine si b=true ou enleve si b=false, le pokémon sur le tile
     * @param b true pour mettre le pokémon dans le tile, ou false pour enlever le pokémon
     * @param pathImagePokemon chemin de l'image du pokémon si b==true, sinon chaine vide
     */
    public void setPokemonPresent(Boolean b, String pathImagePokemon){
        pokemonPresent=b;
        if(b){
            try{
                imagePokemon=ImageIO.read(new File(pathImagePokemon));
            }catch(IOException e){
                System.out.println("File not found!");
            }
        }
        else{
            imagePokemon=null;
        }
        repaint();
    }

    /**
     * enlève la flèche dessiné sur le pokémon
     */
    public void enleverFleche() {
        fleche=false;
        repaint();
    }
}

