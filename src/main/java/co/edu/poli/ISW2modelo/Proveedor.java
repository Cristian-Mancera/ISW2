package co.edu.poli.ISW2modelo;

public class Proveedor {


	public <T> T construir(Builder<T> builder, String stepA, String stepB) {
        builder.reset();
        builder.buildStepA(stepA);
        builder.buildStepB(stepB);
        return builder.getResult();
    }

	
	interface Builder <T>{

		void reset();

		void buildStepA(String valor);

		void buildStepB(String valor);

		T getResult();
	}
}
