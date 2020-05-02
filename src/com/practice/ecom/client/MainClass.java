package com.practice.ecom.client;

import com.practice.ecom.polling.Poller;

public class MainClass {

	public static void main(String args[]){
		Thread pollerThread = new Thread(new Poller());
		pollerThread.start();
	}
}
