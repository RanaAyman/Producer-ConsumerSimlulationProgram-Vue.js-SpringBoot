package com.example.project;

import java.util.ArrayList;

import org.json.simple.JSONObject;

public class test {
	ArrayList<JSONObject> arr = new ArrayList<JSONObject>();
	int start = 0;
	
	public static void main(String[] args) {	
		Tools tool = new Tools();
		JSONObject[] shapes = new JSONObject[12];
		JSONObject[] arrows = new JSONObject[14];
		JSONObject obj1 = new JSONObject();
		JSONObject obj2 = new JSONObject();
		JSONObject obj3 = new JSONObject();
		JSONObject obj4 = new JSONObject();
		JSONObject obj5 = new JSONObject();
		JSONObject obj6 = new JSONObject();
		JSONObject obj7 = new JSONObject();
		JSONObject obj8 = new JSONObject();
		JSONObject obj9 = new JSONObject();
		JSONObject obj10 = new JSONObject();
		JSONObject obj11 = new JSONObject();
		JSONObject obj12 = new JSONObject();
		JSONObject obj13 = new JSONObject();
		
		obj1.put("id", "1st");
		obj1.put("shape", "rectangle");
		shapes[0] = obj1;
		
		obj2.put("id", "2nd");
		obj2.put("shape", "ellipse");
		shapes[1] = obj2;
		
		obj3.put("id", "3rd");
		obj3.put("shape", "rectangle");
		shapes[2] = obj3;
		
		obj4.put("id", "4th");
		obj4.put("shape", "ellipse");
		shapes[3] = obj4;
		
		obj5.put("id", "5th");
		obj5.put("shape", "ellipse");
		shapes[4] = obj5;
		
		obj6.put("id", "6th");
		obj6.put("shape", "rectangle");
		shapes[5] = obj6;
		
		
		obj7.put("id", "7th");
		obj7.put("shape", "ellipse");
		shapes[6] = obj7;
		
		obj8.put("id", "8th");
		obj8.put("shape", "rectangle");
		shapes[7] = obj8;
		
		obj9.put("id", "9th");
		obj9.put("shape", "ellipse");
		shapes[8] = obj9;
		
		obj10.put("id", "10th");
		obj10.put("shape", "ellipse");
		shapes[9] = obj10;
		
		obj11.put("id", "11th");
		obj11.put("shape", "rectangle");
		shapes[10] = obj11;
		
		obj12.put("id", "12th");
		obj12.put("shape", "ellipse");
		shapes[11] = obj12;
		
		
		JSONObject ob1 = new JSONObject();
		JSONObject ob2 = new JSONObject();
		JSONObject ob3 = new JSONObject();
		JSONObject ob4 = new JSONObject();
		JSONObject ob5 = new JSONObject();
		JSONObject ob6 = new JSONObject();
		JSONObject ob7 = new JSONObject();
		JSONObject ob8 = new JSONObject();
		JSONObject ob9 = new JSONObject();
		JSONObject ob10 = new JSONObject();
		JSONObject ob11 = new JSONObject();
		JSONObject ob12 = new JSONObject();
		JSONObject ob13 = new JSONObject();
		JSONObject ob14 = new JSONObject();
		JSONObject ob15 = new JSONObject();
		JSONObject ob16 = new JSONObject();
		
		ob1.put("source", "1st");
		ob1.put("destination", "2nd");
		arrows[0] = ob1;
		
		ob2.put("source", "2nd");
		ob2.put("destination", "3rd");
		arrows[1] = ob2;
		
		ob3.put("source", "3rd");
		ob3.put("destination", "4th");
		arrows[2] = ob3;
		
		ob4.put("source", "4th");
		ob4.put("destination", "6th");
		arrows[3] = ob4;
		
		ob5.put("source", "3rd");
		ob5.put("destination", "5th");
		arrows[4] = ob5;
		
		ob6.put("source", "5th");
		ob6.put("destination", "6th");
		arrows[5] = ob6;
		
		ob7.put("source", "6th");
		ob7.put("destination", "7th");
		arrows[6] = ob7;
		
		ob8.put("source", "7th");
		ob8.put("destination", "8th");
		arrows[7] = ob8;
		
		ob9.put("source", "1st");
		ob9.put("destination", "12th");
		arrows[8] = ob9;
		
		ob10.put("source", "12th");
		ob10.put("destination", "6th");
		arrows[9] = ob10;
		
		ob11.put("source", "8th");
		ob11.put("destination", "9th");
		arrows[10] = ob11;
		
		ob12.put("source", "9th");
		ob12.put("destination", "11th");
		arrows[11] = ob12;
		
		ob13.put("source", "8th");
		ob13.put("destination", "10th");
		arrows[12] = ob13;
		
		ob14.put("source", "10th");
		ob14.put("destination", "11th");
		arrows[13] = ob14;
		
		tool.fillArray(shapes, arrows, false);
		
		
		Singleton s = Singleton.getInstance();
		s.loadLast(tool.getLast());
		s.loadPN(5);
		
		
		tool.setProducts(5);
		
		System.out.println("");
		
		
//		while(true) {
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			ArrayList<JSONObject> arr = ;
//			for(int i = 0; i < arr.size(); i++) {
//				JSONObject o = new JSONObject();
//				System.out.println(o.get("id"));
//				System.out.println(o.get("color") + "\n");
//			}
//		}
	}
	

}
