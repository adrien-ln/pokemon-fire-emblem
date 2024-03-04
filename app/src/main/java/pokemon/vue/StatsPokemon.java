package pokemon.vue;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.ColorUIResource;

import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class StatsPokemon extends JPanel{

  /**
   * le type du pokémon
   */
  private String type;
  private JLabel labelType;
  /**
   * le nombre de points de vie
   */
  private int pdv;
  private int ExPdv=pdv;
  private JLabel labelPdv;
  private double largeurBDV;
  private double largeurPdvInitiale;
  /**
   * le nombre de points de vie initial
   */
  private final int pdvTotal;
  private JPanel backgroundBarreDevie;
  private JPanel barreDeVie;
  private int atk;
  private JLabel labelAtk;
  private String nomPokemon;
  private JLabel labelNomPokemon;
  /**
   * dessiner un cadre vert sur le panel si cible=true,
   * ne pas dessiner sinon
   */
  private boolean cible;
  /**
   * dessiner un cadre rouge sur le panel si cibleEnnemi=true,
   * ne pas dessiner sinon
   */
  private boolean cibleEnnemi;
  /**
   * image pour selectionner les stats des pokémons ennemis
   */
  private BufferedImage cadreRouge;
  /**
   * image pour selectionner les stats des pokémons alliés 
   */
  private BufferedImage cadreVert;
  /**
   * largeur du panel
   */
  private int largeur=PanelJoueurs.largeurStats;

  private JPanelPeur panelPeur=new JPanelPeur();
  private JPanelConfus panelConfus=new JPanelConfus();
  private JPanelEffet panelEffet=new JPanelEffet();

  

  public StatsPokemon(String nom,String t,int p,int a){
    try{
			cadreRouge=ImageIO.read(new File("src/main/resources/selection_stat_rouge.png"));
			cadreVert=ImageIO.read(new File("src/main/resources/selection_stat_vert.png"));
		}catch(IOException e){
			System.out.println("erreur lecture photo cadre");
		}

    nomPokemon=nom;
    type=t;
    pdvTotal=p;
    pdv=p;
    atk=a;

    setLayout(null);
    setBackground(Color.GRAY);

    //ajouter et positionner le label du nom du pokémon
    labelNomPokemon=new JLabel(nomPokemon);
    add(labelNomPokemon);
    labelNomPokemon.setBounds(5,2,(largeur/2)-5,15);

    //ajouter et positionner le label Atk
    labelAtk=new JLabel("ATK: "+atk);
    add(labelAtk);
    labelAtk.setBounds(5,20,(largeur)/2-5,15);
    labelAtk.setForeground(Color.WHITE);

    //ajouter et positionner la barre de vie et son background
    backgroundBarreDevie=new JPanel();
    backgroundBarreDevie.setBackground(Color.BLACK);
    add(backgroundBarreDevie);
    barreDeVie=new JPanel();
    largeurBDV=(largeur)/2-5;
    largeurPdvInitiale=largeurBDV;
    barreDeVie.setBounds(largeur/2,5,(int)largeurBDV,5);
    barreDeVie.setBackground(Color.GREEN);
    add(barreDeVie);

    //ajouter et positionner le label des points de vie
    labelPdv=new JLabel(pdv+"/"+pdvTotal);
    add(labelPdv);
    labelPdv.setBounds(largeur/2,20,(largeur)/2-5,15);
    labelPdv.setForeground(Color.WHITE);

    //ajouter et positionner le label de confusion du pokémon
    add(panelConfus);
    panelConfus.setBounds(5,55,(largeur-10)/3,15);
    panelConfus.setBackground(Color.gray);

    //ajouter et positionner le label de peur du pokémon
    add(panelPeur);
    panelPeur.setBounds(5+(largeur-10)/3,55,(largeur-10)/3,15);
    panelPeur.setBackground(Color.gray);

    //ajouter et positionner le label de l'etat(effet/status) du pokémon
    add(panelEffet);
    panelEffet.setBounds(5+2*((largeur-10)/3),55,(largeur-10)/3,15);
    panelEffet.setBackground(Color.gray);

    //ajouter et positionner le label du type du pokémon
    labelType=new JLabel(type);
    add(labelType);
    labelType.setBounds(5,38,(largeur-10)/2,15);
    if(type.equals("Eau")){
      labelType.setForeground(new ColorUIResource(99, 144, 240));
    }else if(type.equals("Electrique")){
      labelType.setForeground(new ColorUIResource(247, 208, 44));
    }else if(type.equals("Feu")){
      labelType.setForeground(new ColorUIResource(238, 129, 48));
    }else if(type.equals("Poison")){
      labelType.setForeground(new ColorUIResource(163, 62, 161));
    }else if(type.equals("Psy")){
      labelType.setForeground(new ColorUIResource(249, 85, 135));
    }else if(type.equals("Tenebres")){
      labelType.setForeground(new ColorUIResource(112, 87, 70));
    }else if(type.equals("Plante")){
      labelType.setForeground(new ColorUIResource(122, 199, 76));
    }else if(type.equals("Insecte")){
      labelType.setForeground(new ColorUIResource(166, 185, 26));
    }else if(type.equals("Dragon")){
      labelType.setForeground(new ColorUIResource(111, 53, 252));
    }else if(type.equals("Glace")){
      labelType.setForeground(new ColorUIResource(150, 217, 214));
    }else if(type.equals("Normal")){
      labelType.setForeground(new ColorUIResource(168, 167, 122));
    }else if(type.equals("Combat")){
      labelType.setForeground(new ColorUIResource(194, 46, 40));
    }else if(type.equals("Spectre")){
      labelType.setForeground(new ColorUIResource(115, 87, 151));
    }else if(type.equals("Acier")){
      labelType.setForeground(new ColorUIResource(183, 183, 206));
    }else if(type.equals("Fee")){
      labelType.setForeground(new ColorUIResource(214, 133, 173));
    }else if(type.equals("Vol")){
      labelType.setForeground(new ColorUIResource(169, 143, 243));
    }else if(type.equals("Sol")){
      labelType.setForeground(new ColorUIResource(226, 191, 101));
    }

  }

  /**
   * renvoie le nombre de points de vie du pokémon auquel le stats appartient
   * @return le nombre de points de vie du pokémon auquel le stats appartient
   */
  public int getPdv() {
    return pdv;
  }

  /**
   * met à jour le nombre de points de vie, la largeur de la barre de vie et son background
   * si la nouvelle largeur de la barre de vie est inférieure à la moitié de sa largeur initiale, la barre de vie est colorée en orange
   * si la nouvelle largeur de la barre de vie est inférieure à 1/10 de sa largeur initiale, la barre de vie est colorée en rouge
   * @param newPdv le nouveau nombre de points de vie
   */
  public void setPdv(int newPdv) {
    ExPdv=pdv;
    pdv=newPdv;
    if(pdv>0)
      labelPdv.setText(pdv+"/"+pdvTotal);
    else{
      labelPdv.setText("KO");
      pdv=0;//pour ne pas avoir de valeurs négatives
      panelEffet.setVisible(false);
    }
    largeurBDV=(largeurPdvInitiale*pdv)/pdvTotal;
    barreDeVie.setBounds(largeur/2,5,(int)largeurBDV,5);
    backgroundBarreDevie.setBounds(largeur/2+(int)largeurBDV,5,(int)(largeurPdvInitiale-largeurBDV),5);
    if(largeurBDV<=0){
      barreDeVie.setSize((int)largeurPdvInitiale,5);
      barreDeVie.setBackground(Color.black);
    }else if(largeurBDV<=largeurPdvInitiale/2){
      barreDeVie.setBackground(Color.ORANGE);
    }else if(largeurBDV<=largeurPdvInitiale/10){
      barreDeVie.setBackground(Color.RED);
    }
  }

  public void setEffet(String effet){
    switch(effet){
      case "Brule":
        panelEffet.setBRN(true);
        break;
      case "Paralyse":
        panelEffet.setPAR(true);
        break;
      case "Gele":
        panelEffet.setFRZ(true);
        break;
      case "Poison":
        panelEffet.setPSN(true);
        break;
    }
    panelEffet.repaint();
  }

  public void cacherEffet(){
    panelEffet.setBRN(false);
    panelEffet.setFRZ(false);
    panelEffet.setPAR(false);
    panelEffet.setPSN(false);
  }

  public void setConfus(boolean b, int confusTour) {
    panelConfus.setConfus(b,confusTour);
  }

  public void setPeur(boolean b) {
    panelPeur.setPeur(b);
  }

  @Override
  protected void paintComponent(Graphics g) {
      int height=getSize().height;
      int width=getSize().width;
      //calculer la nouvelle largeur de la barre de vie après redimensionnement de la fenêtre
      largeurBDV=(largeurBDV*((largeur/2)-5))/largeurPdvInitiale;
      if(barreDeVie!=null)//redessiner la barre de vie
        barreDeVie.setBounds(largeur/2,5,(int)largeurBDV,5);
      if(backgroundBarreDevie!=null)//redessiner le background de la barre de vie
        backgroundBarreDevie.setBounds(largeur/2+(int)largeurBDV,5,(int)(largeurPdvInitiale-largeurBDV),5);
      super.paintComponent(g);
      if(cible)//si le stats d'un pokémon allié est selectionné, on dessine le cadre vert
        g.drawImage(cadreVert, 0, 0, width, height, this);
      else if(cibleEnnemi)//si le stats d'un pokémon ennemi est selectionné, on dessinne le cadre rouge
        g.drawImage(cadreRouge, 0, 0, width, height, this);
  }


  /**
   * selectionne le panel si afficheOuPas= true, déselectionne sinon, avec un cadre vert si pokAllieOuEnnemi=true, avec un cadre rouge sinon
   * @param afficherOuPas si true, on selectionne le stats 
   * @param pokAllieOuEnnemi si true on selectionne avec un cadre vert, sinon avec un cadre rouge
   */
  public void cibleVisible(boolean afficherOuPas, boolean pokAllieOuEnnemi){
    if(pokAllieOuEnnemi)
      cible=afficherOuPas; 
    else
      cibleEnnemi=afficherOuPas;
    repaint();
  }

  public JPanelPeur getJPanelPeur(){
    return panelPeur;
  }
  public JPanelConfus getJpanelConfus(){
    return panelConfus;
  }
  public JPanelEffet getJPanelEffet(){
    return panelEffet;
  }

  public class JPanelConfus extends JPanel{
    private boolean estConfus=false;
    private BufferedImage imageConfus;
    private JLabel labelConfusTour=new JLabel();

    public JPanelConfus(){
      try{
      imageConfus=ImageIO.read(new File("src/main/resources/Confus.png"));
      }catch(IOException e){
        e.printStackTrace();
      }
      add(labelConfusTour);
    }

    public void setConfus(boolean b, int confusTour) {
      estConfus=b;
      if(b)
        labelConfusTour.setText(""+confusTour);
      else
        labelConfusTour.setText("");
      repaint();
    }

    @Override
    public void paintComponent(Graphics g){
      super.paintComponent(g);
      if(estConfus){
        g.drawImage(imageConfus,0,0,getWidth()-30,getHeight(),this);
        labelConfusTour.setBounds(getWidth()-20,0,20,getHeight());
      }
    }
  }
  public class JPanelPeur extends JPanel{
    private boolean aPeur=false;
    private BufferedImage imagePeur;

    public JPanelPeur(){
      try{
        imagePeur=ImageIO.read(new File("src/main/resources/Fear.png"));
      }catch(IOException e){
        e.printStackTrace();
      }
    }

    public void setPeur(boolean b) {
      aPeur=b;
      repaint();
    }

    @Override
    public void paintComponent(Graphics g){
      super.paintComponent(g);
      if(aPeur){
        g.drawImage(imagePeur,0,0,getWidth(),getHeight(),this);
      }
    }
  }

  public class JPanelEffet extends JPanel{
    private boolean estPAR=false;
    private boolean estBRN=false;
    private boolean estPSN=false;
    private boolean estFRZ=false;
    private BufferedImage imagePAR;
    private BufferedImage imageBRN;
    private BufferedImage imageFRZ;
    private BufferedImage imagePSN;

    public JPanelEffet(){
      try{
        imagePAR=ImageIO.read(new File("src/main/resources/Paralysis.png"));
        imageBRN=ImageIO.read(new File("src/main/resources/Burned.png"));
        imagePSN=ImageIO.read(new File("src/main/resources/Poisoned.png"));
        imageFRZ=ImageIO.read(new File("src/main/resources/Frozen.png"));
      }catch(IOException e){
        e.printStackTrace();
      }
    }

    public void setPSN(boolean b) {
      estPSN=b;
      repaint();
    }

    public void setFRZ(boolean b) {
      estFRZ=b;
      repaint();
    }

    public void setPAR(boolean b) {
      estPAR=b;
      repaint();
    }

    public void setBRN(boolean b) {
      estBRN=b;
      repaint();
    }

    @Override
    public void paintComponent(Graphics g){
      super.paintComponent(g);
      if(estPAR)
        g.drawImage(imagePAR,0,0,getWidth(),getHeight(),this);
      if(estBRN)
        g.drawImage(imageBRN,0,0,getWidth(),getHeight(),this);
      if(estPSN)
        g.drawImage(imagePSN,0,0,getWidth(),getHeight(),this);
      if(estFRZ)
        g.drawImage(imageFRZ,0,0,getWidth(),getHeight(),this);
    }
  }

  public boolean estBRN(){
    return panelEffet.estBRN;
  }
  public boolean estPAR(){
    return panelEffet.estPAR;
  }
  public boolean estPSN(){
    return panelEffet.estPSN;
  }
  public boolean estFRZ(){
    return panelEffet.estFRZ;
  }

  public boolean aPeur() {
    return panelPeur.aPeur;
  }

  public boolean estConfus() {
      return panelConfus.estConfus;
  }

  public int getExPdv() {
    return ExPdv;
  }
  
}
