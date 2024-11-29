package entidades;

public class Producto extends Object {
	
	private int idProducto;
	private String nombre;
	private int precioNormal;
	private int precioMinimo;
	
	public Producto() {
		
	}

	public Producto(int idProducto, String nombre, int precioNormal, int precioMinimo) {
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.precioNormal = precioNormal;
		this.precioMinimo = precioMinimo;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecioNormal() {
		return precioNormal;
	}

	public void setPrecioNormal(int precioNormal) {
		this.precioNormal = precioNormal;
	}

	public int getPrecioMinimo() {
		return precioMinimo;
	}

	public void setPrecioMinimo(int precioMinimo) {
		this.precioMinimo = precioMinimo;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombre=" + nombre + ", precioNormal=" + precioNormal
				+ ", precioMinimo=" + precioMinimo + "]";
	}
	
	

}
