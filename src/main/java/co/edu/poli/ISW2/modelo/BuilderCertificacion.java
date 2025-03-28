package co.edu.poli.ISW2.modelo;

public class BuilderCertificacion implements Proveedor.Builder<Certificacion> {
    
	private Certificacion result;

    @Override
    public void reset() {
        result = new Certificacion();
    }

    @Override
    public void buildStepA(String nombre) {
        result.setNombre(nombre);
    }

    @Override
    public void buildStepB(String nivel) {
        result.setNivel(nivel);
    }

    @Override
    public Certificacion getResult() {
        return result;
    }
}