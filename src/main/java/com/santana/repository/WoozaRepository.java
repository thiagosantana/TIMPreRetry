package com.santana.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.santana.factory.ConnectionFactory;

@Component
public class WoozaRepository {
	private ConnectionFactory factory;
	private static final Logger log = LoggerFactory.getLogger(WoozaRepository.class);
	
	public WoozaRepository(ConnectionFactory factory) {
		this.factory = factory;
	}
	
	public void selectFailedActivationsFrom() {
		
	}
}
