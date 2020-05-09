package co.s4n.corrientazos.domain.orientation;

public interface ICardinalState {

    void turnLeft90Degrees(IGyroscopeContext gyroscope);

    void turnRight90Degrees(IGyroscopeContext gyroscope);

}
