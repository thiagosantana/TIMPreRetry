package com.santana.scheduler;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.santana.data.DataUtil;
import com.santana.repository.WoozaRepositoryImpl;
import com.santana.repository.contract.WoozaRepository;
import com.santana.vo.FailedActivationVO;


@Component
public class Worker {
	private static final Logger log = LoggerFactory.getLogger(Worker.class);
	private WoozaRepository woozaRepo;
	private DataUtil dataUTil;
	private final int DAYS_BEHIND = 0;
	private final int INTERVAL_IN_MINUTES = 30;
	
	public Worker(WoozaRepository woozaRepo, DataUtil dataUtil) {
		this.woozaRepo = woozaRepo;
		this.dataUTil = dataUtil;
	}
	
	@Scheduled(fixedRate=INTERVAL_IN_MINUTES*60*1000, initialDelay = 5000)
	public void perform() throws Exception {
		log.info("Start.");
		dataUTil.setCurrentDate(LocalDate.now());
		List<FailedActivationVO> failedCalls = woozaRepo.selectFailedActivationsFrom(dataUTil.subtractDays(DAYS_BEHIND));
		log.info("Errors returned");
	}
}
