package br.com.americanas.polotech.ProOri.Projeto02.Produtos;

import br.com.americanas.polotech.ProOri.Projeto02.BancoDeDados.Estoque;
import br.com.americanas.polotech.ProOri.Projeto02.Main;
import br.com.americanas.polotech.ProOri.Projeto02.Produtos.Produto;

import java.math.BigDecimal;
import java.util.Scanner;

public class Jogo extends Produto {

    String distribuidora;
    String genero;
    String estudio;

    public String getDistribuidora() {
        return distribuidora;
    }

    public void setDistribuidora(String distribuidora) {
        this.distribuidora = distribuidora;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    @Override
    public String toString() {
        return "Jogo {" +
                " ID = " + id + " " +
                "| nome = " + nome + " " +
                "| preço = R$ " + preco + " " +
                "| distribuidora = " + distribuidora + " " +
                "| gênero = " + genero + " " +
                "| estúdio = " + estudio + " " +
                " }";
    }

    public static void adicionarJogoEstoque(String nome, BigDecimal preco, String distribuidora, String genero, String estudio){
        Jogo produtoNovo = new Jogo();
        produtoNovo.setNome(nome);
        produtoNovo.setId();
        produtoNovo.setPreco(preco);
        produtoNovo.setDistribuidora(distribuidora);
        produtoNovo.setGenero(genero);
        produtoNovo.setEstudio(estudio);
        Estoque.estoqueLista.add(produtoNovo);
    }

    public static void adicionarJogoEstoque(){
        Jogo produtoNovo = new Jogo();
        Main.sc = new Scanner(System.in);
        System.out.println("Digite o NOME do jogo: ");
        produtoNovo.setNome(Main.sc.nextLine());
        produtoNovo.setId();
        System.out.println("Digite o PREÇO do jogo: ");
        produtoNovo.setPreco(Main.sc.nextBigDecimal());
        Main.sc = new Scanner(System.in);
        System.out.println("Digite a DISTRIBUIDORA do jogo: ");
        produtoNovo.setDistribuidora(Main.sc.nextLine());
        System.out.println("Digite o GÊNERO do jogo: ");
        produtoNovo.setGenero(Main.sc.nextLine());
        System.out.println("Digite o ESTÚDIO do jogo: ");
        produtoNovo.setEstudio(Main.sc.nextLine());

        Estoque.setEstoqueLista(produtoNovo);
        System.out.println(produtoNovo);
        System.out.println("Jogo adicionado!");
    }

    public static void alterarJogoEstoque(Integer id){
        Main.sc = new Scanner(System.in);
        System.out.println("O quê do Jogo? >>> NOME, PRECO, DISTRIBUIDORA, GENERO, ESTUDIO");
        String oQueAlterar = Main.sc.nextLine();
        oQueAlterar = oQueAlterar.replace("class br.com.americanas.polotech.ProOri.Projeto02.Produtos.","").toUpperCase();
        Jogo.ParametrosEnum parametrosEnum = Jogo.ParametrosEnum.valueOf(oQueAlterar);
        switch (parametrosEnum){
            case NOME -> {
                Main.sc = new Scanner(System.in);
                System.out.println("Qual o novo NOME?");
                String nome = Main.sc.nextLine();
                Estoque.estoqueLista.get(id-1).setNome(nome);
            }
            case PRECO -> {
                Main.sc = new Scanner(System.in);
                System.out.println("Qual o novo PREÇO?");
                BigDecimal preco = Main.sc.nextBigDecimal();
                Estoque.estoqueLista.get(id-1).setPreco(preco);
            }
            case DISTRIBUIDORA -> {
                Main.sc = new Scanner(System.in);
                System.out.println("Qual(is) a(s) nova(s) DISTRIBUIDORA(S)?");
                String distribuidora = Main.sc.nextLine();
                ((Jogo) Estoque.estoqueLista.get(id-1)).setDistribuidora(distribuidora);
            }
            case GENERO -> {
                Main.sc = new Scanner(System.in);
                System.out.println("Qual o novo GÊNERO?");
                String genero = Main.sc.nextLine();
                ((Jogo) Estoque.estoqueLista.get(id-1)).setGenero(genero);
            }
            case ESTUDIO -> {
                Main.sc = new Scanner(System.in);
                System.out.println("Qual o novo ESTÚDIO?");
                String estudio = Main.sc.nextLine();
                ((Jogo) Estoque.estoqueLista.get(id-1)).setEstudio(estudio);
            }
        }
        System.out.println("Jogo alterado!");
        System.out.println(Estoque.estoqueLista.get(id-1).toString());
    }

    public enum ParametrosEnum{
        NOME, PRECO, DISTRIBUIDORA, GENERO, ESTUDIO
    }
}
