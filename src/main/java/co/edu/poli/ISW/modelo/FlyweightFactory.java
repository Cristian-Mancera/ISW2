package co.edu.poli.ISW.modelo;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {

	private static Map<String, FlyweightProveedor> proveedores = new HashMap<>();

	public static FlyweightProveedor getProveedor(String nombre, String direccion) {
		String key = nombre + "_" + direccion;
		if (!proveedores.containsKey(key)) {
			proveedores.put(key, new FlyweightProveedor(nombre, direccion));
		}
		return proveedores.get(key);
	}

}
