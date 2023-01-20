package br.com.americanas.polotech.ProOri.Projeto02.Produtos;

import br.com.americanas.polotech.ProOri.Projeto02.BancoDeDados.Estoque;
import br.com.americanas.polotech.ProOri.Projeto02.Main;
import br.com.americanas.polotech.ProOri.Projeto02.Produtos.Produto;

import java.math.BigDecimal;
import java.util.Scanner;

public class Brinquedo extends Produto {

    String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Brinquedo {" +
                " ID = " + id + " " +
                "| nome = " + nome + " " +
                "| preço = R$ " + preco + " " +
                "| tipo = " + tipo + " " +
                 " }";
    }

    public static void adicionarBrinquedoEstoque(String nome, BigDecimal preco, String tipo) {
        Brinquedo produtoNovo = new Brinquedo();
        produtoNovo.setNome(nome);
        produtoNovo.setPreco(preco);
        produtoNovo.setId();
        produtoNovo.setTipo(tipo);
        Estoque.estoqueLista.add(produtoNovo);
    }

    public static void adicionarBrinquedoEstoque(){
        Brinquedo produtoNovo = new Brinquedo();
        Main.sc = new Scanner(System.in);
        System.out.println("Digite o NOME do brinquedo: ");
        produtoNovo.setNome(Main.sc.nextLine());
        produtoNovo.setId();
        System.out.println("Digite o PREÇO do brinquedo: ");
        produtoNovo.setPreco(Main.sc.nextBigDecimal());
        Main.sc = new Scanner(System.in);
        System.out.println("Digite o TIPO do brinquedo: ");
        produtoNovo.setTipo(Main.sc.nextLine());

        Estoque.setEstoqueLista(produtoNovo);
        System.out.println(produtoNovo);
        System.out.println("Brinquedo adicionado!");
    }

    public static void alterarBrinquedoEstoque(Integer id){
        Main.sc = new Scanner(System.in);
        System.out.println("O quê do Brinquedo? >>> NOME, PRECO, TIPO");
        String oQueAlterar = Main.sc.nextLine();
        oQueAlterar = oQueAlterar.replace("class br.com.americanas.polotech.ProOri.Projeto02.Produtos.","").toUpperCase();
        Brinquedo.ParametrosEnum parametrosEnum = Brinquedo.ParametrosEnum.valueOf(oQueAlterar);
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
            case TIPO -> {
                Main.sc = new Scanner(System.in);
                System.out.println("Qual o novo TIPO?");
                String tipo = Main.sc.nextLine();
                ((Brinquedo) Estoque.estoqueLista.get(id-1)).setTipo(tipo);
            }
        }
        System.out.println("Brinquedo alterado!");
        System.out.println(Estoque.estoqueLista.get(id-1).toString());
    }

    public enum ParametrosEnum{
        NOME, PRECO, TIPO
    }
}
