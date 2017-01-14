<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sistema de Ordem de Serviço</title>
<link rel="shortcut icon" type="image/x-icon" href="http://scontent.cdninstagram.com/t51.2885-19/s150x150/14723099_1723586417964495_3127319396507189248_a.jpg"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="../js/jquery.blockUI.js"></script>

<style>
#coluna1 {
	float: left;
	width: 33%;
	height: 100%;
}

#coluna2 {
	float: left;
	width: 33%;
	height: 100%;
}

#coluna3 {
	float: left;
	width: 33%;
	height: 100%;
}

.tela {
	border-width: 6px;
    border-style: dashed;
	border-color: #ee5f03;
	border-radius: 8px;
	text-align: center;
	font-weight: bold;
	line-height: 1px;
	padding-top: 20px;
}
.acesso{
	background-color: #ee5f03;
	color: white;
	font-weight: bold;
	font-size: 16pt;
	width: 150px;
	height: 70px;
	border-radius: 8px;
}
.test{
	text-decoration: none;
}
</style>
<script>
$(document).ready(function() { 
	var url = '';
    $('.acesso').click(function() { 
    	$this = $(this);
        $.blockUI({ 
        	
            message: '<h1><img src="../image/loadingpaper.gif"/> Carregando</h1>', 
            timeout:  4000,
			fadeIn: 200,
			onUnblock: function() { 
                window.location.href = 'http://localhost:8082/desafio/jsp/cadastro/ordem.jsp'; 
            } 
       
        }); 
       
    }); 
}); 
</script>
</head>
<body>

	<div id="coluna1">
		<h1 style="color: white;">Primeira</h1>
	</div>
	<div id="coluna2" class="tela" >
	<br/>
		<img src="../image/advertencia.png" />
		<h2>Sistema de Cadastro</h2>
		<h2>de Ordem de Serviço</h2>
		
		<button class="acesso">Acessar</button>
		
		<br/><br/><br/><br/>
	</div>
	<div id="coluna3">
		
	</div>
	
</body>
</html>