package edu.designpatterns.state;

import static edu.designpatterns.state.GarageDoor.CLOSING;
import static edu.designpatterns.state.GarageDoor.OPEN;

public class OpenState extends DoorState {
    @Override
    void click(GarageDoor garageDoor) {
        //old code
        garageDoor.setMessageString(CLOSING);
    }

    @Override
    void sensor(GarageDoor garageDoor) {
        //old code
        garageDoor.setMessageString(OPEN);

    }

    @Override
    String getCurrentStateString(GarageDoor garageDoor) {
        return null;
    }
}
