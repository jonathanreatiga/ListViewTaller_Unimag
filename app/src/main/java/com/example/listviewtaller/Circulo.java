package com.example.listviewtaller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Circulo extends AppCompatActivity {
    private EditText DatoCirculo;
    private TextView Dato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulo);

        DatoCirculo = findViewById(R.id.txtDatoCirculo);
        Dato = findViewById(R.id.txtCalcularCirculo);
    }

    public void guardar(View v){
        String resultado, operacion, dato, mensaje_guardado;
        Double result;

        mensaje_guardado = getResources().getString(R.string.mensaje_guardado)+" - "+getResources().getString(R.string.tabla_Resultado)+": ";
        operacion = getResources().getString(R.string.guardar_AreaDelCirculo);

        Operaciones Op;
        if(validar()){
            dato = Dato.getText().toString() +": "+ DatoCirculo.getText().toString();

            result = Math.PI * Math.pow(Integer.parseInt(DatoCirculo.getText().toString()),2);
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

        if(DatoCirculo.getText().toString().isEmpty()){
            DatoCirculo.setError(error_CampoVacio);
            return false;
        }
        if( 0 >= Integer.parseInt(DatoCirculo.getText().toString()) ){
            DatoCirculo.setError(error_CampoMenorCero);
            return false;
        }
        return true;
    }

    public void limpiar(View v){
        limpiar();
    }

    public void limpiar(){
        DatoCirculo.setText("");
        DatoCirculo.requestFocus();
    }
}
