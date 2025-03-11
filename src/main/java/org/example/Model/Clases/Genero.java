package org.example.Model.Clases;

public enum Genero {
    FICCION("Ficcion"),
    AVENTURA("Aventura"),
    SUPERVIVENCIA("Supervivencia");

    private String genero;

    private Genero(String genero) {
        this.genero = genero;
    }
    public String getGenero() {
        return genero;
    }
}
