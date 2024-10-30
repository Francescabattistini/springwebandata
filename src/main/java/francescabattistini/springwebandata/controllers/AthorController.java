package francescabattistini.springwebandata.controllers;

import francescaBattistini.esercizioS6L2.entities.Author;
import francescaBattistini.esercizioS6L2.payloads.AuthorPayload;
import francescaBattistini.esercizioS6L2.services.AuthorService;
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
@RestController
@RequestMapping("/author")
public class AthorController {
        //autowired per usare il service all'interno del controller
       @Autowired
       private AuthorService authorservice;

        // 1. GET http://localhost:3002/blogpost
        @GetMapping
        public List<Author> getAuthor(){
           return this.authorservice.findAllAuthore();
        }


//2.post http://localhost:3002/blogpost(+paylod)

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)//201 per la risposta local
        public Author createAuthor(@RequestBody AuthorPayload body){
            return this.authorservice.saveAuthorPost(body);
        }


        //3. Get http://localhost:3002/blogpost ( utente specifico)
        @GetMapping("/{blogId}")
        public Author findAuthorByid(@PathVariable int authorId){
            return this.authorservice.findAuthorById(authorId);
        }



        //4 PUT http://localhost:3002/blogpost {blogID} (+paylod)
        @PutMapping("/{blogId}")
        public Author findAuthorByIdAndUpdate(@PathVariable int authorId, @RequestBody AuthorPayload body){
            return this.authorservice.findAuthoreByIdAndUpdate(authorId,body);
        }




        //5 DELETE http://localhost:3002/blogpost {blogID}
        @DeleteMapping("/{blogId}")
        @ResponseStatus(HttpStatus.NO_CONTENT)//204
        public void findAuthorIdAndDelate(@PathVariable int authorId){
            this.authorservice.findauthorByIdAndDelete(authorId);
        }
}
