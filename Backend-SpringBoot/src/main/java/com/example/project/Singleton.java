package com.example.project;

import java.util.ArrayList;

import org.json.simple.JSONObject;

public class Singleton {
	ArrayList<JSONObject> arr = new ArrayList<JSONObject>();
	int start = 0, pn = 0;
	private Queues last = new Queues("last");
	private static Singleton instance = new Singleton();
	//Singleton DP
	private Singleton() {}
	public static Singleton getInstance(){
	      return instance;
	}
	public void add(JSONObject obj) {
		arr.add(obj);
	}
	public ArrayList<JSONObject> getUpdate(){
		ArrayList<JSONObject> a = new ArrayList<JSONObject>(arr.subList(start, arr.size()));
		start = arr.size();
		return a;
	}public void loadLast(Queues last) {
		this.last = last;
	}
	public void loadPN(int pn) {
		this.pn = pn;
	}
	public boolean done() {
		if(last.size() == pn) {
			return true;
		}return false;
	}
}
