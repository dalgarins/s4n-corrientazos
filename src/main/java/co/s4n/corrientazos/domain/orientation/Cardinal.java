package co.s4n.corrientazos.domain.orientation;

import co.s4n.corrientazos.domain.gps.IMovePosition;

public enum Cardinal {

    NORTH("Norte") {
        @Override
        public void updateLocation(IMovePosition position) {
            position.moveToNorth();
        }
    }, SOUTH("Sur") {
        @Override
        public void updateLocation(IMovePosition position) {
            position.moveToSouth();
        }
    }, EAST("Oriente") {
        @Override
        public void updateLocation(IMovePosition position) {
            position.moveToEast();
        }
    }, WEST("Occidente") {
        @Override
        public void updateLocation(IMovePosition position) {
            position.moveToWest();
        }
    };

    private String value;
    Cardinal(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public abstract void updateLocation(IMovePosition position);

}
