package com.luxkapotter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.luxkapotter.consultacep.Endereco;
import com.luxkapotter.consultacep.ServicoDeCep;

public class MainActivity extends AppCompatActivity {

    private EditText rEditCep;
    private TextView rTextLogradouro, rTextBairro, rTextLocalidade;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rEditCep = findViewById(R.id.editCep);
        rTextLogradouro = findViewById(R.id.textLogradouro);
        rTextBairro = findViewById(R.id.textBairro);
        rTextLocalidade = findViewById(R.id.textLocalidade);
    }

    public void consultarCep(View view) throws Exception {
        String cep = rEditCep.getText().toString();
        Endereco endereco = ServicoDeCep.buscaEnderecoPelo(cep);
        rTextLogradouro.setText("Logradouro: " + endereco.getLogradouro());
        rTextBairro.setText("Bairro: " + endereco.getBairro());
        rTextLocalidade.setText("Localidade: " + endereco.getLocaliade());
    }
}