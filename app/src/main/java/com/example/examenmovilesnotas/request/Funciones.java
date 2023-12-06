package com.example.examenmovilesnotas.request;

import com.example.examenmovilesnotas.modelo.Lista;

import java.util.ArrayList;

public class Funciones {

    private String nota;
    public ArrayList<String> notas = new ArrayList<>();


    public void agregarNotaALista(String nota){
        notas.add(nota);
    }

   public ArrayList<String> getLista(){
       return notas;
   }

}
