package com.micromata.webengineering.demo.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * HTTP endpoint for a post-related HTTP requests.
 */
@RestController
public class PostController {
    @Autowired
    private PostService postService;

    @RequestMapping("/post")
    public List<Post> getPostList() {
        return postService.getPosts();
    }
    
    @RequestMapping(value = "/post/{postId}", method = RequestMethod.GET)
    public Post getPost(@PathVariable long postId){
    	return postService.getPost(postId);
    }

    @RequestMapping(value = "/post/add", method = RequestMethod.POST)
    public void addPost(@RequestBody Post post) {
        postService.addPost(post);
    }

    @RequestMapping(value = "/post/delete", method = RequestMethod.DELETE)
    public void deletePost(@RequestParam("id") long id) {
    	postService.deletePost(id);
    }
    
}
