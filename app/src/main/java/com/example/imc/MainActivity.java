package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Objetos Encapsulados
    private EditText editTextPeso;
    private EditText editTextAltura;
    private TextView textViewResultado;

    //Método principal
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Vinculando os objetos com elementos de layout
        editTextPeso = findViewById(R.id.edit_text_peso);
        editTextAltura = findViewById(R.id.edit_text_altura);
        textViewResultado = findViewById(R.id.text_view_resultado);
    }

      public void calcularIMC(View v)
      {
        Double peso = Double.parseDouble(editTextPeso.
                getText().
                toString().
                replace(",",".")
        );
        Double altura = Double.parseDouble(editTextAltura.
                getText().
                toString().
                replace(",",".")
        );

        Double imc = peso / Math.pow(altura, 2);

        if (imc<18.5) {
            textViewResultado.setText("Magreza");

            textViewResultado.setTextColor(
                    getResources().
                            getColor(R.color.magreza)
            );
        }
        else if (imc>=18.5 && imc<24.9){
        textViewResultado.setText("Saudável");

        textViewResultado.setTextColor(
                getResources().
                        getColor(R.color.saudavel)

        );
      }
    }

    public void trocaActivity(View v){
        Intent intent = new Intent(this, InfoActivity.class);
        intent.putExtra("RESULTADO", 22.6);
        startActivity(intent);
    }
}
