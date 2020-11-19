package com.example.taller_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.taller_listview.models.Datos;
import com.example.taller_listview.models.Historial;

import java.util.ArrayList;

public class HistorialActivity extends AppCompatActivity {


    private TableLayout tabla;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);

        this.tabla = findViewById(R.id.tabla);
        ArrayList<Historial> lista = Datos.obtener();

        for (int i=0; i<lista.size(); i++){
            TableRow row = new TableRow(this);
            TextView tv1 = new TextView(this);
            TextView tv2 = new TextView(this);
            TextView tv3 = new TextView(this);
            TextView tv4 = new TextView(this);

            tv1.setText( (i+1)+"" );
            tv2.setText( lista.get(i).getOperacion() );
            tv3.setText( lista.get(i).getDatos() );
            tv4.setText( lista.get(i).getResultados() );

            tv1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tv2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tv3.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tv4.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            row.addView(tv1);
            row.addView(tv2);
            row.addView(tv3);
            row.addView(tv4);

            tabla.addView(row);
        }

    }
}
