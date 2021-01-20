package com.example.project;

import java.util.Observable;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Queues extends Observable{
	private BlockingQueue<String> q = new LinkedBlockingQueue<String>();
	private String id;
	public Queues(String id) {
		this.id = id;
	}
	public void add(String product) {
		q.add(product);
		if(q.size() == 1) {
			setChanged();
			notifyObservers();
		}
	}
	public String remove() {
		if(q.isEmpty()) {
			return null;
		}else {
			String temp;
			try {
				temp = q.remove();
			}catch(Exception e){
				return null;
			}return  temp;
		}
	}
	
	public boolean isEmpty() {
		return q.isEmpty();
	}
	
	public String getId() {
		return this.id;
	}
	
	public int size() {
		return q.size();
	}
}
