package com.example.project;

import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class Controller {
	Tools tool = new Tools();
	JSONObject[] shapes;
	JSONObject[] arrows;
	Singleton s = Singleton.getInstance();
	int pn = 99;
	@GetMapping("/start")
	public void start(String[] shapesID, String[] shapesSh, String[] arrowsSrc, String[] arrowsDst, String productsNum) {
		System.out.println("Started---------------");
		JSONObject[] shapes = new JSONObject[shapesID.length]; 
		JSONObject[] arrows = new JSONObject[arrowsSrc.length]; 
		for(int i = 0; i < shapes.length; i++) {
			JSONObject obj = new JSONObject();
			obj.put("id", shapesID[i]);
			obj.put("shape", shapesSh[i]);
			shapes[i] = obj;
		}
		for(int i = 0; i < arrows.length; i++) {
			JSONObject obj = new JSONObject();
			obj.put("source", arrowsSrc[i]);
			obj.put("destination", arrowsDst[i]);
			arrows[i] = obj;
		}
		this.shapes = shapes;
		this.arrows = arrows;
		
		tool.fillArray(this.shapes, this.arrows, false);
		
		s.loadLast(tool.getLast());
		s.loadPN(Integer.parseInt(productsNum));
		this.pn = Integer.parseInt(productsNum);
		tool.setProducts(Integer.parseInt(productsNum));
	}
	
	@GetMapping("/repeat")
	public void repeat() {
		tool.fillArray(shapes, arrows, true);
		
		s.loadLast(tool.getLast());
		s.loadPN(pn);
		
		
		tool.repeatSimulation();
	}
	
	@GetMapping("/update")
	public ArrayList<JSONObject> update() {
		return s.getUpdate();
	}
	
//	public void show() {
//		ArrayList<JSONObject> a = new ArrayList<JSONObject>(s.arr.subList(start, s.arr.size()));
//		start = s.arr.size();
//		for(int i = 0; i < a.size(); i++) {
//			JSONObject obj = a.get(i);
//			System.out.println("id: " + obj.get("id") + "\ncolor: " + obj.get("color") + "\n");
//		}
//	}
}
