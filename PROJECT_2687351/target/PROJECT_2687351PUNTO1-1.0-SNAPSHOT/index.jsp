 <%@ page import="java.awt.*" %>
 <%@ page import="java.text.SimpleDateFormat" %>
 <%@ page import="java.util.Calendar" %>
 <%@ page import="java.util.Date" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <!---MEDATA-->
    <!---charset caracteres especiales -->
    <meta charset="utf-8">
    <!--author-->
    <meta name="author" content="Nombre Autor">
        <!--description-->
    <meta name="description"  content="Esta debe ser la informacion que aparece en el párrafo que acompaña
los resultados de una busqueda de Internet">
    <!--keywords-->
    <meta name ="keywords" content="Registro de usuario, Formulario de registro, Crear cuenta, Registro en linea">
    <!--minium resposive viewport-->
    <meta name ="viewport" content="Width=divice-width,initial-scale=1">
    <!---TITLE-->
    <title>REGISTRO DE USUARIO .:. MY APP </title>
    <!--FAVICON-->
    <link rel="icon" type="image/x-icon" href="./img/icons8-application-64.png">
    <!--CSS-->
    <!--BOOSTRAP/ ICONS-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/boostrap/icons@1.10.3/font/boostrap-icons.css">
    <!--custom css-->
    <link rel="stylesheet" href="./css/signin.css">
</head>
<body class="text-center">
<!--login form-->
<main class="form-signin w-100 m-auto">
    <form action="" method="post" >
        <img class="mb-4 " src="./img/user-login-icon-14.png" alt="MY APP" width="100" >
        <h4 class="test-secondary">REGISTRATE</h4>
        <h1 class="h5 mb-3 fw-normal" > Ingreso</h1>
        <div class="form-floating" >
           <input type="text" class="form-control" id="floatingInput"
            placeholder="ingrese su nombre del usuario "  required autofocus
           pattern="[A-Za-z0-9]{8,12}">
            <label for="floatingInput" >Usuario </label>

        </div>
        <div class="form-floating" >
            <input type="password" class="form-control" id="floatingPassword"
                   placeholder="ingrese su contraseña "  required
                   pattern="[A-Za-z0-9]{8,12}">
            <label for="floatingPassword" >Password </label>

        </div>
        <button class="w-100 btn btn-lg btn-success" type="submit">Ingresar</button>
        <div id="register">
            <a href="registro">Registrarse</a>
            <a href="categorias">Categorias</a>
            <a href="producto">Productos</a>
            <a href="sena">Sena</a>
        </div>

    </form>
    <footer>
        <p class="mt-3 mb-3 text-muter">Todo los derechos reservados MY APP
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
</body>
</html>
