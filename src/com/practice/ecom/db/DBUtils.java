package com.practice.ecom.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.practice.ecom.utils.EcomConstants;

public class DBUtils {

	private static Connection conn = null;

	public static Connection connect() {
		try {
			conn = DriverManager.getConnection(EcomConstants.DB_URL);
			System.out.println("Connection to SQLite has been established.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return conn;
	}
}
