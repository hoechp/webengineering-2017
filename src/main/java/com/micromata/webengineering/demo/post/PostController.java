package com.micromata.webengineering.demo.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @RequestMapping("/post/{postId}")
    public Post getPost(@PathVariable int postId){
    	return postService.getPost(postId);
    }

    @RequestMapping(value = "/post/add", method = RequestMethod.POST)
    public void addPost(@RequestParam("title") String title) {
        postService.addPost(title);
    }

    @RequestMapping(value = "/post/delete", method = RequestMethod.DELETE)
    public void deletePost(@RequestParam("id") int id) {
    	postService.deletePost(id);
    }
    
}
