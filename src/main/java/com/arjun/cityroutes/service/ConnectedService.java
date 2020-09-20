package com.arjun.cityroutes.service;

import java.io.IOException;

import com.arjun.cityroutes.entities.ConnectedResponse;

public interface ConnectedService {
	
	final String SERVICE_NAME="ConnectedService";
	
	public ConnectedResponse getConnectedStatus(String origin,String destination) throws IOException;

}
