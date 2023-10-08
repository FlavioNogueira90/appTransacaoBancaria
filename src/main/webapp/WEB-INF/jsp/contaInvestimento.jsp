<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Conta Corrente</title>
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
        <c:if test="${empty user}">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Servi�os</a>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="/contaCorrente">Conta Corrente</a></li>
                    <li><a class="dropdown-item" href="/contaPoupanca">Poupan�a</a></li>
                    <li><a class="dropdown-item" href="/contaInvestimento">Investimentos</a></li>
                </ul>
            </li>
        </c:if>
            
        <c:if test="${not empty user}">    
                <div class="collapse navbar-collapse" id="collapsibleNavbar">
                  <ul class="navbar-nav">
                    <li class="nav-item">
                      <a class="nav-link" href="/contaCorrenteLogado">Conta Corrente</a>
                    </li>                       
                    <li class="nav-item">
                      <a class="nav-link" href="/contaPoupancaLogado">Poupan�a</a>
                    </li>
                  </ul>
                </div>
            </c:if>

        
        <c:if test="${not empty user}">
            <li class="nav-item">
              <a class="nav-link" href="/homeLogado">Home</a>
            </li>
        </c:if>
          
        <c:if test="${empty user}">           
            <li class="nav-item">
              <a class="nav-link" href="/home">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/cliente/cadastroCliente">Abra sua conta</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/sobre">Sobre</a>
            </li> 
        </c:if>           
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
    
<div class="carousel-inner">
    <div class="carousel-item active">
    <img src=https://www.fundsexplorer.com.br/artigos/wp-content/uploads/2022/01/pexels-photo-7735704.jpeg alt="Los Angeles" class="d-block" width="100%" height="400">
      <div class="carousel-caption">    
        <h2>Conta Investimento</h2>  
      </div>
     </div>  
</div>
    
    <c:if test="${empty user}"> 
        <div class="container-fluid mt-3">
            <h2>O que � conta investimento?</h2>
            <p>Em primeiro lugar, a conta investimento, servi�o criado no ano de 2004, � um dos primeiros - e mais importantes - passos para entrar no mundo dos investimentos.</p>
            <p>Essa conta � uma forma pr�tica de separar os seus investimentos da sua conta corrente, proporcionando melhor controle e gerenciamento das suas aplica��es. </p>
            <p>Nesse sentido, todos os bancos devem oferecer a seus clientes a op��o de abrir uma conta investimento. Por�m, recomendamos que seja feita uma pesquisa caprichada para descobrir qual deles oferece mais vantagens. </p>    
        </div>
    </c:if>
    
           <c:if test="${not empty user}">
        <div class="container mt-3">
          <h3>Quantidade de contas: ${contas.size()}</h3>

          <h4><a href="/novaContaInvestimento">Nova Conta</a></h4>

          <table class="table table-striped">
              <thead>
                  <tr>
                    <th>ID</th>
                    <th>Tipo Conta</th>
                    <th>Ag�ncia</th>
                    <th>Conta</th>
                    <th>Saldo</th>
                    <th>Taxa juros</th>
                    <th>Prazo (anos)</th>
                    <th></th>
                  </tr>
              </thead>
              <tbody>
                  <c:forEach var="c" items="${contas}">
                      <tr>
                        <td>${c.id}</td>
                        <td>${c.tipoConta}</td>
                        <td>${c.agencia}</td>
                        <td>${c.conta}</td>
                        <td>${c.saldo}</td>
                        <td>${c.taxaJuros} % a.m</td>
                        <td>${c.prazoInvestimento}</td>
                    <!--    <td><a href="/conta/${p.id}/excluir">Detalhar</a></td> -->
                      </tr>
                  </c:forEach>
              </tbody>
          </table>
        </div>
    </c:if>

    
</body>
</html>
