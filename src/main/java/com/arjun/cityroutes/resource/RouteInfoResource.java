package com.arjun.cityroutes.resource;

import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RouteInfoResource {
	
  @GetMapping("/connected")
	public String isRouteAvilable(@QueryParam(value = "origin") String origin,
			@QueryParam(value = "destination") String destination) {
		String result;
		if (origin.equals("Malvern")) {
			result = "YES";

		}else {
			result = "NO";
		}
		
		return result;
			
	}

	

}
