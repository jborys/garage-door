package edu.designpatterns.state;


import org.junit.jupiter.api.Test;

import static edu.designpatterns.state.GarageDoor.*;
import static org.assertj.core.api.Assertions.assertThat;

public class GarageDoorTest {
	private GarageDoor garageDoor = new GarageDoor();
	
	@Test
	public void initialConditionsDoorShouldBeClosed() {
		assertDoorMessage(CLOSED); // Closed
	}

	@Test
	public void clickShouldStartDoorOpening() {
		garageDoor.click(); // Opening
		
		assertDoorMessage(OPENING);
	}

	@Test
	public void sensorShouldIndicateGarageDoorIsOpen() {
		openDoor();	// Open
		
		assertDoorMessage(OPEN);
	}

	@Test
	public void clickOnOpenDoorShouldStartDoorClosing() {
		openDoor();	// Open
		garageDoor.click();	// Closing
		
		assertDoorMessage(CLOSING);
	}

	@Test
	public void sensorShouldIndicateDoorIsClosed() {
		openDoor();				// Open
		garageDoor.click(); 	// Closing
		garageDoor.sensor();	// Closed
		
		assertDoorMessage(CLOSED);
	}

	@Test
	public void clickWhileOpeningShouldStopDoor() {
		garageDoor.click(); // Opening
		garageDoor.click(); // Stopped - Opening
		
		assertDoorMessage("Stopped");
	}
	
	@Test
	public void clickWhenStoppedShouldCloseDoor() {
		garageDoor.click(); // Opening
		garageDoor.click(); // Stopped
		garageDoor.click(); // Closing
		
		assertDoorMessage(CLOSING);
	}

	@Test
	public void clickWhenOpeningShouldStopDoor() {
		openDoor();			// Open
		garageDoor.click();	// Closing
		garageDoor.click();	// Stopped - Closing
		
		assertDoorMessage(STOPPED);
	}
	
	@Test
	public void clickWhenStoppedClosingShouldOpenDoor() {
		openDoor();			// Open
		garageDoor.click();	// Closing
		garageDoor.click();	// Stopped - Closing
		garageDoor.click();	// Opening
		
		assertDoorMessage(OPENING);
	}
	
	// Helper methods

	private void openDoor() {
		garageDoor.click();
		garageDoor.sensor();
	}
	
	private void assertDoorMessage(String expected) {
		assertThat(garageDoor.getCurrentStateString()).isEqualTo(expected);
	}

}
