package entidades;

import java.util.ArrayList;

public class CarroCompra {
	
	private ArrayList<ProductoCarro> elementos;
	
	public CarroCompra() {
		elementos = new ArrayList<ProductoCarro>();
	}
	
	public void setElementos(ArrayList<ProductoCarro> elementos) {
		this.elementos = elementos;
	}
	
	public ArrayList<ProductoCarro> getElementos() {
		return elementos;
	}
	
	public void addProducto(ProductoCarro p) {
        boolean encontrado = false;

        // Verificar que el producto ya está en el carro
        for (ProductoCarro producto : elementos) {
            if (producto.getIdProducto() == p.getIdProducto()) {
                // Si está, sumamos 1
                producto.setCantidad(producto.getCantidad() + p.getCantidad());
                encontrado = true;
                break;
            }
        }

        // Sino, lo añadimos a la cesta
        if (!encontrado) {
            elementos.add(p);
        }
    }
	
	public void quitarProducto(int idProducto) {
        for (ProductoCarro producto : elementos) {
            if (producto.getIdProducto() == idProducto) {
                if (producto.getCantidad() > 1) {
                    producto.setCantidad(producto.getCantidad() - 1);  // Restamos 1
                } else {
                    elementos.remove(producto);  // Si es menor de 1, lo quitamos de la cesta
                }
                break;
            }
        }
    }

    public void eliminarProducto(int idProducto) {
        for (ProductoCarro producto : elementos) {
            if (producto.getIdProducto() == idProducto) {
                elementos.remove(producto);
                break;
            }
        }
    }

	@Override
	public String toString() {
		return "CarroCompra [elementos=" + elementos + "]";
	}
	
	

}
