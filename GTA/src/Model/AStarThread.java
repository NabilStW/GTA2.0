package Model;

public class AStarThread implements Runnable{
	private Game g;
	private Player p;
	private int x;
	private int y;

	public AStarThread(Game g, Player p, int x, int y) {
		this.g= g;
		this.p = p;
		this.x = x;
		this.y = y;
		
	}
	
	@Override
	public void run() {
		int direction = 0;
		synchronized(p) {
		while(direction != -1) {
			direction = (new AStar(p.getPosX(), p.getPosY(), x, y, g.getGameObjects())).getNextStep();
			switch (direction) {
				case 0 : g.movePlayer(1,0); break;
				case 1 : g.movePlayer(0,-1); break;
				case 2 : g.movePlayer(-1,0); break;
				case 3 : g.movePlayer(0,1); break;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
	}
		

}
