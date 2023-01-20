package br.com.americanas.polotech.ProOri.Projeto02;

import br.com.americanas.polotech.ProOri.Projeto02.BancoDeDados.Caixa;
import br.com.americanas.polotech.ProOri.Projeto02.BancoDeDados.Carrinho;
import br.com.americanas.polotech.ProOri.Projeto02.BancoDeDados.Estoque;
import br.com.americanas.polotech.ProOri.Projeto02.Produtos.Filme;
import br.com.americanas.polotech.ProOri.Projeto02.Produtos.Jogo;
import br.com.americanas.polotech.ProOri.Projeto02.Produtos.Musica;
import br.com.americanas.polotech.ProOri.Projeto02.Produtos.Produto;
import br.com.americanas.polotech.ProOri.Projeto02.Util.Menu;
import br.com.americanas.polotech.ProOri.Projeto02.Util.MusicaHelper;
import br.com.americanas.polotech.ProOri.Projeto02.Util.OpcoesEnum;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static br.com.americanas.polotech.ProOri.Projeto02.BancoDeDados.Estoque.estoqueLista;

public class Main {

    public static Integer contId = 0;


    static List<Musica> listaMusicas = new ArrayList<>();
        public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Boolean continuar = Boolean.TRUE;
        Estoque.carregarEstoque();
        Caixa.getCaixa();
        Menu.menu();

//        criar Produto e depois Filme no estoque ja passando os parametros
//        System.out.println("Listagem do estoque: ");
//        Produto.adicionarProdutoEstoque("Produto criado 1", BigDecimal.valueOf(45.8));
//        Produto.adicionarProdutoEstoque("Produto criado 2", BigDecimal.valueOf(377.98));
//
//
//        Filme.criarFilmeEstoque("Nome do filme", BigDecimal.valueOf(23.75), "Estudio Livre", "Diretor X", "Comedia", "Globo Filmes");
//        estoqueLista.forEach(produto -> System.out.println("Produto: "+produto.getNome()));

////      colocando os produtos da lista de estoque acima no caixa
//        Caixa.setCaixa(estoqueLista);
//        Caixa.caixa.forEach(produto -> System.out.printf("Preço do produto '%s' do caixa: R$ %s\n", produto.getNome(), produto.getPreco()));


////      colocar produto do indice 1 no carrinho
//        Carrinho meuCarrinho = new Carrinho();
//        meuCarrinho.colocarProdutoNoCarrinho(estoqueLista.get(1));
//        System.out.println("O Seu Carrinho tem: ");
//        meuCarrinho.getCarrinho().forEach(produto -> System.out.printf("Produto %s -> %s no valor de R$ %s.\n", produto.getClass(), produto.getNome(), produto.preco));
//
//        System.out.println("\nRemovendo produto...");
////        estoqueLista.remove(produtoNovo);
//        estoqueLista.remove(1);

//      criando produtos
//        Musica novoAlbum = new Musica();
//        novoAlbum.setNome("Titas Acustico");
//        novoAlbum.setId();
//        novoAlbum.setPreco(BigDecimal.valueOf(35.78));
//        novoAlbum.setMusicos("Arnaldo Antunes, Toni Beloto, Bla bla bla");
//        novoAlbum.setGenero("Pop Rock");
//        novoAlbum.setSelos("Som Livre");
//        estoqueLista.add(novoAlbum);
//
//        Produto.adicionarProdutoEstoque("Produto do Rappa", BigDecimal.valueOf(34.55));
//        Musica.adicionarProdutoEstoque("Album Rappa", BigDecimal.valueOf(34.55),"Varios", "Reggae", "Aurora Digital");

//        Produto novoAlbum2 = new Musica();
//        novoAlbum2.setId();
//        estoqueLista.add(novoAlbum2);
//
//        estoqueLista.forEach(produto -> System.out.println(produto.toString()));



//        System.out.println("\nAdicionando outro produto...");
//
//        Produto novoJogo = new Jogo();
//        novoJogo.setId();
//        novoJogo.setPreco(BigDecimal.valueOf(34.5));
//        estoqueLista.add(novoJogo);
//        estoqueLista.forEach(produto -> System.out.println(produto.toString()));


//        System.out.println("\nApagando....");
//        estoqueLista.remove(novoJogo);
//        estoqueLista.remove(0);
//        estoqueLista.forEach(produto -> System.out.println(produto.toString()));

//        System.out.println("\nClear... cancel");
//        estoqueLista.clear();
//        estoqueLista.forEach(produto -> System.out.println(produto.toString()));

//        Musica musica = new Musica();
//        System.out.println("Qual o nome do Album: ");
//        musica.setNome(sc.nextLine());
//        System.out.println("Musicos: ");
//        musica.setMusicos(sc.nextLine());
//        musica.setId();
//        System.out.printf("Seu id e: %s\n", musica.getId());
//        listaMusicas.add(musica);
//        estoqueLista.add(musica);


//        do {
//            Carrinho carrinho = new Carrinho();
//            carrinho.setCarrinho(estoqueLista);
//            System.out.println("Carrinho: ");
//            carrinho.getCarrinho().forEach(produto -> System.out.println(produto.toString()));
////            carrinho.carrinho.stream().map(Produto::getPreco).max(BigDecimal::compareTo);
//
////
//
//            System.out.println("Deseja adicionar outra musica? (S/N)\n");
//            String escolha = sc.next();
//            sc.nextLine();
//
//            if (escolha.equalsIgnoreCase("N")){
//                continuar = Boolean.FALSE;
//                return Boolean.FALSE;
//            }
//
//        }while (continuar);


//        Produto produto456 = new Produto();
//        produto456.adicionarProdutoEstoque("Batedeira Arno", BigDecimal.valueOf(34.6));
//        produto456.adicionarProdutoEstoque("Geladeira Brastemp", BigDecimal.valueOf(2534.99));

//        System.out.println("\nListagem sem filtro");
//        estoqueLista.forEach(produto -> System.out.println(produto.toString()));

//        System.out.println("\nListagem com if: ");
//        estoqueLista.forEach(produto -> {
//            if (produto.nome=="Teste"){
//                estoqueLista.remove(produto.getId().equals(357494));
//            }
////            System.out.println("Nome do filme: " + produto.getNome());
////            System.out.println("ID: " + produto.getId());
////            System.out.println("Preco: " + produto.getPreco());
////            System.out.println();
//            System.out.println(produto.toString());
//        });

//        System.out.println("\nEstoque Geral");
//        estoqueLista.forEach(produto -> System.out.println(produto.toString()));

//        System.out.println("\nLista de Albuns");
//        listaMusicas.forEach(produto -> System.out.println(produto.toString()));


//        System.out.println("\nAlterar nome na lista");
//        listaMusicas.get(1).setNome("Jre");
//        listaMusicas.forEach(produto -> System.out.println(produto.toString()));


//        System.out.println("\nTipos especificos no estoque:");

//        estoqueLista.forEach(produto -> estoqueLista.contains("Musica"));


//        Musica teste = musica.criarMusica(sc);
//        estoqueLista.add(new Musica(sc));

//        listaMusicas.add(MusicaHelper.construirMusica(sc));


//        OpcoesEnum opcao = OpcoesEnum.valueOf(String.valueOf(sc.nextInt()));
//        OpcoesEnum opcao2 = OpcoesEnum.valueOf(sc.nextLine());
//        switch (opcao){
//            case 1 -> {
//                System.out.println("adicionar");
//            }
//            case 2 -> {
//                System.out.println("Alterar");
//            }
//        }

    }
        public static Integer getContId(Integer contId){
            contId += 1;
            return Main.contId = contId;
        }

//        public static void removerMusica(Scanner sc){
//            System.out.println("Qual musica quer remover?");
//            sc.skip("((?<!\\R\\s)*)");
//            String nomeMusica = sc.nextLine();
//            System.out.println("Qual id?");
//            Integer id = sc.nextInt();
//            List<Musica> listaNome = listaMusicas.stream().filter(musica ->
//                    musica.getNome().equals(nomeMusica)).collect(Collectors.toList());
//
//            List<Musica> listaId = listaMusicas.stream().filter(musica ->
//                    musica.getNome().equals(id)).collect(Collectors.toList());
//
////            listaMusicas.stream().filter(musica -> {
////                return musica.getNome().equals(nomeMusica)
////            })
//
//            listaMusicas.removeAll(listaNome);
//        }
}
