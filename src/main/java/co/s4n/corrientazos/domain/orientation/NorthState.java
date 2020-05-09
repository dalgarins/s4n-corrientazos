package co.s4n.corrientazos.domain.orientation;

public class NorthState implements ICardinalState {

    @Override
    public void turnLeft90Degrees(IGyroscopeContext gyroscope) {
        gyroscope.setCardinalState(new WestState());
    }

    @Override
    public void turnRight90Degrees(IGyroscopeContext gyroscope) {
        gyroscope.setCardinalState(new EastState());
    }
}
