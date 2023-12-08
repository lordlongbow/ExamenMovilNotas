package com.example.examenmovilesnotas.request;

import com.example.examenmovilesnotas.modelo.Lista;

import java.util.ArrayList;

public class Funciones {

    private String nota;
    public static ArrayList<String> notas = new ArrayList<>();


    public static void agregarNotaALista(String nota){
        notas.add(nota);
    }

   public static ArrayList<String> getLista(){
       return notas;
   }

}
