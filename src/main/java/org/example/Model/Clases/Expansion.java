package org.example.Model.Clases;

import org.example.Exceptions.FormatoInvalidoException;

public class Expansion extends Producto {
    private String fechaLanzamiento;

    public Expansion(Genero genero, String creador, String titulo, String fechaLanzamiento) throws FormatoInvalidoException {
        super(genero, creador, titulo);
        setFechaLanzamiento(fechaLanzamiento);
    }

    public Expansion() {
        super();
        fechaLanzamiento = null;
    }

    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(String fechaLanzamiento) throws FormatoInvalidoException {
        if(fechaLanzamiento != null) {
            this.fechaLanzamiento = fechaLanzamiento;
        } else {
            this.fechaLanzamiento = "N/A";
            throw new FormatoInvalidoException("La fecha de lanzamiento no puede ser nula.");
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "fechaLanzamiento='" + fechaLanzamiento + '\'' +
                '}';
    }
}
