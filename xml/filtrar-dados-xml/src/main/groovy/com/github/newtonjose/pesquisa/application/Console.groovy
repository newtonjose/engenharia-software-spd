package com.github.newtonjose.pesquisa.application

import com.thoughtworks.xstream.XStream

import com.github.newtonjose.pesquisa.domain.ArquivoUtils


class Console {
    static def scanner = System.in.newReader()
    static XStream xstream = new XStream()
    static ArquivoUtils arqUtils = new ArquivoUtils()

    private static void lerFuncionarioXML() {
        println "Informe o seu CPF:"
        def cpf = scanner.readLine()

        try {
            String arqXML = arqUtils.lerArquivoTexto(cpf + ".xml")

        } catch (FileNotFoundException f) {
            System.err.println f.getMessage()
        }
    }

    static void main(String[] args) {
        assert System.getenv("STATIC_DIR") instanceof String

        // classes alias
//        xstream.alias("funcionario", Funcionario.class)
//        xstream.alias("habilidade", Habilidade.class)

        // security issue
        XStream.setupDefaultSecurity(xstream)
//        xstream.allowTypes(new Class[]{Funcionario.class, Habilidade.class})


        println "Digite:\n" +
                "1 - Criar um novo funcionário\n" +
                "2 - Visualizar os dodos de um funcionário"

        def opcao = scanner.readLine() as int

        switch (opcao) {
            case 1:
                break
            case 2:
                lerFuncionarioXML()
                break
            default:
                println "Nenhuma opção selecionada!"
        }

    }
}
