package com.revaturesocialmedia.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee implements User{
	@Id
	@Column(name="id_number")
	@SequenceGenerator(name="id_seq", sequenceName = "user_id_seq", initialValue = 100001, allocationSize = 899999)
	@GeneratedValue(generator="id_seq", strategy=GenerationType.AUTO)
	private int id;
	@Column(name = "username")
	private String username;
	@Column(name = "pass")
	private String password;
	@Column(name = "picture")
	private String picture;
	@Column(name = "firstname")
	private String firstname;
	@Column(name = "lastname")
	private String lastname;
	@Column(name = "about_me")
	private String aboutMe;
	@Column(name = "technologies")
	private String technologies;
	
	public Employee() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public String getTechnologies() {
		return technologies;
	}

	public void setTechnologies(String technologies) {
		this.technologies = technologies;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [id=");
		builder.append(id);
		builder.append(", username=");
		builder.append(username);
		builder.append(", password=");
		builder.append(password);
		builder.append(", picture=");
		builder.append(picture);
		builder.append(", firstname=");
		builder.append(firstname);
		builder.append(", lastname=");
		builder.append(lastname);
		builder.append(", aboutMe=");
		builder.append(aboutMe);
		builder.append(", technologies=");
		builder.append(technologies);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
