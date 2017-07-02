package com.santana.filter;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.santana.repository.WoozaRepositoryImpl;
import com.santana.repository.contract.WoozaRepository;
import com.santana.vo.FailedActivationVO;

import static org.junit.Assert.assertEquals;

public class SVAFilterTest {
	private static SVAFilter filter;
	private static WoozaRepository repositoryMock;
	
	@BeforeClass
	public static void setUP() throws Exception {
		filter = new SVAFilter();
		repositoryMock = mock(WoozaRepositoryImpl.class);
		ArrayList<FailedActivationVO> f = new ArrayList<FailedActivationVO>();
		FailedActivationVO vo = new FailedActivationVO();
		vo.setDS_LOG("I/O error: Read timed out; nested exception is java.net.SocketTimeoutException: Read timed out");
		vo.setDS_PARAMS("Service: activation. Parameters: {idRespondedor=46, linha=41995973550, plano=SVAP007, chaveChat=74127537, WKF_ID=null}");
		f.add(vo);
		FailedActivationVO vo1 = new FailedActivationVO();
		vo1.setDS_LOG("-304: Erro Desconhecido");
		vo1.setDS_PARAMS("dummy data");
		f.add(vo1);
		when(repositoryMock.selectFailedActivationsFrom(any())).thenReturn(f);
	}
	
	@Test
	public void filterByTimeOutError() throws Exception{
		List<FailedActivationVO> filtered = filter.filterByTimeoutError(repositoryMock.selectFailedActivationsFrom(""));
		assertEquals(1, filtered.size());
	}
}
