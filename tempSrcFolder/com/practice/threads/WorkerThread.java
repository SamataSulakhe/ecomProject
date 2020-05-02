package com.practice.threads;

public class WorkerThread implements Runnable {

	@Override
	public void run() {
		try {
			for(int i = 0;i<10;i++){
				Thread.sleep(1000);
				System.out.println("SAM "+i);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
