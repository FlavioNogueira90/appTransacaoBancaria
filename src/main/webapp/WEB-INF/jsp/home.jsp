<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Aplicação AgroBank</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">AgroBank</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
      <ul class="navbar-nav">
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Serviços</a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="/contaCorrente">Conta Corrente</a></li>
            <li><a class="dropdown-item" href="/contaPoupanca">Poupança</a></li>
            <li><a class="dropdown-item" href="/contaInvestimento">Investimentos</a></li>
          </ul>
        </li>
  
        <li class="nav-item">
          <a class="nav-link" href="/cliente/cadastroCliente">Abra sua conta</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/sobre">Sobre</a>
        </li> 
          
      </ul>
    </div>
    
        
      <ul class="nav navbar-nav navbar-right">
      <c:if test="${empty user}">
	      <li><a href="/cliente/cadastroCliente"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>      
	      <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </c:if>
      
      <c:if test="${not empty user}">
      	  <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Logout ${user.nome}</a></li>
      </c:if>
    </ul>
      
  </div>
</nav>


    
<!-- Carousel -->
<div id="demo" class="carousel slide" data-bs-ride="carousel">
    
  <!-- Indicators/dots -->
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
    <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
    <button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
  </div>
  
  <!-- The slideshow/carousel -->
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src=https://files.certifiquei.com.br/p/uploads/2022/01/conta-investimento.jpg alt="Los Angeles" class="d-block" width="100%" height="400">
      <div class="carousel-caption">
        <h3>Conta Corrente</h3>

      </div>
    </div>
    <div class="carousel-item">
      <img src=https://cdn.borainvestir.b3.com.br/2022/07/22173445/seisdicasparaeconomizardinheiro-1.jpg.webp alt="Chicago" class="d-block" width="100%" height="400">
      <div class="carousel-caption">
        <h3>Conta Poupança</h3>

      </div> 
    </div>
    <div class="carousel-item">
      <img src=https://files.certifiquei.com.br/p/uploads/2022/01/conta-investimento-1.jpg alt="New York" class="d-block" width="100%" height="400">
      <div class="carousel-caption">
        <h3>Conta Investimento</h3>

      </div>  
    </div>
  </div>
  
  <!-- Left and right controls/icons -->
  <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
    <span class="carousel-control-next-icon"></span>
  </button>
</div>

<div class="container-fluid mt-3">
  <h3>Bem vindo ao AgroBank</h3>
  <p>Somos uma instituição financeira focada no agronegócio com itúito de levar facilidades ao campo. Venha fazer parte da nossa história e nos permita fazer parte da sua.</p>
    <p>Abra já sua conta investimento com a gente, plante agora e colha no futuro!</p>
</div>

</body>
</html>
