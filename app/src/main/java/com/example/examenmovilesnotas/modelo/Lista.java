package com.example.examenmovilesnotas.modelo;

import java.io.Serializable;

public class Lista implements Serializable {

    private String nota;

    public Lista(String nota) {
        this.nota = nota;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Lista{" +
                "nota='" + nota + '\'' +
                '}';
    }
}
