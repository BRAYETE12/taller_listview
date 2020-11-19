package com.example.taller_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.taller_listview.models.Historial;

public class CalcularAVActivity extends AppCompatActivity {

    private int TIPO_OPERACION = 0;
    private int OPERACION = 0;
    private ListView c_opciones;
    private TextView titulo, label1, label2, respuesta;
    private EditText input1, input2;
    private LinearLayout group2;
    private double pi = 3.14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_av);

        this.titulo =  findViewById(R.id.titulo);
        this.c_opciones =  findViewById(R.id.opciones);
        this.group2 =  findViewById(R.id.group2);
        this.label1 =  findViewById(R.id.label1);
        this.label2 =  findViewById(R.id.label2);
        this.input1 =  findViewById(R.id.input1);
        this.input2 =  findViewById(R.id.input2);
        this.respuesta =  findViewById(R.id.respuesta);

        this.TIPO_OPERACION = getIntent().getIntExtra("TIPO_OPERACION", 0);
        this.OPERACION = getIntent().getIntExtra("OPERACION", 0);


        if(this.TIPO_OPERACION==1){
            switch (this.OPERACION){
                case 0:
                        this.titulo.setText( R.string.cuadrado );
                        this.group2.setVisibility(View.GONE);
                        this.label1.setText(R.string.valor_lado);
                    break;
                case 1:
                        this.titulo.setText( R.string.rectangulo );
                        this.group2.setVisibility(View.VISIBLE);
                        this.label1.setText(R.string.valor_base);
                        this.label2.setText(R.string.valor_altura);
                    break;
                case 2:
                        this.titulo.setText( R.string.triangulo );
                        this.group2.setVisibility(View.VISIBLE);
                        this.label1.setText(R.string.valor_base);
                        this.label2.setText(R.string.valor_altura);
                    break;
                case 3:
                        this.titulo.setText( R.string.circulo );
                        this.group2.setVisibility(View.GONE);
                        this.label1.setText(R.string.valor_radio);
                    break;
            }
        }
        else if(this.TIPO_OPERACION==2){
            switch (this.OPERACION){
                case 0:
                        this.titulo.setText( R.string.esfera );
                        this.group2.setVisibility(View.GONE);
                        this.label1.setText(R.string.valor_radio);
                    break;
                case 1:
                        this.titulo.setText( R.string.cilindro );
                        this.group2.setVisibility(View.VISIBLE);
                        this.label1.setText(R.string.valor_altura);
                        this.label2.setText(R.string.valor_radio);
                    break;
                case 2:
                        this.titulo.setText( R.string.cono );
                        this.group2.setVisibility(View.VISIBLE);
                        this.label1.setText(R.string.valor_altura);
                        this.label2.setText(R.string.valor_radio);
                    break;
                case 3:
                        this.titulo.setText( R.string.cubo );
                        this.group2.setVisibility(View.GONE);
                        this.label1.setText(R.string.valor_lado);
                    break;
            }

        }

    }

    public void calcular(View v){

        if(!this.validar()){ return; }

        String op = "";
        String dt = "";

        double r = 0, n1 = 0, n2 = 0;
        n1 = Double.parseDouble(this.input1.getText().toString());

        if(this.group2.getVisibility() == View.VISIBLE){
            n2 = Double.parseDouble(this.input2.getText().toString());
        }


        if(this.TIPO_OPERACION==1){
            switch (this.OPERACION){
                case 0:
                    r = n1 * n1;
                    dt =  "L: " + n1;
                    break;
                case 1:
                    r = n1 * n2;
                    dt =  "L: " + n1 + " / A: " + n2;
                    break;
                case 2:
                    r = (n1 * n2) / 2;
                    dt =  "B: " + n1 + " / A: " + n2;
                    break;
                case 3:
                    r = n1 * n1 * pi;
                    dt =  "R: " + n1;
                    break;
            }

            op = getString(R.string.areas) +" "+ this.titulo.getText();

        }
        else if(this.TIPO_OPERACION==2){
            switch (this.OPERACION){
                case 0:
                    r =  (4/3) * n1 * n1 * n1 * pi;
                    dt =  "R: " + n1;
                    break;
                case 1:
                    r =  n1 * n2 * n2 * pi;
                    dt =  "A: " + n1 + " / R: " + n2;
                    break;
                case 2:
                    r =  (1/3) * n1 * n2 * n2 * pi;
                    dt =  "A: " + n1 + " / R: " + n2;
                    break;
                case 3:
                    r = n1 * n1 * n1;
                    dt =  "L: " + n1;
                    break;
            }

            op = getString(R.string.volumenes) +" "+ this.titulo.getText();

        }

        this.respuesta.setText( String.format("%.2f", r) );

        Historial h = new Historial(op, dt, String.format("%.2f", r));
        h.guardar();
    }

    public void limpiar(View v){
        this.input1.setText( "" );
        this.input2.setText( "" );
        this.respuesta.setText( "" );
        this.input1.requestFocus();
    }

    public boolean validar(){

        if(this.input1.getText().toString().isEmpty()){
            this.input1.setError( getString(R.string.error_numero) );
            this.input1.requestFocus();
            return false;
        }

        if(this.group2.getVisibility() == View.VISIBLE) {
            if (this.input2.getText().toString().isEmpty()) {
                this.input2.setError(getString(R.string.error_numero));
                this.input2.requestFocus();
                return false;
            }
        }

        return true;
    }

}
