package com.santana.data;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DataUtilTest {
	static DataUtil dataUtil;
	
	@Test
	public void sub2Days() {
		LocalDate myBirth = LocalDate.of(1984, Month.JANUARY, 28);
		dataUtil = new DataUtil(myBirth);
		assertEquals("1984-01-26", dataUtil.subDays(2));
	}
	
	@Test
	public void sub3Days() {
		LocalDate myBirth = LocalDate.of(1984, Month.JANUARY, 28);
		dataUtil = new DataUtil(myBirth);
		assertEquals("1984-01-25", dataUtil.subDays(3));
	}
	
	@Test
	public void sub3DaysWhenMonthChanges() {
		LocalDate myBirth = LocalDate.of(1984, Month.JANUARY, 1);
		dataUtil = new DataUtil(myBirth);
		assertEquals("1983-12-30", dataUtil.subDays(3));
	}
}
