package Model;

import View.Window;

import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.activation.Activatable;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import org.omg.CosNaming.IstringHelper;

public class Game implements DeletableObserver {
    private ArrayList<GameObject> objects1 = new ArrayList<GameObject>();
    private ArrayList<GameObject> objects2 = new ArrayList<GameObject>();
    private ArrayList<GameObject> objects3 = new ArrayList<GameObject>();
    private ArrayList<GameObject> objects4 = new ArrayList<GameObject>();
    private ArrayList<Player> players = new ArrayList<Player>();
    private ArrayList<Bot> bots = new ArrayList<Bot>();
    private Player active_player = null;   // quel joueur est joué ?
    private Window window;
    private int numeroMap = 1;
    private int size;
    private int numberOfBreakableBlocks = 100;
    
    public void MapCreator(int numeroMap) {
    	try {
    		System.out.println("ok");
    		FileReader file;
    		file = new FileReader("Cartes/Map"+numeroMap+".txt");
    		System.out.println("ok");
    		BufferedReader br = new BufferedReader(file);
    		String line;
    		
    		while ((line = br.readLine())!=null) {
    			String[] data = line.split(" ");
    			if (data.length > 1) {
    				MapReader(data,numeroMap);
    				}
    			}
    		br.close();
    		
    	}
    	catch(FileNotFoundException ex) {
            System.out.println("File not found");
        } catch(IOException ex) {
            System.out.println("Error in the file");
        }
    	notifyView();
    }
    
    public void MapReader(String[] data,int numeroMap) {
    	ArrayList<GameObject> liste = new ArrayList<GameObject>();
    	if (numeroMap==1) {
    		liste = objects1;
    	}else if (numeroMap==2) {
    		liste = objects2;
    	}else if (numeroMap == 3) {
    		liste = objects3;
    	}else if (numeroMap == 4) {
    		liste = objects4;
    	}
    	switch(Integer.parseInt(data[0])) {
    	case 0: BlockBreakable block = new BlockBreakable(Integer.parseInt(data[1]), Integer.parseInt(data[2]),1);block.attachDeletable(this);
    	liste.add(block);break;
    	case 1: liste.add(new BlockUnbreakable(Integer.parseInt(data[1]), Integer.parseInt(data[2]),Integer.parseInt(data[3]))); break;
    	}
    }
    public void changeMap(int numeroMap) {
    	this.numeroMap= numeroMap;
    	switch(numeroMap) {
    	case 1: window.setGameObjects(objects1,1);break;
    	case 2 : window.setGameObjects(objects2,2);break;
    	case 3 : window.setGameObjects(objects3, 3);break;
    	case 4 : window.setGameObjects(objects4, 4);break;
    	}
    	notifyView();
    }
    
    public Game(Window window) {
        this.window = window;
        size = window.getMapSize();	
        Player p = new Player(10, 10,666666); objects1.add(p); players.add(p); objects2.add(p); objects3.add(p);objects4.add(p); 
        MapCreator(1); MapCreator(2); MapCreator(3); MapCreator(4);
        
        /*for (int i = 0; i < 10; i++) {
        	objects1.add(new Bot(i,i,6,1000,window,this));
        	objects2.add(new Bot(i,i,6,1000,window,this));
        }*/
	
        ThreadBarres barres = new ThreadBarres(100,0.05,0.05,p,window);
        window.setPlayer(p);
        active_player = p;

        // Map building
        for (int i = 0; i < size; i++) {
            objects1.add(new BlockUnbreakable(i, 0,0));objects2.add(new BlockUnbreakable(i, 0,0));
            objects3.add(new BlockUnbreakable(i, 0,0));objects4.add(new BlockUnbreakable(i, 0,0));
            
            objects1.add(new BlockUnbreakable(0, i,0));objects2.add(new BlockUnbreakable(0, i,0));
            objects3.add(new BlockUnbreakable(0, i,0));objects4.add(new BlockUnbreakable(0, i,0));
            
            objects1.add(new BlockUnbreakable(i, size - 1,0));objects2.add(new BlockUnbreakable(i, size - 1,0));
            objects3.add(new BlockUnbreakable(i, size - 1,0));objects4.add(new BlockUnbreakable(i, size - 1,0));
            
            objects1.add(new BlockUnbreakable(size - 1, i,0));objects2.add(new BlockUnbreakable(size - 1, i,0));
            objects3.add(new BlockUnbreakable(size - 1, i,0));objects4.add(new BlockUnbreakable(size - 1, i,0));                          
            
        }
        window.setGameObjects(objects1,1);
        notifyView();
    }
    
    public boolean Obstacle(int x,int y) {
    	ArrayList<GameObject> liste = new ArrayList<GameObject>();
    	boolean obstacle = false;
    	switch(numeroMap) {
    	case 1: liste = objects1; break;
    	case 2: liste = objects2;break;
    	case 3: liste = objects3;break;
    	case 4: liste = objects4;break;
    	}
        for (GameObject object : liste) {
            if (object.isAtPosition(x, y)) {
                obstacle = object.isObstacle();
            }
            if (obstacle == true) {
                break;
            }         
        }
    	return obstacle;
    }


    public void movePlayer(int x, int y) {
        int nextX = active_player.getPosX() + x;
        int nextY = active_player.getPosY() + y;
        
        boolean obstacle = this.Obstacle(nextX, nextY);
        active_player.rotate(x, y);
        if (obstacle == false) {
            active_player.move(x, y);
        }
        notifyView();
    }
  
    public void tirePlayer() {
    	changeMap(2);
    	active_player.tire();
    	notifyView();
    }
    
    public void bouledefeu() {
    	bouledefeu(active_player.getPosX(), active_player.getPosY(),active_player.getDirection());
    }
    public void bouledefeu(int x, int y, int d) {	
    	objects1.add(new BouleDeFeu(x,y,8,d,30,this)); 	
    }
    
    public void flash() {
    	if (active_player.pouvoir2 > 99) {
    	if (active_player.getDirection() == 0) {
    		active_player.move(4, 0); 		
    	}else if (active_player.getDirection() == 1) {
    		active_player.move(0,- 4); 		
    	}else if (active_player.getDirection() == 2) {
    		active_player.move(-4, 0); 		
    	}else if (active_player.getDirection() == 3) {
    		active_player.move(0, 4); 		
    	}
    	active_player.pouvoir2 = 0;
    	}
    	
    }
    
    public void setObject(GameObject object) {
    	objects1.remove(object); 	
    }
    
    public void action() {
    		action(active_player);
    	}
    public void action(Charactere cara) {
        Activable aimedObject = null;
		for(GameObject object : objects1){
			if(object.isAtPosition(cara.getFrontX(),cara.getFrontY())){
			    if(object instanceof Activable){
			        aimedObject = (Activable) object;
			    }
			}
		}
		if(aimedObject != null){
			System.out.println("c'est passé");
		    aimedObject.activate();
            notifyView();
		}
        
    }
    public boolean disparaitre(Charactere cara) {
        boolean mur = false;
        
		for(GameObject object : objects1){
			if(object.isAtPosition(cara.getFrontX(),cara.getFrontY())){
				mur = true;
			}				
		}
		notifyView(); 
		return mur;     
    }
    

    private void notifyView() {
        window.update();
    }

    public ArrayList<GameObject> getGameObjects() {
        return this.objects1;
    }

    @Override
    synchronized public void delete(Deletable ps, ArrayList<GameObject> loot) {
        objects1.remove(ps);
        if (loot != null) {
            objects1.addAll(loot);
        }
        notifyView();
    }


    public void playerPos() {
        System.out.println(active_player.getPosX() + ":" + active_player.getPosY());
        
    }

	public void stop() {
		window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
	}


	public void sendPlayer(int x, int y) {
		Thread t = new Thread(new AStarThread(this, active_player, x,  y));
		t.start();
	}


}
/*
Random rand = new Random();
for (int i = 0; i < numberOfBreakableBlocks; i++) {
    int x = rand.nextInt(size-4) + 2;
    int y = rand.nextInt(size-4) + 2;
    int lifepoints = rand.nextInt(5)+1;
    int energy = rand.nextInt(2);
    BlockBreakable block = new BlockBreakable(x, y, lifepoints,energy);
    block.attachDeletable(this);
    objects.add(block);
} */
/*public void quatreFeux() {
if (active_player.pouvoir1 > 99) {
bouledefeu(active_player.getPosX(), active_player.getPosY(),0);
bouledefeu(active_player.getPosX(), active_player.getPosY(),1); 
bouledefeu(active_player.getPosX(), active_player.getPosY(),2);
bouledefeu(active_player.getPosX(), active_player.getPosY(),3);
active_player.pouvoir1 = 0;
}
} */