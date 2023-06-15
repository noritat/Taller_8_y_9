<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: APRENDIZ
  Date: 18/5/2023
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width,initial-scale=1.0">
  <title>Registrar Productos</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  <link rel="stylesheet" href="./css/Products.css">
</head>
<body class="text-center">
<div class="container">
  <header></header>
  <nav></nav>
  <section>
    <main class="form-signin w-100 m-auto">
    <form action="products-register" method="post">
      <img class="mb-4 " src="./img/productos.jpg" alt="MY APP" width="100" >
      <h4 class="test-secondary">Registrar productos</h4>
      <label for="product_name">Nombre Producto:</label>
      <input type="text" id="product_name" name="product_name" placeholder="Ingrese el nombre del producto" required autofocus
             pattern="[A-Za-z]{8,12}}">
      <label for="product_value">Valor Producto:</label>
      <input type="number" id="product_value" name="product_value" placeholder="Ingrese el valor de el producto" required
             pattern="[0-9]{8,12}">
      <label for="product_value">Categoria:</label>
      <input type="number" id="product_categories" name="product_categories" placeholder="Ingrese el codigo de categoria" required
             pattern="[0-9]{8,12}"><br>
      <button class="w-100 btn btn-lg btn-success" type="submit">Enviar</button>
    </form>
      <footer>
        <p class="mt-3 mb-3 text-muter">Todo los derechos reservados Estrada Angely
          <%=displayDate()%>
        </p>
      </footer>
      <main>
      </main>
      <!--Boostrap Script-->
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <%!
    public String displayDate(){
      SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY");
      Date date= Calendar.getInstance().getTime();
      return dateFormat.format(date);
    }
  %>
  </section>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>
</html>