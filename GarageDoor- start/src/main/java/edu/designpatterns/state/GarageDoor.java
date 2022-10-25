package edu.designpatterns.state;

public class GarageDoor {
	public static final String CLOSED = "Closed";
	public static final String OPENING = "Opening";
	public static final String CLOSING = "Closing";
	public static final String STOPPED = "Stopped";
	public static final String OPEN = "Open";
	private String currentStateString = CLOSED;
	String resumeState;

	DoorState state = new ClosedState();

	void setState(DoorState state) {
		this.state = state;
	}

	public void click() {
		if (CLOSED.equals(currentStateString)) {
			state = new ClosedState();
			state.click(this);
		} else if (OPENING.equals(currentStateString)) {
			state = new OpeningState();
			state.click(this);
		} else if (CLOSING.equals(currentStateString)) {
			state = new ClosingState();
			state.click(this);
		} else if (STOPPED.equals(currentStateString)) {
			state = new StoppedState();
			state.click(this);
		} else {
			state = new OpenState();
			state.click(this);

		}
	}

	void setMessageString(String string) {
		currentStateString = string;
	}

	public String getCurrentStateString() {
		return currentStateString;
	}

	public void sensor() {
		if (OPENING.equals(currentStateString)) {
			state = new OpenState();
			state.sensor(this);
		} else {
			state = new ClosedState();
			state.sensor(this);
		}
	}
}
