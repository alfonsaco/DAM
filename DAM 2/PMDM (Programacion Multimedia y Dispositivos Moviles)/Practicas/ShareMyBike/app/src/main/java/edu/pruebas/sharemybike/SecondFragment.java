package edu.pruebas.sharemybike;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

        recicler=view.findViewById(R.id.recicler);
        recicler.setLayoutManager(new LinearLayoutManager(getContext()));

        BikesContent.loadBikesFromJSON(requireContext());
        recicler.setAdapter(new MyItemRecyclerViewAdapter(requireContext(), BikesContent.ITEMS));

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