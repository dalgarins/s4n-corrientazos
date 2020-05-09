package co.s4n.corrientazos.domain.location;

public class Location {

    private int coordinateX;
    private int coordinateY;

    public Location(int coordinateX, int coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public void increaseX() {
        coordinateX++;
    }

    public void decreaseX() {
        coordinateX--;
    }

    public void increaseY() {
        coordinateY++;
    }

    public void decreaseY() {
        coordinateY--;
    }

}
