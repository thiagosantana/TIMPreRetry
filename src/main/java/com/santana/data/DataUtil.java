package com.santana.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

@Component
public class DataUtil {
	
	public LocalDate getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(LocalDate currentDate) {
		this.currentDate = currentDate;
	}

	private LocalDate currentDate;
	private DateTimeFormatter formatter;

	public DataUtil() {
		formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
	}

	public String subtractDays(int days) {
		return currentDate.minusDays(days).format(formatter);
	}

}
