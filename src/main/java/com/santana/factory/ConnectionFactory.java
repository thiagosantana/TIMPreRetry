package com.santana.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component
public class ConnectionFactory {
	public Connection getOracleConnection() {
		try {
			return DriverManager.getConnection("jdbc:oracle:thin:@cd.czmbbunm7gyb.sa-east-1.rds.amazonaws.com:1521:ORCL","CD","CD");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public Connection getMysqlConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
