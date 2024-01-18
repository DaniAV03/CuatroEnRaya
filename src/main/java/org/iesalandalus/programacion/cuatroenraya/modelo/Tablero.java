package org.iesalandalus.programacion.cuatroenraya.modelo;

import javax.naming.OperationNotSupportedException;

public class Tablero {
    public static final int FILAS = 6;
    public static final int COLUMNAS = 7;
    public static final int FICHAS_IGUALES_CONSECUTIVAS_NECESSARIAS = 4;
    private Casilla[][] casillas;

    public Tablero() {
        casillas = new Casilla[FILAS][COLUMNAS];
        inicializarCasillas();
    }

    private void inicializarCasillas() {
        for (int fila = 0; fila < FILAS; fila++) {
            for (int columna = 0; columna < COLUMNAS; columna++) {
                casillas[fila][columna] = new Casilla();
            }
        }
    }

    private boolean columnaVacia(int columna) {
        if (columna < 0 || columna >= COLUMNAS) {
            throw new IllegalArgumentException("Columna incorrecta.");
        }
        for (int fila = 0; fila < FILAS; fila++) {
            if (!casillas[fila][columna].estaOcupada()) {
                return true;
            }
        }
        return false;
    }

    public boolean estaVacio() {
        for (int columna = 0; columna < COLUMNAS; columna++) {
            if (!columnaVacia(columna)) {
                return false;
            }
        }
        return true;
    }

    private boolean columnaLlena(int columna) {
        if (columna < 0 || columna >= COLUMNAS) {
            throw new IllegalArgumentException("Columna incorrecta.");
        }
        return !columnaVacia(columna);
    }

    public boolean estaLleno() {
        for (int columna = 0; columna < COLUMNAS; columna++) {
            if (!columnaLlena(columna)) {
                return false;
            }
        }
        return true;
    }

    public boolean introducirFicha(int columna, Ficha ficha) throws OperationNotSupportedException {
        if (columna < 0 || columna >= COLUMNAS) {
            throw new IllegalArgumentException("Columna incorrecta.");
        }
        for (int fila = FILAS - 1; fila >= 0; fila--) {
            if (!casillas[fila][columna].estaOcupada()) {
                casillas[fila][columna].setFicha(ficha);
                casillas[fila][columna].estaOcupada();
                return true;
            }
        }
        throw new OperationNotSupportedException("Columna llena.");
    }

    private boolean comprobarHorizontal(int fila, Ficha ficha) {
        if (fila < 0 || fila >= FILAS) {
            throw new IllegalArgumentException("Fila incorrecta.");
        }
        for (int columna = 0; columna < COLUMNAS - FICHAS_IGUALES_CONSECUTIVAS_NECESSARIAS + 1; columna++) {
            if (comprobarFichasIguales(fila, columna, ficha, FICHAS_IGUALES_CONSECUTIVAS_NECESSARIAS)) {
                return true;
            }
        }
        return false;
    }

    private boolean comprobarVertical(int columna, Ficha ficha) {
        if (columna < 0 || columna >= COLUMNAS) {
            throw new IllegalArgumentException("Columna incorrecta.");
        }
        for (int fila = 0; fila < FILAS - FICHAS_IGUALES_CONSECUTIVAS_NECESSARIAS + 1; fila++) {
            if (comprobarFichasIguales(fila, columna, ficha, FICHAS_IGUALES_CONSECUTIVAS_NECESSARIAS)) {
                return true;
            }
        }
        return false;
    }

   private boolean comprobarDiagonalNE(int fila, int columna, Ficha ficha) {
        int desplazamiento = Math.min(fila, columna);
        int filaInicial = fila - desplazamiento;
        int columnaInicial = columna - desplazamiento;

        for (int i = 0; i < FICHAS_IGUALES_CONSECUTIVAS_NECESSARIAS; i++) {
            if (!comprobarFichasIguales(filaInicial + i, columnaInicial + i, ficha, FICHAS_IGUALES_CONSECUTIVAS_NECESSARIAS)) {
                break;
            }
            if (i == FICHAS_IGUALES_CONSECUTIVAS_NECESSARIAS - 1) {
                return true;
            }
        }
        return false;
    }

    private boolean comprobarDiagonalNO(int fila, int columna, Ficha ficha) {
        int desplazamiento = Math.min(fila, COLUMNAS - 1 - columna);
        int filaInicial = fila - desplazamiento;
        int columnaInicial = columna + desplazamiento;

        for (int i = 0; i < FICHAS_IGUALES_CONSECUTIVAS_NECESSARIAS; i++) {
            if (!comprobarFichasIguales(filaInicial + i, columnaInicial - i, ficha, FICHAS_IGUALES_CONSECUTIVAS_NECESSARIAS)) {
                break;
            }
            if (i == FICHAS_IGUALES_CONSECUTIVAS_NECESSARIAS - 1) {
                return true;
            }
        }
        return false;
    }

    private boolean comprobarFichasIguales(int fila, int columna, Ficha ficha, int fichasIgualesNecessarias) {
        for (int i = 0; i < fichasIgualesNecessarias; i++) {
            if (casillas[fila][columna].getFicha() != ficha) {
                return false;
            }
            columna++;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
            String line = "       ";
            int repetitions = 6;
            for (int i = 0; i < repetitions; i++) {
                builder.append("|").append(line).append("|").append("\n");
            }
            builder.append(" -------").append("\n");

            return builder.toString();
    }
}