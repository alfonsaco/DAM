package edu.pruebas.sharemybike;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import edu.pruebas.sharemybike.bikes.BikesContent;
import edu.pruebas.sharemybike.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

private FragmentSecondBinding binding;

    RecyclerView recicler;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_second, container, false);

        recicler = view.findViewById(R.id.recicler);
        ProgressBar placeholderProgressBar = view.findViewById(R.id.placeholderProgressBar);

        // Configurar RecyclerView
        recicler.setLayoutManager(new LinearLayoutManager(getContext()));

        // Mostrar el ProgressBar antes de cargar los datos
        placeholderProgressBar.setVisibility(View.VISIBLE);
        recicler.setVisibility(View.GONE);

        // Cargar datos desde JSON
        BikesContent.loadBikesFromJSON(requireContext());



        Handler handler = new Handler(); // Crear un nuevo Handler
        handler.postDelayed(() -> {
            // Lógica que se ejecutará después del retraso
            placeholderProgressBar.setVisibility(View.GONE);
            recicler.setVisibility(View.VISIBLE);
            recicler.setAdapter(new MyItemRecyclerViewAdapter(requireContext(), BikesContent.ITEMS));
        }, 1000);

        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}