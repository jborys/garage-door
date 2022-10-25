package edu.designpatterns.state;

import static edu.designpatterns.state.GarageDoor.CLOSED;
import static edu.designpatterns.state.GarageDoor.OPENING;

public class ClosedState extends DoorState {
    @Override
    void click(GarageDoor garageDoor) {
        //old code
        garageDoor.setMessageString(OPENING);
    }

    @Override
    void sensor(GarageDoor garageDoor) {
        //old code
        garageDoor.setMessageString(CLOSED);
    }

    @Override
    String getCurrentStateString(GarageDoor garageDoor) {
        return OPENING;
    }
}
