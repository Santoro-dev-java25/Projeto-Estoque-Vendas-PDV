package ESTUDOSJAVA.Project_EstoqueVendas.Entities;

import ESTUDOSJAVA.Project_EstoqueVendas.Enums.FormaPagamento;
import ESTUDOSJAVA.Project_EstoqueVendas.Enums.StatusVenda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Venda {

    private List<ItemVenda> itens = new ArrayList<>();
    private LocalDate data;
    private FormaPagamento formaPagamento;
    private StatusVenda statusVenda;
    private Cliente cliente;
    private double total;

    public Venda(FormaPagamento formaPagamento){
        this.data = LocalDate.now();
        this.formaPagamento = formaPagamento;
        this.statusVenda = StatusVenda.ABERTA;
        this.total = calcularTotal();
    }

    public void addItem(ItemVenda item){
        itens.add(item);
    }
    public void finalizar(){
        statusVenda = StatusVenda.FINALIZADA;
    }
    public void cancelar(){
        statusVenda = StatusVenda.CANCELADA;
    }
    public double calcularTotal(){
        double total = 0.0;
        for(ItemVenda item : itens){
            total += item.getSubtotal();
        }
        return total;
    }

    public void associarCliente(Cliente cliente){
     this.cliente = cliente;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public double getTotal() {
        return calcularTotal();
    }

    public StatusVenda getStatusVenda() {
        return statusVenda;
    }

    public LocalDate getData() {
        return data;
    }
}
