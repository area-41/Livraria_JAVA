package br.com.americanas.polotech.ProOri.Projeto02;

import br.com.americanas.polotech.ProOri.Projeto02.BancoDeDados.Caixa;
import br.com.americanas.polotech.ProOri.Projeto02.BancoDeDados.Estoque;
import br.com.americanas.polotech.ProOri.Projeto02.Util.Menu;

import java.util.Scanner;

public class Main {
    public static Integer contId = 0;
        public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Boolean continuar = Boolean.TRUE;
        Estoque.carregarEstoque();
        Caixa.getCaixa();
        Menu.menu();
    }
        public static Integer getContId(Integer contId){
            contId += 1;
            return Main.contId = contId;
        }
}