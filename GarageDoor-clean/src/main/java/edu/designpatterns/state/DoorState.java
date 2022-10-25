package edu.designpatterns.state;

abstract class DoorState {

    abstract void click(GarageDoor garageDoor);

    void sensor(GarageDoor garageDoor){
        throw new IllegalStateException();
    }

    abstract String getMessageString();
}

class ClosedState extends DoorState {

    @Override
    void click(GarageDoor garageDoor) {
        garageDoor.setState(new OpeningState());
    }

    @Override
    String getMessageString() {
        return "Closed";
    }
}
class OpeningState extends DoorState {

    @Override
    void click(GarageDoor garageDoor) {
        garageDoor.setState(new StoppedOpening());
    }

    @Override
    void sensor(GarageDoor garageDoor) {
        garageDoor.setState(new OpenState());
    }

    @Override
    String getMessageString() {
        return "Opening";
    }
}

class ClosingState extends DoorState {
    @Override
    void click(GarageDoor garageDoor) {
        garageDoor.setState(new StoppedClosing());
    }

    @Override
    void sensor(GarageDoor garageDoor) {
        garageDoor.setState(new ClosedState());
    }

    @Override
    String getMessageString() {
        return "Closing";
    }
}

abstract class StoppedState extends DoorState {

    @Override
    String getMessageString() {
        return "Stopped";
    }
}
class StoppedOpening extends StoppedState {

    @Override
    void click(GarageDoor garageDoor) {
        garageDoor.setState(new ClosingState());
    }
}

class StoppedClosing extends StoppedState {
    @Override
    void click(GarageDoor garageDoor) {
            garageDoor.setState(new OpeningState());
    }
}
 class OpenState extends DoorState {

     @Override
     void click(GarageDoor garageDoor) {
         garageDoor.setState(new ClosingState());
     }

     @Override
     String getMessageString() {
         return "Open";
     }
 }
