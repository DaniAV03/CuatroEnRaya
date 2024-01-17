package org.iesalandalus.programacion.cuatroenraya.modelo;

public class Tablero {
    public static int FILAS = 6;
    public static  int COLUMNAS = 7;
    public static  int FICHAS_IGUALES_CONSECUTIVAS_NECESARIAS = 4;

    private Casilla[][] casillas = new Casilla[FILAS][COLUMNAS];

    public Tablero() {
        inicializarTablero();
    }
    private void inicializarTablero() {
        for (int fila = 0; fila < FILAS; fila++) {
            for (int columna = 0; columna < COLUMNAS; columna++) {
                casillas[fila][columna] = new Casilla();
            }
        }
    }

    public boolean estaVacio() {

    }

    private boolean columnaVacia(int columna) {

    }

    public boolean estaLleno() {

    }

    private boolean columnaLlena(int columna) {

    }

    public boolean introducirFicha(int columna, Ficha ficha) {
        for (int fila = 0; fila < filas; fila++) {
            if (tablero[fila][columna] == Ficha.VACIO) {
                tablero[fila][columna] = ficha;
                return comprobarTirada(fila, columna, ficha);
            }
        }
        throw new IllegalArgumentException("Columna llena");
    }

    private boolean comprobarFicha(Ficha ficha) {

    }

    private int getPrimeraFilaVacia(int columna) {

    }

    private boolean comprobarTirada(int fila, int columna, Ficha ficha) {
        return comprobarHorizontal(fila, columna, ficha) || comprobarVertical(columna, ficha) || comprobarDiagonalNE(fila, columna, ficha) || comprobarDiagonalNO(fila, columna, ficha);
    }

    private boolean objetivoAlcanzado(int fichasIgualesConsecutivas) {

    }

    private boolean comprobarHorizontal(int fila, Ficha ficha) {

    }


    private boolean comprobarVertical(int columna, Ficha ficha) {
        int contador = 0;
        for (int fila = 0; fila < filas; fila++) {
            if (tablero[fila][columna] == ficha) {
                contador++;
            } else {
                contador = 0;
            }
            if (contador == 4) {
                return true;
            }
        }
        return false;
    }
    private boolean comprobarDiagonalNE(int fila, int columna, Ficha ficha) {
        int contador = 0;
        int desplazamiento = menor(fila, columna);
        for (int i = desplazamiento; i >= 0; i--) {
            if (tablero[fila - i][columna - i] == ficha) {
                contador++;
            } else {
                contador = 0;
            }
            if (contador == 4) {
                return true;
            }
        }
        return false;
    }
    private boolean comprobarDiagonalNO(int fila, int columna, Ficha ficha) {
        int contador = 0;
        int desplazamiento = menor(fila, columnas - 1 - columna);
        for (int i = desplazamiento; i >= 0; i--) {
            if (tablero[fila - i][columna + i] == ficha) {
                contador++;
            } else {
                contador = 0;
            }
            if (contador == 4) {
                return true;
            }
        }
        return false;
    }
    private int menor(int num1, int num2) {
        return Math.min(num1, num2);
    }
    @Override
    public String toString() {

        return null;
    }

}

