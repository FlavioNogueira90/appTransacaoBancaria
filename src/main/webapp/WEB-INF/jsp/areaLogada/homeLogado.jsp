<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/js/bootstrap.bundle.min.js"></script>
    <title>Area do cliente</title>
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
        <li class="nav-item">
          <a class="nav-link" href="/contaCorrenteLogado">Conta Corrente</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/contaPoupancaLogado">Poupança</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/contaInvestimentoLogado">Investimentos</a>
        </li>  
      </ul>
    </div>   
    <ul class="nav navbar-nav navbar-right">
      <c:if test="${empty user}">
	      <li><a href="/usuario/cadastro"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>      
	      <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </c:if>
      
      <c:if test="${not empty user}">
      	  <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Logout ${user.nome}</a></li>
      </c:if>
    </ul>
 
  </div>
</nav>

<div class="container-fluid mt-3">
  <h3>Olá ${nome}, bem vindo ao AgroBank!</h3>
  <p>Plante e colha com a gente.</p>
</div>

<div class="container mt-3">
  <h3>Quantidade de contas: ${listagem.size()}</h3>

  <table class="table table-striped">
      <thead>
	      <tr>
	        <th>ID</th>
	        <th>Tipo Conta</th>
	        <th>Agência</th>
	        <th>Conta</th>
	        <th>Saldo</th>
	        <th></th>
	      </tr>
	  </thead>
	  <tbody>
		  <c:forEach var="c" items="${listagem}">
		      <tr>
				<td>${c.id}</td>
		        <td>${c.tipoConta}</td>
		        <td>${c.agencia}</td>
		        <td>${c.conta}</td>
		        <td>${c.saldo}</td>
		        <td><a href="/conta/${c.id}/excluir">Excluir</a></td>
		      </tr>
	      </c:forEach>
      </tbody>
  </table>
</div>

    
    
</body>
</html>
