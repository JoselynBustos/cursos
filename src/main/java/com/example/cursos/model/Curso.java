package com.example.cursos.model;


import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descripcion;
    private Integer horas;

    public Curso() {}

    public Curso(Long id, String titulo, String descripcion, Integer horas) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.horas = horas;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public Integer getHoras() { return horas; }
    public void setHoras(Integer horas) { this.horas = horas; }

}
