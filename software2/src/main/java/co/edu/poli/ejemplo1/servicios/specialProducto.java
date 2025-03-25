package co.edu.poli.ejemplo1.servicios;

import java.util.List;

import co.edu.poli.ejemplo1.modelo.Producto;

public interface specialProducto<T, id> extends DAOCrud<Producto, String>{

	
	List<Producto> BuscarProducto(String busqueda);
}
