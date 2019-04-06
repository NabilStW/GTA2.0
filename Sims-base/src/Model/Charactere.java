package Model;

public class Charactere extends GameObject implements Directable{
	
	double energy = 100;
	double vie = 100;
	double pouvoir1 = 100;
	double pouvoir2 = 100;
    int direction = EAST;

    public Charactere(int x, int y, int couleur) {
        super(x, y, couleur);
    }

    public void move(int X, int Y) {
        this.posX = this.posX + X;
        this.posY = this.posY + Y;
    }

    public void rotate(int x, int y) {
        if(x == 0 && y == -1)
            direction = NORTH;
        else if(x == 0 && y == 1)
            direction = SOUTH;
        else if(x == 1 && y == 0)
            direction = EAST;
        else if(x == -1 && y == 0)
            direction = WEST;
    }

   // //////////////////////////////////////////////////////////////////////////////////////


    @Override
    public boolean isObstacle() {
        return true;
    }

    @Override
    public int getDirection() {
    return direction;
    }

    public int getFrontX() {
        int delta = 0;
        if (direction % 2 == 0){
            delta += 1 - direction;
        }
        return this.posX + delta;
    }

    public int getFrontY() {
        int delta = 0;
        if (direction % 2 != 0){
            delta += direction - 2;
        }
        return this.posY + delta;
    }
    
    public double getEnergy() {
    	return energy/100.0;
    }
    public double getVie() {
    	return vie/100.0;
    }
    public double getPouvoir1() {
    	return pouvoir1/100.0;
    }
    public double getPouvoir2() {
    	return pouvoir2/100.0;
    }
}