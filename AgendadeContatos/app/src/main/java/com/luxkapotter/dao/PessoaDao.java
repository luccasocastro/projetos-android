package com.luxkapotter.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.luxkapotter.modelo.Pessoa;

import java.util.ArrayList;

public class PessoaDao extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "DBPessoa.db";
    private static final int VERSION = 1;
    private static final String TABELA = "pessoa";

    private static final String ID = "id";
    private static final String NOME = "nome";
    private static final String IDADE = "idade";
    private static final String ENDERECO = "endereco";
    private static final String TELEFONE = "telefone";

    public PessoaDao(@Nullable Context context) {
        super(context, NOME_BANCO, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABELA + "(" +
                " " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " " + NOME + " TEXT, " + IDADE + " INTEGER, " +
                " " + ENDERECO + " TEXT, " + TELEFONE + " TEXT );";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS " + TABELA;
        db.execSQL(sql);
        onCreate(db);
    }

    public long salvarPessoa(Pessoa p){
        ContentValues values = new ContentValues();
        long retornoDb;

        values.put(NOME, p.getNome());
        values.put(IDADE, p.getIdade());
        values.put(ENDERECO, p.getEndereco());
        values.put(TELEFONE, p.getTelefone());

        retornoDb = getWritableDatabase().insert(TABELA, null, values);

        return retornoDb;
    }
    public ArrayList<Pessoa> selectPessoas(){

        String[] colunas = {ID, NOME, IDADE, ENDERECO, TELEFONE};

        Cursor cursor = getWritableDatabase().query(TABELA,colunas,null,null,null,null,"upper(nome)", null);

        ArrayList<Pessoa> listPessoas = new ArrayList<Pessoa>();

        while(cursor.moveToNext()){
            Pessoa p = new Pessoa();

            p.setId(cursor.getInt(0));
            p.setNome(cursor.getString(1));
            p.setIdade(cursor.getInt(2));
            p.setEndereco(cursor.getString(3));
            p.setTelefone(cursor.getString(4));

            listPessoas.add(p);
        }

        return listPessoas;
    }

    public long alterarPessoa(Pessoa p){
        ContentValues values = new ContentValues();
        long retornoDb;

        values.put(NOME, p.getNome());
        values.put(IDADE, p.getIdade());
        values.put(ENDERECO, p.getEndereco());
        values.put(TELEFONE, p.getTelefone());

        String[] args = {String.valueOf(p.getId())};
        retornoDb = getWritableDatabase().update(TABELA, values, "id=?", args);

        return retornoDb;
    }

    public long deletarPessoa(Pessoa p){
        long retornoDb;

        String[] args = {String.valueOf(p.getId())};
        retornoDb = getWritableDatabase().delete(TABELA,ID+"=?", args);

        return retornoDb;
    }
}
