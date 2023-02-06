package com.luxkapotter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText rEditNota1, rEditNota2, rEditNota3, rEditNota4;
    private TextView rTextResultado, rTextMedia;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rEditNota1 = findViewById(R.id.editNota1);
        rEditNota2 = findViewById(R.id.editNota2);
        rEditNota3 = findViewById(R.id.editNota3);
        rEditNota4 = findViewById(R.id.editNota4);

        rTextResultado = findViewById(R.id.textResultado);
        rTextMedia = findViewById(R.id.textMedia);

    }

    public void calcularMedia(View view){
        double nota1, nota2, nota3, nota4, media;

        nota1 = Double.parseDouble(rEditNota1.getText().toString());
        nota2 = Double.parseDouble(rEditNota2.getText().toString());
        nota3 = Double.parseDouble(rEditNota3.getText().toString());
        nota4 = Double.parseDouble(rEditNota4.getText().toString());

        media = (nota1+nota2+nota3+nota4)/4;

        if(media >= 7.0){
            rTextResultado.setText("ALUNO APROVADO!");
        }else{
            rTextResultado.setText("ALUNO REPROVADO!");
        }

        rTextMedia.setText("" + media);

    }
}