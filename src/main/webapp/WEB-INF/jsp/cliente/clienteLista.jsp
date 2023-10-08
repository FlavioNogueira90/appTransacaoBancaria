<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Cadastro cliente</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/js/bootstrap.bundle.min.js"></script>
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
          <a class="nav-link" href="/home">Home</a>
        </li>

        <li class="nav-item">
          <a class="nav-link" href="/sobre">Sobre</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/login">Login</a>
        </li>
        
      </ul>
    </div>
  </div>
</nav>

<!--<c:import url="/WEB-INF/jsp/menu.jsp"/>-->

	
	<div class="container-fluid mt-3">
	   <h3>Clientes: ${listaCliente.size()}</h3>
        <h3>Listagem de clientes:</h3>

	  <table class="table table-striped">
	    <thead>
	      <tr>
	        <th>ID</th>
            <th>CPF</th>
	        <th>Nome</th>
	        <th>E-mail</th>
	        <th>Data Nasc</th>
	        <th></th>
	      </tr>
	    </thead>
	    <tbody>
  	  
	      <c:forEach items="${listaCliente}" var="c" >
 
              <tr>
		        <td>${c.id}</td>
		        <td>${c.cpf}</td>
		        <td>${c.nome}</td>
		        <td>${c.email}</td>
		        <td>${c.dataNasc}</td>
		        <td><a href="/cliente/${c.id}/excluir">excluir</a> </td>
		      </tr>
	      </c:forEach> 
	    </tbody>
	  </table>
	  
	</div>
   </body>
</html> 