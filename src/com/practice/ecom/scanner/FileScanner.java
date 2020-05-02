package com.practice.ecom.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.concurrent.BlockingQueue;

import com.google.gson.Gson;
import com.practice.ecom.modal.Example;

public class FileScanner implements Runnable {

	private BlockingQueue<File> fileQueue;
	private FileReader fileReader;
	private File readFile;

	
	public FileScanner(BlockingQueue<File> fileQueue) {
		this.fileQueue = fileQueue;
	}

	@Override
	public void run() {
		Gson gson = new Gson();
		while(true) {
			try {
				  Thread.sleep(2000);
				  readFile = fileQueue.poll();
				  if(readFile != null) {
					  fileReader = new FileReader(readFile); 
					  Example jsonData = gson.fromJson(fileReader, Example.class);
					  System.out.println("GET JSON COMPANY - " + " " +
					  jsonData.getData().getCompany());
					  System.out.println("GET JSON CUSTOMER - " + " " +
					  jsonData.getData().getCustomerName());
				  }

			} catch (InterruptedException | FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		 
		 
	

	}

}
