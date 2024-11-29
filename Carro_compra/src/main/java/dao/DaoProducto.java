package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexiones.Conexion;
import entidades.Producto;

public class DaoProducto {
	
	public DaoProducto() {
		
	}
	
	public ArrayList<Producto> listaProductos(){
		
		ArrayList<Producto> lista = new ArrayList<Producto>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Conexion miconex = new Conexion();
		String query = "SELECT * FROM PRODUCTO";
		
		try {
			con = miconex.getConexion();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Producto producto = new Producto();
				producto.setIdProducto(rs.getInt("ID"));
				producto.setNombre(rs.getString("NOMBRE"));
				producto.setPrecioNormal(rs.getInt("PRECIO_NORMAL"));
				producto.setPrecioMinimo(rs.getInt("PRECIO_MINIMO"));
				lista.add(producto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return lista;
	}
	
	public Producto obtenerProductoPorId(int idProducto) {
		
		Producto producto = new Producto();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Conexion miconex = new Conexion();
		String query = "SELECT * FROM PRODUCTO WHERE ID=?";
		
		try {
			con = miconex.getConexion();
			ps = con.prepareStatement(query);
			ps.setInt(1, idProducto);
			rs=ps.executeQuery();
			if(rs.next()) {
				producto.setIdProducto(rs.getInt("ID"));
				producto.setNombre(rs.getString("NOMBRE"));
				producto.setPrecioNormal(rs.getInt("PRECIO_NORMAL"));
				producto.setPrecioMinimo(rs.getInt("PRECIO_MINIMO"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return producto;
	}

}
