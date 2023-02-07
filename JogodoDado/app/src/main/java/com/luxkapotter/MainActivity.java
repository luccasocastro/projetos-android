package com.luxkapotter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imgDado;

    private int[] numerosDoDado = {
            R.drawable.diceum,
            R.drawable.dicedois,
            R.drawable.dicetres,
            R.drawable.dicequatro,
            R.drawable.dicecinco,
            R.drawable.diceseis
    };

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgDado = findViewById(R.id.imgDado);

        imgDado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int numeroAleatorio = new Random().nextInt(numerosDoDado.length);
                imgDado.setImageResource(numerosDoDado[numeroAleatorio]);
            }
        });

    }
}