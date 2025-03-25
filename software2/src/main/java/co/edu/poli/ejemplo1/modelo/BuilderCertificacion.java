package co.edu.poli.ejemplo1.modelo;

public class BuilderCertificacion implements Proveedor.Builder{
	
	private String nombreCertificacion;
    private String fechaEmision;

    // Constructor
    public BuilderCertificacion(String nombreCertificacion, String fechaEmision) {
        this.nombreCertificacion = nombreCertificacion;
        this.fechaEmision = fechaEmision;
    }

    public String getNombreCertificacion() {
        return nombreCertificacion;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    @Override
    public Proveedor build() {
        return new Proveedor(null, new BuilderCertificacion(this.nombreCertificacion, this.fechaEmision), null);
    }

    @Override
    public String toString() {
        return "Certificacion{" +
               "nombreCertificacion='" + nombreCertificacion + '\'' +
               ", fechaEmision='" + fechaEmision + '\'' +
               '}';
    }

}
