package org.example.Model.Clases;

import org.example.Exceptions.FormatoInvalidoException;

public class Juego extends Producto {
    private int numeroVersion;

    public Juego(Genero genero, String creador, String titulo, int numeroVersion) throws FormatoInvalidoException {
        super(genero, creador, titulo);
        setNumeroVersion(numeroVersion);
    }

    public Juego() {
        super();
        numeroVersion = 0;
    }

    public int getNumeroVersion() {
        return numeroVersion;
    }

    public void setNumeroVersion(int numeroVersion) throws FormatoInvalidoException {
        if (numeroVersion > 0) {
            this.numeroVersion = numeroVersion;
        }
        else {
            this.numeroVersion = 0;
            throw new FormatoInvalidoException("El numero de version no puede ser menor a cero");
        }
    }


    @Override
    public String toString() {
        return super.toString() +
                "numeroVersion=" + numeroVersion +
                '}';
    }
}
