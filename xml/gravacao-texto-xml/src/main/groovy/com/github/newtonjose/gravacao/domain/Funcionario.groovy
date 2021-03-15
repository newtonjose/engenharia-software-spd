package com.github.newtonjose.gravacao.domain

class Funcionario {
    String cpf
    String nome
    int idade
    double salario
    String cargo
    ArrayList<Habilidade> habilidades

    static def convertHabilidades(String hbs) {
        String[] hbsSplited = hbs.split(",")

        def hbsList = []

        for (int i = 0; i < hbsSplited.length; i++) {
            hbsList.add(new Habilidade(nome: hbsSplited[i].trim()))
        }

        return hbsList
    }

    def getHabilidades() {
        def hbs = []
        habilidades.forEach(h -> hbs.add(h.getNome()))

        return hbs
    }
}
