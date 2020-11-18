package com.example.taller_listview.models;

import java.util.ArrayList;

public class Datos {

    private static ArrayList<Historial> historial = new ArrayList();

    public static void guardar(Historial x){
        historial.add(x);
    }

    public static ArrayList<Historial> obtener(){
        return historial;
    }

}
