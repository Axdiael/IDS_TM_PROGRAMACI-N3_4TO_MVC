package models;

import java.util.Date;

public class Users {
	
	private int id;
	private String name;
	private String email;
	private String role;
	private String phone;
	private Date fecha;
	
	public Users (int id, String name,String email, String role, String phone, Date fecha) {

		this.id = id;
		this.name=name;
		this.email= email;
		this.role=role;
		this.phone=phone;
		this.fecha=fecha;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getRole() {
		return role;
	}

	public String getPhone() {
		return phone;
	}

	public Date getFecha() {
		return fecha;
	}
		
	
}
