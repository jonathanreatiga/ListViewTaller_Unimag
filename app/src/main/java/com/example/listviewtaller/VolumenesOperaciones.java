package com.example.listviewtaller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class VolumenesOperaciones extends AppCompatActivity {
    private ListView lista_opciones;
    private String[] opciones;
    private ArrayAdapter<String> adapter;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumenes_operaciones);

        lista_opciones = findViewById(R.id.lstVolumenesOpciones);
        opciones = getResources().getStringArray(R.array.opcionesVolumenes);
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, opciones);
        lista_opciones.setAdapter(adapter);
        lista_opciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position) {
                    case 0:
                        intent = new Intent(VolumenesOperaciones.this, Esfera.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(VolumenesOperaciones.this, Cilindro.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(VolumenesOperaciones.this, Cono.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(VolumenesOperaciones.this, Cubo.class);
                        startActivity(intent);
                        break;
                }}
        });

    }
}
