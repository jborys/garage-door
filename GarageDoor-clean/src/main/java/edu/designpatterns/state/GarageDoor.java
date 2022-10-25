package edu.designpatterns.state;

public class GarageDoor {
	DoorState state = new ClosedState();

	public void click() {
		state.click(this);
	}

	public String getMessageString() {
		return state.getMessageString();
	}

	public void sensor() {
		state.sensor(this);
	}

	void setState(DoorState doorState) {
		state = doorState;
	}


}
