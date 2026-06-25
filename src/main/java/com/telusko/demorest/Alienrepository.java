package com.telusko.demorest;

import java.util.ArrayList;
import java.util.List;

public class Alienrepository {

	List<Alien> alien;
	
    public Alienrepository(){
	 
		alien=new ArrayList<>(); 
		
		Alien a1=new Alien();
		a1.setId(101);
		a1.setName("Sandesh");
		a1.setPoints(90);
		
		Alien a2=new Alien();
		a2.setId(102);
		a2.setName("Brijesh");
		a2.setPoints(79);
		
		alien.add(a1);
		alien.add(a2);
		
		
	}
	
	public List<Alien> getAliens(){
		return alien;
	}
	
	public Alien getAlien(int id){
		
		for(Alien a:alien) {
			if(a.getId()==id) {
				return a;
			}
		}
		return new Alien();
	}

	public void create(Alien a1) {
		
		alien.add(a1);
	}
	
	
	
}
