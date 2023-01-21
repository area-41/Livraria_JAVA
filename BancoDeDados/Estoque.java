package br.com.americanas.polotech.ProOri.Projeto02.BancoDeDados;

import br.com.americanas.polotech.ProOri.Projeto02.Main;
import br.com.americanas.polotech.ProOri.Projeto02.Produtos.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Estoque {

    public static List<Produto> estoqueLista = new ArrayList<>();

    public static List<Produto> getEstoqueLista() {
        estoqueLista.forEach(produto -> System.out.println(produto.toString()));
        return estoqueLista;
    }

    public static List getEstoqueListaIndividual() {
        System.out.println("Qual o NOME produto para listar?");
        String novoNome = Main.sc.nextLine();

        List<Produto> listaNome = Estoque.estoqueLista.stream().filter(produtoLista ->
                produtoLista.getNome().equals(novoNome)).collect(Collectors.toList());

        listaNome.stream().forEach(produto -> System.out.println(produto.toString()));

        System.out.printf("\tTOTAL de Produtos: %s\n", listaNome.stream().map(Produto::getId).count());
        return estoqueLista;
    }

    public static void setEstoqueLista(List<Produto> estoqueLista) {
        Estoque.estoqueLista = estoqueLista;
    }

    public static void setEstoqueLista(Produto produto){
        Estoque.estoqueLista.add(produto);
    }

    public static void carregarEstoque() {
//        estoqueLista.add(new Musica("Construção", BigDecimal.valueOf(34.65), "Chico Buarque", "MPB", "Selos internacionais"));
        Musica.adicionarMusicaEstoque("Epitáfio", BigDecimal.valueOf(30.50), "Titãs", "rock", "Som Livre");
        Livro.adicionarLivroEstoque("Frankenstein", BigDecimal.valueOf(34.5),"Mary Shelley", "Ficção Científica", "Editora Nova");
        Brinquedo.adicionarBrinquedoEstoque("PlayMobil", BigDecimal.valueOf(69.99), "Boneco");
        Livro.adicionarLivroEstoque("Frankenstein", BigDecimal.valueOf(34.5),"Mary Shelley", "Ficção Científica", "Editora Nova");
        Musica.adicionarMusicaEstoque("Construção", BigDecimal.valueOf(34.65), "Chico Buarque", "MPB", "Selos internacionais");
        Brinquedo.adicionarBrinquedoEstoque("Pião", BigDecimal.valueOf(9.80), "Brinquedo manual");
        Livro.adicionarLivroEstoque("Dom Quixote", BigDecimal.valueOf(78.50), "Miguel de Cervantes", "Aventura", "Nova Cultura");
        Musica.adicionarMusicaEstoque("Malandro é Malandro e Mané é Mané", BigDecimal.valueOf(39.35), "Bezerra da Silva", "Samba", "Samba Raiz");
        Musica.adicionarMusicaEstoque("Como Nossos Pais", BigDecimal.valueOf(29.99), "Elis Regina", "MPB", "As melhores Nacionais");
        Jogo.adicionarJogoEstoque("Barbie", BigDecimal.valueOf(237.65), "Fofa Jogos", "Social Life", "Pequenas Belezas");
        Livro.adicionarLivroEstoque("Dom Quixote", BigDecimal.valueOf(78.50), "Miguel de Cervantes", "Aventura", "Nova Cultura");
        Brinquedo.adicionarBrinquedoEstoque("Forte Apache", BigDecimal.valueOf(245.99), "Boneco");
        Musica.adicionarMusicaEstoque("Malandro é Malandro e Mané é Mané", BigDecimal.valueOf(39.35), "Bezerra da Silva", "Samba", "Samba Raiz");
        Brinquedo.adicionarBrinquedoEstoque("Creide", BigDecimal.valueOf(99.80), "Boneca Star");
        Jogo.adicionarJogoEstoque("Combat War", BigDecimal.valueOf(237.65), "RockStar Games", "PVP", "Art e Design");
        Filme.adicionarFilmeEstoque("E o vento derrubou tudo", BigDecimal.valueOf(33.33), "Estudio Caseiro", "Tio da Banca", "True Story", "Produzim");
    }
}
