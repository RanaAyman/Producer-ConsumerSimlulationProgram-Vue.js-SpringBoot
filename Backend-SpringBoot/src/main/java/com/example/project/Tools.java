package com.example.project;
import java.util.*;


import org.json.simple.JSONObject;
public class Tools {
	private ArrayList<Queues> qs = new ArrayList<Queues>();
	private ArrayList<Machines> ms = new ArrayList<Machines>();
	private Long[] msTimes = new Long[] {1000L, 2000L, 3000L, 4000L};
	private String[] AllPColors = new String[] {"#860fc2","#791dfe","#f59e3d","#1938b7","#8735c5","#0fbffb","#996cbf","#32907a","#607445","#953cab","#315fc4","#52e9c4","#7b46dd","#3cb61d","#960fde","#b77d89","#d8acd5","#db754d","#b97beb","#fc7b55","#fb1a71","#893dec","#867e5a","#f7d56c","#664aa2","#7ba01b","#ff40b1","#dbbdfd","#8e602f","#68ca7b","#3be44b","#b3d683","#df9a33","#496f33","#a69553","#cd26ad","#ab0acd","#9c425c","#ebddda","#51e5cd","#e2c6d3","#7d9930","#c74087","#60d408","#418fa7","#20dcb2","#3844d4","#1dae62","#991786","#606139","#0749e0","#b7a19f","#03d837","#56249b","#00785d","#d32e76","#767bd3","#f99d18","#7c61bb","#62c43c","#d041d8","#a9a224","#6598d5","#a8212d","#aa3295","#be6bb5","#9d5a31","#3a7a77","#a7fae9","#c534a8","#a415d1","#c1e208","#2b820d","#046dc2","#aaa94b","#451f7b","#d48e1d","#e24991","#73a5e3","#7fddc8","#6dc284","#ddc2d0","#c13619","#870c86","#ba07a4","#4b4efb","#ffc9bc","#65f06b","#eb4ed9","#9a5ceb","#68f820","#ca22c1","#8400c4","#336fa7","#1972d3","#561adc","#96b6e0","#b1e88b","#97ee4d","#a1a39c","#0ac9b8","#4b1ba7","#30a5ba","#ffb4a6","#8ce641","#e98391","#4496e6","#4398af","#4afa6a","#0fd62a","#4471ac","#c4e2a3","#d8fed3","#b2184e","#4608df","#002348","#73eb01","#2ae695","#52fb85","#f0f436","#d3d3c4","#94cbfb","#094566","#2fee45","#158de2","#a6273b","#a18bc6","#74c763","#7a85bb","#33d2cf","#5bb906","#c87ae1","#250c0e","#83abc7","#169b1e","#4feeb1","#01c349","#8a6a8b","#7a5a66","#726225","#0cd934","#e646cc","#1977e4","#a4541d","#6111d3","#38fb71","#fb94c2","#d466cd","#5bbb1f","#426dab","#0c093d","#8c1e69","#56a765","#2b1d33","#3eb21b","#62c8e4","#e62a84","#05a030","#e083e7","#6712c5","#37a3f8","#2b5c89","#66a3f1","#7065af","#1c2a3e","#3ca01a","#043d4d","#43baaf","#94328f","#360507","#703ba9","#375a74","#f9723c","#33eae3","#ba52e5","#b71b53","#104a8d","#f8b833","#996215","#aaceea","#a7c670","#146b22","#a7e3f7","#da9d50","#b64e99","#7a9483","#5b231d","#5687c5","#b76a0f","#c673da","#781671","#987ea8","#bfaf09","#a6e27b","#e41610","#69b01d","#3a4b12","#1b1e63","#db77f8","#e23732","#ea540e","#cd38f5","#954fc3","#6d2d6b","#52ee05","#434ff9","#f8aec5","#463e84","#200ab0","#90d9ff","#54194a","#d8e0d8","#a60326","#d3844a","#05097f","#5d7af8","#4ba9c0","#4c9752","#204628","#9581b2","#18e23a","#d643f8","#bd38fc","#774cde","#9abce7","#d5f924","#7303e4","#c8c4b4","#a36640","#8eb8d0","#69c5ee","#a74888","#ef7dbd","#b8a5e4","#ca4cc9","#3c1fe1","#4ffc31","#21430a","#505e4f","#9804c4","#efc73f","#e32f2c","#91c7e7","#def197","#7bf044","#f1d5de","#1feda0","#201437","#14eb51","#40da99","#c97dfc","#819e29","#a00bf6","#a8438a","#123f52","#084383","#932804","#8430a0","#d3b796","#2caa5f","#eefc8d","#585601","#ba4a5b","#e4cba3","#7620a9","#16d64a","#533669","#06cb56","#406dd9","#fd275b","#56f9b5","#632cd9","#cfe8af","#19ade0","#486987","#96a4be","#a36453","#faaf73","#e9f754","#8303ca","#2729bb","#ab8448","#77d4f8","#526fa7","#8ae6ce","#2ab887","#6daf2c","#85baf7","#70fa51","#f66a39","#70de33","#a03448","#5b6fb2","#c1d92e","#2c6e1c","#7ab3a3","#533e63","#60de69","#767ed2","#fa5e2e","#1c6298","#fa4e66","#2f557c","#bb71b0","#f0f1b4","#338bff","#207950","#a90e02","#eae068","#9e6c56","#0baaf4","#0406ef","#b25873","#e2339d","#92b6ee","#d63105","#e245e9","#d48c7c","#72f9f9","#f318c3","#40e559","#9b9972","#0bb8d9","#4eaed0","#6914ee","#90daca","#a17271","#33fc5f","#19777e","#a3520a","#eb4c48","#0ae076","#3df670","#b5dbb9","#82a348","#0472d7","#4d9bee","#98e9d3","#458b04","#16429b","#cdbd27","#3f47fb","#c4e7c1","#ab5ad9","#bcb08f","#101c89","#23ffe6","#fc6aa0","#d38cdd","#304aba","#f358e7","#e440c3","#defa93","#7f815b","#a2eca7","#5c57aa","#7a3a86"};

	private Originator org = new Originator();
	private int pNum = 0;
	//Singleton c = Singleton.getInstance();
	Queues times = new Queues("times");
	
	public void setProducts(int productsNum) {
		pNum = productsNum;
		Queues first = qs.get(0);
		Machines mlast = ms.get(ms.size()-1);
		Queues last = mlast.getN();
		Queues states = new Queues("states");
		try {
      	    Thread.sleep(2000);
      	} catch (InterruptedException ie) {
      	    Thread.currentThread().interrupt();
      	}
		for(int i = 0; i < productsNum; i++) {
			Random r = new Random();        
	      	int randomNumber = r.nextInt(AllPColors.length);
	      	String color = AllPColors[randomNumber];
	      	first.add(color);
	      	states.add(color);
		}
//		while(!(last.size() == productsNum)) {}
//		try {
//			Thread.sleep(700);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	    c.setDone();
		org.setStates(states, times);
	}
	
	private String detect(String id ,JSONObject[] shapes) {
		JSONObject jobj = new JSONObject();
		for(int i = 0; i < shapes.length; i++) {
			jobj = shapes[i];
			String temp = (String)jobj.get("id");
			if(temp.equals(id)) {
				return (String)jobj.get("shape");
			}
		}return null;
	}
	
	public void fillArray(JSONObject[] shapes, JSONObject[] arrows, Boolean repeat) {
		JSONObject jobj = new JSONObject();
		ms.clear();
		qs.clear();
		for(int i = 0; i < arrows.length; i++) {
			jobj = arrows[i];
			String src = detect((String)jobj.get("source"), shapes);
			String dst = detect((String)jobj.get("destination"), shapes);
			if(src.equals("rectangle")) {
				qs.add(new Queues((String)jobj.get("source")));
			}else if(dst.equals("rectangle")) {
				qs.add(new Queues((String)jobj.get("destination")));
			}
		}
		int j = 0;
		for(int i = 0; i < arrows.length; i++) {
			jobj = arrows[i];
			String dst = detect((String)jobj.get("destination"), shapes);
			if(!dst.equals("rectangle")) {
				Queues bef = qs.get(j);
				Queues aft = qs.get(j+1);
				
				
				Queues q1;
				Queues q2;
				String befID = bef.getId();
				String aftID = aft.getId();
				for(int k = 0; k < qs.size(); k++) {
					q1 = qs.get(k);
					String tempID = q1.getId();
					if(tempID.equals(befID)) {
						bef = q1;
						break;
					}
				}
				for(int k = 0; k < qs.size(); k++) {
					q2 = qs.get(k);
					String tempID = q2.getId();
					if(tempID.equals(aftID)) {
						aft = q2;
						break;
					}
				}
				
				Machines temp;
				Random r=new Random();        
		      	int randomNumber=r.nextInt(msTimes.length);
		      	int ind = 0;
		      	if(!repeat) {
		      		String time = msTimes[randomNumber].toString();
			      	times.add(time);
			      	temp = new Machines((String)jobj.get("destination"), bef, aft, msTimes[randomNumber]);
		      	}else {
		      		Queues ts = org.getTime().getState();
		      		String tempTime = ts.remove();
		      		ts.add(tempTime);
		      		temp = new Machines((String)jobj.get("destination"), bef, aft, Long.parseLong(tempTime));
		      	}
				
				ms.add(temp);
				bef.addObserver(temp);
				j+=2;
			}
		}
	}
	public void repeatSimulation() {
		Queues first = qs.get(0);
		Queues states = org.getColor().getState();
		try {
      	    Thread.sleep(2000);
      	} catch (InterruptedException ie) {
      	    Thread.currentThread().interrupt();
      	}
		for(int i = 0; i < pNum; i++) {
	      	String color = states.remove();
	      	states.add(color);
	      	first.add(color);
		}
	}
	public Queues getLast() {
		Machines m = ms.get(ms.size() - 1);
		return m.n;
	}
}
