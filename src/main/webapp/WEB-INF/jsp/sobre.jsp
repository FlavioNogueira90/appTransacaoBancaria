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
        <li class="nav-item">
          <a class="nav-link" href="/cliente/clienteLista">Lista clientes</a>       
        </li>
      </ul>
    </div>
  </div>
</nav>
    
<div class="container">
  <h2>Classe: Cliente</h2>
       
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Campo</th>
        <th>Tipo</th>
        <th>Observação</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>ID</td>
        <td>Integer</td>
        <td>Código único implementado automáticamente</td>
      </tr>
      <tr>
        <td>CPF</td>
        <td>String</td>
        <td>Número do CPF sem pontuação PK</td>
      </tr>
      <tr>
        <td>Nome</td>
        <td>String</td>
        <td>Nome completo</td>
      </tr>
      <tr>
        <td>Email</td>
        <td>String</td>
        <td>E-mail do cliente</td>
      </tr>
      <tr>
        <td>DataNasc</td>
        <td>Date</td>
        <td>Data nascimento dd/MM/aaaa</td>
      </tr>
    </tbody>
  </table>
</div>
    
<div class="container">
  <h2>Classe: ContaBancaria</h2>           
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Campo</th>
        <th>Tipo</th>
        <th>Observação</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>ID</td>
        <td>Integer</td>
        <td>Código único implementado automáticamente</td>
      </tr>
      <tr>
        <td>tipoConta</td>
        <td>Enun TipoConta</td>
        <td>Informa o tipo de conta</td>
      </tr>
      <tr>
        <td>agencia</td>
        <td>int</td>
        <td>Número da agência</td>
      </tr>
      <tr>
        <td>conta</td>
        <td>int</td>
        <td>Número da conta</td>
      </tr>
      <tr>
        <td>saldo</td>
        <td>float</td>
        <td>Saldo da conta</td>
      </tr>

    </tbody>
  </table>
</div>

<div class="container">
  <h2>Classe: ContaCorrente</h2>           
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Campo</th>
        <th>Tipo</th>
        <th>Observação</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>limiteChequeEspecial</td>
        <td>float</td>
        <td>Informa o limite de cheque especial da conta</td>
      </tr>
      <tr>
        <td>taxaManutencao</td>
        <td>float</td>
        <td>Taxa a ser aplicada caso o cliente consuma o limite disponível</td>
      </tr>
      <tr>
        <td>talonarioCheque</td>
        <td>boolean</td>
        <td>Informa se cliente aderiu a talão de cheque</td>
      </tr>
      
    </tbody>
  </table>
</div>

<div class="container">
  <h2>Classe: ContaPoupanca</h2>           
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Campo</th>
        <th>Tipo</th>
        <th>Observação</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>taxaRendimento</td>
        <td>float</td>
        <td>Taxa de rendimento do valor aplicado</td>
      </tr>
      <tr>
        <td>aniversarioConta</td>
        <td>Date</td>
        <td>Data base para cálculo do rendimento baseado na taxa</td>
      </tr>
      <tr>
        <td>limiteSaqueMensal</td>
        <td>int</td>
        <td>Quantidade de saques em um mês</td>
      </tr>
    </tbody>
  </table>
</div>

<div class="container">
  <h2>Classe: ContaInvestimento</h2>           
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Campo</th>
        <th>Tipo</th>
        <th>Observação</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>taxaJuros</td>
        <td>float</td>
        <td>Taxa aplicada ao investimento</td>
      </tr>
      <tr>
        <td>prazoInvestimento</td>
        <td>int</td>
        <td>Prazo que pretende manter o investimento em meses</td>
      </tr>
      <tr>
        <td>valorInvestido</td>
        <td>float</td>
        <td>Valor investido</td>
      </tr>
    </tbody>
  </table>
</div>

</body>
</html>