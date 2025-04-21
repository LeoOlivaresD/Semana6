package com.duoc.Semana6.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoJuego {
    private int id;
    private String titulo;
    private int precio;
    private String plataforma;
    private boolean disponibilidad;

}
