package main;

import java.util.Scanner;

public class Tablero {

    private int filas1, columnas1;
    private int area;
    private int MAXIMO = 20;
    private String[][] tablero;
    Scanner scan = new Scanner(System.in);

    public Tablero() {
    }

    public void crearTablero() {
        while (true) {
            try {

                System.out.print("Ingrese alto y ancho de la pieza: ");
                String separador = scan.nextLine();
                String[] cadena = separador.split(",");
                String filas = cadena[0];
                String columnas = cadena[1];
                filas1 = Integer.parseInt(filas);
                columnas1 = Integer.parseInt(columnas);
                if (filas1 <= MAXIMO && columnas1 <= MAXIMO) {
                    tablero = new String[filas1][columnas1];

                    for (int i = 0; i < tablero.length; i++) {
                        for (int j = 0; j < tablero[i].length; j++) {
                            tablero[i][j] = "  -";
                        }

                    }
                    area = filas1 * columnas1;
                    break;
                } else {
                    System.err.println("No se puede superar el maximo[" + MAXIMO + "]");
                }

            } catch (Exception e) {
                System.err.println("Ingrese dos numeros separados por una coma ");
            }

        }

    }

    public void mostrarTablero() {
        mostrarRayas();

        System.out.print("F/C ");
        int cont = 0;
        for (int i = 0; i < columnas1; i++) {
            if (cont < 10) {
                System.out.print("0" + cont + " ");
                cont++;
            } else {
                System.out.print(cont + " ");
                cont++;
            }

        }
        int num1 = 0;
        for (int i = 0; i < tablero.length; i++) {
            System.out.println("");
            for (int j = 0; j < tablero[i].length; j++) {
                if (j == 0) {
                    if (num1 < 10) {
                        System.out.print("0" + num1);
                        num1++;
                    } else {
                        System.out.print(num1);
                        num1++;
                    }

                }
                System.out.print(tablero[i][j]);
            }

        }
        System.out.println();
        mostrarRayas();
    }

    public void mostrarRayas() {

        for (int i = 0; i < columnas1; i++) {
            if (i == 0) {
                System.out.print("---");

            }
            System.out.print("---");

        }
        System.out.println();

    }

    public void ingresarGato() {

        double calcularP = Math.round(area * 10) / 100;
        int porcentaje_gato = (int) calcularP;
        System.out.println("Solo se pueden Ingresar" + "[" + porcentaje_gato + "] Gatos como Maximo");

        while (true) {
            try {
                int contGatos = 0;
                System.out.println("");
                System.out.print("Cantidad de gatos:");
                int numGatos = Integer.parseInt(scan.nextLine());
                if (numGatos < porcentaje_gato && numGatos >= 1) {
                    while (contGatos < numGatos) {
                        try {

                            System.out.println("");
                            System.out.println("---------");
                            System.out.println("Gato N° " + (contGatos + 1));
                            System.out.println("---------");
                            System.out.print("Ingrese Fila y columna: ");
                            String separadorg = scan.nextLine();
                            String[] cadenag = separadorg.split(",");
                            String gato1 = cadenag[0];
                            String gato2 = cadenag[1];
                            int gatof, gatoc;
                            gatof = Integer.parseInt(gato1);
                            gatoc = Integer.parseInt(gato2);
                            if (gatof <= filas1 && gatoc <= columnas1) {
                                tablero[gatof][gatoc] = "  G";
                                contGatos++;
                                mostrarTablero();
                            } else {
                                System.err.println("[ERROR] No se puede superar el maximo de la fila o columa");
                            }

                        } catch (Exception e) {
                            System.err.println("[ERROR] Ingrese 2 numeros separados por una coma ");
                        }

                    }
                    break;
                } else {
                    System.err.println("[ERROR] No se puede exceder el numero de gatos [" + porcentaje_gato + "]");
                    System.err.println("Tampoco ingrese numeros negativos");
                }
            } catch (Exception e) {
                System.err.println("[ERROR] Solo ingrese numeros ");
            }

        }

    }

    public void ingresarRaton() {

        double calcularR = Math.round(area * 25) / 100;
        int porcentaje_ratones = (int) calcularR;
        System.out.println("Solo se pueden Ingresar" + "[" + porcentaje_ratones + "] Ratones como Maximo");
        System.out.println("");
        while (true) {
            try {
                int conRatones = 0;
                System.out.print("Cantidad de ratones:");
                int numRatones = Integer.parseInt(scan.nextLine());
                if (numRatones < porcentaje_ratones && numRatones >= 1) {
                    while (conRatones < numRatones) {
                        try {
                            System.out.println("");
                            System.out.println("---------");
                            System.out.println("Raton N° " + (conRatones + 1));
                            System.out.println("---------");
                            System.out.print("Ingrese Fila y columna: ");
                            String separadorR = scan.nextLine();
                            String[] cadenaR = separadorR.split(",");
                            String raton1 = cadenaR[0];
                            String raton2 = cadenaR[1];
                            int ratonf, ratonc;
                            ratonf = Integer.parseInt(raton1);
                            ratonc = Integer.parseInt(raton2);
                            if (tablero[ratonf][ratonc] != "  G") {
                                if (ratonf <= filas1 && ratonc <= columnas1) {

                                    tablero[ratonf][ratonc] = "  R";

                                    conRatones++;
                                    mostrarTablero();
                                } else {
                                    System.err.println("[ERROR] No se puede superar el maximo de la fila o columa");

                                }
                            } else {
                                System.err.println("[ERROR] no se puede colocar un raton encima de[G" + "(" + ratonf + " ," + ratonc + ")" + "]");
                            }

                        } catch (Exception e) {
                            System.err.println("[ERROR] Ingrese 2 numeros separados por una coma ");
                        }

                    }

                    System.out.println("");
                    break;

                } else {
                    System.err.println("[ERROR] No se puede exceder el numero de Ratones [" + porcentaje_ratones + "]");
                    System.err.println("Tampoco ingrese numeros negativos");
                }

            } catch (Exception e) {
                System.err.println("[ERROR] Solo ingrese numeros ");
            }

        }
    }
    ////////////MUEBLES

    public void ingresarMueble() {
        int y1, y2;
        int x1, x2;
        int contMuebles = 0;
        int numMuebles;
        while (true) {
            try {
                System.out.print("N° de muebles:");
                numMuebles = Integer.parseInt(scan.nextLine());
                while (contMuebles < numMuebles) {
                    try {
                        while (true) {
                            System.out.println("------------");
                            System.out.println("Mueble N° " + (contMuebles + 1));
                            System.out.println("------------");
                            System.out.print("Ingrese fila y columna separada por un espacio: ");
                            String separadorM = scan.nextLine();
                            String[] cadenaM = separadorM.split(",");
                            String mueble1 = cadenaM[0];
                            String mueble2 = cadenaM[1];
                            x2 = Integer.parseInt(mueble1);
                            x1 = Integer.parseInt(mueble2);
                            if (x1 <= filas1 && x2 <= columnas1 && tablero[x1][x2] != "  G" && tablero[x1][x2] != "  R") {
                                tablero[x2][x1] = "  x";

                                mostrarTablero();
                                System.out.print("Ingrese fila y columna separada por un espacio: ");
                                String separadorM2 = scan.nextLine();
                                String[] cadenaM2 = separadorM2.split(",");
                                String mueble3 = cadenaM2[0];
                                String mueble4 = cadenaM2[1];

                                y2 = Integer.parseInt(mueble3);
                                y1 = Integer.parseInt(mueble4);
                                if (y1 <= filas1 && y2 <= columnas1 && tablero[y1][y2] != "  G" && tablero[y1][y2] != "  R") {
                                    tablero[y2][y1] = "  x";

                                    mostrarTablero();
                                    int opProc;
                                    System.out.print("Proceder?: ");
                                    System.out.println();
                                    System.out.println("1.-SI");
                                    System.out.println("2.-NO");
                                    opProc = Integer.parseInt(scan.nextLine());

                                    if (opProc == 1) {

                                        for (int i = 0; i < tablero.length; i++) {
                                            for (int j = 0; j < tablero[i].length; j++) {
                                                if (i >= x1 && j >= x2 && j <= y1 && i <= y2) {
                                                    tablero[i][j] = "  M";
//                                                    if (tablero[i][j] == ("  G") || tablero[i][j] == ("  R")){
//                                                        for (int k = 0; k < tablero.length; k++) {
//                                                            for (int l = 0; l < tablero[i].length; l++) {
//                                                                if (k >= x1 && l >= x2 && l <= y1 && k <= y2){
//                                                                    tablero[i][j] = "  -";
//                                                                }
//                                                            }
//                                                        }
//                                                        contMuebles--;
//                                                        break etiqueta;
//                                                    }

                                                }
                                            }

                                        }
                                        mostrarTablero();
                                        contMuebles++;
                                        if (contMuebles == numMuebles) {

                                            break;
                                        }

                                    } else {
                                        tablero[y1][y2] = "  -";
                                        tablero[x1][x2] = "  -";
                                        mostrarTablero();

                                    }

                                } else {
                                    System.err.println("[ERROR] no se puede colocar el mueble encima de[" + "(" + x1 + " ," + x2 + ")" + "]");
                                }

                            } else {
                                System.err.println("[ERROR] no se puede colocar el mueble encima de[" + "(" + x1 + " ," + x2 + ")" + "]");
                            }
                        }

                    } catch (Exception e) {
                        System.err.println("Ingrese dos numeros separados por una coma");
                    }

                }
                break;

            } catch (Exception e) {
                System.err.println("[ERROR] ingrese un numero valido");
            }

        }

    }

}
