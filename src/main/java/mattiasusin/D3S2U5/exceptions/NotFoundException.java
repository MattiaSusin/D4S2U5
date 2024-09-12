package mattiasusin.D3S2U5.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(int id) {
        super("l'elemento con " + id + " non è stato trovato");
    }
}
