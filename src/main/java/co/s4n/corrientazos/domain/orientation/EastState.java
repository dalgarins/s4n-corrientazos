package co.s4n.corrientazos.domain.orientation;

public class EastState implements ICardinalState {
    @Override
    public void turnLeft90Degrees(IGyroscopeContext gyroscope) {
        gyroscope.setCardinalState(new NorthState());
    }

    @Override
    public void turnRight90Degrees(IGyroscopeContext gyroscope) {
        gyroscope.setCardinalState(new SouthState());
    }

    @Override
    public Cardinal currentCardinal() {
        return Cardinal.EAST;
    }
}
