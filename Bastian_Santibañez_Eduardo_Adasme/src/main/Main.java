package main;

public class Main {

    public static void main(String[] args) {

        System.out.println("------------------------------------");
        System.out.println("Bienvenido al creador de planos");
        System.out.println("------------------------------------");
        System.out.println("Regla: todo lo que sea coordenada");
        System.out.println("tiene que ser separado por ");
        System.out.println("coma. Eje: 1,4");
        System.out.println("------------------------------------");

        Tablero t = new Tablero();

        t.crearTablero();
        t.mostrarTablero();
        t.ingresarGato();
        t.ingresarRaton();
        t.ingresarMueble();
    }

}
