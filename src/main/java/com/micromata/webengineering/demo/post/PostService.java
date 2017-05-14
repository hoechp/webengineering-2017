package com.micromata.webengineering.demo.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Handle all CRUD operations for posts.
 */
@Service
public class PostService {
	@Autowired
	private PostRepository repository;
	
    private List<Post> posts = new LinkedList<>();
    
    /**
     * Retrieve the list of all posts.
     *
     * @return post list
     */
    public Iterable<Post> getPosts() {
    	return repository.findAll();
        //return posts;
    }


    /**
     * Add a new post.
     *
     * @param title the post title.
     */
    public void addPost(Post post) {
        repository.save(post);
    	//posts.add(post);
    }


	public Post getPost(long postId) {
		return repository.findOne(postId);
//		for (Post post : posts) {
//			if(post.getId() == postId) return post;
//		}
//		return null; // Post with the given Id doesn't exist
	}


	public void deletePost(long postId) {
		repository.delete(postId);
//		for (Post post : posts) {
//			if(post.getId() == postId) posts.remove(post);
//		}
	}
}
