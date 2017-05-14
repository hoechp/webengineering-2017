package com.micromata.webengineering.demo.post;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Post {
	
	private static AtomicLong nextId = new AtomicLong();
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private Date timeOfCreation;
	
	public Post() {
		setId((Long)nextId.getAndIncrement());
		setTimeOfCreation(new Date());
	}

	public Post(long id, String title, Date timeOfCreation) {
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}