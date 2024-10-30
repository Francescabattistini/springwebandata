package francescabattistini.springwebandata.services;

import francescaBattistini.esercizioS6L2.entities.Blogpost;
import francescaBattistini.esercizioS6L2.exceptions.NotFoundExceptions;
import francescaBattistini.esercizioS6L2.payloads.BlogPayload;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BlogService {
    //Lista per attributo
    private List <Blogpost> blogList = new ArrayList<>();

    //1. metodo per farci avere una lista di blogpost
    public List <Blogpost> findAll(){
        return this.blogList;
    }
    //2. Salvo un nuovo BlogPost alla lista
    public Blogpost saveBlogPost(BlogPayload body) {
        Random random = new Random();
        Blogpost newBlogPost = new Blogpost(body.getCategoria(), body.getTitolo(),
                body.getContenuto(), body.getTempoDiLettura());
        newBlogPost.setId(random.nextInt(1, 1000));
        newBlogPost.setCover("https://placedog.net/400x200");// attributi da settare
        this.blogList.add(newBlogPost);
        return newBlogPost;
    }

    //3.Trovo un blogPost per ID

    public Blogpost findById(int blogId) {
        return this.blogList.stream().filter(blogPost ->
                blogPost.getId() == blogId).findFirst().orElseThrow(() ->
                new NotFoundExceptions(blogId));
    }

    /*public User findById(int userId) {
        User found = null;
        for (User user : this.usersList) {
            if (user.getId() == userId) found = user;
        }
        if (found == null) throw new NotFoundException(userId);
        return found;
    }*/
    //4. Trovo blogPost per id and update
    public Blogpost findByIdAndUpdate(int blogId, BlogPayload body) {
        Blogpost found = null;
        for (Blogpost blogPost : this.blogList) {
            if (blogPost.getId() == blogId) {
                found= blogPost;
                found.setTitolo(body.getTitolo());
                found.setContenuto(body.getContenuto());
                found.setCategoria(body.getCategoria());
                found.setTempoDiLettura(body.getTempoDiLettura());
            }
        }
        if (found == null) throw new NotFoundExceptions(blogId);
        return found;
    }
    //cerco l'utente, se l'id è uguale il found  si modifica con quello che mi arriva dal body
    //se null eccezione
// 5.Trovo blogPost per id e cancello
    public void findByIdAndDelete(int blogPostId) {
        Blogpost blogPostDelete = this.blogList.stream().filter(blogPost -> blogPost.getId() == blogPostId).
                findFirst().orElseThrow(() -> new NotFoundExceptions(blogPostId));
        this.blogList.remove(blogPostDelete);
    }


}
