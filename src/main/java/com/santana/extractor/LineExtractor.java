package com.santana.extractor;

import org.springframework.stereotype.Component;

@Component
public class LineExtractor {

	public String extractPhoneNumber(String dsParams) {
		String[] parts = dsParams.split("linha=");
		String phoneNumber = parts[1].split(",")[0];
		return phoneNumber;
	}

}
