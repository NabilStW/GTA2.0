package Model;

public class BouleDeFeu extends Charactere implements Runnable{ //directable
	private int waitingTime;
	private int direction;
	private Game game;
	private Thread thread;
	private boolean thread_active = true;
	
	public BouleDeFeu(int x, int y, int couleur,int direction, int waitingTime, Game game) {
		super(x, y, couleur);
		this.waitingTime = waitingTime;
		this.direction = direction;
		this.game = game;
		this.thread = new Thread(this);
		thread.start();
	}
	
	public boolean setThread_active(boolean thread_active) {
		this.thread_active = thread_active;
		return thread_active;
	}
	
	/*public void stopThread() {
		thread.interrupt();
	}*/
	
	public void run() {
		synchronized(this) {
		try {
			while (thread_active) {
				//System.out.println("okkkkk");
				Thread.sleep(waitingTime);
				switch (direction) {
				case 0 : if (game.disparaitre(this) == false) {
							this.move(1,0);this.rotate(1,0); }	
						else  {
							game.action(this);
							game.setObject(this);
							thread_active = false;
					}
				  	break;
				case 1 : if (game.disparaitre(this) == false) {
							this.move(0,-1); this.rotate(0,-1); }
						else  {
							game.action(this);
							game.setObject(this);
							thread_active = false;
					}	
					break;
				case 2 : if (game.disparaitre(this) == false) {
							this.move(-1,0); this.rotate(-1,0); }
						else  {
							game.action(this);
							game.setObject(this);
							thread_active = false;
					}
					break;
				case 3 : if (game.disparaitre(this) == false) {
							this.move(0,1); this.rotate(0,1); }
						else  {
							game.action(this);
							game.setObject(this);
							thread_active = false;
					}
					break;
			}	
				}
			}
		catch(Exception e){  System.out.println("zjdfhgjhcvjdh");
			
		}
	}
}
}
