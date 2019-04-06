package Model;
import java.util.Random;
import View.Window;

public class Bot extends Charactere implements Runnable {
	private int waitingTime = 0;
	private Window window;
	private Game game;
	private Thread thread;
	
	public Bot(int x,int y, int couleur, int waitingTime, Window window,Game game) {
		super(x,y,6);
		this.waitingTime = waitingTime;
		this.window = window;
		this.game = game;
		this.thread = new Thread(this);
		thread.start();	
	}
	
	public void run() {
		try {
			Random rand = new Random();
			while (true) {
				Thread.sleep(waitingTime);
				int direction = rand.nextInt(4);
				switch (direction) {
				case 0 : if (game.Obstacle(this.getPosX()+1,this.getPosY())==false) {
					this.move(1,0); this.rotate(1, 0);  break;
					// game.bouledefeu(this.getPosX(),this.getPosY(),direction,1);
				}
				case 1 : if (game.Obstacle(this.getPosX(),this.getPosY()-1)==false) {
					this.move(0,-1); this.rotate(0, -1);  break;
				}
				case 2 : if (game.Obstacle(this.getPosX()-1,this.getPosY())==false) {
					this.move(-1,0); this.rotate(-1, 0); break;
				}
				case 3 : if (game.Obstacle(this.getPosX(),this.getPosY()+1)==false) {
					this.move(0,1); this.rotate(0, 1); break;
				}
			}
				window.update();	
			}
		}
		catch(Exception e){
			
		}
		
	}
	//boolean obstacle = game.Obstacle(0,1);

}
