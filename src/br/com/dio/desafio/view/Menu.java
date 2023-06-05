package br.com.dio.desafio.view;

import java.util.Scanner;
import java.util.LinkedHashSet;
import java.time.LocalDate;

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
            System.out.println("");
            System.out.println("Selecione um grupo de acoes:");
            System.out.println("   1) Adicionar");
            System.out.println("   2) Exibir");
            System.out.println("   3) Excluir");
            System.out.println("   0) Sair");
            if (scanner.hasNextInt())
                escolha = Integer.parseInt(scanner.nextLine());

            if (escolha == 1) {
                System.out.println("");
                System.out.println("Selecione uma ação:");
                System.out.println("      1) Adicionar Bootcamp.");
                System.out.println("      2) Adicionar Curso.");
                System.out.println("      3) Adicionar Dev.");
                System.out.println("      4) Adicionar Mentoria.");
                System.out.println("      0) Sair");
                if (scanner.hasNextInt())
                    escolha = Integer.parseInt(scanner.nextLine());

            } else if (escolha == 2) {
                System.out.println("");
                System.out.println("Selecione uma ação:");
                System.out.println("      1) Exibir Bootcamp.");
                System.out.println("      2) Exibir Curso.");
                System.out.println("      3) Exibir Dev.");
                System.out.println("      4) Exibir Mentoria.");
                System.out.println("      0) Sair");
                if (scanner.hasNextInt())
                    escolha = Integer.parseInt(scanner.nextLine()) * 10;

            } else if (escolha == 3) {
                System.out.println("");
                System.out.println("Selecione uma ação:");
                System.out.println("      1) Excluir Bootcamp.");
                System.out.println("      2) Excluir Curso.");
                System.out.println("      3) Excluir Dev.");
                System.out.println("      4) Excluir Mentoria.");
                System.out.println("      0) Sair");
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
                    exibeBootcamps();
                    break;
                case 20:
                    exibeCursos();
                    break;
                case 30:
                    exibeDevs();
                    break;
                case 40:
                    exibeMentorias();
                    break;
                // case 100:
                //     excluiBootcamp();
                //     break;
                // case 200:
                //     excluiCurso();
                //     break;
                // case 300:
                //     excluiDev();
                //     break;
                // case 400:
                //     excluiMentoria();
                //     break;
                case 0:
                default:
                    return;
            }
        }
    }

    public void adicionaBootcamp() {
        Bootcamp bootcamp = new Bootcamp();
        String entrada;

        System.out.println("");
        System.out.print("Titulo do bootcamp? ");
        entrada = scanner.nextLine();
        bootcamp.setNome(entrada);
        System.out.print("Descricao do bootcamp? ");
        entrada = scanner.nextLine();
        bootcamp.setDescricao(entrada);
        System.out.print("Conteudos para o bootcamp? \n");
        System.out.print("   Titulos separados por virgula.\n");
        String[] possiveisCounteudos = scanner.nextLine().split(",");

        for (String tituloConteudo : possiveisCounteudos) {
            try {
                bootcamp.getConteudos().add(encontraConteudo(tituloConteudo));
            } catch (ItemNaoEncontradoException e) {
                System.out.println(e.getMessage());
            }
        }

        bootcamps.add(bootcamp);
    }

    public void adicionaCurso() {
        Curso curso = new Curso();
        String entrada;

        System.out.println("");
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

        System.out.println("");
        System.out.println("Nome do Dev? ");
        dev.setNome(scanner.nextLine());
        System.out.println("Conteudos para o Dev? (Separados por virgula)");
        entradas = scanner.nextLine().split(",");

        for (String nomeBootcamp : entradas) {
            try {
                dev.inscreverBootcamp(encontraBootcamp(nomeBootcamp));
            } catch (ItemNaoEncontradoException e) {
                System.out.println(e.getMessage());
            }
        }

        devs.add(dev);
    }

    public void adicionaMentoria() {
        Mentoria mentoria = new Mentoria();
        String entrada;

        System.out.println("");
        System.out.print("Titulo do mentoria? ");
        entrada = scanner.nextLine();
        mentoria.setTitulo(entrada);
        System.out.print("Descricao do mentoria? ");
        entrada = scanner.nextLine();
        mentoria.setDescricao(entrada);
        mentoria.setData(LocalDate.now());

        mentorias.add(mentoria);
    }

    public void exibeBootcamps() {
        System.out.println("");
        for (Bootcamp bb : bootcamps) {
            System.out.println(bb);
        }
    }

    public void exibeCursos() {
        System.out.println("");
        for (Curso cc : cursos) {
            System.out.println(cc);
        }
    }

    public void exibeDevs() {
        System.out.println("");
        for (Dev dd : devs) {
            System.out.println(dd);
        }
    }

    public void exibeMentorias() {
        System.out.println("");
        for (Mentoria mm : mentorias) {
            System.out.println(mm);
        }
    }

    public Conteudo encontraConteudo(String nome) throws ItemNaoEncontradoException {
        LinkedHashSet<Conteudo> conteudos = new LinkedHashSet<>();
        conteudos.addAll(cursos);
        conteudos.addAll(mentorias);

        for (Conteudo cc : conteudos) {
            if (cc.getTitulo().equals(nome)) {
                return cc;
            }
        }

        throw new ItemNaoEncontradoException(nome);
    }

    public Bootcamp encontraBootcamp(String nome) throws ItemNaoEncontradoException {
        for (Bootcamp bb : bootcamps) {
            if (bb.getNome().equals(nome)) {
                return bb;
            }
        }

        throw new ItemNaoEncontradoException(nome);
    }

    public Dev encontraDev(String nome) throws ItemNaoEncontradoException {
        for (Dev dd : devs) {
            if (dd.getNome().equals(nome)) {
                return dd;
            }
        }

        throw new ItemNaoEncontradoException(nome);
    }

    @Override
    protected void finalize() {
        this.scanner.close();
    }
}
