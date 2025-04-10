package co.edu.poli.ISW.modelo;

public class ProductProxy implements Product {
	private ProductReal productoReal;
	private Usuario usuario;
	private static final int NIVEL_REQUERIDO = 5;

	public ProductProxy(String nombreProducto, Usuario usuario) {
		this.productoReal = new ProductReal(nombreProducto);
		this.usuario = usuario;
	}

	@Override
	public String mostrarDetalles() {
		if (usuario.getNivelAcceso() >= NIVEL_REQUERIDO) {
			return "Acceso permitido para " + usuario.getNombre() + "\n" + productoReal.mostrarDetalles();
		} else {
			return "Acceso denegado para " + usuario.getNombre() + ". Nivel requerido: " + NIVEL_REQUERIDO
					+ ", nivel actual: " + usuario.getNivelAcceso() + "\n";
		}
	}
}
