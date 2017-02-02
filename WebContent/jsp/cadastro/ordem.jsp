<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Página de cadastro de Ordem de Serviço</title>
<link rel="shortcut icon" type="image/x-icon" href="http://www.abegas.org.br/Site/wp-content/uploads/2012/03/h_lg_algas.jpg"/>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker({ dateFormat: 'dd/mm/yy',
    	 monthNames: [ "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" ],
    	 gotoCurrent: true
    });
  } );
  </script>
</head>

<style>
header{
	background-color: black;
	color: white;
	font-weight: bold;
	padding-top: 10px;
	height: 100%;
	text-decoration: blink;
}
</style>
<body>
<header>
<h1>Cadastro de Ordem de Serviço</h1>
</header>
 <c:if test="${msg != ''} ">
<label><strong style="color: red;">${msg}</strong></label>
</c:if>
<html:form action="/index.do?acao=Sair">
<html:text styleId="datepicker" property="dataformatada"/>
<html:submit value="Sair"></html:submit>
</html:form>
</body>
</html>