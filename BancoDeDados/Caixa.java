package br.com.americanas.polotech.ProOri.Projeto02.BancoDeDados;

import br.com.americanas.polotech.ProOri.Projeto02.Produtos.Produto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Caixa {

    BigDecimal compra;
    BigDecimal contaUsuario;
    BigDecimal caixaRegistradora;
    BigDecimal carteira;

    public static List<Produto> caixa = new ArrayList<>();

    public Caixa(BigDecimal compra, BigDecimal contaUsuario, BigDecimal caixaRegistradora, BigDecimal carteira) {
        this.compra = compra;
        this.contaUsuario = contaUsuario;
        this.caixaRegistradora = caixaRegistradora;
        this.carteira = carteira;
    }

    public Caixa() {
    }

    public BigDecimal getCompra() {
        return compra;
    }

    public void setCompra(BigDecimal compra) {
        this.compra = compra;
    }

    public BigDecimal getContaUsuario() {
        return contaUsuario;
    }

    public void setContaUsuario(BigDecimal contaUsuario) {
        this.contaUsuario = contaUsuario;
    }

    public BigDecimal getCaixaRegistradora() {
        return caixaRegistradora;
    }

    public void setCaixaRegistradora(BigDecimal caixaRegistradora) {
        this.caixaRegistradora = caixaRegistradora;
    }

    public BigDecimal getCarteira() {
        return carteira;
    }

    public void setCarteira(BigDecimal carteira) {
        this.carteira = carteira;
    }

    public static List<Produto> getCaixa() {
        return caixa;
    }

    public static void setCaixa(List<Produto> caixa) {
        Caixa.caixa = caixa;
    }

    @Override
    public String toString() {
        return "Caixa{" +
                "compra=" + compra +
                ", contaUsuario=" + contaUsuario +
                ", caixaRegistradora=" + caixaRegistradora +
                ", carteira=" + carteira +
                '}';
    }


}
