package com.arjun.cityroutes.service;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.arjun.cityroutes.entities.ConnectedResponse;

class ConnectedServiceImplTest {

	String origin = "";
	String destination = "";

	ConnectedResponse conncted = new ConnectedResponse();
	ConnectedServiceImpl connectedServiceImpl = new ConnectedServiceImpl();

	@Test
	void testgetConnectedStatus() throws IOException {
		// good input
		conncted = connectedServiceImpl.getConnectedStatus("Malvern", "Exton");
		assertEquals("yes", conncted.getConnected());

		// good input with case sensitive testing
		conncted = connectedServiceImpl.getConnectedStatus("malvern", "exton");
		assertEquals("yes", conncted.getConnected());

		// good input with user mistakenly added a space
		conncted = connectedServiceImpl.getConnectedStatus("Trenton", "Albany ");
		assertEquals("yes", conncted.getConnected());

		// Not conncted in the list
		conncted = connectedServiceImpl.getConnectedStatus("Buffalo", "Geneva");
		assertEquals("no", conncted.getConnected());

		// bad input
		conncted = connectedServiceImpl.getConnectedStatus("74849", "06345");
		assertEquals("no", conncted.getConnected());

		// bad input
		conncted = connectedServiceImpl.getConnectedStatus("^775#", "xcRFrr");
		assertEquals("no", conncted.getConnected());

		// bad input
		conncted = connectedServiceImpl.getConnectedStatus("87y664q9y5", "349=]e");
		assertEquals("no", conncted.getConnected());

	}

}
