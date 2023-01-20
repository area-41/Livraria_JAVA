package br.com.americanas.polotech.ProOri.Projeto02.Util;

public enum ProdutosEnum {

    MUSICA(1), BRINQUEDO(2), FILME(3), JOGO(4), LIVRO(5);

    private Integer codigoProduto;

    ProdutosEnum(Integer codigoProduto){
        this.codigoProduto = codigoProduto;
    }

}
