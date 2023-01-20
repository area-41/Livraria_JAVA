package br.com.americanas.polotech.ProOri.Projeto02.Produtos;

import br.com.americanas.polotech.ProOri.Projeto02.BancoDeDados.Estoque;
import br.com.americanas.polotech.ProOri.Projeto02.Main;
import br.com.americanas.polotech.ProOri.Projeto02.Produtos.Produto;

import java.math.BigDecimal;
import java.util.Scanner;

public class Livro extends Produto {

    String genero;
    String escritor;
    String editora;

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEscritor() {
        return escritor;
    }

    public void setEscritor(String escritor) {
        this.escritor = escritor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    @Override
    public String toString() {
        return "Livro {" +
                " ID = " + id + " " +
                "| nome = " + nome + " " +
                "| preço = R$ " + preco + " " +
                "| gênero = " + genero + " " +
                "| escritor = " + escritor + " " +
                "| editora = " + editora + " " +
                " }";
    }

    public static void adicionarLivroEstoque(String nome, BigDecimal preco, String escritor, String genero, String editora){
        Livro produtoNovo = new Livro();
        produtoNovo.setNome(nome);
        produtoNovo.setId();
        produtoNovo.setPreco(preco);
        produtoNovo.setGenero(genero);
        produtoNovo.setEscritor(escritor);
        produtoNovo.setEditora(editora);
        Estoque.estoqueLista.add(produtoNovo);
    }

    public static void adicionarLivroEstoque(){
        Livro produtoNovo = new Livro();
        Main.sc = new Scanner(System.in);
        System.out.println("Digite o NOME do livro: ");
        produtoNovo.setNome(Main.sc.nextLine());
        produtoNovo.setId();
        System.out.println("Digite o PREÇO do livro: ");
        produtoNovo.setPreco(Main.sc.nextBigDecimal());
        Main.sc = new Scanner(System.in);
        System.out.println("Digite o ESCRITOR do livro: ");
        produtoNovo.setEscritor(Main.sc.nextLine());
        System.out.println("Digite o GÊNERO do livro: ");
        produtoNovo.setGenero(Main.sc.nextLine());
        System.out.println("Digite a EDITORA do livro: ");
        produtoNovo.setEditora(Main.sc.nextLine());

        Estoque.setEstoqueLista(produtoNovo);
        System.out.println(produtoNovo);
        System.out.println("Livro adicionado!");
    }

    public static void alterarLivroEstoque(Integer id){
        Main.sc = new Scanner(System.in);
        System.out.println("O quê do Livro? >>> NOME, PRECO, ESCRITOR, GENERO, EDITORA");
        String oQueAlterar = Main.sc.nextLine();
        oQueAlterar = oQueAlterar.replace("class br.com.americanas.polotech.ProOri.Projeto02.Produtos.","").toUpperCase();
        Livro.ParametrosEnum parametrosEnum = Livro.ParametrosEnum.valueOf(oQueAlterar);
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
            case ESCRITOR -> {
                Main.sc = new Scanner(System.in);
                System.out.println("Qual(is) o(s) novo(s) ESCRITOR(ES)?");
                String escritor = Main.sc.nextLine();
                ((Livro) Estoque.estoqueLista.get(id-1)).setEscritor(escritor);
            }
            case GENERO -> {
                Main.sc = new Scanner(System.in);
                System.out.println("Qual o novo GÊNERO?");
                String genero = Main.sc.nextLine();
                ((Livro) Estoque.estoqueLista.get(id-1)).setGenero(genero);
            }
            case EDITORA -> {
                Main.sc = new Scanner(System.in);
                System.out.println("Qual a nova EDITORA?");
                String editora = Main.sc.nextLine();
                ((Livro) Estoque.estoqueLista.get(id-1)).setEditora(editora);
            }
        }
        System.out.println("Livro alterado!");
        System.out.println(Estoque.estoqueLista.get(id-1).toString());
    }

    public enum ParametrosEnum{
        NOME, PRECO, ESCRITOR, GENERO, EDITORA
    }

}
