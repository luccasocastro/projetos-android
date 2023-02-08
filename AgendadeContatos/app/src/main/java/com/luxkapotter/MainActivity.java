package com.luxkapotter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listaVisivel;
    Button btnNovoRegistro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaVisivel = (ListView) findViewById(R.id.listaPessoas);
        btnNovoRegistro = (Button) findViewById(R.id.btnNovoRegistro);

        btnNovoRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, FormPessoa.class);
                startActivity(i);
            }
        });
    }
}