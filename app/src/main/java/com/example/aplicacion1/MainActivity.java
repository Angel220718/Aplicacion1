package com.example.aplicacion1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.ComponentActivity;

public class MainActivity extends ComponentActivity {
    private String[] nombres = {
            "Anthony Borboy", "Maite Guerrero ", "Angel Maruri", "Niurka Murillo", "Cinthia Del Carmen Orellana"
    };
    private int[] edades = {
          19, 23, 22, 19, 34
    };

    private ListView lista;
    private TextView resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        lista = (ListView)findViewById(R.id.lista);
        resultado = (TextView) findViewById(R.id.resultado);

        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombres);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                resultado.setText("Hola "+lista.getItemAtPosition(position)+" Su Edad es: "+ edades[position]+" años");

                String opcSeleccion = (String)lista.getAdapter().getItem(position);
                Toast.makeText(getApplicationContext(),opcSeleccion,Toast.LENGTH_SHORT).show();
            }
        });

    }

    }