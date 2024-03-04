package pokemon.vue;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.*;

public class Accueil extends JPanel{
    private BufferedImage imageAcceuil;
    private JPanel panelButton;
    public Accueil(JButton buttonCommencer){
        try{
            imageAcceuil = ImageIO.read(new File("src/main/resources/banniere-conquest.png"));
        }catch(IOException e){
            System.out.println("File not found!");
        }setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(imageAcceuil.getWidth(),imageAcceuil.getHeight()));
        setLayout(null);
        panelButton=new JPanel();
        panelButton.setLayout(null);
        buttonCommencer.setBounds(0,0,100,30);
        buttonCommencer.setBackground(Color.gray);
        panelButton.add(buttonCommencer);
        add(panelButton);	
    }

    @Override
    protected void paintComponent(Graphics g) {
        int height=getSize().height;
        int width=getSize().width;
        super.paintComponent(g);
        g.drawImage(imageAcceuil, 0, 0,width, height, this);
        panelButton.setBounds((int)getSize().getWidth()/2-50,(int)getSize().getHeight()/2,100,30);
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(imageAcceuil.getWidth(this),imageAcceuil.getHeight(this));
    }
}
