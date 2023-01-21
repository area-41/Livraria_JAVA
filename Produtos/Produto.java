package br.com.americanas.polotech.ProOri.Projeto02.Produtos;

import br.com.americanas.polotech.ProOri.Projeto02.BancoDeDados.Caixa;
import br.com.americanas.polotech.ProOri.Projeto02.BancoDeDados.Estoque;
import br.com.americanas.polotech.ProOri.Projeto02.Main;
import br.com.americanas.polotech.ProOri.Projeto02.Util.ProdutosEnum;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Produto {
    public String nome;
    Integer id;
    public BigDecimal preco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId() {
        this.id = Main.getContId(Main.contId);
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Produto() {
    }
    @Override
    public String toString() {
        return "Produto {" +
                " ID = " + id + " " +
                "| nome = " + nome + " " +
                "| preço = R$ " + preco + " " +
                " }";
    }

    public static void adicionarProdutoEstoque(String nome, BigDecimal preco){
        Produto produtoNovo = new Produto();
        produtoNovo.setNome(nome);
        produtoNovo.setId();
        produtoNovo.setPreco(preco);
        Estoque.estoqueLista.add(produtoNovo);
    }

    public static void adicionarProdutoEstoque(){
        Produto produtoNovo = new Produto();
        Main.sc = new Scanner(System.in);
        System.out.println("Digite o NOME do produto: ");
        produtoNovo.setNome(Main.sc.nextLine());
        produtoNovo.setId();
        System.out.println("Digite o PREÇO do produto: ");
        produtoNovo.setPreco(Main.sc.nextBigDecimal());
        Estoque.setEstoqueLista(produtoNovo);
        System.out.println(produtoNovo);
        System.out.println("Produto adicionado!");
    }

    public void criarProduto() {
        Produto produto = new Produto();
        produto.criarProduto();
    }

    public static void removerProdutoEstoque(Produto produto) {
    }

    public static void removerProdutoEstoque() {
        Main.sc = new Scanner(System.in);
        System.out.println("\tDigite [1] se deseja remover pelo NOME\n\te [2] para remover pelo ID do produto.");
        short escolha = Main.sc.nextShort();
        switch (escolha){
            case 1 -> {
                Main.sc = new Scanner(System.in);
                System.out.println("Qual o NOME do produto para remover?");
                String produtoParaRemover = Main.sc.nextLine();
                List<Produto> listaNome = Estoque.estoqueLista.stream().filter(produtoLista ->
                        produtoLista.getNome().equals(produtoParaRemover)).collect(Collectors.toList());

                Estoque.estoqueLista.removeAll(listaNome);
            }
            case 2 -> {
                System.out.println("Qual o ID do produto para remover?");
                Integer id = Main.sc.nextInt();

                List<Produto> listaId = Estoque.estoqueLista.stream().filter(produtoLista ->
                        produtoLista.id.equals(id)).collect(Collectors.toList());

                Estoque.estoqueLista.removeAll(listaId);
            }
        }
    }

    public static void alterarProdutoEstoque() {
        System.out.println("Qual o ID do produto para alterar?");
        Integer id = Main.sc.nextInt();
        String tipoEscolhido = String.valueOf(Estoque.estoqueLista.get(id-1).getClass());
        System.out.println(Estoque.estoqueLista.get(id-1).toString());
        tipoEscolhido = tipoEscolhido.replace("class br.com.americanas.polotech.ProOri.Projeto02.Produtos.","").toUpperCase();

        ProdutosEnum produtosEnum = ProdutosEnum.valueOf(tipoEscolhido);
        System.out.println(produtosEnum);
        switch (produtosEnum){
            case MUSICA -> {
                Musica.alterarMusicaEstoque(id);
            }
            case FILME -> {
                Filme.alterarFilmeEstoque(id);
            }
            case JOGO -> {
                Jogo.alterarJogoEstoque(id);
            }
            case BRINQUEDO -> {
                Brinquedo.alterarBrinquedoEstoque(id);
            }
            case LIVRO -> {
                Livro.alterarLivroEstoque(id);
            }
        }
    }
    public static void adicionarProdutoCaixa(Produto produto){
        Caixa.caixa.add(produto);
    }
}
