package com.teste.appalcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private EditText  editPrecoAlcool, editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);
        textResultado = findViewById(R.id.textResultado);


    }


    public void calcularPreco(View view){
        //Recuperar Preço
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        //Verificar se tem campo em branco
        Boolean camposValidados = validarCampos(precoAlcool,precoGasolina);

        if(camposValidados){
            //convertendo string para double
            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);

            Double resultado = valorAlcool/valorGasolina;

            if(resultado >= 0.7){
                textResultado.setText("Melhor abastecer com Gasolina!");
            }else{
                textResultado.setText("Melhor abastecer com Alcool!");
            }
        }else{
            textResultado.setText("Preencha os preços primeiro!");
        }

    }
    public boolean validarCampos(String pAlcool, String pGasolina){
        Boolean camposValidados = true;

        if(pAlcool == null || pAlcool.equals("")){
            camposValidados = false;
        }else if(pGasolina == null || pGasolina.equals("")){
            camposValidados = false;
        }

        return camposValidados;
    }
}