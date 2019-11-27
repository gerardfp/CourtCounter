package com.company.viewmodel;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class MainFragment extends Fragment  implements View.OnClickListener{

    TextView marcadorA, marcadorB;
    PuntuacionViewModel puntuacionViewModel;

    public MainFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        puntuacionViewModel = ViewModelProviders.of(requireActivity()).get(PuntuacionViewModel.class);

        marcadorA = view.findViewById(R.id.marcadorA);
        marcadorB = view.findViewById(R.id.marcadorB);

        view.findViewById(R.id.add3A).setOnClickListener(this);
        view.findViewById(R.id.add2A).setOnClickListener(this);
        view.findViewById(R.id.add1A).setOnClickListener(this);
        view.findViewById(R.id.add3B).setOnClickListener(this);
        view.findViewById(R.id.add2B).setOnClickListener(this);
        view.findViewById(R.id.add1B).setOnClickListener(this);
        view.findViewById(R.id.reset).setOnClickListener(this);

        puntuacionViewModel.puntosA.observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                marcadorA.setText(String.valueOf(integer));
            }
        });

        puntuacionViewModel.puntosB.observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                marcadorB.setText(String.valueOf(integer));
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.add3A: puntuacionViewModel.sumarA(3); break;
            case R.id.add2A: puntuacionViewModel.sumarA(2); break;
            case R.id.add1A: puntuacionViewModel.sumarA(1); break;
            case R.id.add3B: puntuacionViewModel.sumarB(3); break;
            case R.id.add2B: puntuacionViewModel.sumarB(2); break;
            case R.id.add1B: puntuacionViewModel.sumarB(1); break;
            case R.id.reset: puntuacionViewModel.resetear(); break;
        }
    }
}
