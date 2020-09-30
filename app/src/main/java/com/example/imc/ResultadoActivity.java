package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    private TextView pesoText;
    private TextView alturaText;
    private TextView resultadoText;
    private TextView imcText;
    private Button refazerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        pesoText = findViewById(R.id.pesoTextView);
        alturaText = findViewById(R.id.alturaTextView);
        resultadoText = findViewById(R.id.resultadoTextView);
        imcText = findViewById(R.id.imcTextView);
        refazerButton = findViewById(R.id.refazerButton);

        Intent intent = getIntent();
        String peso = intent.getStringExtra("Peso");
        String altura = intent.getStringExtra("Altura");
        String resultado = intent.getStringExtra("Resultado");
        String imc = intent.getStringExtra("IMC");
        pesoText.setText(peso);
        alturaText.setText(altura);
        resultadoText.setText(resultado);
        imcText.setText(imc);
        refazerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultadoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
