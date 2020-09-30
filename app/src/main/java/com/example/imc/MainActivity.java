package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.number.FormattedNumber;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText peso;
    private EditText altura;
    private Button buttonEnvia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        peso = findViewById(R.id.pesoEditText);
        altura = findViewById(R.id.alturaEditText);
        buttonEnvia = findViewById(R.id.enviarButton);

        buttonEnvia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (peso.getText().toString().isEmpty()){
                    peso.setError("Informe o peso");
                    return;
                }if (altura.getText().toString().isEmpty()) {
                    altura.setError("Informe a altura");
                    return;
                }

                String pesoString = peso.getText().toString();
                double pesoD = Double.parseDouble(pesoString);
                if (pesoD <= 0){
                    peso.setError("Peso inválido");
                    return;
                }

                String alturaString = altura.getText().toString();
                double alturaD = Double.parseDouble(alturaString);
                if (alturaD <= 0){
                    altura.setError("Altura inválida");
                    return;
                }

                Intent intent = new Intent(MainActivity.this, ResultadoActivity.class);
                intent.putExtra("Peso", pesoString);
                intent.putExtra("Altura", alturaString);

                String imc = calculaIMC(pesoD, alturaD);
                intent.putExtra("Resultado", imc);

                Double resultadoIMC = imc(pesoD, alturaD);
                String imcResultado = formatar(resultadoIMC);
                intent.putExtra("IMC", imcResultado);

                startActivity(intent);
            }
        });
    }

    private String calculaIMC(double peso, double altura) {
        double imc = peso / (altura * altura);
        if (imc <= 18.5) {
            return "Abaixo do peso";
        }
        if (imc >= 18.5 && imc <= 24.9) {
            return "Peso Ideal";
        }
        if (imc >= 25 && imc <= 29.9) {
            return "Levemente acima do peso";
        }
        if (imc >= 30 && imc <= 34.9) {
            return "Obsidade grau I";
        }
        if (imc >= 35 && imc <= 39.9) {
            return "Obsidade grau II(severa)";
        }else{
            return "Obsidade grau III(mórbida)";
        }
    }

    private double imc(double peso, double altura){
        return peso/(altura*altura);
    }

    private String formatar(Double numero){
        DecimalFormat f = new DecimalFormat("0.##");
        return f.format(numero);
    }
}