package co.s4n.corrientazos.domain.orientation;

public class SouthState implements ICardinalState {
    @Override
    public void turnLeft90Degrees(IGyroscopeContext gyroscope) {
        gyroscope.setCardinalState(new EastState());
    }

    @Override
    public void turnRight90Degrees(IGyroscopeContext gyroscope) {
        gyroscope.setCardinalState(new WestState());
    }

    @Override
    public Cardinal currentCardinal() {
        return Cardinal.SOUTH;
    }
}
