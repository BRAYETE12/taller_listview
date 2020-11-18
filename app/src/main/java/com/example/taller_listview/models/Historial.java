package com.example.taller_listview.models;

public class Historial {

    private String operacion;
    private String datos;
    private String resultados;

    public Historial(String operacion, String datos, String resultados){
        this.setOperacion(operacion);
        this.setDatos(datos);
        this.setResultados(resultados);
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    public String getResultados() {
        return resultados;
    }

    public void setResultados(String resultados) {
        this.resultados = resultados;
    }

    public void guardar(){
        Datos.guardar(this);
    }

}
