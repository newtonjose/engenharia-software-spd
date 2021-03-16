package com.github.newtonjose.pesquisa.application

import com.github.newtonjose.pesquisa.domain.Curso

import com.thoughtworks.xstream.XStream
import org.w3c.dom.Document
import org.w3c.dom.Element
import org.w3c.dom.NodeList
import org.xml.sax.SAXException

import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.parsers.ParserConfigurationException
import javax.xml.xpath.XPath
import javax.xml.xpath.XPathConstants
import javax.xml.xpath.XPathExpression
import javax.xml.xpath.XPathFactory

class Console {
    static def PATH = System.getenv("STATIC_DIR")
    static def scanner = System.in.newReader()
    static XPath xPath = XPathFactory.newInstance().newXPath()
    static DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder()
    static XStream xStream = new XStream()

    private static void pesquisaPorTexto(int op, Document documento) throws
            SAXException {

        def filtro = ""
        switch (op) {
            case 1:
                println "Insira o nome de um disciplina ou uma palavra:"
                def disciplina = scanner.readLine()
                filtro = "/universidade/curso[contains(disciplina," +
                         "'${disciplina.toUpperCase()}')]"
                break
            case 2:
                println "Insira o nome de um curso ou um ano de criação:"
                def nomeAno = scanner.readLine()

                if (nomeAno.toUpperCase().find($/[A-Z]+/$)) {
                    filtro = "/universidade/curso[contains(nome," +
                            "'${nomeAno.toUpperCase()}')]"
                } else {
                    filtro = "/universidade/curso[ano>'${nomeAno as int}']"
                }
                break
            case 3:
                filtro = "/universidade/curso"
                break
            case 4:
                System.exit(0)
                break
            default:
                println "Nenhuma opção selecionada!"
        }

        XPathExpression exp = xPath.compile(filtro)

        def lista = exp.evaluate(documento, XPathConstants.NODESET) as NodeList
        if (lista.getLength()) {
            for (int i = 0; i < lista.getLength(); i++) {
                def el = lista.item(i) as Element
                def curso = xStream.fromXML(el as String) as Curso

                println curso.toString()
            }
        } else {
            println "Não existe nenhuma disciplina com este nome ou palavra."
        }
    }

    static void main(String[] args) {
        assert System.getenv("STATIC_DIR") instanceof String

        xStream.alias("curso", Curso.class)

        // security issue
        XStream.setupDefaultSecurity(xStream)
        xStream.allowTypes(new Class[]{Curso.class})

        try {
            Document document = builder.parse(PATH)

            println "Selecione uma opção:\n" +
                    "1 - Pesquisar por texto\n" +
                    "2 - Pesquisar por número e texto\n" +
                    "3 - Listar todos os cursos\n" +
                    "4 - Sair"

            def opcao = scanner.readLine() as int

            pesquisaPorTexto(opcao, document)

        } catch (IOException ioe) {
            System.err.println ioe.getMessage()
        } catch (ParserConfigurationException pce) {
            System.err.println pce.getMessage()
        } catch (SAXException saxe) {
            System.err.println saxe.getMessage()
        }
    }
}
