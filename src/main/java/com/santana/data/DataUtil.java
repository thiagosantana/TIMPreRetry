package com.santana.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataUtil {
	
	private LocalDate currentDate;
	private DateTimeFormatter formatter;

	public DataUtil(LocalDate currentDate) {
		this.currentDate = currentDate;
		formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");
	}

	public String subDays(int days) {
		return currentDate.minusDays(days).format(formatter);
	}

}
