package com.santana.filter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.santana.vo.FailedActivationVO;

public class SVAFilter {

	public List<FailedActivationVO> filterByTimeoutError(List<FailedActivationVO> failedActivations) {
		Stream<FailedActivationVO> listWithOnlyTimeoutError = failedActivations.stream().filter(vo -> vo.getDS_LOG().contains("timed out"));
		return listWithOnlyTimeoutError.collect(Collectors.toList());
	}

}
