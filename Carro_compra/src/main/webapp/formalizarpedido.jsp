<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Realizar Pedido</title>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />

    <!-- Bootstrap CSS v5.2.1 -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
      crossorigin="anonymous"
    />
    
    <script>
      // Función para validar el ID del cliente
      function validarFormulario() {
        var idCliente = document.getElementById("idCliente").value;
        if (isNaN(idCliente) || idCliente.trim() === "") {
          alert("El identificador del cliente debe ser un número válido.");
          return false; // Evita el envío del formulario
        }
        return true;
      }
    </script>
  </head>
<body>

	<header class="p-3">
      <div class="container">
        <img src="img/headerazarquiel.jpg" alt="" class="w-100" />
      </div>
    </header>
    
    <main>
    
    <div class="container my-5">
    <h2 class="text-center mb-4">INTRODUZCA SU IDENTIFICADOR DE CLIENTE Y LA DIRECCIÓN DE ENVÍO</h2>
    <c:if test="${not empty error}">
            <div class="alert alert-danger" role="alert">
                ${error}
            </div>
        </c:if>
    <form action="controller?operacion=realizarPedido" method="post" class="p-4 border rounded shadow-sm">
        <div class="mb-3">
            <label for="idCliente" class="form-label">ID CLIENTE</label>
            <input type="number" id="idCliente" name="idCliente" class="form-control" placeholder="Introduce tu ID de cliente" required>
        </div>
        <div class="mb-3">
            <label for="direccion" class="form-label">Dirección</label>
            <input type="text" id="direccion" name="direccion" class="form-control" placeholder="Introduce tu dirección de envío" required>
        </div>
        <div class="text-center">
            <button type="submit" class="btn btn-primary">Realizar Pedido</button>
        </div>
    </form>
</div>
    </main>
    
    
    
     <footer class="p-3">
      <div class="container bg-primary">
        <h1 class="text-white text-center p-2">Made by ajkasajs</h1>
      </div>
    </footer>
    
    
    <script
      src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
      integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
      crossorigin="anonymous"
    ></script>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
      integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
      crossorigin="anonymous"
    ></script>


</body>
</html>