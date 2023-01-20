package br.com.americanas.polotech.ProOri.Projeto02.BancoDeDados;

import br.com.americanas.polotech.ProOri.Projeto02.Main;
import br.com.americanas.polotech.ProOri.Projeto02.Produtos.Brinquedo;
import br.com.americanas.polotech.ProOri.Projeto02.Produtos.Produto;
import jdk.jshell.execution.Util;

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
        System.out.println("Seu Carrinho: |---- ");
        carrinho.stream().forEach(produtoCarrinho -> System.out.println(produtoCarrinho.toString()));
        System.out.printf("TOTAL de Produtos: %s\n", carrinho.stream().map(Produto::getId).count());


//        List[] totalPrecos = new List[0];
//        carrinho.stream().forEach(produto -> produto.getPreco().add(totalPrecos));



        List<BigDecimal> listaPrecos = new ArrayList<>();
        carrinho.stream().forEach(produto -> listaPrecos.add(produto.getPreco()));
//        carrinho.stream().forEach(produto -> lista.add(produto.getPreco()));



        BigDecimal valorTotal = BigDecimal.valueOf(0);
        carrinho.stream().forEach(produto -> valorTotal.add(produto.getPreco()));
        System.out.println(valorTotal);

//        carrinho.forEach(produto -> { produto.getPreco().add((BigDecimal)lista).toString();});
//        System.out.println(lista.stream().count());
//
//
        System.out.printf("\tValor Total das Compras: %s\n", listaPrecos);

        System.out.println(listaPrecos.getClass());
        listaPrecos.forEach(System.out::println);


    }
}