package org.iesalandalus.programacion.cuatroenraya.modelo;

public enum Ficha {
    AZUL, VERDE, VACIO;

    @Override
    public String toString() {
        return String.valueOf(this.name().charAt(0));
    }

}


