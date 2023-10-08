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
              <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Serviços</a>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="/contaCorrente">Conta Corrente</a></li>
                    <li><a class="dropdown-item" href="/contaPoupanca">Poupança</a></li>
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
                      <a class="nav-link" href="/contaInvestimentoLogado">Investimentos</a>
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
    <img src=https://einvestidor.estadao.com.br/wp-content/uploads/2023/01/savingmoney20220801012103utc-241020220719_100120232012.jpg.webp alt="Los Angeles" class="d-block" width="100%" height="400">
      <div class="carousel-caption">    
        <h2>Conta Poupança</h2>  
      </div>
     </div>  
</div>
    
    <c:if test="${empty user}"> 
        <div class="container-fluid mt-3">
            <h2>O que é conta poupança? Veja como ela funciona</h2>
            <p>Em definição simplificada, a conta poupança é uma conta específica para guardar dinheiro, diferente da conta corrente, que é mais utilizada para receber salário e fazer pagamentos. Regulada pelo Banco Central, a também chamada caderneta de poupança foi criada justamente com o objetivo de poupar dinheiro e permite apenas movimentações básicas: 2 saques, 2 transferências  e 2 extratos por mês.</p>
        </div>
    </c:if>  

        <c:if test="${not empty user}">
        <div class="container mt-3">
          <h3>Quantidade de contas: ${contas.size()}</h3>

          <h4><a href="/novaContaPoupanca">Nova Conta</a></h4>

          <table class="table table-striped">
              <thead>
                  <tr>
                    <th>ID</th>
                    <th>Tipo Conta</th>
                    <th>Agência</th>
                    <th>Conta</th>
                    <th>Saldo</th>
                    <th>Taxa Rendimento</th>
                    <th>Aniversário Conta</th>
                    <th>Lim. Saque mensal</th>
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
                        <td>${c.taxaRendimento} % a.m</td>
                        <td>${c.aniversarioConta}</td>
                        <td>${c.limiteSaqueMensal}</td>
                    <!--    <td><a href="/conta/${c.id}/excluir">Detalhar</a></td> -->
                      </tr>
                  </c:forEach>
              </tbody>
          </table>
        </div>
    </c:if>
    
    </body>
</html>
