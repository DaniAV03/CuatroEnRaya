package org.iesalandalus.programacion.cuatroenraya.modelo;
public class Casilla {
        private Ficha ficha;
        public Casilla() {
            this.ficha = null;
        }
        public Ficha getFicha() {
            return ficha;
        }
        public void setFicha(Ficha ficha) {
            this.ficha = ficha;
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

