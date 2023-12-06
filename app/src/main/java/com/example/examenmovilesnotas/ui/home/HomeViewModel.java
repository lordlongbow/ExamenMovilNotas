package com.example.examenmovilesnotas.ui.home;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.examenmovilesnotas.request.Funciones;

import java.io.Closeable;

public class HomeViewModel extends ViewModel {

    private Context contexto;
    private Funciones funciones = new Funciones();
    private final MutableLiveData<String> mText;

    private String nota;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");

    }

    public LiveData<String> getText() {
        return mText;
    }

    public void agregarNota(String nota){

        Log.d("Nota en View Model ", nota);
        mText.setValue("Se agrego la nota");
        if(nota == null || nota.isEmpty()){
            mText.setValue("No se puede agregar una nota vacia");

        }else{

            funciones.agregarNotaALista(nota);
            mText.setValue("Nota agregada con exito");
        }
    }
}