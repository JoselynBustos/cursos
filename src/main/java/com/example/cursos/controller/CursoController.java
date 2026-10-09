package com.example.cursos.controller;

import com.example.cursos.model.Curso;
import com.example.cursos.service.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public List<Curso> listarTodos() {
        return cursoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> obtenerPorId(@PathVariable Long id) {
        return cursoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Curso> crear(@RequestBody Curso curso) {
        return new ResponseEntity<>(cursoService.save(curso), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> actualizar(@PathVariable Long id, @RequestBody Curso curso) {
        try {
            return ResponseEntity.ok(cursoService.update(id, curso));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        cursoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}