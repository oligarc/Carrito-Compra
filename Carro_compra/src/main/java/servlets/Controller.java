package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import dao.DaoDetallePedido;
import dao.DaoPedido;
import dao.DaoProducto;
import entidades.CarroCompra;
import entidades.DetallePedido;
import entidades.Pedido;
import entidades.Producto;
import entidades.ProductoCarro;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String operacion = request.getParameter("operacion");
        HttpSession session = request.getSession();
        DaoProducto daoProducto = new DaoProducto();
        DaoPedido daoPedido = new DaoPedido();

        switch (operacion) {

            case "iniciar":
                // Lista de productos guardada en la sesión para siempre
                ArrayList<Producto> listaProductos = daoProducto.listaProductos();
                session.setAttribute("listaProductos", listaProductos);
                request.getRequestDispatcher("home.jsp").forward(request, response);
                break;

            case "aniadirProducto":
                // Cogemos el carrito que tenemos en la sesión
                CarroCompra carritoCompra = (CarroCompra) session.getAttribute("carritoCompra");
                if (carritoCompra == null) {
                    carritoCompra = new CarroCompra();  // Si no existe, lo creamos
                    session.setAttribute("carritoCompra", carritoCompra);
                }

                
                int idProducto = Integer.parseInt(request.getParameter("idProducto"));
                Producto producto = daoProducto.obtenerProductoPorId(idProducto);
                ProductoCarro productoCarro = new ProductoCarro(producto, 1); // Agregar 1 como cantidad por defecto

                // Verificar si el producto ya existe en el carrito, si existe se actualiza la cantidad
                boolean productoExistente = false;
                for (ProductoCarro pc : carritoCompra.getElementos()) {
                    if (pc.getIdProducto() == productoCarro.getIdProducto()) {
                        pc.setCantidad(pc.getCantidad() + 1);  // Incrementar cantidad si ya está en el carrito
                        productoExistente = true;
                        break;
                    }
                }

                // Si el producto no existía, añadirlo al carrito
                if (!productoExistente) {
                    carritoCompra.addProducto(productoCarro);
                }

                
                request.getRequestDispatcher("home.jsp").forward(request, response);
                break;
                
            case "quitarProducto":
                //Conseguir el carro de compra
                carritoCompra = (CarroCompra) session.getAttribute("carritoCompra");
                if (carritoCompra != null) {
                    // Obtener producto
                    idProducto = Integer.parseInt(request.getParameter("idProducto"));
                    producto = daoProducto.obtenerProductoPorId(idProducto);

                    // Buscar el producto en el carrito y disminuir su cantidad
                    for (ProductoCarro pc : carritoCompra.getElementos()) {
                        if (pc.getIdProducto() == producto.getIdProducto()) {
                            if (pc.getCantidad() > 1) {
                                pc.setCantidad(pc.getCantidad() - 1);  // Disminuir la cantidad
                            } else {
                                carritoCompra.eliminarProducto(pc.getIdProducto());  // Eliminar si la cantidad es 1
                            }
                            break;
                        }
                    }
                }

                // Redirigir al home después de quitar el producto
                request.getRequestDispatcher("home.jsp").forward(request, response);
                break;

            case "eliminarProducto":
                // Obtener carrito de compras
                carritoCompra = (CarroCompra) session.getAttribute("carritoCompra");
                if (carritoCompra != null) {
                    // Obtener producto
                    idProducto = Integer.parseInt(request.getParameter("idProducto"));
                    producto = daoProducto.obtenerProductoPorId(idProducto);

                    // Buscar y eliminar el producto completamente del carrito
                    for (ProductoCarro pc : carritoCompra.getElementos()) {
                        if (pc.getIdProducto() == producto.getIdProducto()) {
                            carritoCompra.eliminarProducto(pc.getIdProducto());  // Eliminar el producto del carrito
                            break;
                        }
                    }
                }
                
                request.getRequestDispatcher("home.jsp").forward(request, response);
                
                break;

            case "mostrarFormularioPedido":
                // Verificar si el carrito tiene productos
                CarroCompra carritoCompraMostrar = (CarroCompra) session.getAttribute("carritoCompra");
                if (carritoCompraMostrar == null || carritoCompraMostrar.getElementos().isEmpty()) {
                    request.setAttribute("mensaje", "El carrito está vacío. Agrega productos antes de realizar el pedido.");
                    request.getRequestDispatcher("home.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("formalizarpedido.jsp").forward(request, response);
                }
                break;

            case "realizarPedido":
                // Obtener parámetros del formulario
                int idCliente = Integer.parseInt(request.getParameter("idCliente"));
                String direccion = request.getParameter("direccion");

                // Obtener el carrito de compras
                CarroCompra carritoCompraSesion = (CarroCompra) session.getAttribute("carritoCompra");

                
                Pedido pedido = new Pedido();
                pedido.setIdCliente(idCliente);
                pedido.setDireccionEnvio(direccion);
                int idPedido = daoPedido.addPedido(pedido);

                
                int ld = 1; // Línea de detalle inicializada a 1 para luego ir incrementando
                for (ProductoCarro productoCarro2 : carritoCompraSesion.getElementos()) {
                    DetallePedido dp = new DetallePedido();
                    dp.setIdPedido(idPedido);
                    dp.setLineaDetalle(ld); 
                    dp.setIdProducto(productoCarro2.getIdProducto());
                    dp.setCantidad(productoCarro2.getCantidad());
                    dp.setPrecioUnitario(productoCarro2.getPrecioNormal());
                    dp.setTotalLineaDetalle(productoCarro2.getPrecioNormal() * productoCarro2.getCantidad());
                    DaoDetallePedido daoDetallePedido = new DaoDetallePedido();
                    daoDetallePedido.addDetallePedido(dp);
                    ld++; 
                }

               
                request.getRequestDispatcher("pedidoconfirmado.jsp").forward(request, response);
                break;
        }
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
