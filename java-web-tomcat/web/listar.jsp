<%@ page import="main.java.github.newtonjose.domain.models.Candidato" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
          crossorigin="anonymous">
    <title>Controle de Candidatos</title>
</head>
<body>
<table class="table mt-3 ms-3 table-hover">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Nome</th>
        <th scope="col">Gênero</th>
        <th scope="col">Data de Nascimento</th>
        <th scope="col">Cargo Pretendido</th>
        <th scope="col">Resumo do Currículo</th>
        <th scope="col">Ações</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <%for (Candidato c : candidatos) {%>
        <th scope="row">
            <%=c.getCodigo()%>
        </th>
        <th scope="row">
            <%=c.getName()%>
        </th>
        <th scope="row">
            <%=c.getGender()%>
        </th>
        <th scope="row">
            <%=c.getBornDate()%>
        </th>
        <th scope="row">
            <%=c.getJobPosition()%>
        </th>
        <th scope="row">
            <%=c.getCurriculumResume()%>
        </th>
        <a href="/deletar"></a>
        <% } %>
    </tr>
    </tbody>
</table>
<br/>
<a href="/index.html">
    <button class="btn btn-primary mt-3 ms-3">Voltar</button>
</a>
</body>
</html>
