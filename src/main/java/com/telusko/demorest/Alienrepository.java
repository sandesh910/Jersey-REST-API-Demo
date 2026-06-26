package com.telusko.demorest;

import java.util.ArrayList;
import java.util.List;

import java.sql.*;
public class Alienrepository {

	Connection Connect=null;
	Statement st=null;
	PreparedStatement pstmt=null;

	public Alienrepository() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/restdb";
			String user="root";
			String password="mutadak@1";
		    Connect = DriverManager.getConnection(url, user, password);
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
public List<Alien> getAliens(){
		
		List<Alien> alien=new ArrayList<>();
		
		String sql="Select * From alien";
		
		try {
			st= Connect.createStatement();
			ResultSet rs=st.executeQuery(sql);
			
			while(rs.next()) {
				Alien a=new Alien();
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setPoints(rs.getInt(3));
				alien.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alien;
}
	
public Alien getAlien(int id){
	String sql="Select * From alien where id="+id;
	Alien a=new Alien();
	try {
		st= Connect.createStatement();
		ResultSet rs=st.executeQuery(sql);
		
		if(rs.next()) {
			
			a.setId(rs.getInt(1));
			a.setName(rs.getString(2));
			a.setPoints(rs.getInt(3));
			
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return a;

}	
public void create(Alien a1) {

	try {
		String query = "INSERT INTO alien(id, name, points) VALUES(?,?,?)";
		pstmt= Connect.prepareStatement(query);
		pstmt.setInt(1, a1.getId());
		pstmt.setString(2, a1.getName());
		pstmt.setInt(3, a1.getPoints());
		
		pstmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

public void update(Alien a1) {

	try {
		String query = "update alien set name=?, points=? where id=?";
		pstmt= Connect.prepareStatement(query);
		
		
		pstmt.setString(1, a1.getName());
		pstmt.setInt(2, a1.getPoints());
		pstmt.setInt(3, a1.getId());
		
		pstmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
	
public void delete(int id) {

	try {
		String query = "DELETE FROM alien where id=?";
		pstmt= Connect.prepareStatement(query);
		
		pstmt.setInt(1, id);
		
		pstmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}	

//	List<Alien> alien;
//	
//    public Alienrepository(){
//	 
////		alien=new ArrayList<>(); 
////		
////		Alien a1=new Alien();
////		a1.setId(101);
////		a1.setName("Sandesh");
////		a1.setPoints(90);
////		
////		Alien a2=new Alien();
////		a2.setId(102);
////		a2.setName("Brijesh");
////		a2.setPoints(79);
////		
////		alien.add(a1);
////		alien.add(a2);
////		
//		
//	}
//	
//	public List<Alien> getAliens(){
////		return alien;
////	}
////	
////	public Alien getAlien(int id){
////		
////		for(Alien a:alien) {
////			if(a.getId()==id) {
////				return a;
////			}
////		}
////		return new Alien();
////	}
////
////	public void create(Alien a1) {
////		
////		alien.add(a1);
////	}
	
	
	
}
