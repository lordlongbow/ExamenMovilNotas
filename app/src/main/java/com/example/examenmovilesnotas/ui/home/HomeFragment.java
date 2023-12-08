package com.example.examenmovilesnotas.ui.home;

import static android.os.Build.VERSION_CODES.R;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleRegistryOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.examenmovilesnotas.R;
import com.example.examenmovilesnotas.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private HomeViewModel vm;
    private FragmentHomeBinding binding;
    private TextView mensaje;
    private EditText et_nota;
    private Button btn_agregar;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        vm =  new ViewModelProvider(this).get(HomeViewModel.class);
        vm = new HomeViewModel(this);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        cargarInit(root);

        vm.getNotaMutableEditText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                et_nota.setText(s);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void cargarInit(View root){
        et_nota = root.findViewById(com.example.examenmovilesnotas.R.id.et_nota);
        btn_agregar = root.findViewById(com.example.examenmovilesnotas.R.id.btn_Agregar);

        btn_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nota = et_nota.getText().toString();
                Log.d("nota", nota);

                vm.agregarNota(nota);
                vm.setNotaMutableEditText("");
            }
        });
    }
}