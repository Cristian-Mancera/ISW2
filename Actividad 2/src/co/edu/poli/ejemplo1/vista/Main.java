package co.edu.poli.ejemplo1.vista;

import java.util.ArrayList;
import java.util.List;

import co.edu.poli.ejemplo1.controlador.ClienteController;
import co.edu.poli.ejemplo1.modelo.Cliente;
import co.edu.poli.ejemplo1.modelo.Pedido;
import co.edu.poli.ejemplo1.modelo.Producto;

public class Main {
	
public static String txtid = "1237";
public static String txtname = "johan";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClienteController cc = new ClienteController();
		
		System.out.println(cc.Actioncrear());
		

	}

}
