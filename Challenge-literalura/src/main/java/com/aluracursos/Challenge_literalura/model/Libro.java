package com.aluracursos.Challenge_literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;

    @ManyToMany(mappedBy = "libro", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Autor> autor= new ArrayList<>();;
    private String idiomas;
    private Double numeroDeDescargas;



    public Libro(DatosLibro datosLibro) {
        this.titulo= datosLibro.titulo();
        this.idiomas= datosLibro.idiomas().get(0);
        this.numeroDeDescargas= datosLibro.numeroDeDescargas();

    }

    public void addAutor(Autor autor) {
        this.autor.add(autor);
        autor.getLibro().add(this);
    }

    @Override
    public String toString() {
        return "------LIBRO----\n" +
                ", titulo='" + titulo + '\n' +
                ", autor=" + autor + "\n"+
                ", idiomas='" + idiomas + '\'' +"\n"+
                ", numeroDeDescargas=" + numeroDeDescargas +"\n"+
                "------------";
    }

    public Libro() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutor() {
        return autor;
    }

    public void setAutor(List<Autor> autor) {
        this.autor = autor;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public Double getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public void setNumeroDeDescargas(Double numeroDeDescargas) {
        this.numeroDeDescargas = numeroDeDescargas;
    }
}
