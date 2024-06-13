package com.janatavares.frasesdodia;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    String[] frases = {
            "Desejar algo maior pra sua vida não significa que você está insatisfeito com o que tem.",
            "Mudar é bom! Aprenda a se redescobrir.",
            "Ter sucesso é estar em paz com as nossas escolhas.",
    };

    TextView fraseView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        fraseView = findViewById(R.id.textViewResultado);
    }



    public void gerarFrase(View view){
        int indice = (int) (Math.random() * frases.length);
        String frase = frases[indice];
        fraseView.setText(frase);
    }

    public void exibirTodas(View view){

        StringBuilder todasFrases = new StringBuilder();
        for (String frase : frases) {
            todasFrases.append(frase).append("\n");
        }
        fraseView.setText(todasFrases);
    }
}