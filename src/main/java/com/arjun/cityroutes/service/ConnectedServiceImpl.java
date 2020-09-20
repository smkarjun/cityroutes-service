package com.arjun.cityroutes.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.arjun.cityroutes.entities.ConnectedResponse;

@Service
public class ConnectedServiceImpl implements ConnectedService {

	@Override
	public ConnectedResponse getConnectedStatus(String origin, String destination) throws IOException {
		ConnectedResponse conncted = new ConnectedResponse();

		String inputCities = String.join(",", origin.trim(), destination.trim());

		List<String> list = Files.lines(Paths.get("city.txt")).collect(Collectors.toList());

		if (list.stream().filter(s -> s.equalsIgnoreCase(inputCities)).findAny().isPresent()) {
			conncted.setConnected("yes");
		} else {
			conncted.setConnected("no");
		}
		return conncted;
	}
}
