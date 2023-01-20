package br.com.americanas.polotech.ProOri.Projeto02.Produtos;

import br.com.americanas.polotech.ProOri.Projeto02.BancoDeDados.Estoque;
import br.com.americanas.polotech.ProOri.Projeto02.Main;

import java.math.BigDecimal;
import java.util.Scanner;

public class Filme extends Produto {

    String estudio;
    String diretor;
    String genero;
    String produtor;


    public Filme(String estudio, String diretor, String genero, String produtor) {
        this.estudio = estudio;
        this.diretor = diretor;
        this.genero = genero;
        this.produtor = produtor;
    }

    public Filme() {

    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getProdutor() {
        return produtor;
    }

    public void setProdutor(String produtor) {
        this.produtor = produtor;
    }


    @Override
    public String toString() {
        return "Filme {" +
                " ID = " + id + " " +
                "| nome = " + nome + " " +
                "| preço = R$ " + preco + " " +
                "| estúdio = " + estudio + " " +
                "| diretor = " + diretor + " " +
                "| gênero = " + genero + " " +
                "| produtor = " + produtor + " " +
                " }";
    }

    public static void adicionarFilmeEstoque(String nome, BigDecimal preco, String estudio, String diretor, String genero, String produtor) {
        Filme produtoNovo = new Filme();
        produtoNovo.setNome(nome);
        produtoNovo.setId();
        produtoNovo.setPreco(preco);
        produtoNovo.setDiretor(diretor);
        produtoNovo.setEstudio(estudio);
        produtoNovo.setGenero(genero);
        produtoNovo.setProdutor(produtor);
        Estoque.estoqueLista.add(produtoNovo);
    }

    public static void adicionarFilmeEstoque(){
        Filme produtoNovo = new Filme();
        Main.sc = new Scanner(System.in);
        System.out.println("Digite o NOME do filme: ");
        produtoNovo.setNome(Main.sc.nextLine());
        produtoNovo.setId();
        System.out.println("Digite o PREÇO do filme: ");
        produtoNovo.setPreco(Main.sc.nextBigDecimal());
        Main.sc = new Scanner(System.in);
        System.out.println("Digite o DIRETOR do filme: ");
        produtoNovo.setDiretor(Main.sc.nextLine());
        System.out.println("Digite o ESTÚDIO do filme: ");
        produtoNovo.setEstudio(Main.sc.nextLine());
        System.out.println("Digite o GÊNERO do filme: ");
        produtoNovo.setGenero(Main.sc.nextLine());
        System.out.println("Digite o PRODUTOR do filme: ");
        produtoNovo.setProdutor(Main.sc.nextLine());

        Estoque.setEstoqueLista(produtoNovo);
        System.out.println(produtoNovo);
        System.out.println("Filme adicionado!");
    }

    public static void alterarFilmeEstoque(Integer id){
        Main.sc = new Scanner(System.in);
        System.out.println("O quê do Filme? >>> NOME, PRECO, DIRETOR, ESTÚDIO, GÊNERO, PRODUTOR");
        String oQueAlterar = Main.sc.nextLine();
        oQueAlterar = oQueAlterar.replace("class br.com.americanas.polotech.ProOri.Projeto02.Produtos.","").toUpperCase();
        Filme.ParametrosEnum parametrosEnum = Filme.ParametrosEnum.valueOf(oQueAlterar);
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
            case DIRETOR -> {
                Main.sc = new Scanner(System.in);
                System.out.println("Qual o novo DIRETOR?");
                String diretor = Main.sc.nextLine();
                ((Filme) Estoque.estoqueLista.get(id-1)).setDiretor(diretor);
            }
            case ESTUDIO -> {
                Main.sc = new Scanner(System.in);
                System.out.println("Qual o novo ESTÚDIO?");
                String estudio = Main.sc.nextLine();
                ((Filme) Estoque.estoqueLista.get(id-1)).setEstudio(estudio);
            }
            case GENERO -> {
                Main.sc = new Scanner(System.in);
                System.out.println("Qual o novo GÊNERO?");
                String genero = Main.sc.nextLine();
                ((Filme) Estoque.estoqueLista.get(id-1)).setGenero(genero);
            }
            case PRODUTOR -> {
                Main.sc = new Scanner(System.in);
                System.out.println("Qual o novo PRODUTOR?");
                String produtor = Main.sc.nextLine();
                ((Filme) Estoque.estoqueLista.get(id-1)).setProdutor(produtor);
            }
        }
        System.out.println("Filme alterado!");
        System.out.println(Estoque.estoqueLista.get(id-1).toString());
    }

    public enum ParametrosEnum{
        NOME, PRECO, DIRETOR, ESTUDIO, GENERO, PRODUTOR
    }
}
