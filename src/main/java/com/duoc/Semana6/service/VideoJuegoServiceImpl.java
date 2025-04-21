package com.duoc.Semana6.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.duoc.Semana6.models.VideoJuego;
import com.duoc.Semana6.repository.VideoJuegoRepository;

@Service
public class VideoJuegoServiceImpl implements VideoJuegoService {
    private final VideoJuegoRepository juegoRepository = new VideoJuegoRepository();

    @Override
    public List<VideoJuego> getAllVideoJuegos() {
        return juegoRepository.findAllVideoJuego();
    }

    @Override
    public VideoJuego findById(int id) {
        return juegoRepository.findById(id);
    }

    @Override
    public void agregarVideoJuego(VideoJuego juego) {
        juegoRepository.addVideoJuego(juego);
    }

    @Override
    public boolean deleteById(int id) {
        return juegoRepository.deleteById(id);
    }

    @Override
    public VideoJuego findByTittle(String titulo) {
        return juegoRepository.obtenerPorTitulo(titulo);
    }

    @Override
    public VideoJuego findByPlataform(String plataforma) {
        return juegoRepository.obtenerPorPLataforma(plataforma);
    }

}
