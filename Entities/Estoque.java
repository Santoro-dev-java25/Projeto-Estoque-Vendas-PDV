package ESTUDOSJAVA.Project_EstoqueVendas.Entities;

import ESTUDOSJAVA.Project_EstoqueVendas.Exceptions.EstoqueInsuficienteException;
import ESTUDOSJAVA.Project_EstoqueVendas.Exceptions.ProdutoInexistenteException;
import ESTUDOSJAVA.Project_EstoqueVendas.Exceptions.ValorInvalidoException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Estoque {


    private List<Produto> produtos = new ArrayList<>();

    public Estoque(){

    }

    public void listarProdutos(){
        if(produtos.isEmpty()){
            System.out.println("Nennhum produto cadastrado!");
        }
        for(Produto p : produtos){
            System.out.println("Codigo: "+ p.getCodigo() + " | Nome: "+ p.getNome() + " | Preco: "+ p.getPreco() + " | Estoque: "+ p.getQuantidadeEstoque());
        }
    }

    public void cadastrarProduto(Produto p){
        produtos.add(p);
    }

    public Produto buscarProduto(String codigo)throws ProdutoInexistenteException {
        for(Produto p: produtos){
            if(p.getCodigo().equalsIgnoreCase(codigo)){
                return p;
            }
        }
        throw new ProdutoInexistenteException("Produto de codigo "+ codigo + " nao existe");
    }
    public void reporQuantidade(String codigo,int quantidade)throws ProdutoInexistenteException,ValorInvalidoException{
            Produto p = buscarProduto(codigo);
            p.addQuantidadeEstoque(quantidade);
        }


    public void darBaixa(String codigo,int quantidade)throws EstoqueInsuficienteException,ProdutoInexistenteException, ValorInvalidoException {
        Produto p = buscarProduto(codigo);
            if(p.getQuantidadeEstoque() >= quantidade){
                p.removerQuantidadeEstoque(quantidade);
            }
            else{
                   throw new EstoqueInsuficienteException("Estoque insuficiente");
            }

        }
    }


