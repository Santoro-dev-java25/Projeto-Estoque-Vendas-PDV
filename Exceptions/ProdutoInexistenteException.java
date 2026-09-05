package ESTUDOSJAVA.Project_EstoqueVendas.Exceptions;

public class ProdutoInexistenteException extends RuntimeException {
    public ProdutoInexistenteException(String message) {
        super(message);
    }
}
