import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;
import br.com.dio.desafio.view.Menu;

import java.time.LocalDate;
import java.util.LinkedHashSet;

public class Main {
    public static void main(String[] args) {
        LinkedHashSet<Bootcamp> bootcamps = new LinkedHashSet<>();
        LinkedHashSet<Curso> cursos = new LinkedHashSet<>();
        LinkedHashSet<Dev> devs = new LinkedHashSet<>();
        LinkedHashSet<Mentoria> mentorias = new LinkedHashSet<>();

        Menu menu = new Menu(bootcamps, cursos, devs, mentorias);

        menu.MenuPrincipal();
    }
}
