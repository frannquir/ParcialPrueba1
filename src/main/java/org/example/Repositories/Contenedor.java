package org.example.Repositories;

import org.example.Exceptions.ContenedorVacioException;
import org.example.Exceptions.FormatoInvalidoException;
import org.example.Exceptions.IdentificadorDuplicadoException;
import org.example.Model.Clases.Expansion;
import org.example.Model.Clases.Genero;
import org.example.Model.Clases.Juego;
import org.example.Model.Clases.Producto;


import java.security.cert.Extension;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Contenedor<T extends Producto> {
    private LinkedList<T> contenedor;

    public Contenedor() {
        this.contenedor = new LinkedList<>();
    }

    public void agregar(T t) throws IdentificadorDuplicadoException {
        if (!contenedor.add(t))
            throw new IdentificadorDuplicadoException("El producto ya existe en este contenedor");
    }

    public void eliminar(T t) {
        contenedor.remove(t);
    }

    public String ordenarLista() {
        StringBuilder lista = null;
        List<T> listaOrdenada = new LinkedList<>(contenedor);
        if (!listaOrdenada.isEmpty()) {
            Collections.sort(listaOrdenada);
            lista = new StringBuilder();
            for (T elemento : listaOrdenada) {
                lista.append(elemento);
            }
            return lista.toString();
        }
        return "La lista esta vacia";
    }

    public String mostrarContenedor() throws ContenedorVacioException {
        StringBuilder mensaje = null;
        int contador = 0;
        if (contenedor.isEmpty()) {
            throw new ContenedorVacioException("El contenedor esta vacio.");
        } else {
            mensaje = new StringBuilder("Elementos en el contenedor: ");
        }
        for (T elemento : contenedor) {
            contador++;
            mensaje.append(contador)
                    .append(":")
                    .append(elemento);
        }
        return mensaje.toString();
    }

    private boolean estaVacio() {
        return contenedor.isEmpty();
    }

    public String filtrarGenero(String genero) throws ContenedorVacioException, IdentificadorDuplicadoException {
        if (contenedor.isEmpty()) {
            throw new ContenedorVacioException("El contenedor esta vacio");
        }
        var filtrados = new Contenedor<>();
        StringBuilder mensaje = new StringBuilder("Juegos del genero " + genero + ":");
        for (T t : contenedor) {
            if (t.getGenero() == Genero.valueOf(genero.toUpperCase())) { // catchear illegalargumentexception
                filtrados.agregar(t);
            }
        }
        if (filtrados.estaVacio()) {
            throw new ContenedorVacioException("No se encontraron productos con el genero " + genero + ".");
        }
        return filtrados.mostrarContenedor();
    }

    public T buscarProducto(int posicion) throws FormatoInvalidoException, ContenedorVacioException {
        if (posicion < 0 || posicion > contenedor.size() + 1) {
            throw new FormatoInvalidoException("No se encontro el producto");
        }
        if (contenedor.isEmpty()) {
            throw new ContenedorVacioException("El contenedor esta vacio");
        }
        return contenedor.get(posicion - 1);
    }

    public void modificarTitulo(int posicion, String titulo) throws ContenedorVacioException, FormatoInvalidoException {
        T producto = buscarProducto(posicion);
        producto.setTitulo(titulo);
    }

    public void modificarGenero(int posicion, String genero) throws ContenedorVacioException, FormatoInvalidoException {
        T producto = buscarProducto(posicion);
        producto.setGenero(Genero.valueOf(genero.toUpperCase())); // illegalargumentexception
    }

    public void modificarCreador(int posicion, String creador) throws ContenedorVacioException, FormatoInvalidoException {
        T producto = buscarProducto(posicion);
        producto.setCreador(creador);
    }
    public void modificarVersion (int posicion, int version) throws FormatoInvalidoException, ContenedorVacioException {
        T producto = buscarProducto(posicion);
        if(producto instanceof Juego)
            ((Juego) producto).setNumeroVersion(version);
    }
    public void modificarFecha (int posicion, String fecha) throws ContenedorVacioException, FormatoInvalidoException {
        T producto = buscarProducto(posicion);
        if(producto instanceof Expansion)
            ((Expansion) producto).setFechaLanzamiento(fecha);
    }
}

