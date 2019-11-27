package com.company.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class PuntuacionViewModel extends AndroidViewModel {

    MutableLiveData<Integer> puntosA = new MutableLiveData<>(0);
    MutableLiveData<Integer> puntosB = new MutableLiveData<>(0);

    public PuntuacionViewModel(@NonNull Application application) {
        super(application);
    }

    void sumarA(int puntos){
        puntosA.setValue(puntosA.getValue() + puntos);
    }

    void sumarB(int puntos){
        puntosB.setValue(puntosB.getValue() + puntos);
    }

    void resetear(){
        puntosA.setValue(0);
        puntosB.setValue(0);
    }
}
