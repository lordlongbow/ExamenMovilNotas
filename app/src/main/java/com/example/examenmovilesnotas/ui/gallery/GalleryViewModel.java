package com.example.examenmovilesnotas.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.examenmovilesnotas.request.Funciones;

import java.util.ArrayList;

public class GalleryViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private Funciones funciones;
    private ArrayList<String> notas;


    public GalleryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public ArrayList<String> getNotas(){
        if(notas == null){
            notas = funciones.getLista();
        }
        return notas;
    }


}