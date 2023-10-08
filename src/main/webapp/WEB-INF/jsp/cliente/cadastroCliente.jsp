<!DOCTYPE html>
<html lang="en">
<head>
  <title>Cadastro cliente</title>
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
        <li class="nav-item">
          <a class="nav-link" href="/home">Home</a>
        </li>

        <li class="nav-item">
          <a class="nav-link" href="/sobre">Sobre</a>
        </li>

        
      </ul>
    </div>
      <ul class="nav navbar-nav navbar-right">

	      <li><a href="/cliente/cadastroCliente"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>      
	      <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>

    </ul>
  </div>
</nav>

<div class="container mt-3">
  <h2>Cadastro cliente</h2>
  <form action="/cliente/novoCliente" method="post">
    <div class="mb-3 mt-3">
      <label for="cpf">CPF:</label>
      <input type="cpf" class="form-control" id="cpf" placeholder="Informe seu CPF" name="cpf" >
    </div>
    
    <div class="mb-3 mt-3">
      <label for="nome">Nome:</label>
      <input type="nome" class="form-control" id="nome" placeholder="Informe seu nome" name="nome">
    </div>
    
    <div class="mb-3">
      <label for="email">E-mail:</label>
      <input type="email" class="form-control" id="email" placeholder="Informe seu e-mail" name="email">
    </div>
    
    <div class="mb-3">
      <label for="dtNasc">Data nascimento:</label>
      <input type="dtNasc" class="form-control" id="dtNasc" placeholder="Informe sua data de nascimento dd/MM/aaaa" name="dtNasc">
    </div>
      
	<div class="form-group">
	   <label>Tipo Conta:</label>
        <div class="form-check">
            <input type="checkbox" class="form-check-input" name="tpConta" value="CONTACORRENTE"> Conta Corrente
            <label class="form-check-label"></label>
        </div>
		
        <div class="form-check">
            <input type="checkbox" class="form-check-input" name="tpConta" value="CONTAPOUPANCA"> Conta Poupança
            <label class="form-check-label"></label>
        </div>
		
        <div class="form-check">
			<input type="checkbox" class="form-check-input" name="tpConta" value="CONTAINVESTIMENTO"> Conta Investimento
			<label class="form-check-label"></label>
        </div>
    </div>
      
    <div class="mb-3">
      <label for="senha">Senha:</label>
      <input type="senha" class="form-control" id="senha" placeholder="Informe uma senha" name="senha">
    </div>
      
    <button type="submit" class="btn btn-primary">Cadastrar</button>
  </form>
</div>


</body>
</html>
