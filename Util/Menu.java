package br.com.americanas.polotech.ProOri.Projeto02.Util;

import br.com.americanas.polotech.ProOri.Projeto02.BancoDeDados.Carrinho;
import br.com.americanas.polotech.ProOri.Projeto02.BancoDeDados.Estoque;
import br.com.americanas.polotech.ProOri.Projeto02.Main;
import br.com.americanas.polotech.ProOri.Projeto02.Produtos.*;
import br.com.americanas.polotech.ProOri.Projeto02.Produtos.Musica;
import java.util.Scanner;

public class Menu {

    public Menu(){
    }

    public static void menu(){
        String[] menu = {"Sair", "Adicionar Produto ao Estoque", "Remover", "Alterar", "Ver Estoque", "Ver Estoque Individual",
                "Ver Carrinho", "Adicionar Produto ao Carrinho", "Remover produto do Carrinho", "Pagar"};
        Boolean chave = Boolean.TRUE;
        letreiro();
        while (chave) {
            System.out.println("Digite uma das opções: \n\t");
            for (int i = 0; i < menu.length; i++) {
                System.out.printf("[%d] - %s%n", i, menu[i]);
            }
            try {
                Scanner scMenu = new Scanner(System.in);
                int value = scMenu.nextInt();
                switch (value) {
                    case 0 -> {
                        System.out.println("Sair\nObrigado e até breve!!!\nConfira nossas ofertas no site. www.ofertasloja.com.br");
                        chave = Boolean.FALSE;
                    }
                    case 1-> {
                        System.out.println("--Adicionar produto ao Estoque--");
                        menuProduto();
                    }
                    case 2 -> {
                        System.out.println("--Remover--");
                        Produto.removerProdutoEstoque();
                    }
                    case 3 -> {
                        System.out.println("--Alterar--");
                        Produto.alterarProdutoEstoque();
                    }
                    case 4 -> {
                        System.out.println("--Ver Estoque--");
                        Estoque.getEstoqueLista();
                    }
                    case 5 -> {
                        System.out.println("--Estoque Individual--");
                        Estoque.getEstoqueListaIndividual();
                    }
                    case 6 -> {
                        System.out.println("--Carrinho Lista--");
                        Carrinho.verCarrinho();
                    }
                    case 7 -> {
                        System.out.println("--Adicionar Produto ao Carrinho--");
                        Carrinho.colocarProdutoNoCarrinho();
                    }
                    case 8 -> {
                        System.out.println("--Remover Produto do Carrinho--");
                        Carrinho.removerProdutoDoCarrinho();
                    }
                    case 9 -> {
                        System.out.println("--Ir ao Caixa e Pagar--");
                        Carrinho.pagar();
                    }
                    default -> System.out.println("Opção numérica inválida");
                }
            } catch (RuntimeException e) {
                System.out.println("Valor inválido! ->" + e.getMessage());
            } finally {
                System.out.println("------------");
            }
        }
    }

        public static void menuProduto(){
            System.out.println("Qual Produto >>> MUSICA, BRINQUEDO, FILME, JOGO, LIVRO");
            ProdutosEnum opcao = ProdutosEnum.valueOf(Main.sc.nextLine().toUpperCase());
            switch (opcao) {
                case MUSICA -> {
                    Musica.adicionarMusicaEstoque();
                }case BRINQUEDO -> {
                    Brinquedo.adicionarBrinquedoEstoque();
                }case FILME -> {
                    Filme.adicionarFilmeEstoque();
                }case JOGO -> {
                    Jogo.adicionarJogoEstoque();
                }case LIVRO -> {
                    Livro.adicionarLivroEstoque();
                }default -> {
                    System.out.println("Valor inválido, tente novamente.");
                }
            }
        }
    public static void letreiro(){
        System.out.println("Olá, essa é a Livraria Polo Tech 925!\nComo posso te ajudar?\n");
    }
}
