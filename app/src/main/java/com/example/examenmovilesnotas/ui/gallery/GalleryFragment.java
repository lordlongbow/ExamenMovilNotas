package com.example.examenmovilesnotas.ui.gallery;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examenmovilesnotas.R;
import com.example.examenmovilesnotas.databinding.FragmentGalleryBinding;
import com.example.examenmovilesnotas.request.Funciones;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;
    private RecyclerView rv;
    private Adapter adapter;
    private GalleryViewModel vm;
    private Context contexto;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        vm =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        contexto= root.getContext();

        fragmentInit(root);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

        public void fragmentInit(View root){
            rv = root.findViewById(R.id.rv_ListaTareas);

            GridLayoutManager gridLayoutManager= new GridLayoutManager(contexto,1, GridLayoutManager.VERTICAL,false);
       rv.setLayoutManager(gridLayoutManager);
            adapter = new Adapter(contexto, Funciones.getLista(), getLayoutInflater());
        rv.setAdapter(adapter);

    }
}