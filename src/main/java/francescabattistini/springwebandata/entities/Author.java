package francescabattistini.springwebandata.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private  int id;
    private  String nome;
    private   String cognome;
    private  String email;
    private  LocalDate dataDiNascita;
    private  String avatar;

    public Author(String nome, String cognome, String email, LocalDate dataDiNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
    }
}
