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
            R.drawable.lado1,
            R.drawable.lado2,
            R.drawable.lado3,
            R.drawable.lado4,
            R.drawable.lado5,
            R.drawable.lado6
    };

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgDado = findViewById(R.id.imgDado);
    }

    public void jogarDado(View view){
        int numerosAleatorios = new Random().nextInt(numerosDoDado.length);
        imgDado.setImageResource(numerosDoDado[numerosAleatorios]);
    }
}