<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>CarroCompra</title>
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
  </head>

  <body>
    <header class="p-3">
      <div class="container">
        <img src="img/headerazarquiel.jpg" alt="" class="w-100" />
      </div>
    </header>
    <main>
      <div class="container my-5">
        <h2 class="text-center mb-4">Productos</h2>
        <table class="table table-bordered table-striped table-hover">
          <thead class="table-primary">
            <tr>
              <th scope="col">ID</th>
              <th scope="col">Descripción</th>
              <th scope="col">Precio (€)</th>
              <th scope="col"></th>
            </tr>
          </thead>
          <tbody>
          <c:forEach items="${listaProductos}" var="producto">
            <tr>
              <td>${producto.idProducto}</td>
              <td>${producto.nombre}</td>
              <td>${producto.precioNormal}</td>
              <td><a href="controller?operacion=aniadirProducto&idProducto=${producto.idProducto}"><img src="img/tobasket_button.gif" alt="" /></a></td>
            </tr>
            </c:forEach>
          </tbody>
        </table>
        
        <c:if test="${carritoCompra != null}">
        
        <h2 class="text-center mb-4">Productos de la cesta</h2>
        <table class="table table-bordered table-striped table-hover">
          <thead class="table-primary">
            <tr>
              <th scope="col">CÓDIGO</th>
              <th scope="col">PRODUCTO</th>
              <th scope="col">PRECIO (€)</th>
              <th scope="col">CANTIDAD</th>
              <th scope="col">TOTAL</th>
              <th scope="col"></th>
              <th scope="col"></th>
              <th scope="col"></th>
            </tr>
          </thead>
           <tbody>
           
           <c:forEach items="${carritoCompra.elementos}" var="productosCarro">
           <tr>
           <td>${productosCarro.idProducto} </td>
           <td>${productosCarro.nombre}</td>
           <td>${productosCarro.precioNormal} </td>
           <td>${productosCarro.cantidad}</td>
           <td>${productosCarro.precioNormal*productosCarro.cantidad}</td>
           <td><a href="controller?operacion=aniadirProducto&idProducto=${productosCarro.idProducto}"><img src="img/addCarro.png" /></a></td>
           <td><a href="controller?operacion=quitarProducto&idProducto=${productosCarro.idProducto}"><img src="img/remCarro.png" /></a></td>
           <td><a href="controller?operacion=eliminarProducto&idProducto=${productosCarro.idProducto}"><img src="img/delCarro.png" /></a></td>
           </tr>
           </c:forEach>
           </tbody>
           </table>
           <a href="controller?operacion=mostrarFormularioPedido" class="text-center p-3">Formalizar pedido</a>
        </c:if>
      </div>
    </main>
    <footer class="p-3">
      <div class="container bg-primary">
        <h1 class="text-white text-center p-2">Made by ajkasajs</h1>
      </div>
    </footer>
    <!-- Bootstrap JavaScript Libraries -->
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