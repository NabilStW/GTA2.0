package View;

import Model.Directable;
import Model.GameObject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Controller.Mouse;

public class Map extends JPanel {
    private ArrayList<GameObject> objects = null;
    public int MAP_SIZE = 0;
    private int BLOC_SIZE = 0;
    private Mouse mouseController = null;
    private int numeroMap = 1;
    BufferedImage img = null;
    BufferedImage feu = null;
    BufferedImage mechant = null;
    BufferedImage maison = null;
    BufferedImage lit1 = null;
    BufferedImage lit2 = null;
    BufferedImage parquet = null;
    BufferedImage mur = null;
    BufferedImage porte_ferme = null;
    BufferedImage porte_ouverte = null;
    BufferedImage plante = null;
    BufferedImage bain = null;
    BufferedImage armoire = null;
    BufferedImage four = null;
    BufferedImage truccuisine = null;
    BufferedImage bureau = null;
    BufferedImage miroir = null;
    BufferedImage canape = null;
    BufferedImage armoirecuisine = null;
    BufferedImage portail = null;
    BufferedImage murgris = null;
    
    public Map(int MAP_SIZE, int BLOC_SIZE) {
    	this.BLOC_SIZE = BLOC_SIZE;
    	this.MAP_SIZE = MAP_SIZE;
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.setPreferredSize(new Dimension(MAP_SIZE*BLOC_SIZE, MAP_SIZE*BLOC_SIZE));
        addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				int x = e.getX()/BLOC_SIZE;
				int y = e.getY()/BLOC_SIZE;
				mouseController.mapEvent(x, y);
			}
			public void mouseClicked(MouseEvent arg0) {}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
		});
        
        try {
        	img = ImageIO.read(new File("Images/mario.png"));
        	BufferedImage img = new BufferedImage(BLOC_SIZE,BLOC_SIZE, BufferedImage.TYPE_INT_ARGB);
        	feu = ImageIO.read(new File("Images/boule.png"));
        	BufferedImage feu = new BufferedImage(BLOC_SIZE,BLOC_SIZE, BufferedImage.TYPE_INT_ARGB);
        	mechant = ImageIO.read(new File("Images/mechant.png"));
        	BufferedImage mechant = new BufferedImage(BLOC_SIZE,BLOC_SIZE, BufferedImage.TYPE_INT_ARGB);
        	maison = ImageIO.read(new File("Images/BigHouse.png"));
        	BufferedImage maison = new BufferedImage(BLOC_SIZE,BLOC_SIZE, BufferedImage.TYPE_INT_ARGB);
        	lit1 = ImageIO.read(new File("Images/bed1.png"));
        	BufferedImage lit1 = new BufferedImage(BLOC_SIZE,BLOC_SIZE, BufferedImage.TYPE_INT_ARGB);
        	lit2 = ImageIO.read(new File("Images/bed2.png"));
        	BufferedImage lit2 = new BufferedImage(BLOC_SIZE,BLOC_SIZE, BufferedImage.TYPE_INT_ARGB);
        	parquet = ImageIO.read(new File("Images/parquet.png"));
        	BufferedImage parquet = new BufferedImage(BLOC_SIZE,BLOC_SIZE, BufferedImage.TYPE_INT_ARGB);
        	mur = ImageIO.read(new File("Images/mur.png"));
        	BufferedImage mur = new BufferedImage(BLOC_SIZE,BLOC_SIZE, BufferedImage.TYPE_INT_ARGB);
        	porte_ferme = ImageIO.read(new File("Images/porterferme.png"));
        	BufferedImage porte_ferme = new BufferedImage(BLOC_SIZE,BLOC_SIZE, BufferedImage.TYPE_INT_ARGB);
        	porte_ouverte = ImageIO.read(new File("Images/porteouverte.png"));
        	BufferedImage porte_ouverte = new BufferedImage(BLOC_SIZE,BLOC_SIZE, BufferedImage.TYPE_INT_ARGB);
        	plante = ImageIO.read(new File("Images/plante.png"));
        	BufferedImage plante = new BufferedImage(BLOC_SIZE,BLOC_SIZE, BufferedImage.TYPE_INT_ARGB);
        	bain = ImageIO.read(new File("Images/bain.png"));
        	BufferedImage bain = new BufferedImage(BLOC_SIZE,BLOC_SIZE, BufferedImage.TYPE_INT_ARGB);
        	armoire = ImageIO.read(new File("Images/armoire.png"));
        	BufferedImage armoire = new BufferedImage(BLOC_SIZE,BLOC_SIZE, BufferedImage.TYPE_INT_ARGB);
        	four = ImageIO.read(new File("Images/four.png"));
        	BufferedImage four = new BufferedImage(BLOC_SIZE,BLOC_SIZE, BufferedImage.TYPE_INT_ARGB);
        	truccuisine = ImageIO.read(new File("Images/truccuisine.png"));
        	BufferedImage truccuisine = new BufferedImage(BLOC_SIZE,BLOC_SIZE, BufferedImage.TYPE_INT_ARGB);
        	bureau = ImageIO.read(new File("Images/bureau.png"));
        	BufferedImage bureau = new BufferedImage(BLOC_SIZE,BLOC_SIZE, BufferedImage.TYPE_INT_ARGB);
        	miroir = ImageIO.read(new File("Images/miroir.png"));
        	BufferedImage miroir = new BufferedImage(BLOC_SIZE,BLOC_SIZE, BufferedImage.TYPE_INT_ARGB);
        	canape = ImageIO.read(new File("Images/canape.png"));
        	BufferedImage canape = new BufferedImage(BLOC_SIZE,BLOC_SIZE, BufferedImage.TYPE_INT_ARGB);
        	armoirecuisine = ImageIO.read(new File("Images/armoirecuisine.png"));
        	BufferedImage armoirecuisine = new BufferedImage(BLOC_SIZE,BLOC_SIZE, BufferedImage.TYPE_INT_ARGB);
        	portail = ImageIO.read(new File("Images/portail.png"));
        	BufferedImage portail = new BufferedImage(BLOC_SIZE,BLOC_SIZE, BufferedImage.TYPE_INT_ARGB);
        	murgris = ImageIO.read(new File("Images/murgris.png"));
        	BufferedImage murgris = new BufferedImage(BLOC_SIZE,BLOC_SIZE, BufferedImage.TYPE_INT_ARGB);
        	
        	
        	
        }
        catch (IOException e) {
        	
        }
    }

  

    public void paint(Graphics g) {
    	if (numeroMap == 1) {
        	//g.drawImage(lit1, 7*BLOC_SIZE,4*BLOC_SIZE,19*BLOC_SIZE,17*BLOC_SIZE, null);
        	for (int i = 0; i < MAP_SIZE; i++) { 
                for (int j = 0; j < MAP_SIZE; j++) {
                	int x = i;
                    int y = j;
                    g.drawImage(parquet,  x*BLOC_SIZE-12, y*BLOC_SIZE,BLOC_SIZE,BLOC_SIZE, null);
                }
        	}g.drawImage(portail, BLOC_SIZE*17,BLOC_SIZE*29,BLOC_SIZE*2,BLOC_SIZE,null);   
        }

        for (GameObject object : this.objects) {
            int x = object.getPosX();
            int y = object.getPosY();
            int color = object.getColor();
            
            switch(color) {
            case 0: g.drawImage(mur,  x*BLOC_SIZE, y*BLOC_SIZE,BLOC_SIZE,BLOC_SIZE, null); break;
            case 1: break;
            case 5: g.drawImage(plante,  x*BLOC_SIZE, y*BLOC_SIZE,BLOC_SIZE+15,BLOC_SIZE+15, null); break;
            case 7: g.drawImage(mechant,  x*BLOC_SIZE, y*BLOC_SIZE,BLOC_SIZE+10,BLOC_SIZE+10, null); break;
            case 8: g.drawImage(feu,  x*BLOC_SIZE, y*BLOC_SIZE,BLOC_SIZE,BLOC_SIZE, null); break;
            case 6 : g.drawImage(mechant,  x*BLOC_SIZE, y*BLOC_SIZE,BLOC_SIZE,BLOC_SIZE, null); break;
            case 9 : g.drawImage(porte_ouverte,  x*BLOC_SIZE-10, y*BLOC_SIZE,BLOC_SIZE+15,BLOC_SIZE, null); break;
            case 10 : g.drawImage(porte_ferme,  x*BLOC_SIZE, y*BLOC_SIZE,BLOC_SIZE,BLOC_SIZE, null); break;
            case 11 : g.drawImage(murgris,  x*BLOC_SIZE, y*BLOC_SIZE,BLOC_SIZE,BLOC_SIZE, null); break;
            
            }

            // Decouper en fontions
            if(object instanceof Directable) {
                int direction = ((Directable) object).getDirection();
                
                int deltaX = 0;
                int deltaY = 0;
                
                switch (direction) {
                case Directable.EAST:
                    deltaX = +(BLOC_SIZE-2)/2;
                    break;
                case Directable.NORTH:
                    deltaY = -(BLOC_SIZE-2)/2;
                    break;
                case Directable.WEST:
                    deltaX = -(BLOC_SIZE-2)/2;
                    break;
                case Directable.SOUTH:
                    deltaY = (BLOC_SIZE-2)/2;
                    break;
                }

                int xCenter = x * BLOC_SIZE + (BLOC_SIZE-2)/2;
                int yCenter = y * BLOC_SIZE + (BLOC_SIZE-2)/2;
                g.drawLine(xCenter, yCenter, xCenter + deltaX, yCenter + deltaY);
            }
        }//g.drawImage(maison, 7*BLOC_SIZE,4*BLOC_SIZE,19*BLOC_SIZE,17*BLOC_SIZE, null);
        if (numeroMap == 1) {
        	g.drawImage(lit1,  BLOC_SIZE*3, BLOC_SIZE,BLOC_SIZE*3,BLOC_SIZE*4, null);
        	g.drawImage(lit2,  BLOC_SIZE*26-33, BLOC_SIZE,BLOC_SIZE+65,BLOC_SIZE+75, null);
        	g.drawImage(bain,  BLOC_SIZE*14, BLOC_SIZE-28,BLOC_SIZE*4+10,BLOC_SIZE*3+25, null);
        	g.drawImage(armoire,  BLOC_SIZE, BLOC_SIZE,BLOC_SIZE*2,BLOC_SIZE*2, null);
        	g.drawImage(four,  BLOC_SIZE*28, BLOC_SIZE*17,BLOC_SIZE*2,BLOC_SIZE*2, null);
        	g.drawImage(bureau, BLOC_SIZE*23,BLOC_SIZE*2,BLOC_SIZE,BLOC_SIZE*2,null);
        	g.drawImage(miroir, BLOC_SIZE*10,BLOC_SIZE,BLOC_SIZE,BLOC_SIZE*2,null);
        	g.drawImage(armoirecuisine, BLOC_SIZE*24,BLOC_SIZE*14-15,BLOC_SIZE*3,BLOC_SIZE*2+10,null);
        	 	
        }
        else if (numeroMap == 2) {
        	g.drawImage(portail, BLOC_SIZE*16,BLOC_SIZE*29,BLOC_SIZE*2,BLOC_SIZE,null);    	
        }
        else if (numeroMap == 3) {
        	g.drawImage(portail, BLOC_SIZE*13,BLOC_SIZE*29,BLOC_SIZE*2,BLOC_SIZE,null);  
        	g.drawImage(portail, BLOC_SIZE*15,BLOC_SIZE*1,BLOC_SIZE*2,BLOC_SIZE,null);  
        }
        else if (numeroMap == 4) {
        	g.drawImage(portail, BLOC_SIZE*13,BLOC_SIZE*29,BLOC_SIZE*2,BLOC_SIZE,null);    	
        }
    }

    public void setObjects(ArrayList<GameObject> objects, int numeroMap) {
    	this.numeroMap = numeroMap;
        this.objects = objects;
    }

    public void redraw() {
        this.repaint();
    }

	public void addMouse(Mouse m) {
		this.mouseController = m;
	}
}

//g.setColor(Color.PINK);
//g.fillRect(x * BLOC_SIZE, y * BLOC_SIZE, BLOC_SIZE - 1, BLOC_SIZE - 1);
//g.setColor(Color.BLACK);
//g.drawRect(x * BLOC_SIZE, y * BLOC_SIZE, BLOC_SIZE - 1, BLOC_SIZE - 1);
//g.fillRect(x * BLOC_SIZE, y * BLOC_SIZE, BLOC_SIZE - 2, BLOC_SIZE - 2);
//.setColor(Color.BLACK);
//g.drawRect(x * BLOC_SIZE, y * BLOC_SIZE, BLOC_SIZE - 2, BLOC_SIZE - 2);