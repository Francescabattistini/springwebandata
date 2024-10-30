package francescabattistini.springwebandata.services;


import francescabattistini.springwebandata.entities.Author;
import francescabattistini.springwebandata.exceptions.BadrequestExeption;
import francescabattistini.springwebandata.exceptions.NotFoundExceptions;
import francescabattistini.springwebandata.payloads.AuthorPayload;
import francescabattistini.springwebandata.repository.Authorepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AuthorService {
@Autowired
private Authorepository autoreRepository;


//usiamo ispresent non else trow perchè lui lo usiamo quando l'eccezione  non la  trova, mentre ispresent vede se c'è
    // per esempio qui se l'indirizzo c'è già triggherà l'errore quindi non controlla se non c'è
    //2. Salvo un nuovo Autore alla lista
    public Author save(Author body) {
        this.autoreRepository.findByEmail(body.getEmail()).ifPresent(autore->{
            throw new BadrequestExeption("email"+body.getEmail()+"già in uso");
        }
        );
        //se è ok aggiungo i campi
        Author newAuthor = new Author(body.getNome(), body.getCognome(), body.getEmail(),body.getDataDiNascita());
        newAuthor.setAvatar("https://ui-avatars.com/api/?name=" + newAuthor.getNome() + "+" + newAuthor.getCognome());
        return this.autoreRepository.save(newAuthor);
    }

    //2. trovo tutta la lista(il paylod + body)
    public List<Author>findAll(){
      return this.autoreRepository.findAll();
    }

    //3.Trovo un author per ID

  /*  public Author findAuthorById(int authorId) {

    }


    //4. Trovo author per id and update

    public Author findAuthoreByIdAndUpdate(int authorId, AuthorPayload body) {

    }


// 5.Trovo author  per id e cancello
    public void findauthorByIdAndDelete(int authorId) {

    }*/
}
