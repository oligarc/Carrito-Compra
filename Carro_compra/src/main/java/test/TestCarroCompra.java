package test;

import entidades.CarroCompra;
import entidades.Producto;
import entidades.ProductoCarro;

public class TestCarroCompra {

	public static void main(String[] args) {
		
		CarroCompra carrito = new CarroCompra();
		Producto p = new Producto();
		p.setIdProducto(1);
		p.setNombre("mandarinas");
		p.setPrecioMinimo(1);
		p.setPrecioNormal(2);
		
		ProductoCarro pc = new ProductoCarro(p, 2);
		carrito.addProducto(pc);
		
		System.out.println(carrito);

	}

}
