package francescabattistini.springwebandata.entities;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name= "blogpost")
public class Blogpost {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
     private int id;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private int tempoDiLettura;
    @ManyToOne
    @JoinColumn(name = "authorId")
    private Author autor;

    public Blogpost(String categoria, String titolo, String contenuto, int tempoDiLetturo) {
        this.categoria = categoria;
        this.titolo = titolo;
        this.contenuto = contenuto;
        this.tempoDiLettura = tempoDiLetturo;
    }
}
