package com.example.aluno.dbsamples;

import com.orm.SugarRecord;

/**
 * Created by Aluno on 21/01/2016.
 */
public class Aluno extends SugarRecord {

    private String nome;
    private String email;

    public Aluno(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Aluno{ID = "+getId()+ "nome='" + nome + '\'' + ", email='" + email + '\'' +'}';
    }
}
