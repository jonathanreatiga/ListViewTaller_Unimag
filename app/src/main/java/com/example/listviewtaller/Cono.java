package com.example.listviewtaller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Cono extends AppCompatActivity {
    private EditText DatoRadio, DatoAltura;
    private TextView txtRadio, txtAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cono);

        DatoRadio = findViewById(R.id.lblDatoConoRadio);
        DatoAltura = findViewById(R.id.lblDatoConoAltura);
        txtRadio = findViewById(R.id.txtCalcularConoRadio);
        txtAltura = findViewById(R.id.txtCalcularConoAltura);
    }

    public void guardar(View v){
        String resultado, operacion, dato, mensaje_guardado;
        double result;

        mensaje_guardado = getResources().getString(R.string.mensaje_guardado)+" - "+getResources().getString(R.string.tabla_Resultado)+": ";
        operacion = getResources().getString(R.string.guardar_VolumenCono);

        Operaciones Op;
        if(validar()){
            dato = txtRadio.getText().toString() +": "+ DatoRadio.getText().toString()+" - "+txtAltura.getText().toString() +": "+ DatoAltura.getText().toString();

            result = (Math.PI * Math.pow(Integer.parseInt(DatoRadio.getText().toString()),2) * Integer.parseInt(DatoAltura.getText().toString()) ) / 3;
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

        if(DatoRadio.getText().toString().isEmpty()){
            DatoRadio.setError(error_CampoVacio);
            DatoRadio.requestFocus();
            return false;
        }
        if( 0 >= Integer.parseInt(DatoRadio.getText().toString()) ){
            DatoRadio.setError(error_CampoMenorCero);
            DatoRadio.requestFocus();
            return false;
        }

        if(DatoAltura.getText().toString().isEmpty()){
            DatoAltura.setError(error_CampoVacio);
            DatoAltura.requestFocus();
            return false;
        }
        if( 0 >= Integer.parseInt(DatoAltura.getText().toString()) ){
            DatoAltura.setError(error_CampoMenorCero);
            DatoAltura.requestFocus();
            return false;
        }
        return true;
    }

    public void limpiar(View v){
        limpiar();
    }

    public void limpiar(){
        DatoRadio.setText("");
        DatoAltura.setText("");
        DatoRadio.requestFocus();
    }
}
