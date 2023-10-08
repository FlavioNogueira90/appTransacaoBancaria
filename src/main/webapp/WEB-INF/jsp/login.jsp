<!DOCTYPE html>
<html lang="en">
<head>
  <title>AgroBank Login</title>
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
          <a class="nav-link" href="/cliente/cadastroCliente">Abra sua conta</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/sobre">Sobre</a>
        </li>
        
      </ul>
    </div>
      
      
  </div>
</nav>

<div class="container mt-3">
  <h2>AgroBank Login</h2>
  <form action="/logar" method="post">

    <div class="mb-3 mt-3">
      <label for="cpf">CPF:</label>
      <input type="cpf" class="form-control" id="cpf" placeholder="Informe seu CPF" name="cpf">
    </div>
    <div class="mb-3">
      <label for="pwd">Senha:</label>
      <input type="senha" class="form-control" id="senha" placeholder="Informe a senha" name="senha">
    </div>
    <div class="form-check mb-3">
      <label class="form-check-label">
        <input class="form-check-input" type="checkbox" name="remember"> Remember me
      </label>
    </div>
    <button type="entrar" class="btn btn-primary">Submit</button>
  </form>
</div>

</body>
</html>
