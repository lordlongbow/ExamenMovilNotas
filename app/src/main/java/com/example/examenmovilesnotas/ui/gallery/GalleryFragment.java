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
import androidx.recyclerview.widget.RecyclerView;

import com.example.examenmovilesnotas.R;
import com.example.examenmovilesnotas.databinding.FragmentGalleryBinding;

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
        vm = new ViewModelProvider(this).get(GalleryViewModel.class);
        adapter = new Adapter(contexto, vm.getNotas(), LayoutInflater.from(contexto));
        rv.setAdapter(adapter);

    }
}