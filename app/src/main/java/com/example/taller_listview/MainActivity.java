package com.example.taller_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView c_opciones;
    private  Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        this.c_opciones =  findViewById(R.id.opciones);

        String[] opciones = getResources().getStringArray(R.array.opciones);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, opciones);
        this.c_opciones.setAdapter(adapter);

        this.c_opciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){

                    case 0:
                        intent = new Intent(MainActivity.this, OperacionActivity.class );
                        intent.putExtra(Intent.EXTRA_TEXT, 1);
                        startActivity( intent );
                        break;

                    case 1:
                        intent = new Intent(MainActivity.this, OperacionActivity.class );
                        intent.putExtra(Intent.EXTRA_TEXT, 2);
                        startActivity( intent );
                        break;

                    case 2:
                        intent = new Intent(MainActivity.this, HistorialActivity.class );
                        startActivity( intent );
                        break;


                }
            }
        });

    }
}
