package com.micromata.webengineering.demo.post;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
	
	@Query("SELECT t FROM Post t ORDER BY t.createdAt DESC")
    public Iterable<Post> findAllOrderedByCreatedAt();

}
