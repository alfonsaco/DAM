package edu.pruebas.sharemybike;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.Calendar;

import edu.pruebas.sharemybike.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

private FragmentFirstBinding binding;

    CalendarView calendarView;
    TextView txtFecha;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

      binding = FragmentFirstBinding.inflate(inflater, container, false);
      return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        calendarView=view.findViewById(R.id.calendarView);
        txtFecha=view.findViewById(R.id.txtFecha);

        binding.buttonFirst.setOnClickListener(v ->
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment)
        );

        calendarView.setOnDateChangeListener((view1, year, month, dayOfMonth) -> {
            // Aquí puedes manejar el cambio de fecha
            String fechaSeleccionada=dayOfMonth + "/" + (month + 1) + "/" + year;
            txtFecha.setText(fechaSeleccionada);
        });
    }

    @Override
        public void onDestroyView() {
            super.onDestroyView();
            binding = null;
        }


}