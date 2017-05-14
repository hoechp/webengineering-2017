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
    }


    /**
     * Add a new post.
     *
     * @param title the post title.
     */
    public String addPost(Post post, String url) {
        repository.save(post);
        String baseURL = url.substring(0, url.lastIndexOf("add"));
        return baseURL + post.getId();
    }


	public Post getPost(long postId) {
		return repository.findOne(postId);
	}


	public boolean deletePost(long postId) {
		repository.delete(postId);
		return true;
	}
}
