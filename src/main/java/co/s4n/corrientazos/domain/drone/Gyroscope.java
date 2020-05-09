package co.s4n.corrientazos.domain.drone;

import co.s4n.corrientazos.domain.orientation.ICardinalState;
import co.s4n.corrientazos.domain.orientation.IGyroscope;
import co.s4n.corrientazos.domain.orientation.IGyroscopeContext;
import co.s4n.corrientazos.domain.orientation.NorthState;

public class Gyroscope implements IGyroscope, IGyroscopeContext {

    private ICardinalState state = new NorthState();

    @Override
    public void setCardinalState(ICardinalState cardinalState) {
        state = cardinalState;
    }

    @Override
    public void turnLeft() {
        state.turnLeft90Degrees(this);
    }

    @Override
    public void turnRight() {
        state.turnRight90Degrees(this);
    }
}
