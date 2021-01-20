package com.example.project;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.BlockingQueue;

import org.json.simple.JSONObject;

public class Machines  extends Thread implements Observer{
    String color;
    Queues z;
    Queues n;
    long time;
    String id;
    Boolean test = false;
    Singleton t = Singleton.getInstance();
    public Machines(String id, Queues m, Queues w, long time){
        this.id = id;
        z = m;
        n = w;
        this.time = time;
    }
    public Queues getN() {
    	return n;
    }
    @Override
    public void run() {
    	while(!t.done()) {
    		if(!z.isEmpty()) {
    			try {
    				String temp = z.remove();
    				if(temp != null) {
    					input(temp);
    				}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    	}
    }
    public void update(Observable obj, Object arg) {
    	try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(!test) {
    		test = true;
    		start();
    	}else {
    	}
    }
    synchronized public void input(String x) throws InterruptedException {
        color = x;
        System.out.println(id + " Machine has started procesing a product!");
        JSONObject obj = new JSONObject();
        obj.put("id", this.id);
        obj.put("color", this.color);
        t.add(obj);
        System.out.println(id + " Machine is now colored: " + color);
        Thread.sleep(time);
        System.out.println(id + " Machine has finished procesing a product!\n\n");
        JSONObject obj2 = new JSONObject();
        obj2.put("id", this.id);
        obj2.put("color", "#f0f0f0");
        t.add(obj2);
        n.add(x);
    }
}

