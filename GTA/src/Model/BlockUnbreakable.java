package Model;

public class BlockUnbreakable extends Block {

    public BlockUnbreakable(int X, int Y,int couleur) {
        super(X, Y, couleur);
    }

    @Override
    public boolean isObstacle() {
        return true;
    }
}
