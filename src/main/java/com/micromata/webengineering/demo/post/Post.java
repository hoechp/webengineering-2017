package com.micromata.webengineering.demo.post;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.hibernate.annotations.Type;

@Entity
public class Post {
	
	@Id
	@GeneratedValue
	private Long id;
	@Lob
	@Type(type = "org.hibernate.type.TextType")
	//@Column(name = "title", length=1023)
	private String title;
	private Date createdAt;
	private Date updatedAt;
	
	public Post() { }

	public Post(Long id, String title, Date timeOfCreation) {
		this.id = id;
		this.title = title;
		this.createdAt = timeOfCreation;
	}

	public String getTitle() {
		return title;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@PrePersist
	protected void onCreate() {
		setCreatedAt(new Date());
	}

	@PreUpdate
	protected void onUpdate() {
		updatedAt = new Date();
	}
	
	
}