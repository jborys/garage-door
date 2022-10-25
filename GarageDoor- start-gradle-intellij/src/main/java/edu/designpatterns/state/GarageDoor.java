package edu.designpatterns.state;

public class GarageDoor {
	private String stateString = "Closed";
	private String resumeState;
	

	public void click() {
		if ("Closed".equals(stateString)) {
			setStateString("Opening");
		} else if ("Opening".equals(stateString)) {
			resumeState = "Closing";
			setStateString("Stopped");
		} else if ("Closing".equals(stateString)) {
			resumeState = "Opening";
			setStateString("Stopped");
		} else if ("Stopped".equals(stateString)) {
			setStateString(resumeState);
		} else {
			setStateString("Closing");
		}
	}

	void setStateString(String string) {
		stateString = string;
	}

	public String getMessageString() {
		return stateString;
	}

	public void sensor() {
		if ("Opening".equals(stateString)) {
			setStateString("Open");
		} else {
			setStateString("Closed");
		}
	}
}
