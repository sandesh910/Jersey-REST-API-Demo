package com.telusko.demorest;

import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("aliens")

public class AlienResource {
   
	Alienrepository repo=new Alienrepository();
	//Get request to fetch data form database
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Alien> getAliens() {
	
	System.out.println("getting called");
	 
	
	return repo.getAliens();
	}
	
	//Can access specific id details of Alien instance a.
	@GET
	@Path("alien/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Alien getAlien(@PathParam("id") int id){
		
		return repo.getAlien(id);
	}
	
	//Post request to insert data to database
	@POST
	@Path("alien")
	public Alien createAlien(Alien a1) {
		System.out.println(a1);
		repo.create(a1);
		return a1;
		
	}
}
