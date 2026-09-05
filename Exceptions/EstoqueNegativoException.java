package ESTUDOSJAVA.Project_EstoqueVendas.Exceptions;

public class EstoqueNegativoException extends RuntimeException {
    public EstoqueNegativoException(String message) {
        super(message);
    }
}
