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
        int escolha = 0;

        while (true) {
            System.out.println("Selecione um grupo de acoes:");
            System.out.println("   1) Adicionar");
            System.out.println("   2) Exibir");
            System.out.println("   3) Excluir");
            System.out.println("   0) Sair.");
            if (scanner.hasNextInt())
                escolha = Integer.parseInt(scanner.nextLine());

            if (escolha == 1) {
                System.out.println("Selecione uma ação:");
                System.out.println("      1) Adicionar Bootcamp.");
                System.out.println("      2) Adicionar Curso.");
                System.out.println("      3) Adicionar Dev.");
                System.out.println("      4) Adicionar Mentoria.");
                System.out.println("      0) Sair.");
                if (scanner.hasNextInt())
                    escolha = Integer.parseInt(scanner.nextLine());

            } else if (escolha == 2) {
                System.out.println("Selecione uma ação:");
                System.out.println("      1) Exibir Bootcamp.");
                System.out.println("      2) Exibir Curso.");
                System.out.println("      3) Exibir Dev.");
                System.out.println("      4) Exibir Mentoria.");
                System.out.println("      0) Sair.");
                if (scanner.hasNextInt())
                    escolha = Integer.parseInt(scanner.nextLine()) * 10;

            } else if (escolha == 3) {
                System.out.println("Selecione uma ação:");
                System.out.println("      1) Excluir Bootcamp.");
                System.out.println("      2) Excluir Curso.");
                System.out.println("      3) Excluir Dev.");
                System.out.println("      4) Excluir Mentoria.");
                System.out.println("      0) Sair.");
                if (scanner.hasNextInt())
                    escolha = Integer.parseInt(scanner.nextLine()) * 100;
            }

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
                case 10:
                    exibeBootcamp();
                    break;
                case 20:
                    exibeCurso();
                    break;
                case 30:
                    exibeDev();
                    break;
                case 40:
                    exibeMentoria();
                    break;
                case 100:
                    excluiBootcamp();
                    break;
                case 200:
                    excluiCurso();
                    break;
                case 300:
                    excluiDev();
                    break;
                case 400:
                    excluiMentoria();
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

        if (scanner.hasNextInt()) {
            entrada = scanner.nextLine();
            curso.setCargaHoraria(Integer.parseInt(entrada));
        }

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
