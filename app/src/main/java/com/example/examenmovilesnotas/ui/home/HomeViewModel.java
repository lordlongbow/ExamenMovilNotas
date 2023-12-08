package com.example.examenmovilesnotas.ui.home;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.examenmovilesnotas.request.Funciones;
/*
public class HomeViewModel extends ViewModel {
//    private Context contexto;
    private String nota;
    public HomeViewModel(HomeFragment contexto) {

    }
    public void agregarNota(String nota){

        Log.d("Nota en View Model ", nota);
        if(nota == null || nota.isEmpty()){
            alertDialogCargaVacia();
        }else{

            Funciones.agregarNotaALista(nota);
            Log.d("salida ", "agregada");
      alertDialogCargaExitosa();
        }
    }
    public void alertDialogCargaExitosa(){
        android.app.AlertDialog.Builder alertDialog = new android.app.AlertDialog.Builder()
                    .setMessage("Nota Agregada").setPositiveButton("Aceptar", (dialog, which) -> {
                    });
            alertDialog.show();
        }
    public void alertDialogCargaVacia(){
        android.app.AlertDialog.Builder alertDialog = new android.app.AlertDialog.Builder(contexto).setTitle("Upps!!")
                .setMessage("La Nota no puede estar Vacia").setPositiveButton("Aceptar", (dialog, which) -> {
                });
        alertDialog.show();
    }
}
*/

public class HomeViewModel extends ViewModel {
    private HomeFragment contexto;
    private String nota;
    private MutableLiveData<String> notaMutableEditText;

    public LiveData<String> getNotaMutableEditText() {
        if(notaMutableEditText == null){
            notaMutableEditText = new MutableLiveData<>();
        }
        return notaMutableEditText;
    }

    public void setNotaMutableEditText(String nota) {
        notaMutableEditText.setValue(nota);
    }

    public HomeViewModel() {
    }
    public HomeViewModel(HomeFragment contexto) {
        this.contexto = contexto;
    }
    public void agregarNota(String nota) {
        Log.d("Nota en View Model ", nota);
        if (nota == null || nota.isEmpty()) {
            alertDialogCargaVacia();
        } else {
            Funciones.agregarNotaALista(nota);
            Log.d("salida ", "agregada");

            alertDialogCargaExitosa();
            setNotaMutableEditText("");
        }
    }

    public void alertDialogCargaExitosa() {
        android.app.AlertDialog.Builder alertDialog = new android.app.AlertDialog.Builder(contexto.getContext())
                .setMessage("Nota Agregada").setPositiveButton("Aceptar", (dialog, which) -> {
                });
        alertDialog.show();
    }

    public void alertDialogCargaVacia() {
        android.app.AlertDialog.Builder alertDialog = new android.app.AlertDialog.Builder(contexto.getContext())
                .setTitle("Upps!!")
                .setMessage("La Nota no puede estar Vacia").setPositiveButton("Aceptar", (dialog, which) -> {
                });
        alertDialog.show();
    }
}
