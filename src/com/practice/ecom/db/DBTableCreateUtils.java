package com.practice.ecom.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTableCreateUtils {

	public static void createTables(Connection conn) {
		createTableCompanyGroup(conn);
		createTableCompany(conn);
		createTableCustomer(conn);
		createTableSalesOrderData(conn);
		createTableSalesOrderItem(conn);
	}

	public static void createTableCompanyGroup(Connection conn) {

		String sql = "CREATE TABLE IF NOT EXISTS CompanyGroup (\n"
				+ "	id TEXT PRIMARY KEY\n" + ");";

		try (Statement stmt = conn.createStatement()) {
			stmt.execute(sql);
System.out.println("CHECK "+stmt.execute(sql));
			System.out.println("Table CompanyGroup Created Successfully!!!  "
					+ stmt.execute(sql));

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void createTableCompany(Connection conn) {

		String sql = "CREATE TABLE IF NOT EXISTS Company (\n"
				+ "	name TEXT PRIMARY KEY,\n" + " address TEXT NOT NULL,\n"
				+ " warehouse TEXT NOT NULL,\n" + " territory TEXT NOT NULL,\n"
				+ " companygroup TEXT NOT NULL,\n"
				+ " FOREIGN KEY (companygroup) REFERENCES CompanyGroup(id)\n"
				+ ");";

		try (Statement stmt = conn.createStatement()) {
			stmt.execute(sql);
			System.out.println("CHECK Com "+stmt.execute(sql));
			System.out.println("Table Company Created Successfully!!!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void createTableCustomer(Connection conn) {

		String sql = "CREATE TABLE IF NOT EXISTS Customer (\n"
				+ " name TEXT PRIMARY KEY,\n" + " address TEXT NOT NULL\n"
				+ ");";

		try (Statement stmt = conn.createStatement()) {
			stmt.execute(sql);
			System.out.println("Table Customer Created Successfully!!!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void createTableSalesOrderData(Connection conn) {

		String sql = "CREATE TABLE IF NOT EXISTS SalesOrderData (\n"
				+ "	id INTEGER PRIMARY KEY,\n"
				+ "	conversion_rate TEXT NOT NULL,\n"
				+ "	currency TEXT NOT NULL,\n"
				+ "	delivery_date TEXT NOT NULL,\n"
				+ "	grand_total INTEGER NOT NULL,\n"
				+ "	price_list_currency TEXT NOT NULL,\n"
				+ "	transaction_date TEXT NOT NULL,\n"
				+ "	customer_group TEXT NOT NULL,\n"
				+ " companyName TEXT NOT NULL,\n"
				+ " customerName TEXT NOT NULL,\n"
				+ " salesOrderItem INTEGER NOT NULL,\n"
				+ " FOREIGN KEY (companyName) REFERENCES Company(name),\n"
				+ " FOREIGN KEY (customerName) REFERENCES Customer(name),\n"
				+ " FOREIGN KEY (salesOrderItem) REFERENCES SalesOrderItem(id)\n"
				+ ");";

		try (Statement stmt = conn.createStatement()) {
			stmt.execute(sql);
			System.out.println("Table SalesOrderData Created Successfully!!!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void createTableSalesOrderItem(Connection conn) {

		String sql = "CREATE TABLE IF NOT EXISTS SalesOrderItem (\n"
				+ "	id TEXT PRIMARY KEY,\n" + " base_amount TEXT NOT NULL,\n"
				+ " base_rate INTEGER NOT NULL,\n"
				+ " description TEXT NOT NULL,\n" + " doctype TEXT NOT NULL,\n"
				+ " item_name TEXT NOT NULL,\n" + " warehouse TEXT NOT NULL\n"
				+ ");";

		try (Statement stmt = conn.createStatement()) {
			stmt.execute(sql);
			System.out.println("Table SalesOrderItem Created Successfully!!!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

}
