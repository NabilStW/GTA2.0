package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import Model.Bot;
import Model.Player;

public class Status extends JPanel {
	private Player p;
	private Bot b;
	private int BAR_LENGTH = 200;
	private int BAR_WIDTH = 30;
	private int AVATAR_SIZE = 100;

    public Status() {
        this.setPreferredSize(new Dimension(450, 600));
        this.setBackground(Color.LIGHT_GRAY);
        this.setOpaque(true);
    }
    
	public void paint(Graphics g) {  // permet de réafficher à l'écran, toutes les operations ici
		super.paintComponent(g);
		// draw avatar
        g.setColor(Color.BLUE);
        g.fillRect(150, 25, AVATAR_SIZE, AVATAR_SIZE);
        g.setColor(Color.WHITE);
        g.drawString("AVATAR 1", 173, 75);

		// bars 
        // Energy 
        g.setColor(Color.BLACK);
        g.drawString("Energy", 0, 190);
        g.setColor(Color.RED);
        g.fillRect(0, 200, BAR_LENGTH, BAR_WIDTH);  // (x,y, longueur, largeur)
        g.setColor(Color.GREEN);
        int length_ok = (int) Math.round(BAR_LENGTH*p.getEnergy()); // permet de modifier la taille du vert
        g.fillRect(0, 200, length_ok, BAR_WIDTH);
        
     // Vie 
        g.setColor(Color.BLACK);  // couleur
        g.drawString("Vie", 0, 255);
        g.setColor(Color.RED);
        g.fillRect(0, 265, BAR_LENGTH, BAR_WIDTH);
        g.setColor(Color.GREEN);
        length_ok = (int) Math.round(BAR_LENGTH*p.getVie());
        g.fillRect(0, 265, length_ok, BAR_WIDTH);
        
     // Pouvoir1
        g.setColor(Color.BLACK);  // couleur
        g.drawString("Pouvoir 1", 0, 390);
        g.setColor(Color.RED);
        g.fillRect(0, 400, 150, BAR_WIDTH);
        g.setColor(Color.GREEN);
        length_ok = (int) Math.round(150*p.getPouvoir1());
        g.fillRect(0, 400, length_ok, BAR_WIDTH);
        
     // Pouvoir2
        g.setColor(Color.BLACK);  // couleur
        g.drawString("Pouvoir 2", 0, 455);
        g.setColor(Color.RED);
        g.fillRect(0, 465, 150, BAR_WIDTH);
        g.setColor(Color.GREEN);
        length_ok = (int) Math.round(150*p.getPouvoir2());
        g.fillRect(0, 465, length_ok, BAR_WIDTH);
    }

    public void redraw() {
        this.repaint();
    }

	public void setPlayer(Player p2) {
		this.p = p2;
	}
}
