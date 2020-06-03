package com.example.listviewtaller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Esfera extends AppCompatActivity {
    private EditText DatoEsfera;
    private TextView Dato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esfera);

        DatoEsfera = findViewById(R.id.txtDatoEsfera);
        Dato = findViewById(R.id.txtCalcularEsfera);
    }

    public void guardar(View v){
        String resultado, operacion, dato, mensaje_guardado;
        Double result;

        mensaje_guardado = getResources().getString(R.string.mensaje_guardado)+" - "+getResources().getString(R.string.tabla_Resultado)+": ";
        operacion = getResources().getString(R.string.guardar_VolumenEsfera);

        Operaciones Op;
        if(validar()){
            dato = Dato.getText().toString() +": "+ DatoEsfera.getText().toString();

            result = (4 * Math.PI * Math.pow(Integer.parseInt(DatoEsfera.getText().toString()),3)) /3;
            DecimalFormat formato = new DecimalFormat("#.000");
            resultado = formato.format(result);

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

        if(DatoEsfera.getText().toString().isEmpty()){
            DatoEsfera.setError(error_CampoVacio);
            return false;
        }
        if( 0 >= Integer.parseInt(DatoEsfera.getText().toString()) ){
            DatoEsfera.setError(error_CampoMenorCero);
            return false;
        }
        return true;
    }

    public void limpiar(View v){
        limpiar();
    }

    public void limpiar(){
        DatoEsfera.setText("");
        DatoEsfera.requestFocus();
    }
}
