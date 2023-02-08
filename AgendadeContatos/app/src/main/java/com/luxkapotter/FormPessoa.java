package com.luxkapotter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.luxkapotter.dao.PessoaDao;
import com.luxkapotter.modelo.Pessoa;

public class FormPessoa extends AppCompatActivity {

    EditText editNome, editIdade, editEndereco, editTelefone;
    Button btnVariavel;
    Pessoa pessoa, altPessoa;
    PessoaDao pessoaDao;
    long retornoDb;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_pessoa);

        Intent i = getIntent();
        altPessoa = (Pessoa) i.getSerializableExtra("pessoa-enviada");
        pessoa = new Pessoa();
        pessoaDao = new PessoaDao(FormPessoa.this);

        editNome = (EditText) findViewById(R.id.editNome);
        editIdade = (EditText) findViewById(R.id.editIdade);
        editEndereco = (EditText) findViewById(R.id.editEndereco);
        editTelefone = (EditText) findViewById(R.id.editTelefone);
        btnVariavel = (Button) findViewById(R.id.btnVariavel);

        if(altPessoa != null){
            btnVariavel.setText("Alterar");
            editNome.setText(altPessoa.getNome());
            editIdade.setText(altPessoa.getIdade()+"");
            editEndereco.setText(altPessoa.getEndereco());
            editTelefone.setText(altPessoa.getTelefone());

            pessoa.setId(altPessoa.getId());
        }else{
            btnVariavel.setText("Salvar");
        }

        btnVariavel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pessoa.setId(altPessoa.getId());
                pessoa.setNome(editNome.getText().toString());
                pessoa.setIdade(Integer.parseInt(editIdade.getText().toString()));
                pessoa.setEndereco(editEndereco.getText().toString());
                pessoa.setTelefone(editTelefone.getText().toString());

                if(btnVariavel.getText().toString().equals("Salvar")){
                    retornoDb = pessoaDao.salvarPessoa(pessoa);
                    pessoaDao.close();
                    if(retornoDb == -1){
                        alert("Erro ao cadastrar!");
                    }else{
                        alert("Cadastro realizado com sucesso!");
                    }
                }else{
                    retornoDb = pessoaDao.alterarPessoa(pessoa);
                    pessoaDao.close();
                    if(retornoDb == -1){
                        alert("Erro ao atualizar contato!");
                    }else{
                        alert("Contato atualizado com sucesso!");
                    }
                }
                finish();
            }
        });
    }
    private void alert(String s){
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}