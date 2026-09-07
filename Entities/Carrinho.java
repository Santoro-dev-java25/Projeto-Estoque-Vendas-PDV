package ESTUDOSJAVA.Project_EstoqueVendas.Entities;

import ESTUDOSJAVA.Project_EstoqueVendas.Enums.FormaPagamento;
import ESTUDOSJAVA.Project_EstoqueVendas.Exceptions.CarrinhoVazioException;
import ESTUDOSJAVA.Project_EstoqueVendas.Exceptions.EstoqueInsuficienteException;
import ESTUDOSJAVA.Project_EstoqueVendas.Exceptions.ProdutoInexistenteException;
import ESTUDOSJAVA.Project_EstoqueVendas.Exceptions.ValorInvalidoException;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private List<ItemVenda> itens = new ArrayList<>();
    private Estoque estoque;

    public Carrinho(Estoque estoque) {
        this.estoque = estoque;
    }

    public void addItem(Produto p, int quantidade) {
        ItemVenda item = new ItemVenda(p, quantidade);
        itens.add(item);
    }

    public void removerItem(Produto prod) throws ProdutoInexistenteException {
        boolean removido = itens.removeIf(item -> item.getProduto().getCodigo().equalsIgnoreCase(prod.getCodigo()));

        if (!removido) {
            throw new ProdutoInexistenteException("Produto inexistente no carrinho");
        }
    }

    public double calcularTotalParcial() {
        double totalParcial = 0.0;
        for (ItemVenda item : itens) {
            totalParcial += item.calcularSubtotal();
        }
        return totalParcial;

    }
    public Venda fecharVenda(FormaPagamento formaPagamento)throws CarrinhoVazioException, EstoqueInsuficienteException,ProdutoInexistenteException, ValorInvalidoException {
        if(itens.isEmpty()){
            throw new CarrinhoVazioException("Carrinho vazio");
        }
        Venda venda = new Venda(formaPagamento);
        for(ItemVenda item: itens){
          estoque.darBaixa(item.getProduto().getCodigo(), item.getQuantidade());
            venda.addItem(item);
        }

        venda.finalizar();
        itens.clear();

        return venda;


    }

}
