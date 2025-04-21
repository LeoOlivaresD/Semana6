package com.duoc.Semana6.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.duoc.Semana6.models.VideoJuego;

@Service
public interface VideoJuegoService {

    // retorna todo
    List<VideoJuego> getAllVideoJuegos();

    // retorna uno por id
    VideoJuego findById(int id);

    // crea
    void agregarVideoJuego(VideoJuego juego);

    // elimina por id
    boolean deleteById(int id);

    //busca por titulo
    VideoJuego findByTittle(String titulo);
    //busca por plataforma
    VideoJuego findByPlataform(String plataforma);
}
