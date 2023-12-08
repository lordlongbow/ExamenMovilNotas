package com.example.examenmovilesnotas.ui.gallery;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examenmovilesnotas.R;
import com.example.examenmovilesnotas.request.Funciones;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private Funciones funciones;
    private Context contexto;
    private ArrayList<String> notas;
    private LayoutInflater li;

    public Adapter(Context contexto, ArrayList<String> notas, LayoutInflater li) {
        this.contexto = contexto;
        this.notas=notas;
        this.li = li;
        Log.d("salida ",this.notas.size()+"");
    }


    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = li.inflate(R.layout.cardnota, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        holder.tv_texto.setText(notas.get(position));
    }

    @Override
    public int getItemCount() {
        return this.notas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_texto;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_texto = itemView.findViewById(R.id.tv_textoNota);
        }
    }


}
