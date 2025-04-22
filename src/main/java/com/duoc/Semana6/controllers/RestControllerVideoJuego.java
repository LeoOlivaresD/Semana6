package com.duoc.Semana6.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duoc.Semana6.models.VideoJuego;
import com.duoc.Semana6.service.VideoJuegoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/videojuegos")
@RequiredArgsConstructor
public class RestControllerVideoJuego {

    private final VideoJuegoService juegoService;

    // Listo todo
    @GetMapping
    public ResponseEntity<List<VideoJuego>> listarJuego() {
        List<VideoJuego> juego = juegoService.getAllVideoJuegos();
        if (juego.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(juego);
    }

    // Listo por id
    @GetMapping("/{id}")
    public VideoJuego getVideoJuegoById(@PathVariable int id) {
        return juegoService.findById(id);
    }

    // Busco por titulo
    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<?> findByTitulo(@PathVariable String titulo) {
        VideoJuego juego = juegoService.findByTittle(titulo);
        if (juego != null) {
            return ResponseEntity.ok(juego); // Retorna 200 + el objeto
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontró ningún juego con el título: " + titulo); // Retorna 404 + mensaje
        }
    }
    // Busco por plataforma

    @GetMapping("/plataforma/{plataforma}")
    public ResponseEntity<?> findByPLataform(@PathVariable String plataforma) {
        VideoJuego juego = juegoService.findByPlataform(plataforma);
        if (juego != null) {
            return ResponseEntity.ok(juego); // Retorna 200 + el objeto
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontró ningún juego en la plataforma: " + plataforma); // Retorna 404 + mensaje
        }
    }

    // Se crean juegos
    @PostMapping
    public ResponseEntity<Void> agregarJuego(@RequestBody VideoJuego juego) {
        juegoService.agregarVideoJuego(juego);
        return ResponseEntity.status(201).build();
    }

    // Se eliminan juegos por id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarJuego(@PathVariable int id) {
        VideoJuego juego = juegoService.findById(id);
        if (juego != null) {
            juegoService.deleteById(id);
            return ResponseEntity.ok("Juego eliminado correctamente.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Juego no econtrado con id " + id);
        }

    }

}
