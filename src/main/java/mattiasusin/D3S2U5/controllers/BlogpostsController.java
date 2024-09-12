package mattiasusin.D3S2U5.controllers;

import mattiasusin.D3S2U5.entities.BlogPost;
import mattiasusin.D3S2U5.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogPosts")
public class BlogpostsController {

    @Autowired
    private BlogPostService blogPostService;

    // 1. GET TUTTI --> http://localhost:3001/blogPosts
    @GetMapping
    private List<BlogPost> getBlogPostById(@PathVariable int blogPostId) {return blogPostService.findAll();}

    // 2. GET SINGOLI BLOG POSTS
    @GetMapping("/{blogPostId}")
    private BlogPost getBlogPostId(@PathVariable int blogPostId)
        throws ClassNotFoundException{
        return blogPostService.findById(blogPostId);
    }

    // 3. POST CREA UN NUOVO BLOG
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    private BlogPost createBlogPost(@RequestBody BlogPost body){return blogPostService.saveBlog(body);}

    // 4. PUT MODIFICA IL BLOGPOST
    @PutMapping("/{blogPostId}")
    private BlogPost findBlogPostByIdAndUpdate(@PathVariable int blogPostId, @RequestBody BlogPost body){
        return blogPostService.findByIdAndUpdate(blogPostId,body);
    }

    // 5. DELETE CANCELLA IL BLOG POST
    @DeleteMapping("/{blogPostId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void findBlogPostByIdAndDelete(@PathVariable int blogPostId){blogPostService.findByIdAndDelete(blogPostId);}



}
