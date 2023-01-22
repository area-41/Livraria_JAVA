package br.com.americanas.polotech.ProOri.Projeto02.BancoDeDados;

import br.com.americanas.polotech.ProOri.Projeto02.Main;
import br.com.americanas.polotech.ProOri.Projeto02.Produtos.Produto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Carrinho {

    BigDecimal compra;
    BigDecimal venda;
    BigDecimal valorTotalCarrinho;
    public static List<Produto> carrinho = new ArrayList<>();

    public Carrinho(BigDecimal compra, BigDecimal venda, BigDecimal valorTotalCarrinho, List<Produto> carrinho) {
        this.compra = compra;
        this.venda = venda;
        this.valorTotalCarrinho = valorTotalCarrinho;
        this.carrinho = carrinho;
    }

    public BigDecimal getCompra() {
        return compra;
    }

    public void setCompra(BigDecimal compra) {
        this.compra = compra;
    }

    public BigDecimal getVenda() {
        return venda;
    }

    public void setVenda(BigDecimal venda) {
        this.venda = venda;
    }

    public BigDecimal getValorTotalCarrinho() {
        return valorTotalCarrinho;
    }

    public void setValorTotalCarrinho(BigDecimal valorTotalCarrinho) {
        this.valorTotalCarrinho = valorTotalCarrinho;
    }

    public static List<Produto> getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(List<Produto> carrinho) {
        this.carrinho = carrinho;
    }

    public Carrinho() {
        System.out.println("Usando o carrinho...");
    }

    @Override
    public String toString() {
        return "Carrinho{" +
                "compra=" + compra +
                ", venda=" + venda +
                ", valorTotalCarrinho=" + valorTotalCarrinho +
                ", carrinho=" + carrinho +
                '}';
    }

    public static void verCarrinho() {
        System.out.println("Seu Carrinho: |---- ");
        carrinho.stream().forEach(produtoCarrinho -> System.out.println(produtoCarrinho.toString()));
    }

    public static void colocarProdutoNoCarrinho() {
        System.out.println("Qual o ID do produto para comprar?");
        Integer id = Main.sc.nextInt();
        Produto produtoParaComprar = Estoque.estoqueLista.get(id - 1);
        carrinho.add(produtoParaComprar);
        System.out.println("Produto Adicionado ao Carrinho!");
        System.out.println("Seu Carrinho: |---- ");
        carrinho.stream().forEach(produtoCarrinho -> System.out.println(produtoCarrinho.toString()));
    }

    public static void removerProdutoDoCarrinho() {
        System.out.println("Seu Carrinho: |---- ");
        carrinho.stream().forEach(produtoCarrinho -> System.out.println(produtoCarrinho.toString()));
        System.out.println("Qual o ID do produto que deseja remover?");
        Integer id = Main.sc.nextInt();
        Produto produtoParaRemover = Estoque.estoqueLista.get(id - 1);
        carrinho.remove(produtoParaRemover);
        System.out.println("Produto Removido do Carrinho!");
        System.out.println("Seu Carrinho: |---- ");
        carrinho.stream().forEach(produtoCarrinho -> System.out.println(produtoCarrinho.toString()));
    }

    public static void pagar() {
        BigDecimal totalCarrinho = carrinho.stream().map(Produto::getPreco).reduce(BigDecimal::add).get();

        System.out.println("\nSeu Carrinho: |---- ");
        carrinho.stream().forEach(produtoCarrinho -> System.out.println(produtoCarrinho.toString()));

        System.out.printf("\tTOTAL de Produtos: %s\n", carrinho.stream().map(Produto::getId).count());

        System.out.printf("\nO produto mais CARO do Carrinho: R$ %s", carrinho.stream().map(Produto::getPreco).max(BigDecimal::compareTo).get().toString());

        System.out.printf("\nO produto mais BARATO do Carrinho: R$ %s", carrinho.stream().map(Produto::getPreco).min(BigDecimal::compareTo).get().toString());

        System.out.printf("\nOs produtos Multiplicados do Carrinho: R$ %s", carrinho.stream().map(Produto::getPreco).reduce(BigDecimal::multiply).get().toString());

        System.out.printf("\nO SOMA dos produtos do Carrinho: R$ %s\n", carrinho.stream().map(Produto::getPreco).reduce(BigDecimal::add).get().toString());

        System.out.printf("\nA compra possui os Valores: %s\n", carrinho.stream().map(Produto::getPreco).collect(Collectors.toList()));

        //---- O mesmo que o código acima mas adicionando à uma lista -----
//        List<BigDecimal> listaPrecos = new ArrayList<>();
//        carrinho.stream().forEach(produto -> listaPrecos.add(produto.getPreco()));
//        System.out.printf("\nA compra possui os Valores: %s\n", listaPrecos);

        System.out.printf("::: Valor Total de: R$ %s :::\n\n", totalCarrinho);

        System.out.println("\n\tConfirmar compra? [1] sim ou [2] não");
        short escolha = Main.sc.nextShort();
        switch (escolha){
            case 1 -> {
                System.out.printf("\nOs indices dos itens comprados foram: %s\n", carrinho.stream().map(Produto::getId).collect(Collectors.toList()));
                System.out.println("Compra confirmada...");
                
                carrinho.stream().forEach(produtoParaComprar -> Estoque.estoqueLista.remove(produtoParaComprar));
                System.out.println("Removido produto do estoque!");

                System.out.printf("Valor adicionado ao caixa. \nValor no Caixa: R$ %s\n\n", Caixa.caixaRegistradora.add(totalCarrinho));
                carrinho.clear();
            }
            case 2 -> {
                System.out.println("Operação cancelada.");
            }
            default -> {
                System.out.println("Opção inválida, operação cancelada.");
            }
        }
    }
}
