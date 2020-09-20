package com.arjun.cityroutes.resource;

import java.io.IOException;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arjun.cityroutes.entities.ConnectedResponse;
import com.arjun.cityroutes.service.ConnectedService;

@RestController
public class RouteInfoResource {

	@Autowired
	ConnectedService connectedService;

	@GetMapping("/connected")
	public ConnectedResponse getConnectedStatus(@QueryParam(value = "origin") String origin,
			@QueryParam(value = "destination") String destination) throws IOException {

		ConnectedResponse connected = connectedService.getConnectedStatus(origin, destination);

		return connected; // for best practice returning object which has yes or no
	}

}
