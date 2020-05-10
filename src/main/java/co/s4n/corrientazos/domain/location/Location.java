package co.s4n.corrientazos.domain.location;

import java.util.Objects;

public class Location {

    private int coordinateX;
    private int coordinateY;

    public Location(int coordinateX, int coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return coordinateX == location.coordinateX &&
                coordinateY == location.coordinateY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinateX, coordinateY);
    }
}
