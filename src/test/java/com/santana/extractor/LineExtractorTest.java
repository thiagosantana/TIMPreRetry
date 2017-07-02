package com.santana.extractor;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;

public class LineExtractorTest {
	static LineExtractor extractor;
	@BeforeClass
	public static void setUp() {
		extractor = new LineExtractor();
	}
	@Test
	public void extraction() {
		assertEquals("42999581806",extractor.extractPhoneNumber("Service: activation. Parameters: {idRespondedor=46, linha=42999581806, plano=SVAP007, chaveChat=73993510, WKF_ID=null}"));
	}
}
