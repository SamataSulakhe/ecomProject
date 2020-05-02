package com.practice.threads;

public class MainClass {
	public static void main(String[] args) {
		WorkerThread workerThread = new WorkerThread();
		Thread t1 = new Thread(workerThread);
		t1.start();
		
		for(int i =0;i<10;i++){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Main SAM"+i);
		}
		
	}
}
