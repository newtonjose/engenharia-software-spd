package com.github.newtonjose.pesquisa.domain

class ArquivoUtils {
    static String PATH = System.getenv("STATIC_DIR")

    static void escreveArquivoTexto(
            String nomeArq, String arqStr) throws IOException {
        FileWriter arq = new FileWriter(PATH + nomeArq)

        BufferedWriter bufferedWriter = new BufferedWriter(arq)

        bufferedWriter.write(arqStr)
        bufferedWriter.close()
    }

    static def lerArquivoTexto(String nomeArq) throws IOException {
        BufferedReader arquivo = new BufferedReader(new FileReader(PATH + nomeArq))

        StringBuilder arqStrBuilder = new StringBuilder()

        String linha
        while ((linha = arquivo.readLine()) != null) {
            arqStrBuilder.append(linha)
        }

        return arqStrBuilder
    }
}
