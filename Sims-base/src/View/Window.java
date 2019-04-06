package View;

import Model.Bot;
import Model.GameObject;
import Model.Player;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Controller.Mouse;

public class Window extends JFrame {              // JFrame est un objet pour déclarer des fenêtres
	private JPanel groupPanel = new JPanel(new BorderLayout());    // JPanel petit container
    private Map map;
    private Status status = new Status();

    public Window(String title, int MAP_SIZE, int BLOC_SIZE) {
    	super(title);
    	map = new Map(MAP_SIZE,BLOC_SIZE);
        // JFrame window = new JFrame("Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // croix fermé en haut
        this.setBounds(0, 0, 1000, 1020);   // taille de base mais osef avec pack
        this.getContentPane().setBackground(Color.gray);   // le fond est de couleur grise mais osef on le voit pas a cause des objets devant
        groupPanel.add(map, BorderLayout.LINE_START); // map a droite
        groupPanel.add(status, BorderLayout.LINE_END); // map à gauche
        this.getContentPane().add(this.groupPanel);
        this.setVisible(true);
        this.pack();
    }
    public void setMap() {
    	
    }
    public void setGameObjects(ArrayList<GameObject> objects, int numeroMap) {
        this.map.setObjects(objects,numeroMap);
        this.map.redraw();
    }

    public void update() {
    	groupPanel.repaint();
        //this.map.redraw();
        //this.status.redraw();
    }

    public void setKeyListener(KeyListener keyboard) {
        this.map.addKeyListener(keyboard);
    }

    public void setMouseListener(Mouse m) {
        this.map.addMouse(m);
    }

	public int getMapSize() {
		return map.MAP_SIZE;
	}
	
	public void setPlayer(Player p) {
		status.setPlayer(p);
	}
}
