<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: APRENDIZ
  Date: 18/5/2023
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <title>Registrar Usuario</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <link rel="stylesheet" href="./css/Registro.css">
</head>
<body class="text-center">
<div class="container">
    <header></header>
    <nav></nav>
    <section>
        <main class="form-signin w-100 m-auto">
        <form action="user-register" method="post">
            <img class="mb-4 " src="./img/registro.jpg" alt="MY APP" width="100" >
            <h4 class="test-secondary">REGISTRATE</h4>
            <label for="user_firstname">Nombres:</label>
            <input type="text" id="user_firstname" name="user_firstname" placeholder="Ingrese su nombre" required autofocus
                   pattern="[A-Za-z ]{2,30}"><br>
            <label for="user_lastname">Apellidos:</label>
            <input type="text" id="user_lastname" name="user_lastname" placeholder="Ingrese su apellido" required
                   pattern="[A-Za-z ]{2,30}">
            <label for="user_email">Correo:</label>
            <input type="email" id="user_email" name="user_email" placeholder="Ingrese su correo" required
                   pattern="{60}"><br>
            <label for="user_password">Contraseña:</label>
            <input type="password" id="user_password" name="user_password" placeholder="Ingrese su contraseña" required
                   pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}">
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