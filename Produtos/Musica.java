package br.com.americanas.polotech.ProOri.Projeto02.Produtos;

import br.com.americanas.polotech.ProOri.Projeto02.BancoDeDados.Estoque;
import br.com.americanas.polotech.ProOri.Projeto02.Main;
import java.math.BigDecimal;
import java.util.Scanner;

public class Musica extends Produto {

    String musicos;
    String genero;
    String selos;

    public Musica() {
    }

    public String getMusicos() {
        return musicos;
    }
    public void setMusicos(String musicos) {
        this.musicos = musicos;
    }

    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSelos() {
        return selos;
    }
    public void setSelos(String selos) {
        this.selos = selos;
    }

    @Override
    public String toString() {
        return "Música {" +
                " ID = " + id + " " +
                "| nome = " + nome + " " +
                "| preço = R$ " + preco + " " +
                "| músicos = " + musicos + " " +
                "| gênero = " + genero + " " +
                "| selos = " + selos + " " +
                " }";
    }

    public Musica(String nome, BigDecimal preco, String musicos, String genero, String selos) {
        this.nome = nome;
        this.preco = preco;
        this.id = getId();
        this.musicos = musicos;
        this.genero = genero;
        this.selos = selos;
    }

    public static void adicionarMusicaEstoque(){
        Musica produtoNovo = new Musica();
        Main.sc = new Scanner(System.in);
        System.out.println("Digite o NOME do álbum de música: ");
        produtoNovo.setNome(Main.sc.nextLine());
        produtoNovo.setId();
        System.out.println("Digite o PREÇO do álbum: ");
        produtoNovo.setPreco(Main.sc.nextBigDecimal());
        Main.sc = new Scanner(System.in);
        System.out.println("Digite os MÚSICOS do álbum: ");
        produtoNovo.setMusicos(Main.sc.nextLine());
        System.out.println("Digite o GÊNERO do álbum: ");
        produtoNovo.setGenero(Main.sc.nextLine());
        System.out.println("Digite os SELOS do álbum: ");
        produtoNovo.setSelos(Main.sc.nextLine());

        Estoque.setEstoqueLista(produtoNovo);
        System.out.println(produtoNovo);
        System.out.println("Álbum de música adicionado!");
    }

    public static void adicionarMusicaEstoque(String nome, BigDecimal preco, String musicos, String genero, String selos){
        Musica produtoNovo = new Musica();
        produtoNovo.setNome(nome);
        produtoNovo.setId();
        produtoNovo.setPreco(preco);
        produtoNovo.setMusicos(musicos);
        produtoNovo.setGenero(genero);
        produtoNovo.setSelos(selos);
        Estoque.estoqueLista.add(produtoNovo);
    }

    public Musica criarMusica(Scanner sc){
        Musica musica = new Musica();
        this.nome = sc.nextLine();
        this.genero = sc.nextLine();
        this.id = getId();
        return musica;
    }

    public static void alterarMusicaEstoque(Integer id){
        Main.sc = new Scanner(System.in);
        System.out.println("O quê do Álbum? >>> NOME, PRECO, MUSICOS, GENERO, SELOS");
        String oQueAlterar = Main.sc.nextLine();
        oQueAlterar = oQueAlterar.replace("class br.com.americanas.polotech.ProOri.Projeto02.Produtos.","").toUpperCase();
        Musica.ParametrosEnum parametrosEnum = ParametrosEnum.valueOf(oQueAlterar);
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
            case MUSICOS -> {
                Main.sc = new Scanner(System.in);
                System.out.println("Qual(is) o(s) novo(s) MÚSICO(S)?");
                String musico = Main.sc.nextLine();
                ((Musica) Estoque.estoqueLista.get(id-1)).setMusicos(musico);
            }
            case GENERO -> {
                Main.sc = new Scanner(System.in);
                System.out.println("Qual o novo GÊNERO?");
                String genero = Main.sc.nextLine();
                ((Musica) Estoque.estoqueLista.get(id-1)).setGenero(genero);
            }
            case SELOS -> {
                Main.sc = new Scanner(System.in);
                System.out.println("Qual o novo SELO?");
                String selo = Main.sc.nextLine();
                ((Musica) Estoque.estoqueLista.get(id-1)).setSelos(selo);
            }
        }
        System.out.println("Álbum de Música alterado!");
        System.out.println(Estoque.estoqueLista.get(id-1).toString());
    }

    public enum ParametrosEnum{
        NOME, PRECO, MUSICOS, GENERO, SELOS
    }
}
