package org.iesalandalus.programacion.cuatroenraya.modelo;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {
    public String leerNombre() {
        String nombre = "";
        System.out.print("Ingrese el nombre del jugador: ");


        nombre = Entrada.nextLine();
        while (nombre.equals("")) {
            System.out.print("El nombre no puede estar vacío. Ingrese el nombre del jugador: ");
            nombre = Entrada.nextLine();
        }
        return nombre;
    }

    public Ficha elegirColorFichas() {

    }

    public Ficha leerFicha(Ficha ficha1, Ficha ficha2) {

    }

    public int leerColumna(Jugador jugador1, Jugador jugador2) {

    }
}
