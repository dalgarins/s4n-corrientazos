package co.s4n.corrientazos.domain.orientation;

import co.s4n.corrientazos.domain.gps.IMovePosition;

public enum Cardinal {

    NORTH {
        @Override
        public void updateLocation(IMovePosition position) {
            position.moveToNorth();
        }
    }, SOUTH {
        @Override
        public void updateLocation(IMovePosition position) {
            position.moveToSouth();
        }
    }, EAST {
        @Override
        public void updateLocation(IMovePosition position) {
            position.moveToEast();
        }
    }, WEST {
        @Override
        public void updateLocation(IMovePosition position) {
            position.moveToWest();
        }
    };

    public abstract void updateLocation(IMovePosition position);

}
