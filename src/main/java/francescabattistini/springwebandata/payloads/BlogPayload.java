package francescabattistini.springwebandata.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class BlogPayload {// Rappresenta il body della richiesta di salvataggio di un nuovo utente
    private String categoria;
    private String titolo;
    private String contenuto;
    private int tempoDiLettura;
}
