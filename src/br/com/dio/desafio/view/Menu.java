package br.com.dio.desafio.view;

import java.util.Scanner;
import java.util.LinkedHashSet;

import br.com.dio.desafio.dominio.*;

public class Menu {
    LinkedHashSet<Bootcamp> bootcamps;
    LinkedHashSet<Curso> cursos;
    LinkedHashSet<Dev> devs;
    LinkedHashSet<Mentoria> mentorias;
    Scanner scanner = new Scanner(System.in);

    public Menu(LinkedHashSet<Bootcamp> bootcamps, LinkedHashSet<Curso> cursos, LinkedHashSet<Dev> devs, LinkedHashSet<Mentoria> mentorias ) {
        this.bootcamps = bootcamps;
        this.cursos = cursos;
        this.devs = devs;
        this.mentorias = mentorias;
    }

    public void MenuPrincipal() {
        int escolha;

        while (true) {
            System.out.println("Selecione uma ação:");
            System.out.println("   1) Adcionar Bootcamp.");
            System.out.println("   2) Adcionar Curso.");
            System.out.println("   3) Adcionar Dev.");
            System.out.println("   4) Adcionar Mentoria.");
            System.out.println("   0) Sair.");
            escolha = Integer.parseInt(scanner.nextLine());

            switch (escolha) {
                case 1:
                    adicionaBootcamp();
                    break;
                case 2:
                    adicionaCurso();
                    break;
                case 3:
                    adicionaDev();
                    break;
                case 4:
                    adicionaMentoria();
                    break;
                case 0:
                    return;
                default:
                    return;
            }
        }
    }

    public void adicionaBootcamp() {
    }

    public void adicionaCurso() {
        Curso curso = new Curso();
        String entrada;

        System.out.print("Titulo do curso? ");
        entrada = scanner.nextLine();
        curso.setTitulo(entrada);
        System.out.print("Descricao do curso? ");
        entrada = scanner.nextLine();
        curso.setDescricao(entrada);
        System.out.print("Carga horaria do curso? ");
        entrada = scanner.nextLine();
        curso.setCargaHoraria(Integer.parseInt(entrada));

        cursos.add(curso);
    }

    public void adicionaDev() {
        Dev dev = new Dev();
        String[] entradas;

        System.out.println("Nome do Dev? ");
        dev.setNome(scanner.nextLine());
        System.out.println("Conteudos para o Dev? (Separados por virgula)");
        entradas = scanner.nextLine().split(",");

        for (String nomeBootcamp : entradas) {
            bootcamps
                .stream()
                .filter(b -> b.getNome().equals(nomeBootcamp))
                .forEach(b -> dev.inscreverBootcamp(b));
        }

        devs.add(dev);
    }

    public void adicionaMentoria() {
    }

    @Override
    protected void finalize() {
        this.scanner.close();
    }
}
