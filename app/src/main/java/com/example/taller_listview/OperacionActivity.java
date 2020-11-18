package com.example.taller_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class OperacionActivity extends AppCompatActivity {

    private int TIPO_OPERACION = 0;
    private ListView c_opciones;
    private TextView titulo;
    private String[] opciones = new String[]{};
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operacion);

        this.titulo =  findViewById(R.id.titulo);
        this.c_opciones =  findViewById(R.id.opciones);

        this.TIPO_OPERACION = getIntent().getIntExtra(Intent.EXTRA_TEXT, 0);

        if(this.TIPO_OPERACION==1){
            this.titulo.setText(R.string.areas);
            this.opciones = getResources().getStringArray(R.array.opciones_areas);
        }
        else if(this.TIPO_OPERACION==2){
            this.titulo.setText(R.string.volumenes);
            this.opciones = getResources().getStringArray(R.array.opciones_volumenes);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, this.opciones);
        this.c_opciones.setAdapter(adapter);

        this.c_opciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                intent = new Intent(OperacionActivity.this, CalcularAVActivity.class );
                intent.putExtra("TIPO_OPERACION", TIPO_OPERACION);
                intent.putExtra("OPERACION", i);
                startActivity( intent );
            }
        });


    }
}
