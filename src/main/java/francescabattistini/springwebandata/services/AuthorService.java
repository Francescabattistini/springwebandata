package francescabattistini.springwebandata.services;


import francescabattistini.springwebandata.entities.Author;
import francescabattistini.springwebandata.exceptions.NotFoundExceptions;
import francescabattistini.springwebandata.payloads.AuthorPayload;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AuthorService {
    //Lista per attributo
    private List<Author> authorList = new ArrayList<>();

    //1. metodo per farci avere una lista di blogpost
    public List <Author> findAllAuthore(){
        return this.authorList;
    }
    //2. Salvo un nuovo Autore alla lista
    public Author saveAuthorPost(AuthorPayload body) {
        Random random = new Random();
        Author newAuthor = new Author(body.getNome(), body.getCognome(),
        body.getEmail(), body.getDataDiNascita());
        this.authorList.add(newAuthor);
        return newAuthor;
    }

    //3.Trovo un author per ID

    public Author findAuthorById(int authorId) {
        return this.authorList.stream().filter(author ->
                author.getId() == authorId).findFirst().orElseThrow(() ->
                new NotFoundExceptions(authorId));
    }

    /*public User findById(int userId) {
        User found = null;
        for (User user : this.usersList) {
            if (user.getId() == userId) found = user;
        }
        if (found == null) throw new NotFoundException(userId);
        return found;
    }*/
    //4. Trovo author per id and update

    public Author findAuthoreByIdAndUpdate(int authorId, AuthorPayload body) {
        Author found = null;
        for (Author aut : this.authorList) {
            if (aut.getId() == authorId) {
                found= aut;
                found.setNome(body.getNome());
                found.setCognome(body.getCognome());
                found.setEmail(body.getEmail());
                found.setDataDiNascita(body.getDataDiNascita());
            }
        }
        if (found == null) throw new NotFoundExceptions(authorId);
        return found;
    }
    //cerco l'autore, se l'id è uguale il found  si modifica con quello che mi arriva dal body
    //se null eccezione

// 5.Trovo author  per id e cancello
    public void findauthorByIdAndDelete(int authorId) {
        Author authorDelete = this.authorList.stream().filter(author -> author.getId() == authorId).
                findFirst().orElseThrow(() -> new NotFoundExceptions(authorId));
        this.authorList.remove(authorDelete);
    }
}
