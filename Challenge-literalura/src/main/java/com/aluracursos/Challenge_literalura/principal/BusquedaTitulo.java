package com.aluracursos.Challenge_literalura.principal;

import com.aluracursos.Challenge_literalura.model.DatosLibro;
import com.aluracursos.Challenge_literalura.model.DatosResultados;
import com.aluracursos.Challenge_literalura.service.ConsumoAPI;
import com.aluracursos.Challenge_literalura.service.ConvierteDatos;

import java.util.Optional;

public class BusquedaTitulo {
    private ConsumoAPI consumoAPI=new ConsumoAPI();
    private final String URL_BASE ="https://gutendex.com/books/";
    private ConvierteDatos conversor=new ConvierteDatos();

    public Optional<DatosLibro> BuscarTitulo(String titulo) {
        var JsonBusqueda = consumoAPI.obtenerDatos(URL_BASE+"?search="+titulo);
        var datosBusqueda = conversor.obtenerDatos(JsonBusqueda, DatosResultados.class);

        Optional<DatosLibro> libroBuscado=datosBusqueda.resultado().stream()
                .filter(l->l.titulo().toUpperCase().contains(titulo.toUpperCase()))
                .findFirst();

        if(libroBuscado.isPresent()){
            return libroBuscado;
        }else{
            return null;
        }


    }

}
