package pokemon.vue;

import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.awt.*;

public class PanelFinPartie extends JPanel{
    /**
     * l'image à afficher quand la partie est terminée
     */
    private BufferedImage imageFinPartie;
    
    public PanelFinPartie(BufferedImage imageFinPartie){
        this.imageFinPartie=imageFinPartie;
    }

    @Override
    public void paintComponent(Graphics g){
      int width=getSize().width;
      int height=getSize().height;
      if(imageFinPartie!=null)
        g.drawImage(imageFinPartie, 0, 0,width,height,this);
    }
  
}
