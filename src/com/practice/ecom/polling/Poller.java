package com.practice.ecom.polling;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.concurrent.BlockingQueue;

public class Poller implements Runnable {
	
	private BlockingQueue<File> fileQueue;
	private static final String filePath = "D:\\CompanyData";
	private int prevFileCount = new File(filePath).list().length;
	
	public Poller(BlockingQueue<File> fileQueue) {
		this.fileQueue = fileQueue;
	}

	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int currentFileCount = new File(filePath).list().length;
			System.out.println("prevFileCount - " + prevFileCount);
			System.out.println("currentFileCount - " + currentFileCount);
			if (currentFileCount > prevFileCount) {
				prevFileCount = currentFileCount;
				File latestFile = null;
				try {
					latestFile = getMostRecentFile();
					fileQueue.add(latestFile);
					System.out.println("Recent file added to the Queue - "
							+ latestFile.getName());
				} catch (IOException e) {
					System.out.println("Error while reading recent file - "
							+ e);
				}

			}
		}
	}

	private File getMostRecentFile() throws IOException {
		File directory = new File(filePath);
		File[] files = directory.listFiles();
		File chosenFile = null;
		BasicFileAttributes fileAttributes = Files.readAttributes(
				Paths.get(directory.getPath()), BasicFileAttributes.class);
		;
		FileTime latestFileCreateTime = fileAttributes.creationTime();
		if (files != null) {
			for (File file : files) {
				fileAttributes = Files.readAttributes(
						Paths.get(file.getPath()), BasicFileAttributes.class);
				System.out.println();
				if (fileAttributes.creationTime().compareTo(
						latestFileCreateTime) > 0) {
					chosenFile = file;
					latestFileCreateTime = fileAttributes.creationTime();
				}
			}
		}

		return chosenFile;
	}

}
