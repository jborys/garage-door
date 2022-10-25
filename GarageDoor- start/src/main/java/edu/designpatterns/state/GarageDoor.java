package edu.designpatterns.state;

public class GarageDoor {
	public static final String CLOSED = "Closed";
	public static final String OPENING = "Opening";
	public static final String CLOSING = "Closing";
	public static final String STOPPED = "Stopped";
	public static final String OPEN = "Open";
	private String stateString = CLOSED;
	private String resumeState;
	

	public void click() {
		if (CLOSED.equals(stateString)) {
			setStateString(OPENING);
		} else if (OPENING.equals(stateString)) {
			resumeState = CLOSING;
			setStateString(STOPPED);
		} else if (CLOSING.equals(stateString)) {
			resumeState = OPENING;
			setStateString(STOPPED);
		} else if (STOPPED.equals(stateString)) {
			setStateString(resumeState);
		} else {
			setStateString(CLOSING);
		}
	}

	void setStateString(String string) {
		stateString = string;
	}

	public String getMessageString() {
		return stateString;
	}

	public void sensor() {
		if (OPENING.equals(stateString)) {
			setStateString(OPEN);
		} else {
			setStateString(CLOSED);
		}
	}
}
