package ESTUDOSJAVA.Project_EstoqueVendas.Main;
import ESTUDOSJAVA.Project_EstoqueVendas.Entities.Carrinho;
import ESTUDOSJAVA.Project_EstoqueVendas.Entities.Estoque;
import ESTUDOSJAVA.Project_EstoqueVendas.Entities.Produto;
import ESTUDOSJAVA.Project_EstoqueVendas.Entities.Venda;
import ESTUDOSJAVA.Project_EstoqueVendas.Enums.FormaPagamento;

import java.util.Scanner;
public class estoqueVendasMain {
    static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Estoque estoque = new Estoque();
        Carrinho carrinho = new Carrinho(estoque);

        System.out.println();
        int opcao = 0;
        while(opcao != 7){
        System.out.println("===============");
        System.out.println("SISTEMA PDV - CONTROLE DE ESTOQUE");
        System.out.println("===============");
        System.out.println("[1] - Cadastrar produto");
        System.out.println("[2] - Listar produtos");
        System.out.println("[3] - Adicionar item ao carrinho");
        System.out.println("[4] - Remover item do carrinho");
        System.out.println("[5] - Ver total parcial do carrinho");
        System.out.println("[6] - Fechar venda");
        System.out.println("[7] Sair");
        System.out.print("Escolha uma opcao: ");
        opcao = leitor.nextInt();
        leitor.nextLine();


            switch(opcao){
                case 1:
                    System.out.println();
                    System.out.println("Cadastro de produto");
                    System.out.print("Codigo: ");
                    String codigo = leitor.nextLine();
                    System.out.print("Nome: ");
                    String nome = leitor.nextLine();
                    System.out.print("Preco: ");
                    double preco = leitor.nextDouble();
                    leitor.nextLine();
                    System.out.print("Quantidade em estoque: ");
                    int qntdeEstoque = leitor.nextInt();
                    System.out.print("Quantidade minima: ");
                    int qntdeMinima = leitor.nextInt();
                    Produto produto = new Produto(codigo,nome,preco,qntdeEstoque,qntdeMinima);
                    estoque.cadastrarProduto(produto);
                    System.out.println("Produto cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println();
                    System.out.println("Produtos cadastrados");
                    estoque.listarProdutos();
                    break;
                case 3:
                    System.out.println();
                    System.out.println("Adicionar item ao carrinho");
                    System.out.println("Codigo do produto: ");
                    String codigoProduto = leitor.nextLine();
                    System.out.println("Quantidade: ");
                    int qntde = leitor.nextInt();
                    leitor.nextLine();
                    Produto p = estoque.buscarProduto(codigoProduto);
                    carrinho.addItem(p,qntde);
                    break;
                case 4:
                    System.out.println();
                    System.out.println("Remover item do carrinho");
                    System.out.println("Digite o codigo do produto: ");
                    String codigoProd = leitor.nextLine().toUpperCase();
                    Produto prod = estoque.buscarProduto(codigoProd);
                    carrinho.removerItem(prod);
                    break;
                case 5:
                    System.out.println("Total parcial do carrinho");
                    double parcialTotal = carrinho.calcularTotalParcial();
                    System.out.println("Parcial total: "+ parcialTotal);
                    break;
                case 6:
                    System.out.println("Fechar venda");
                    System.out.println("Digite a forma de pagamento -> [Dinheiro] [Cartao de Crédito/Débito] [Pix] [Boleto]");
                    String pagamento = leitor.nextLine();
                    FormaPagamento formaPagamento = FormaPagamento.valueOf(pagamento);
                    Venda venda =carrinho.fecharVenda(formaPagamento);
                    System.out.println("Venda finalizada total: "+venda.getTotal());
                    break;
                case 7:
                    System.out.println("Encerrando sistema . . .");
                    break;
                default:
                    System.out.println("Opcao inválida");
                    break;
            }
        }



    }
}
