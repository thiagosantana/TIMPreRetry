package com.santana.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class Worker {
	private static final Logger log = LoggerFactory.getLogger(Worker.class);
	
	@Scheduled(fixedRate=5000)
	public void currentTime() {
		log.info("Fired!");
	}
}
