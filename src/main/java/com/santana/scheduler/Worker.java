package com.santana.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.santana.repository.WoozaRepository;


@Component
public class Worker {
	private static final Logger log = LoggerFactory.getLogger(Worker.class);
	private WoozaRepository woozaRepo;
	
	public Worker(WoozaRepository woozaRepo) {
		this.woozaRepo = woozaRepo;
	}
	
	@Scheduled(fixedRate=5000)
	public void currentTime() {
		log.info("Fired!");
		log.info("This is a wooza repo " + this.woozaRepo);
	}
}
