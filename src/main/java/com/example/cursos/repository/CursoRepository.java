package com.example.cursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cursos.model.Curso;



public interface CursoRepository extends JpaRepository<Curso, Long> {

}
