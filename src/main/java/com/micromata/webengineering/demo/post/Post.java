package com.micromata.webengineering.demo.post;

import java.util.Date;

public class Post {
	
	private int id;
	private String title;
	private Date timeOfCreation;

	public Post(int id, String title, Date timeOfCreation) {
		this.id = id;
		this.title = title;
		this.timeOfCreation = timeOfCreation;
	}

	public String getTitle() {
		return title;
	}

	public Date getTimeOfCreation() {
		return timeOfCreation;
	}

	public void setTimeOfCreation(Date timeOfCreation) {
		this.timeOfCreation = timeOfCreation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}