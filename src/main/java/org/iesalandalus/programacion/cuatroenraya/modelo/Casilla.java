package org.iesalandalus.programacion.cuatroenraya.modelo;

import javax.naming.OperationNotSupportedException;
import java.util.Objects;

public class Casilla {
    private Ficha ficha;
    public Casilla() {
        this.ficha = null;
    }
    public Ficha getFicha() {
        return ficha;
    }
    public void setFicha(Ficha ficha) throws OperationNotSupportedException {

        if (this.ficha != null) {
            throw new OperationNotSupportedException("La casilla ya contiene una ficha.");

        }
        Objects.requireNonNull(ficha,("No se puede poner una ficha nula."));
        this.ficha=ficha;
    }
    public boolean estaOcupada() {
        return ficha != null;
    }
    @Override public String toString() {
        if (ficha == null) {
            return " ";
        }
        return String.valueOf(ficha);
    }


}

