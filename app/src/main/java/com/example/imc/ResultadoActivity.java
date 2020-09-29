package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    private TextView pesoText;
    private TextView alturaText;
    private Button refazerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        pesoText.findViewById(R.id.pesoTextView);
        alturaText.findViewById(R.id.alturaTextView);
        refazerButton.findViewById(R.id.refazerButton);

        Intent intent = getIntent();
        String peso = intent.getStringExtra("Peso");
        String altura = intent.getStringExtra("Altura");
        pesoText.setText(peso);
        alturaText.setText(altura);

    }
}
