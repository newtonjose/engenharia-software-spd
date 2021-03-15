package com.github.newtonjose.gravacao.application

import com.thoughtworks.xstream.XStream

import com.github.newtonjose.gravacao.domain.ArquivoUtils
import com.github.newtonjose.gravacao.domain.Funcionario
import com.github.newtonjose.gravacao.domain.Habilidade


class Console {
    static def scanner = System.in.newReader()
    static XStream xstream = new XStream()
    static ArquivoUtils arqUtils = new ArquivoUtils()

    private static void escreveFuncionarioXML() {
        println "Informe o seu CPF:"
        def cpf = scanner.readLine()

        println "Informe o seu nome:"
        def nome = scanner.readLine()

        println "Informe o seu cargo:"
        def cargo = scanner.readLine()

        println "Informe a sua idade:"
        def idade = scanner.readLine() as int

        println "Informe o seu salário:"
        def salario = scanner.readLine() as double

        println "Quais suas habilidades (se tem mais de uma, separe por " +
                "vírgula):"
        def habilidades = scanner.readLine()

        def func = new Funcionario(
                cpf: cpf, nome: nome, idade: idade, cargo: cargo,
                salario: salario, habilidades: Funcionario
                .convertHabilidades(habilidades)
        )

        String xmlDoc = xstream.toXML(func)

        arqUtils.escreveArquivoTexto(cpf + ".xml", xmlDoc)
    }

    private static void lerFuncionarioXML() {
        println "Informe o seu CPF:"
        def cpf = scanner.readLine()

        try {
            String arqXML = arqUtils.lerArquivoTexto(cpf + ".xml")

            def func = (Funcionario) xstream.fromXML(arqXML)

            println "CPF: " + func.getCpf()
            println "Nome: " + func.getNome()
            println "Idade: " + func.getIdade()
            println "Cargo: " + func.getCargo()
            println "Salario: " + func.getSalario()
            println "Habilidades: " + func.getHabilidades()
        } catch (ignored) {
            System.err.println "Não tem nenhum funcionário salvo com este CPF."
        }
    }

    static void main(String[] args) {
        assert System.getenv("STATIC_DIR") instanceof String

        // classes alias
        xstream.alias("funcionario", Funcionario.class)
        xstream.alias("habilidade", Habilidade.class)

        // security issue
        XStream.setupDefaultSecurity(xstream)
        xstream.allowTypes(new Class[]{Funcionario.class, Habilidade.class})


        println "Digite:\n" +
                "1 - Criar um novo funcionário\n" +
                "2 - Para visualizar os dodos de um funcionário " +
                "cadastrado"

        def opcao = scanner.readLine() as int

        switch (opcao) {
            case 1:
                escreveFuncionarioXML()
                break
            case 2:
                lerFuncionarioXML()
                break
            default:
                println "Nenhuma opção selecionada!"
        }

    }
}
