package com.practice.ecom.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;
import com.google.gson.Gson;
import com.practice.ecom.db.DBTableCreateUtils;
import com.practice.ecom.db.DBTableDataManipulate;
import com.practice.ecom.db.DBUtils;
import com.practice.ecom.modal.Company;
import com.practice.ecom.modal.JSONData;

public class FileScanner implements Runnable {

	private BlockingQueue<File> fileQueue;
	private File readFile;
	private Gson gson;
	private Connection conn = null;

	
	public FileScanner(BlockingQueue<File> fileQueue) {
		this.fileQueue = fileQueue;
		this.gson = new Gson();
	}

	@Override
	public void run() {
		
		while(true) {
			try {
				  Thread.sleep(2000);
				  conn = DBUtils.connect();
				  readFile = fileQueue.poll();
				  if(readFile != null) {
					  if(conn != null){
						DBTableCreateUtils.createTables(conn);
					    JSONData jsonData = gson.fromJson(new FileReader(readFile), JSONData.class);
					    if(jsonData.getData() != null)
					    	DBTableDataManipulate.persistData(jsonData.getData(),conn);
					  }
				  }

			} catch (InterruptedException | FileNotFoundException e) {
				System.out.println("Error in File Scanning"+ e);
			}finally{
				if(conn != null){
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
	}
}

