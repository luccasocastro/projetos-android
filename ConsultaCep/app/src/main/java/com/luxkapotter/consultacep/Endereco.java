package com.luxkapotter.consultacep;

public class Endereco {
    private String logradouro;
    private String bairro;
    private String localiade;

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocaliade() {
        return localiade;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "logradouro='" + logradouro + '\'' +
                ", bairro='" + bairro + '\'' +
                ", localiade='" + localiade + '\'' +
                '}';
    }
}
