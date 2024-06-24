import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaPelicula consulta = new ConsultaPelicula();
        System.out.println("De qué película de Star Wars quieres la info? (1 - 7): ");

        try {
            var seleccionDelUsuario = Integer.valueOf(lectura.nextLine());
            Pelicula pelicula = consulta.buscaPelicula(seleccionDelUsuario);
            System.out.println(pelicula);
            GeneradorDeArchivo generador = new GeneradorDeArchivo();
            generador.guardarJson(pelicula);
        } catch (NumberFormatException e) {
            System.out.println("Número no encontrado " + e.getMessage());
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Aplicación finalizada.");
        }

    }
}
