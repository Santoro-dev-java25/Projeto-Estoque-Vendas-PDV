package ESTUDOSJAVA.Project_EstoqueVendas.Entities;

public class ItemVenda {

    private Produto produto;
    private int quantidade;
    private double subtotal;

    public ItemVenda(Produto produto,int quantidade){
        this.produto = produto;
        this.quantidade = quantidade;
        this.subtotal = calcularSubtotal();
    }

    public Produto getProduto() {
        return produto;
    }


    public int getQuantidade() {
        return quantidade;
    }
    public double getSubtotal() {
        return subtotal;
    }
    public double calcularSubtotal(){
        return produto.getPreco() * quantidade;
    }
}
