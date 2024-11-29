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
		DaoDetallePedido daoDetallePedido = new DaoDetallePedido();
		
		switch (operacion) {
		
		case "iniciar":
			
			ArrayList<Producto> listaProductos = daoProducto.listaProductos();
			session.setAttribute("listaProductos", listaProductos);
			request.getRequestDispatcher("home.jsp").forward(request, response);
			break;
			
		case "aniadirProducto":
			
			CarroCompra carritoCompra = (CarroCompra) session.getAttribute("carritoCompra");
			
			if(carritoCompra == null) {
				carritoCompra = new CarroCompra();
				session.setAttribute("carritoCompra", carritoCompra);
			}
			
			int idProducto = Integer.parseInt(request.getParameter("idProducto"));
			Producto producto = daoProducto.obtenerProductoPorId(idProducto);
			ProductoCarro productoCarro = new ProductoCarro(producto, 1);
			carritoCompra.addProducto(productoCarro);
			request.getRequestDispatcher("home.jsp").forward(request, response);
			
			break;
			
		case "mostrarFormularioPedido":
			
			CarroCompra carritoCompraMostrar = (CarroCompra) session.getAttribute("carritoCompra");
			
		    if (carritoCompraMostrar == null || carritoCompraMostrar.getElementos().isEmpty()) {
		        request.setAttribute("mensaje", "El carrito está vacío. Agrega productos antes de realizar el pedido.");
		        request.getRequestDispatcher("home.jsp").forward(request, response);
		    } else {
		   
		        request.getRequestDispatcher("formalizarpedido.jsp").forward(request, response);
		    }
			
			break;
			
		case "realizarPedido":
			
			int idCliente = Integer.parseInt(request.getParameter("idCliente"));
			String direccion = request.getParameter("direccion");
			
			CarroCompra carritoCompraSesion = (CarroCompra) session.getAttribute("carritoCompra");
			
			
			Pedido pedido = new Pedido();
			pedido.setIdCliente(idCliente);
			pedido.setDireccionEnvio(direccion);
			int idPedido = daoPedido.addPedido(pedido);
			
			for (ProductoCarro productoCarro2 : carritoCompraSesion.getElementos()) {
				DetallePedido dp = new DetallePedido();
				int ld = 1;
				dp.setIdPedido(idPedido);
				dp.setLineaDetalle(ld);
				dp.setIdProducto(productoCarro2.getIdProducto());
				dp.setCantidad(productoCarro2.getCantidad());
				dp.setPrecioUnitario(productoCarro2.getPrecioNormal());
				dp.setTotalLineaDetalle(productoCarro2.getPrecioNormal()*productoCarro2.getCantidad());
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
