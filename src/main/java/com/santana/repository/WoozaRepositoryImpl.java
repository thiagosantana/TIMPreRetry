package com.santana.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.santana.factory.ConnectionFactory;
import com.santana.repository.contract.WoozaRepository;
import com.santana.vo.FailedActivationVO;

@Component
public class WoozaRepositoryImpl implements WoozaRepository{
	private ConnectionFactory factory;
	private static final Logger log = LoggerFactory.getLogger(WoozaRepositoryImpl.class);
	
	public WoozaRepositoryImpl(ConnectionFactory factory) {
		this.factory = factory;
	}
	
	public List<FailedActivationVO> selectFailedActivationsFrom(String day) throws Exception {
		String query = "select ds_log,ds_params from tb_log_execute_service where fk_id_service = 89 and dt_fim > TO_DATE('"+day+" 16:30:00','YYYY-MM-DD hh24:mi:ss') order by dt_fim desc";
		log.info(query);
		ArrayList<FailedActivationVO> failedActivations = new ArrayList<FailedActivationVO>();
		Connection conn = factory.getOracleConnection();
		Statement stmt = null;
		ResultSet result = null;
		try {
			stmt = conn.createStatement();
			result = stmt.executeQuery(query);
			while(result.next()) {
				FailedActivationVO vo = new FailedActivationVO();
				vo.setDS_LOG(result.getString(1));
				vo.setDS_PARAMS(result.getString(2));
				failedActivations.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt.close();
			conn.close();
			result.close();
		}
		return failedActivations;
	}
}
