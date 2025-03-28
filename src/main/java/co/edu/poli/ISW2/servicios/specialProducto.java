package co.edu.poli.ISW2.servicios;

import java.util.List;

import co.edu.poli.ISW2.modelo.Producto;

public interface specialProducto<T, id> extends DAOCrud<Producto, String>{

	
	List<Producto> BuscarProducto(String busqueda);
}
