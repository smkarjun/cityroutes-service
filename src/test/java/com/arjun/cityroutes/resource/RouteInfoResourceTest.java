package com.arjun.cityroutes.resource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.powermock.reflect.Whitebox;

import com.arjun.cityroutes.entities.ConnectedResponse;
import com.arjun.cityroutes.service.ConnectedService;

@RunWith(MockitoJUnitRunner.class)
class RouteInfoResourceTest {

	ConnectedService connectedServiceMock;
	RouteInfoResource routeInfoResource;
	ConnectedResponse conncted;

	@BeforeEach
	public void setup() throws IOException {
		MockitoAnnotations.initMocks(this);
		connectedServiceMock = Mockito.mock(ConnectedService.class);
		routeInfoResource = new RouteInfoResource();
		conncted = new ConnectedResponse();
		Whitebox.setInternalState(routeInfoResource, ConnectedService.class, connectedServiceMock);

	}

	@Test
	void testGetConnectedStatus() throws IOException {
		when(connectedServiceMock.getConnectedStatus("Malvern", "Exton")).thenReturn(new ConnectedResponse("yes"));
		conncted = routeInfoResource.getConnectedStatus("Malvern", "Exton");
		assertEquals("yes", conncted.getConnected());

	}
	
	@Test
	void testGetConnectedStatusfornotConnected() throws IOException {
		when(connectedServiceMock.getConnectedStatus("Malvern", "WestChester")).thenReturn(new ConnectedResponse("no"));
		conncted = routeInfoResource.getConnectedStatus("Malvern", "WestChester");
		assertEquals("no", conncted.getConnected());

	}

}
