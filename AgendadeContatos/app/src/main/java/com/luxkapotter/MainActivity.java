package com.luxkapotter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.luxkapotter.dao.PessoaDao;
import com.luxkapotter.modelo.Pessoa;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listaVisivel;
    Button btnNovoRegistro;
    Pessoa pessoa;
    PessoaDao pessoaDao;
    ArrayList<Pessoa> arrayPessoa;
    ArrayAdapter<Pessoa> adapterPessoa;


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

        listaVisivel.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Pessoa pessoaEnviada = (Pessoa) adapterPessoa.getItem(position);

                Intent i = new Intent(MainActivity.this, FormPessoa.class);
                i.putExtra("pessoa-enviada", pessoaEnviada);
                startActivity(i);
            }
        });
    }

    public void populaLista(){
        pessoaDao = new PessoaDao(MainActivity.this);

        arrayPessoa = pessoaDao.selectPessoas();

        pessoaDao.close();

        if(listaVisivel != null){
            adapterPessoa = new ArrayAdapter<Pessoa>(MainActivity.this, android.R.layout.simple_list_item_1, arrayPessoa);
            listaVisivel.setAdapter(adapterPessoa);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        populaLista();
    }
}