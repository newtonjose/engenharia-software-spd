package main.java.github.newtonjose.domain.models;

import java.time.LocalDate;
import java.util.Date;

/*
    codigo               INT PK (pode ou não ser autoincremento, à escolha)
    periodo              char(1)    --M, V ou N (matutino, vespertino,noturno)
    nomepaciente             varchar(60)
    cpf                                 varchar(11)
    data                              DATE
    dose                              int   -- 1 ou 2 (1ª dose ou 2ª dose)
    local                              varchar(30)   --texto com o nome que será aplicado a vacina.
    situacao                       int   --1, 2 ou 3 (1-agendado; 2-executado; 3-cancelado)
    databaixa                    DATE   --gravar nulo quando a situação for 1;  se a situação for 2 ou 3, grave data atual.
 */
public class Agenda {
    private int codigo;
    private char periodo;
    private String nomepaciente;
    private String cpf;
    private LocalDate data;
    private int dose;
    private String local;
    private int situacao;
    private LocalDate databaixa;

    public Agenda(char periodo, String nomepaciente, String cpf, LocalDate data,
                  int dose, String local, int situacao, LocalDate databaixa) {

        this.periodo =  periodo;
        this.nomepaciente = nomepaciente;
        this.cpf = cpf;
        this.data = data;
        this.dose = dose;
        this.local = local;
        this.situacao = situacao;
        this.databaixa = databaixa;
    }

    public char getPeriodo() {
        return periodo;
    }

    public String getNomepaciente() {
        return nomepaciente;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getData() {
        return data;
    }

    public int getDose() {
        return dose;
    }

    public String getLocal() {
        return local;
    }

    public int getSituacao() {
        return situacao;
    }

    public LocalDate getDatabaixa() {
        return databaixa;
    }

    public void setCodigo(int cod) {
        codigo = cod;
    }

    public int getCodigo() {
        return codigo;
    }
}

