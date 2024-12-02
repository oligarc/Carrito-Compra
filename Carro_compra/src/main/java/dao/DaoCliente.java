package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexiones.Conexion;
import entidades.Cliente;

public class DaoCliente {

	
	public DaoCliente() {
		
	}
	
	public Cliente obtenerClientePorID(int idCliente) {
		
		Connection con = null;
		Conexion miconex = new Conexion();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Cliente cliente = new Cliente();
		String query = "SELECT ID, NOMBRE, TIPO, LIMITECREDITO FROM CLIENTES WHERE ID = ?";
		
		try {
			con = miconex.getConexion();
			ps = con.prepareStatement(query);
			ps.setInt(1, idCliente);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				cliente.setIdCliente(rs.getInt("ID"));
                cliente.setNombre(rs.getString("NOMBRE"));
                cliente.setTipo(rs.getString("TIPO"));
                cliente.setLimiteCredito(rs.getInt("LIMITECREDITO"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cliente;
		
	}
	
}
