package com.practice.ecom.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import com.practice.ecom.modal.Data;
import com.practice.ecom.utils.EcomConstants;

public class DBTableDataManipulate {

	private static final Map<String, String> insertStatementMap = new HashMap<String, String>() {
		{
			put(EcomConstants.COMPANY_TABLE_NAME,
					"INSERT INTO Company(name,address,warehouse,territory,companygroup) VALUES(?,?,?,?,?)");
			put(EcomConstants.COMPANYGROUP_TABLE_NAME,
					"INSERT INTO CompanyGroup(id) VALUES(?)");
			put(EcomConstants.ITEM_TABLE_NAME, "INSERT INTO SalesOrderItem(id,base_amount,base_rate,description,doctype,item_name,warehouse) VALUES(?,?,?,?,?,?,?)");
			put(EcomConstants.SALESORDER_TABLE_NAME,
					"INSERT INTO SalesOrderData(id,conversion_rate,currency,delivery_date,grand_total,price_list_currency," +
					"transaction_date,customer_group,companyName,customerName,salesOrderItem) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
			put(EcomConstants.CUSTOMER_TABLE_NAME,
					"INSERT INTO Customer(name,address) VALUES(?,?)");
		}
	};

	public static void persistData(Data data, Connection conn) {
		insertValuesIntoCompanyGroupTable(data, conn);
		insertValuesIntoCompanyTable(data, conn);
		insertValuesIntoCustomerTable(data, conn);
		insertValuesIntoSalesOrderTable(data, conn);
		insertValuesIntoSalesOrderItemTable(data, conn);
	}

	public static void insertValuesIntoCompanyTable(Data data, Connection conn) {
		String sql = insertStatementMap.get(EcomConstants.COMPANY_TABLE_NAME);
		String query = "SELECT COUNT(*) FROM " + EcomConstants.COMPANY_TABLE_NAME
				+ " WHERE name = '" + data.getCompany() + "'";
		ResultSet rs = null;
		if (sql != null && conn != null) {
			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

				rs = conn.createStatement().executeQuery(query);
				rs.next();
			      
				if (rs.getInt(1) == 0) {
					pstmt.setString(1, data.getCompany());
					pstmt.setString(2, data.getCompany());
					pstmt.setString(3, data.getItems().get(0).getWarehouse());
					pstmt.setString(4, data.getTerritory());
					pstmt.setString(5, data.getCustomerGroup());
					pstmt.executeUpdate();
					System.out
							.println("Insertion of Data Successfull for table "
									+ EcomConstants.COMPANY_TABLE_NAME);
				}
			} catch (SQLException e) {
				System.out
						.println("ERROR : Insertion of Data Failed for table "
								+ EcomConstants.COMPANY_TABLE_NAME + " ");
				e.printStackTrace();
			}
		}
	}

	public static void insertValuesIntoCompanyGroupTable(Data data,
			Connection conn) {
		String sql = insertStatementMap
				.get(EcomConstants.COMPANYGROUP_TABLE_NAME);
		String query = "SELECT COUNT(*) FROM " + EcomConstants.COMPANYGROUP_TABLE_NAME
				+ " where id = '" + data.getCustomerGroup() + "'";
		ResultSet rs = null;
		if (sql != null && conn != null) {
			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
				rs = conn.createStatement().executeQuery(query);
				rs.next();
			      
				if (rs.getInt(1) == 0) {
					pstmt.setString(1, data.getCustomerGroup());
					pstmt.executeUpdate();
					System.out
							.println("Insertion of Data Successfull for table "
									+ EcomConstants.COMPANYGROUP_TABLE_NAME);
				}
			} catch (SQLException e) {
				System.out
						.println("ERROR : Insertion of Data Failed for table "
								+ EcomConstants.COMPANYGROUP_TABLE_NAME + " "
								+ e);
			}
		}

	}

	public static void insertValuesIntoCustomerTable(Data data, Connection conn) {
		String sql = insertStatementMap.get(EcomConstants.CUSTOMER_TABLE_NAME);
		String query = "SELECT COUNT(*) FROM " + EcomConstants.CUSTOMER_TABLE_NAME
				+ " WHERE name = '" + data.getCustomer() + "'";
		ResultSet rs = null;
		if (sql != null && conn != null) {
			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

				rs = conn.createStatement().executeQuery(query);
				rs.next();
			      
				if (rs.getInt(1) == 0) {
					pstmt.setString(1, data.getCustomer());
					pstmt.setString(2, data.getCustAddress());
					pstmt.executeUpdate();
					System.out.println("Insertion of Data Successfull for table "
									+ EcomConstants.CUSTOMER_TABLE_NAME);
				}
			} catch (SQLException e) {
				System.out
						.println("ERROR : Insertion of Data Failed for table "
								+ EcomConstants.CUSTOMER_TABLE_NAME + " ");
				e.printStackTrace();
			}
		}
	}

	public static void insertValuesIntoSalesOrderTable(Data data, Connection conn) {
		String sql = insertStatementMap.get(EcomConstants.SALESORDER_TABLE_NAME);
		String query = "SELECT COUNT(*) FROM " + EcomConstants.SALESORDER_TABLE_NAME
				+ " WHERE id = '" + data.getSalesorderID() + "'";
		ResultSet rs = null;
		if (sql != null && conn != null) {
			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

				rs = conn.createStatement().executeQuery(query);
				rs.next();
			      
				if (rs.getInt(1) == 0) {
					pstmt.setInt(1, data.getSalesorderID());
					pstmt.setDouble(2, data.getConversionRate());
					pstmt.setString(3, data.getCurrency());
					pstmt.setString(4, data.getDeliveryDate());
					pstmt.setDouble(5, data.getGrandTotal());
					pstmt.setString(6, data.getPriceListCurrency());
					pstmt.setString(7, data.getTransactionDate());
					pstmt.setString(8, data.getCustomerGroup());
					pstmt.setString(9, data.getCompany());
					pstmt.setString(10, data.getCustomer());
					pstmt.setString(11, data.getItems().get(0).getItemCode());
					pstmt.executeUpdate();
					System.out
							.println("Insertion of Data Successfull for table "
									+ EcomConstants.SALESORDER_TABLE_NAME);
				}
			} catch (SQLException e) {
				System.out
						.println("ERROR : Insertion of Data Failed for table "
								+ EcomConstants.SALESORDER_TABLE_NAME + " ");
				e.printStackTrace();
			}
		}
	}
	
	public static void insertValuesIntoSalesOrderItemTable(Data data, Connection conn) {
		String sql = insertStatementMap.get(EcomConstants.ITEM_TABLE_NAME);
		String query = "SELECT COUNT(*) FROM " + EcomConstants.ITEM_TABLE_NAME
				+ " WHERE id = '" + data.getItems().get(0).getItemCode() + "'";
		ResultSet rs = null;
		if (sql != null && conn != null) {
			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

				rs = conn.createStatement().executeQuery(query);
				rs.next();
			      
				if (rs.getInt(1) == 0) {
					pstmt.setString(1, data.getItems().get(0).getItemCode());
					pstmt.setDouble(2, data.getItems().get(0).getBaseAmount());
					pstmt.setDouble(3, data.getItems().get(0).getBaseRate());
					pstmt.setString(4, data.getItems().get(0).getDescription());
					pstmt.setString(5, data.getItems().get(0).getDoctype());
					pstmt.setString(6, data.getItems().get(0).getItemName());
					pstmt.setString(7, data.getItems().get(0).getWarehouse());
					pstmt.executeUpdate();
					System.out
							.println("Insertion of Data Successfull for table "
									+ EcomConstants.ITEM_TABLE_NAME);
				}
			} catch (SQLException e) {
				System.out
						.println("ERROR : Insertion of Data Failed for table "
								+ EcomConstants.ITEM_TABLE_NAME + " ");
				e.printStackTrace();
			}
		}
	}

}
