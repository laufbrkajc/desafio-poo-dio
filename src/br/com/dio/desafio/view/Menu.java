package br.com.dio.desafio.view;

import java.util.Scanner;

public class Menu {
    public void MenuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        int escolha;

        System.out.println("Selecione uma ação:");
        System.out.println("   1) Adcionar Bootcamp.");
        System.out.println("   2) Adcionar Conteudo.");
        System.out.println("   3) Adcionar Curso.");
        System.out.println("   4) Adcionar Dev.");
        System.out.println("   5) Adcionar Mentoria.");
        System.out.println("   0) Sair.");
        escolha = scanner.nextInt();
    }

    public void adicionaBootcamp() {
    }

    public void adicionaConteudo() {
    }

    public void adicionaCurso() {
    }

    public void adicionaDev() {
    }

    public void adicionaMentoria() {
    }
}
