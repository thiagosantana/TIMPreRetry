package com.santana.repository.contract;

import java.util.List;

import com.santana.vo.FailedActivationVO;

public interface WoozaRepository {
	public List<FailedActivationVO> selectFailedActivationsFrom(String day) throws Exception;
}
