package Model;

import java.util.ArrayList;

public class BlockBreakable extends Block implements Deletable, Activable {
	private int energy = 0;

    private ArrayList<DeletableObserver> observers = new ArrayList<DeletableObserver>();
    private int lifepoints = 0;
    public BlockBreakable(int X, int Y, int lifepoints, int energy) {
        super(X, Y, lifepoints);
        this.energy = energy;
        this.lifepoints = lifepoints; 
       
    }
    public int getEnergy() {
    	return this.energy;
    }
    
    public void activate(){
        if (lifepoints == 1){
            crush();
        }
        else {
            lifepoints--;
            this.color = lifepoints - 1; // pour éviter de retourner au gris
        }
    }


    public void crush(){
        notifyDeletableObserver();
    }
    // //////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void attachDeletable(DeletableObserver po) {
        observers.add(po);
    }

    @Override
    public void notifyDeletableObserver() {
        int i = 0;
        for (DeletableObserver o : observers) {
            i++;
            o.delete(this, null);
        }
    }

    @Override
    public boolean isObstacle() {
        return true;
    }
    
}
