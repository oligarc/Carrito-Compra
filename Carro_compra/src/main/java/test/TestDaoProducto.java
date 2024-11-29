package test;

import java.util.ArrayList;

import dao.DaoProducto;
import entidades.Producto;

public class TestDaoProducto {

	public static void main(String[] args) {
		
		DaoProducto daoP = new DaoProducto();
		ArrayList<Producto> listaPro = daoP.listaProductos();
		
		for (Producto producto : listaPro) {
			System.out.println(producto.toString());
		}
		
		Producto producto = daoP.obtenerProductoPorId(7);
		System.out.println(producto.toString());

	}

}
