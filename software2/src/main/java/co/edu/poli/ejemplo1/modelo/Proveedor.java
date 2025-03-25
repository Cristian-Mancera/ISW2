package co.edu.poli.ejemplo1.modelo;

public class Proveedor {

	private BuilderEvaluacion evaluacion;
	private BuilderCertificacion certificacion;
	private BuilderPoliticaEntrega politicaDeEntrega;

	Proveedor(BuilderEvaluacion evaluacion, BuilderCertificacion certificacion,
			BuilderPoliticaEntrega politicaDeEntrega) {
		this.evaluacion = evaluacion;
		this.certificacion = certificacion;
		this.politicaDeEntrega = politicaDeEntrega;
	}

	public BuilderEvaluacion getEvaluacion() {
		return evaluacion;
	}

	public BuilderCertificacion getCertificacion() {
		return certificacion;
	}

	public BuilderPoliticaEntrega getPoliticaDeEntrega() {
		return politicaDeEntrega;
	}

	@Override
	public String toString() {
		return "Proveedor:\n" + evaluacion + "\n" + certificacion + "\n" + politicaDeEntrega;
	}

	public interface Builder {
		Proveedor build();
	}

	public static class ProveedorBuilder implements Builder {
		private BuilderEvaluacion evaluacion;
		private BuilderCertificacion certificacion;
		private BuilderPoliticaEntrega politicaDeEntrega;

		public ProveedorBuilder conEvaluacion(BuilderEvaluacion evaluacion) {
			this.evaluacion = evaluacion;
			return this;
		}

		public ProveedorBuilder conCertificacion(BuilderCertificacion certificacion) {
			this.certificacion = certificacion;
			return this;
		}

		public ProveedorBuilder conPoliticaDeEntrega(BuilderPoliticaEntrega politicaDeEntrega) {
			this.politicaDeEntrega = politicaDeEntrega;
			return this;
		}

		@Override
		public Proveedor build() {
			return new Proveedor(evaluacion, certificacion, politicaDeEntrega);
		}
	}
}