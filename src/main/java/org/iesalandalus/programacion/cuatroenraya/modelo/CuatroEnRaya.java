package org.iesalandalus.programacion.cuatroenraya.modelo;

public class CuatroEnRaya {
    private Tablero tablero;
    private Jugador jugador1;
    private Jugador jugador2;

    public CuatroEnRaya(Jugador jugador1, Jugador jugador2) {
        this.tablero = new Tablero();
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    public void jugar() {
        Consola consola = new Consola();
        boolean finDelJuego = false;

        while (!finDelJuego) {
            finDelJuego = tirar(consola, jugador1);
            if (finDelJuego) {
                break;
            }
            finDelJuego = tirar(consola, jugador2);
        }
    }

    private boolean tirar(Consola consola, Jugador jugador) {

    }
}
