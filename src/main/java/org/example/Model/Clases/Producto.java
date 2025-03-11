package org.example.Model.Clases;

import java.util.Objects;
import java.util.UUID;

public abstract class Producto implements Comparable<Producto>{
    private String titulo;
    private String creador;
    private UUID identificador;
    private Genero genero;

    public Producto(Genero genero, String creador, String titulo) {
        this.genero = genero;
        identificador = UUID.randomUUID();
        this.creador = creador;
        this.titulo = titulo;
    }
    public Producto(){
        genero = null;
        identificador = null;
        creador = null;
        titulo = null;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public void setIdentificador(UUID identificador) {
        this.identificador = identificador;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return identificador == producto.identificador;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(identificador);
    }

    @Override
    public int compareTo(Producto o) {
        return this.titulo.compareTo(o.getTitulo());
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "titulo='" + titulo + '\'' +
                ", creador='" + creador + '\'' +
                ", identificador=" + identificador +
                ", genero=" + genero;
    }
}
