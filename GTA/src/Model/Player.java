package Model;

public class Player extends Charactere{
	
	public Player(int x,int y, int couleur) {
		super(x,y,7);
	}

	public void tire() {
		if (energy > 10)
			energy -= 10;
	}
}
