package com.example.cursos.service;


import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.example.cursos.model.Curso;
import com.example.cursos.repository.CursoRepository;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public List<Curso> obtenerTodos() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> obtenerPorId(Long id) {
        return cursoRepository.findById(id);
    }

    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Curso update(Long id, Curso cursoDetalles) {
        return cursoRepository.findById(id).map(curso -> {
            curso.setTitulo(cursoDetalles.getTitulo());
            curso.setDescripcion(cursoDetalles.getDescripcion());
            curso.setHoras(cursoDetalles.getHoras());
            return cursoRepository.save(curso);
        }).orElseThrow(() -> new RuntimeException("Curso no encontrado con id: " + id));
    }

    public void delete(Long id) {
        cursoRepository.deleteById(id);
    }
}
