package com.duoc.Semana6.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.duoc.Semana6.models.VideoJuego;

@Repository
public class VideoJuegoRepository {

    // Retorna todos los video Juegos
    private final List<VideoJuego> listaVideoJuego = new ArrayList<>();

    public List<VideoJuego> findAllVideoJuego() {
        return listaVideoJuego;
    }

    // Metodo para buscar por id
    public VideoJuego findById(int id) {
        for (VideoJuego videoJuegoBuscado : listaVideoJuego) {
            if (id == videoJuegoBuscado.getId()) {
                return videoJuegoBuscado;
            }

        }
        return null;

    }

    // Metodo para buscar por titulo
    public VideoJuego obtenerPorTitulo(String titulo) {
        if (listaVideoJuego != null) {
            for (VideoJuego juego : listaVideoJuego) {
                if (titulo.equalsIgnoreCase(juego.getTitulo())) {
                    System.out.println("Juego encontrado !");
                    return juego;
                }
            }
        }
        return null;
    }

    // Metodo para bucar por plataforma
    public VideoJuego obtenerPorPLataforma(String plataforma) {
        if (listaVideoJuego != null) {
            for (VideoJuego juego : listaVideoJuego) {
                if (plataforma.equalsIgnoreCase(juego.getPlataforma())) {
                    System.out.println("Juego encontrado !");
                    return juego;
                }
            }

        }
        return null;
    }

    // Metodo para crear un video juego
    public void addVideoJuego(VideoJuego juego) {
        listaVideoJuego.add(juego);
    };

    public VideoJuegoRepository() {
        listaVideoJuego.add(new VideoJuego(1, "God of War 4", 15000, "Play Station 5", true));
        listaVideoJuego.add(new VideoJuego(2, "fortnite", 0, "Epic Games", true));
    }

    // Elimina un juego
    public boolean deleteById(int id) {
        VideoJuego juego = findById(id);
        if (juego != null) {
            listaVideoJuego.remove(juego);
            return true;
        }
        return false;
    }

}
