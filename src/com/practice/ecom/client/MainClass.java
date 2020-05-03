package com.practice.ecom.client;

import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.practice.ecom.polling.Poller;
import com.practice.ecom.scanner.FileScanner;

public class MainClass {

	public static void main(String args[]) {
		BlockingQueue<File> fileQueue = new ArrayBlockingQueue<>(20, true);
		Thread pollerThread = new Thread(new Poller(fileQueue));
		Thread scannerThread = new Thread(new FileScanner(fileQueue));
		pollerThread.start();
		scannerThread.start();
	}
}
