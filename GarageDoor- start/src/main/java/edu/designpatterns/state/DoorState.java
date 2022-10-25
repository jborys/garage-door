package edu.designpatterns.state;

abstract class DoorState {
    abstract void click(GarageDoor garageDoor);
    abstract void sensor(GarageDoor garageDoor);
    abstract String getCurrentStateString(GarageDoor garageDoor);
}

