package com.micromata.webengineering.demo.post;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Handle all CRUD operations for posts.
 */
@Service
public class PostService {
    private List<Post> posts = new LinkedList<>();
    
    /**
     * Retrieve the list of all posts.
     *
     * @return post list
     */
    public List<Post> getPosts() {
        return posts;
    }


    /**
     * Add a new post.
     *
     * @param title the post title.
     */
    public void addPost(Post post) {
        posts.add(post);
    }


	public Post getPost(long postId) {
		for (Post post : posts) {
			if(post.getId() == postId) return post;
		}
		return null; // Post with the given Id doesn't exist
	}


	public void deletePost(long postId) {
		for (Post post : posts) {
			if(post.getId() == postId) posts.remove(post);
		}
	}
}
