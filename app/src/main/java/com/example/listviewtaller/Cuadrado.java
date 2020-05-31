package com.example.listviewtaller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Cuadrado extends AppCompatActivity {
    private EditText DatoCuadrado;
    private TextView Dato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuadrado);

        DatoCuadrado = findViewById(R.id.txtDatoCuadrado);
        Dato = findViewById(R.id.txtCalcularCuadrado);
    }

    public void guardar(View v){
        String resultado, operacion, dato, mensaje_guardado;
        mensaje_guardado = getResources().getString(R.string.mensaje_guardado)+" - "+getResources().getString(R.string.tabla_Resultado)+": ";
        operacion = getResources().getString(R.string.guardar_AreaDelCuadrado);

        Operaciones Op;
        if(validar()){
            dato = Dato.getText().toString() +": "+ DatoCuadrado.getText().toString();
            resultado = Integer.toString(Integer.parseInt(DatoCuadrado.getText().toString()) * Integer.parseInt(DatoCuadrado.getText().toString()));
            Op = new Operaciones(operacion,dato,resultado);
            Op.guardar();
            Toast.makeText(this,mensaje_guardado + resultado, Toast.LENGTH_LONG).show();
            limpiar();
        }
    }

    public boolean validar(){
        String error_CampoVacio, error_CampoMenorCero;

        error_CampoVacio = getResources().getString(R.string.error_CampoVacio);
        error_CampoMenorCero = getResources().getString(R.string.error_CampoMenorCero);

        if(DatoCuadrado.getText().toString().isEmpty()){
            DatoCuadrado.setError(error_CampoVacio);
            return false;
        }
        if( 0 >= Integer.parseInt(DatoCuadrado.getText().toString()) ){
            DatoCuadrado.setError(error_CampoMenorCero);
            return false;
        }
        return true;
    }

    public void limpiar(View v){
        limpiar();
    }

    public void limpiar(){
        DatoCuadrado.setText("");
        DatoCuadrado.requestFocus();
    }

}
