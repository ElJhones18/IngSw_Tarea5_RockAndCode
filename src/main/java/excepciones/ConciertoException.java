package excepciones;

public class ConciertoException extends RuntimeException{
    public ConciertoException(String mensaje) {
        super(mensaje);
    }
}
