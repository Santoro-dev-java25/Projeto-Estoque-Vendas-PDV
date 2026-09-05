package ESTUDOSJAVA.Project_EstoqueVendas.Entities;

import ESTUDOSJAVA.Project_EstoqueVendas.Exceptions.EstoqueNegativoException;
import ESTUDOSJAVA.Project_EstoqueVendas.Exceptions.ValorInvalidoException;

public class Produto {

    private String codigo;
    private String nome;
    private double preco;
    private int quantidadeEstoque;
    private int quantidadeMinima;

    public Produto(String codigo,String nome,double preco,int quantidadeEstoque,int quantidadeMinima){
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.quantidadeMinima = quantidadeMinima;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidadeMinima() {
        return quantidadeMinima;
    }

    public void setQuantidadeMinima(int quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }

    public void addQuantidadeEstoque(int quantidade)throws ValorInvalidoException {
        if(quantidade <= 0){
            throw new ValorInvalidoException("Valor invalido -> Quantidade tem que ser maior que zero!");
        }else{
            quantidadeEstoque += quantidade;
        }

    }
    public void  removerQuantidadeEstoque(int quantidade)throws ValorInvalidoException{
        if(quantidade <= 0) {
            throw new ValorInvalidoException("Valor invalido -> Quantidade tem que ser maior que zero!");
        }else{
            quantidadeEstoque -= quantidade;
        }

    }

    public boolean estaAbaixoDoMinimo()throws EstoqueNegativoException {
        if(quantidadeEstoque < 0){
            throw new EstoqueNegativoException("Estoque negativo");
        }
        if(quantidadeMinima > quantidadeEstoque){
            return true;
        }else{
            return false;
        }


    }


}
