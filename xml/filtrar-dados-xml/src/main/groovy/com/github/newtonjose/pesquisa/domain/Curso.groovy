package com.github.newtonjose.pesquisa.domain

class Curso {
    int iden
    int ano
    String nome
    String disciplina
    int ch

    @Override
    String toString() {
        return "Nome: " + nome + ", Iden: " + iden + ", Ano: " + ano +
                ", Disciplina: " + disciplina + ", Ch: " + ch
    }
}
