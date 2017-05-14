package com.micromata.webengineering.demo.post;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * HTTP endpoint for a post-related HTTP requests.
 */
@RestController
public class PostController {
	
	@Autowired(required=true)
	private HttpServletRequest request;
	
    @Autowired
    private PostService postService;
    
	public String getUrl() {
		return makeUrl(request);
	}
	
	public String makeUrl(HttpServletRequest request) {
	    return request.getRequestURL().toString();// + "?" + request.getQueryString();
	}

    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public Iterable<Post> getPostList() {
        return postService.getPosts();
    }
    
    @RequestMapping(value = "/post/{postId}", method = RequestMethod.GET)
    public Post getPost(@PathVariable long postId){
    	return postService.getPost(postId);
    }

    @RequestMapping(value = "/post/add", method = RequestMethod.POST)
    public String addPost(@RequestBody Post post) {
        return postService.addPost(post, getUrl());
    }

    @RequestMapping(value = "/post/delete", method = RequestMethod.DELETE)
    public void deletePost(@RequestParam("id") long id) {
    	postService.deletePost(id);
    }
    
}
