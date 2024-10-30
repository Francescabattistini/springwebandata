package francescabattistini.springwebandata.controllers;


import francescabattistini.springwebandata.entities.Blogpost;
import francescabattistini.springwebandata.payloads.BlogPayload;
import francescabattistini.springwebandata.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/* *************************************************** USERS CRUD ****************************************************

1. GET http://localhost:3001/users
2. POST http://localhost:3001/users (+ payload)
3. GET http://localhost:3001/users/{userId}
4. PUT http://localhost:3001/users/{userId} (+ payload)
5. DELETE http://localhost:3001/users/{userId}

*/
/*
@RestController
@RequestMapping("/blogpost")
public class BlogController {
    //autowired per usare il service all'interno del controller
    @Autowired
    private BlogService blogservice;

    // 1. GET http://localhost:3002/blogpost
    @GetMapping
   public List <Blogpost> getBlog(){
        return this.blogservice.findAll();
    }


//2.post http://localhost:3002/blogpost(+paylod)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)//201 per la risposta local
    public Blogpost createBlog(@RequestBody BlogPayload body){
return this.blogservice.saveBlogPost(body);
    }


    //3. Get http://localhost:3002/blogpost ( utente specifico)
    @GetMapping("/{blogId}")
    public Blogpost findBlogByid(@PathVariable int blogId){
  return this.blogservice.findById(blogId);
    }



    //4 PUT http://localhost:3002/blogpost {blogID} (+paylod)
   @PutMapping("/{blogId}")
    public Blogpost findblogByIdAndUpdate(@PathVariable int blogId, @RequestBody  BlogPayload body){
        return this.blogservice.findByIdAndUpdate(blogId,body);
   }




  //5 DELETE http://localhost:3002/blogpost {blogID}
@DeleteMapping("/{blogId}")
@ResponseStatus(HttpStatus.NO_CONTENT)//204
    public void findBlogIdAndDelate(@PathVariable int blogId){
        this.blogservice.findByIdAndDelete(blogId);
}

}*/
