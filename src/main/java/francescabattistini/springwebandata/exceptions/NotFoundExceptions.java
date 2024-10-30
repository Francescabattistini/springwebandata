package francescabattistini.springwebandata.exceptions;


public class NotFoundExceptions extends RuntimeException {
    public NotFoundExceptions(int id) {
        super("Il record con id " + id + " non è stato trovato");
    }
}
