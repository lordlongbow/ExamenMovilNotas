package com.example.examenmovilesnotas.ui.slideshow;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.examenmovilesnotas.R;
import com.example.examenmovilesnotas.databinding.FragmentSlideshowBinding;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        alertDialog();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void alertDialog(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this.getContext()).setTitle("Nos dejas?")
                .setMessage("La aplicacion se cerrará, esperamos regreses pronto").setPositiveButton("Aceptar", (dialog, which) -> {
                   System.exit(0);
                }).setNegativeButton("Cancelar", (dialog, which) -> {
                    Navigation.findNavController(getActivity(), R.id.nav_host_fragment_content_main).navigate(R.id.nav_home);
                });
        alertDialog.show();
    }
}