package com.example.listviewtaller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Rectangulo extends AppCompatActivity {
    private EditText DatoBase, DatoAltura;
    private TextView txtBase, txtAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangulo);

        DatoBase = findViewById(R.id.lblDatoRectanguloBase);
        DatoAltura = findViewById(R.id.lblDatoRectanguloAltura);
        txtBase = findViewById(R.id.txtCalcularRectanguloBase);
        txtAltura = findViewById(R.id.txtCalcularRectanguloAltura);
    }

    public void guardar(View v){
        String resultado, operacion, dato, mensaje_guardado;
        mensaje_guardado = getResources().getString(R.string.mensaje_guardado)+" - "+getResources().getString(R.string.tabla_Resultado)+": ";
        operacion = getResources().getString(R.string.guardar_AreaDelRectangulo);

        Operaciones Op;
        if(validar()){
            dato = txtBase.getText().toString() +": "+ DatoBase.getText().toString()+" - "+txtAltura.getText().toString() +": "+ DatoAltura.getText().toString();
            resultado = Integer.toString(Integer.parseInt(DatoBase.getText().toString()) * Integer.parseInt(DatoAltura.getText().toString()));
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

        if(DatoBase.getText().toString().isEmpty()){
            DatoBase.setError(error_CampoVacio);
            DatoBase.requestFocus();
            return false;
        }
        if( 0 >= Integer.parseInt(DatoBase.getText().toString()) ){
            DatoBase.setError(error_CampoMenorCero);
            DatoBase.requestFocus();
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
        DatoBase.setText("");
        DatoAltura.setText("");
        DatoBase.requestFocus();
    }
}
