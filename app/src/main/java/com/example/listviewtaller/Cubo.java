package com.example.listviewtaller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Cubo extends AppCompatActivity {
    private EditText DatoArista;
    private TextView Dato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cubo);

        DatoArista = findViewById(R.id.txtDatoCubo);
        Dato = findViewById(R.id.txtCalcularCubo);
    }

    public void guardar(View v){
        String resultado, operacion, dato, mensaje_guardado;
        Double result;

        mensaje_guardado = getResources().getString(R.string.mensaje_guardado)+" - "+getResources().getString(R.string.tabla_Resultado)+": ";
        operacion = getResources().getString(R.string.guardar_VolumenCubo);

        Operaciones Op;
        if(validar()){
            dato = Dato.getText().toString() +": "+ DatoArista.getText().toString();

            result = Math.pow(Integer.parseInt(DatoArista.getText().toString()),3);
            DecimalFormat formato = new DecimalFormat("#.0");
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

        if(DatoArista.getText().toString().isEmpty()){
            DatoArista.setError(error_CampoVacio);
            return false;
        }
        if( 0 >= Integer.parseInt(DatoArista.getText().toString()) ){
            DatoArista.setError(error_CampoMenorCero);
            return false;
        }
        return true;
    }

    public void limpiar(View v){
        limpiar();
    }

    public void limpiar(){
        DatoArista.setText("");
        DatoArista.requestFocus();
    }
}
