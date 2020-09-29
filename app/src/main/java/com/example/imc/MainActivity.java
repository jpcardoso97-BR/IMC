package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText peso;
    private EditText altura;
    private Button enviarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        peso.findViewById(R.id.pesoEditText);
        altura.findViewById(R.id.alturaEditText);
        enviarButton.findViewById(R.id.enviarButton);

        enviarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pesoString = peso.getText().toString();
                double peso = Double.parseDouble(pesoString);
                String alturaString = altura.getText().toString();
                double altura = Double.parseDouble(alturaString);

                Intent intent = new Intent(MainActivity.this, ResultadoActivity.class);
                intent.putExtra("Peso", peso);
                intent.putExtra("Altura", altura);
                //calculaIMC(peso,altura);
                startActivity(intent);
            }
        });
    }

//    private void calculaIMC(double peso, double altura) {
//        String resultado;
//        double imc = peso / (altura + altura);
//        if (imc <= 18.5) {
//            resultado = "Abaixo do peso";
//        }
//        if (imc >= 18.5 && imc <= 24.9) {
//            resultado = "Peso Ideal";
//        }
//        if (imc >= 25 && imc <= 29.9) {
//            resultado = "Levemente acima do peso";
//        }
//        if (imc >= 30 && imc <= 34.9) {
//            resultado = "Obsidade grau I";
//        }
//        if (imc >= 35 && imc <= 39.9) {
//            resultado = "Obsidade grau II(severa)";
//        }
//        if (imc >= 40) {
//            resultado = "Obsidade grau III(mórbida)";
//        }
//    }
}
