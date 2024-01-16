package org.iesalandalus.programacion.cuatroenraya.modelo;

public record Jugador() {

    public static Jugador leerJugador(Consola consola) {
        String nombre = consola.leerNombre();
        Ficha ficha = consola.elegirColorFichas();
        return new Jugador(nombre, ficha);
    }public static Jugador leerJugador(Ficha ficha1, Ficha ficha2, Consola consola) {
        String nombre = consola.leerNombre();
        Ficha ficha = consola.leerFicha(ficha1, ficha2);
        return new Jugador(nombre, ficha);
    }
}
