package entidades;

import java.sql.Date;

public class Pedido {
	
	private int idPedido;
	private int idCliente;
	private String estado;
	private char pagado;
	private Date fecha;
	private String direccionEnvio;
	
	public Pedido() {
        
    }

	public Pedido(int idPedido, int idCliente, String estado, char pagado, Date fecha, String direccionEnvio) {
		this.idPedido = idPedido;
		this.idCliente = idCliente;
		this.estado = estado;
		this.pagado = pagado;
		this.fecha = fecha;
		this.direccionEnvio = direccionEnvio;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public char getPagado() {
		return pagado;
	}

	public void setPagado(char pagado) {
		this.pagado = pagado;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDireccionEnvio() {
		return direccionEnvio;
	}

	public void setDireccionEnvio(String direccionEnvio) {
		this.direccionEnvio = direccionEnvio;
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", idCliente=" + idCliente + ", estado=" + estado + ", pagado=" + pagado
				+ ", fecha=" + fecha + ", direccionEnvio=" + direccionEnvio + "]";
	}
	
	

}
