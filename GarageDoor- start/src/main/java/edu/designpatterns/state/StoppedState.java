package edu.designpatterns.state;

public class StoppedState extends DoorState {
    @Override
    void click(GarageDoor garageDoor) {
        //old code
        garageDoor.setMessageString(garageDoor.resumeState);
    }

    @Override
    void sensor(GarageDoor garageDoor) {

    }

    @Override
    String getCurrentStateString(GarageDoor garageDoor) {
        return null;
    }
}
