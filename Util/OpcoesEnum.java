package br.com.americanas.polotech.ProOri.Projeto02.Util;

public enum OpcoesEnum {
    ADICIONAR(1), REMOVER(2), ALTERAR(3), VISUALIZAR(4);

    private  Integer codigoOpcao;
    OpcoesEnum(Integer codigoOpcao){
        this.codigoOpcao = codigoOpcao;
    }



}
